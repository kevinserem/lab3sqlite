package serem.lab2sqlite;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import static android.provider.Contacts.SettingsColumns.KEY;

/**
 * Created by Seremio 7 on 10/19/2017.
 */

public class DatabaseHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME ="contactManager";

    private static final String TABLE_CONTACT = "contact";

    //PRODUCT

    private static final String TABLE_PRODUCT= "product";
//shop
private static final String TABLE_SHOP = "shop";


    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "_name";
    private static final String KEY_PH_NO = "phone_number";

    //product
    private static final String KEY_id = "id";
    private static final String KEY_PRODUCT_NAME = "product_name";
    private static final String KEY_QUANTITY = "quantity";
    private String countQuery;

    //SHOP

    private static final String KEY_SID = "id";
    private static final String KEY_SNAME = "_name";
    private static final String KEY_SADDRESS = "address";



    public DatabaseHandler(Context context){

        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_CONTACT_TABLE = "CREATE TABLE " + TABLE_CONTACT + "(" + KEY_ID +
                " INTEGER PRIMARY KEY, " + KEY_NAME + " TEXT, " + KEY_PH_NO + " TEXT " +")";
        db.execSQL(CREATE_CONTACT_TABLE);


        //product
        String CREATE_PRODUCT_TABLE = "CREATE TABLE " + TABLE_PRODUCT + "(" + KEY_ID +
                " INTEGER PRIMARY KEY, " + KEY_PRODUCT_NAME + " TEXT, " + KEY_QUANTITY + " TEXT " +")";
        db.execSQL(CREATE_PRODUCT_TABLE);


        //shop
        String CREATE_SHOP_TABLE = "CREATE TABLE " + TABLE_SHOP + "(" + KEY_SID +
                " INTEGER PRIMARY KEY, " + KEY_SNAME + " TEXT, " + KEY_SADDRESS + " TEXT " +")";
        db.execSQL(CREATE_SHOP_TABLE);



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACT);
//product
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PRODUCT);
//SHOP
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SHOP);


        onCreate(db);

    }

    // crude operations
    public void addContact (Contact contact){
        SQLiteDatabase db = this.getReadableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, contact.getName());
        values.put(KEY_PH_NO, contact.getPhoneNumber());

        db.insert(TABLE_CONTACT , null, values);
        db.close();

    }

//product
    public void addProduct (Product product){
        SQLiteDatabase db = this.getReadableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_PRODUCT_NAME, product.getProduct_Name());
        values.put(KEY_QUANTITY, product.getQuantity());

        db.insert(TABLE_PRODUCT , null, values);
        db.close();

    }
    //SHOP

    public void addShop (Shop shop){
        SQLiteDatabase db = this.getReadableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_SNAME, shop.getsName());
        values.put(KEY_SADDRESS, shop.getsAddress());

        db.insert(TABLE_SHOP , null, values);
        db.close();

    }




    public  Contact getContact (int id) {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_CONTACT, new String[] {KEY_ID ,KEY_NAME,KEY_PH_NO}
                , KEY_ID + "=?", new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor !=null)
            cursor.moveToFirst();
        Contact contact = new Contact(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2));

        return contact;

    }


    //product
    public  Product getProduct (int id) {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_PRODUCT, new String[] {KEY_ID ,KEY_PRODUCT_NAME ,KEY_QUANTITY}
                , KEY_ID + "=?", new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor !=null)
            cursor.moveToFirst();
        Product product = new Product(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2));

        return product;

    }

    //shop
    public  Shop getShop (int id) {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_SHOP, new String[] {KEY_SID ,KEY_SNAME ,KEY_SADDRESS}
                , KEY_SID + "=?", new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor !=null)
            cursor.moveToFirst();
        Shop shop = new Shop(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2));

        return shop;

    }


    public List<Contact> getAllcontact(){
        List<Contact> contactList = new ArrayList<Contact>();

        String selectQuery = "SELECT * FROM " + TABLE_CONTACT;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if(cursor.moveToFirst()) {
            do{

                Contact contact = new Contact();
                contact.setId(Integer.parseInt(cursor.getString(0)));
                contact.setName(cursor.getString(1));
                contact.setPhoneNumber(cursor.getString(2));

                contactList.add(contact);
            }
            while (cursor.moveToNext());

        }
        return contactList;


    }
//product

    public List<Product> getAllproduct(){
        List<Product> productList = new ArrayList<Product>();

        String selectQuery = "SELECT * FROM " + TABLE_PRODUCT;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if(cursor.moveToFirst()) {
            do{

                Product product = new Product();
                product.setId(Integer.parseInt(cursor.getString(0)));
                product.setProductName(cursor.getString(1));
                product.setQuantity(cursor.getString(2));

                productList.add(product);
            }
            while (cursor.moveToNext());

        }
        return productList;


    }


    //shop

    public List<Shop> getAllshop(){
        List<Shop> shopList = new ArrayList<Shop>();

        String selectQuery = "SELECT * FROM " + TABLE_SHOP;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if(cursor.moveToFirst()) {
            do{

                Shop shop = new Shop();
                shop.setsId(Integer.parseInt(cursor.getString(0)));
                shop.setsName(cursor.getString(1));
                shop.setsAddress(cursor.getString(2));

                shopList.add(shop);
            }
            while (cursor.moveToNext());

        }
        return shopList;


    }


    public  int getContactCount() {

        String CountQuery = "SELECT * FROM " + TABLE_CONTACT;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        return cursor.getCount();

    }


    //product

    public  int getProductproduct() {

        String CountQuery = "SELECT * FROM " + TABLE_PRODUCT;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        return cursor.getCount();

    }
    //shop

    public  int getShopshop() {

        String CountQuery = "SELECT * FROM " + TABLE_SHOP;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        return cursor.getCount();

    }





    public int updateContact(Contact contact) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, contact.getName());
        values.put(KEY_PH_NO, contact.getPhoneNumber());


        return  db.update(TABLE_CONTACT, values, KEY_ID + "=?",
                new String[] {String.valueOf(contact.getId())});
    }

//product update
    public int updateProduct(Product product) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_PRODUCT_NAME, product.getProduct_Name());
        values.put(KEY_QUANTITY, product.getQuantity());


        return  db.update(TABLE_PRODUCT, values, KEY_ID + "=?",
                new String[] {String.valueOf(product.getId())});
    }

    //SHOP update
    public int updateShop(Shop shop) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_SNAME, shop.getsName());
        values.put(KEY_SADDRESS, shop.getsAddress());


        return  db.update(TABLE_SHOP, values, KEY_SID + "=?",
                new String[] {String.valueOf(shop.getsId())});
    }



    //delete contact
    public void deleteContact (Contact contact) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_CONTACT, KEY_ID + "=?", new String[]
                { String.valueOf(contact.getId())});
        db.close();
    }



//product delete
public void deleteProduct (Product product) {
    SQLiteDatabase db = this.getWritableDatabase();
    db.delete(TABLE_PRODUCT, KEY_id + "=?", new String[]
            { String.valueOf(product.getId())});
    db.close();
}
    //shop delete
    public void deleteShop (Shop shop) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_SHOP, KEY_SID + "=?", new String[]
                { String.valueOf(shop.getsId())});
        db.close();
    }





}