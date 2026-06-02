public class CartItem {
    private int id;
    private String name;
    private int price;
    private int quantity;

    public CartItem(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = 1;
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }



    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
