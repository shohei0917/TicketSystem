import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Item> items = new ArrayList<>();
        items.add(new Item(1, "特製ラーメン", 1000));
        items.add(new Item(2, "醤油ラーメン", 780));
        items.add(new Item(3, "しおラーメン", 880));
        items.add(new Item(4, "ごはん", 150));

        TicketVendor vendor = new TicketVendor(items);
        Scanner scanner = new Scanner(System.in);

        vendor.showItems();

        while (true) {
            System.out.print("購入する商品番号(支払いに進む場合はc)>");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("c")) {
                break;
            }

            if (input.isEmpty()) {
                System.out.println("商品番号またはcを指定してください。");
                continue;
            }

            try {
                int choice = Integer.parseInt(input);

                if (choice < 1 || choice > 4) {
                    System.out.println("商品番号またはcを指定してください。");
                    continue;
                }

                vendor.addItemToCart(choice);

            } catch (NumberFormatException e) {
                System.out.println("商品番号またはcを指定してください。");
            }
        }

        vendor.showCartItems();

        System.out.print("現金を投入してください>");
        String paymentInput = scanner.nextLine().trim();

        int payment = 0;
        try {
            payment = Integer.parseInt(paymentInput);
        } catch (NumberFormatException e) {
            System.out.println("不正な入力です。");
            scanner.close();
            System.exit(0);
        }

        if (payment <= 0) {
            System.out.println("エラー：正の数を入力してください。");
            scanner.close();
            System.exit(0);
        }

        boolean isSuccess = vendor.showChange(payment);

        if (!isSuccess) {
            System.out.println("金額が不足しています。");
            scanner.close();
            System.exit(0);
        }

        scanner.close();
    }
}