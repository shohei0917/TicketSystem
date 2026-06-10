import java.util.ArrayList;
import java.util.List;

public class Cart {
    List<CartItem> cartItems = new ArrayList<CartItem>();

    public void addItem(Item item){
        boolean found = false;
        for(int i = 0; i < cartItems.size(); i++){
            CartItem cartItem= cartItems.get(i);
            if(cartItem.getName().equals(item.getName())){
                cartItem.setQuantity(cartItem.getQuantity()+1);
                cartItems.set(i, cartItem);
                found = true;
                break;
            }
        }
        if(!found){
            CartItem newItem=new CartItem();
            newItem.setId(item.getId());
            newItem.setName(item.getName());
            newItem.setPrice(item.getPrice());
            newItem.setQuantity(1);
            cartItems.add(newItem);
        }

    }

    public List<CartItem> getCartItems(){
        return cartItems;
    }

    public int getTotalPrice(){
        int totalPrice = 0;
        for (CartItem item : cartItems){
            for(int i=0;i<item.getQuantity();i++){
                totalPrice += item.getPrice();
            }
        }
        return totalPrice;
    }
}
