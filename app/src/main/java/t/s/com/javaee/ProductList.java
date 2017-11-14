package t.s.com.javaee;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Administrator on 2017/11/1.
 */

public class ProductList extends Observable {
    private List<String> productList = null;//产品列表
    private static ProductList instance;
    private ProductList(){};
    public static ProductList getInstance(){
        if(instance==null){
            instance=new ProductList();
            instance.productList=new ArrayList<>();
        }
        return instance;
    }

    public void addProductListObserver(Observer observable){
        this.addObserver(observable);
    }

    public void addProuduct(String newProduct){
        productList.add(newProduct);

        Log.i("Observable","Observable");
        this.setChanged();
        this.notifyObservers(newProduct);
    }

}
