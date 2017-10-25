package serem.lab2sqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DatabaseHandler db = new DatabaseHandler(this);
        /**
         * Crud operations
         */

        //inserting new contacts
        Log.d("insert: ", "inserting ..");
        db.addContact(new Contact("kevo", "123456789"));
        db.addContact(new Contact("lolo", "987654321"));
        db.addContact(new Contact("tony", "099999999"));
        db.addContact(new Contact("bunde", "09823344"));


//product
        Log.e("insert: ", "inserting ..");
        db.addProduct(new Product("unga", "200kg"));
        db.addProduct(new Product("cooking oil", "20litres"));
        db.addProduct(new Product("soap", "50 bars"));
        db.addProduct(new Product("maize", "900kg"));
//SHOP
        Log.e("insert: ", "inserting ..");
        db.addShop(new Shop("kili", "eastlands"));
        db.addShop(new Shop("south c", "junction store"));
        db.addShop(new Shop("madaraka", "foodstore"));
        db.addShop(new Shop("dukasstore", "siwaka plaza"));


        Log.d("Reading: ", "Reading all contact..");
        List<Contact> contact = db.getAllcontact();

        for (Contact cn : contact) {
            Log.e("n", cn.getName());
            String log = "id: " + cn.getId() + " ,Name:" + cn.getName()
                    + " ,phone:" + cn.getPhoneNumber();
            Log.e("Name: ", log);

            //product
            Log.d("Reading: ", "Reading all product..");
            List<Product> product = db.getAllproduct();

            for (Product pn : product) {
                Log.d("n", pn.getProduct_Name());
                String vog = "id: " + pn.getId() + " ,ProductName:" + pn.getProduct_Name()
                        + " ,quantity:" + pn.getQuantity();
                Log.e("product_name: ", log);

                //shop
                Log.d("Reading: ", "Reading all shop..");
                List<Shop> shop = db.getAllshop();

                for (Shop sp : shop) {
                    Log.e("n", sp.getsName());
                    String tog = "id: " + sp.getsId() + " ,Name:" + sp.getsName()
                            + " ,address:" + sp.getsAddress();
                    Log.e("name: ", log);


                }
            }
        }
    }
}