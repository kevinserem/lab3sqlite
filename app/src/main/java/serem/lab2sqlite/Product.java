package serem.lab2sqlite;



import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Seremio 7 on 10/19/2017.
 */

public class Product {

    int _id;
    String _product_name;
    String _quantity;

    public Product(){


    }

    public Product(int id, String _product_name, String _quantity){

        this._id = id;
        this._product_name = _product_name;
        this. _quantity=_quantity;

    }


    public Product(String product_namename, String _quantity){


        this._product_name = product_namename;
        this._quantity= _quantity;

    }

    public void setId(int _id) {
        this._id = _id;
    }

    public int getId() {
        return _id;
    }

    public String getProduct_Name() {
        return _product_name;
    }

    public void setProductName(String _productname) {
        this._product_name = _product_name;
    }

    public  String getQuantity() {
        return _quantity;
    }

    public void setQuantity(String _quantity) {
        this._quantity = _quantity;
    }


}
