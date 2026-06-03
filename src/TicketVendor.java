import java.util.ArrayList;
import java.util.List;

public class TicketVendor {
//    商品一覧の保存用
    private ArrayList<Item> ProductList = new ArrayList<Item>();
//    カート内商品の保存用
    private Cart cart ;

//    コンストラクタ
    public TicketVendor(List<Item> items){
        this.ProductList.addAll(items) ;
        this.cart = new Cart();
    }

//    商品一覧の表示
    public void showItems(){
        System.out.println( "商品　　　　　金額" );
        for(Item item:ProductList){
//            表示要件例）1.特製ラーメン　1000円
            String text =
                    item.getId() + "."
                    + item.getName() + "　"
                    + item.getPrice() + "円" ;
            System.out.println(text) ;
        }
    }

//    カートに商品の追加
    public void addItemToCart(int itemId){
        for(Item item:ProductList){
            if( item.getId() == itemId ){
                cart.addItem( item ) ;
                break ;
            }
        }
    }

//    カート内商品の表示
    public void showCartItems(){
        System.out.println("商品　　　　　　　　数量");
        for( CartItem cartItem : cart.getCartItems() ){
            System.out.println( cartItem ) ;
        }
        int totalPrice = cart.getTotalPrice() ;
        System.out.println("合計" + totalPrice + "円です。");
    }

//    お釣りの計算
    public boolean showChange(int payment){
        int TotalPrice = cart.getTotalPrice() ;
        if( payment >= TotalPrice ){
            int change =  payment - TotalPrice ;
            System.out.println( "ご購入ありがとうございます。おつり" + change + "円です。" ) ;
            return true ;
        }
        return false ;
    }
}
