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
        for(Item item:ProductList){
//            toString -> itemクラス内のオーバーライド準拠
            System.out.println(item.toString()) ;
        }
    }

    public void addItemToCart(int itemId){

    }

    public void showCartItems(){

    }

    public boolean showChange(int payment){
        return false ;
    }
}
