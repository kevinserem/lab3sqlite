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

public class Contact {

    int _id;
    String _name;
    String _phone_number;

    public Contact(){


    }

    public Contact(int id, String name, String _phone_number){

        this._id = id;
        this._name = name;
        this. _phone_number=_phone_number;

    }


    public Contact(String name, String _phone_number){


        this._name = name;
        this._phone_number= _phone_number;

    }

    public void setId(int _id) {
        this._id = _id;
    }

    public int getId() {
        return _id;
    }

    public String getName() {
        return _name;
    }

    public void setName(String _name) {
        this._name = _name;
    }

    public String getPhoneNumber() {
        return _phone_number;
    }

    public void setPhoneNumber(String _phone_number) {
        this._phone_number = _phone_number;
    }
}
