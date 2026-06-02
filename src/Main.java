package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.List;

public class Main extends Application {

    private TicketVendor vendor;
    private Stage primaryStage;
    private TextArea displayArea;
    private TextField inputField;
    private Button submitButton;
    private Label promptLabel;

    private int currentPhase = 1;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("券売機システム");

        List<Item> items = new ArrayList<>();
        items.add(new Item(1, "特製ラーメン", 1000));
        items.add(new Item(2, "醤油ラーメン", 780));
        items.add(new Item(3, "しおラーメン", 880));
        items.add(new Item(4, "ごはん", 150));

        vendor = new TicketVendor(items);

        VBox root = new VBox(15);
        root.setPadding(new Insets(20));
        root.setAlignment(Pos.CENTER);

        displayArea = new TextArea();
        displayArea.setEditable(false);
        displayArea.setPrefHeight(250);

        promptLabel = new Label("購入する商品番号(支払いに進む場合はc)>");
        inputField = new TextField();
        submitButton = new Button("確定");

        HBox inputLayout = new HBox(10);
        inputLayout.setAlignment(Pos.CENTER);
        inputLayout.getChildren().addAll(inputField, submitButton);

        root.getChildren().addAll(displayArea, promptLabel, inputLayout);

        showWelcomeMessage();

        submitButton.setOnAction(e -> handleInput());
        inputField.setOnAction(e -> handleInput());

        Scene scene = new Scene(root, 450, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void showWelcomeMessage() {
        StringBuilder sb = new StringBuilder();
        sb.append("商品\t\t\t金額\n");
        sb.append("1.特製ラーメン\t1000円\n");
        sb.append("2.醤油ラーメン\t780円\n");
        sb.append("3.しおラーメン\t880円\n");
        sb.append("4.ごはん\t\t150円\n");
        sb.append("---------------------------------------\n");
        displayArea.setText(sb.toString());
    }

    private void handleInput() {
        String input = inputField.getText().trim();
        inputField.clear();

        if (currentPhase == 1) {
            handlePurchasePhase(input);
        } else if (currentPhase == 2) {
            handlePaymentPhase(input);
        }
    }

    private void handlePurchasePhase(String input) {
        // エラーチェック: 入力が空（null）の場合
        if (input == null || input.isEmpty()) {
            showAlert("商品番号またはcを指定してください。");
            return;
        }

        if (input.equalsIgnoreCase("c")) {
            currentPhase = 2;

            String cartContent = vendor.showCartItems();
            displayArea.setText(cartContent);
            promptLabel.setText("現金を投入してください>");
            return;
        }

        try {
            int itemId = Integer.parseInt(input);
            if (itemId < 1 || itemId > 4) {
                showAlert("商品番号またはcを指定してください。");
                return;
            }

            vendor.addItemToCart(itemId);
            displayArea.appendText("購入する商品番号(支払いに進む場合はc)>" + input + "\n");

        } catch (NumberFormatException e) {
            showAlert("商品番号またはcを指定してください。");
        }
    }

    private void handlePaymentPhase(String input) {
        try {
            int payment = Integer.parseInt(input);

            if (payment <= 0) {
                showErrorAndExit("不正な入力です。");
                return;
            }

            boolean success = vendor.showChange(payment, displayArea);

            if (success == false) {

                showErrorAndExit("金額が不足しています。");
            } else {
                inputField.setDisable(true);
                submitButton.setDisable(true);
                promptLabel.setText("ご利用ありがとうございました。");
            }

        } catch (NumberFormatException e) {
            showErrorAndExit("不正な入力です。");
        }
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("注意");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void showErrorAndExit(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("エラー");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
        primaryStage.close();
    }

    public static void main(String[] args) {
        launch(args);
    }
}