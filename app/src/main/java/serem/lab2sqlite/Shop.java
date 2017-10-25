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


public class Shop {

           int _sid;
        String _sname;
        String _saddress;

        public Shop(){


        }

        public Shop(int _sid, String _sname, String _saddress){

            this._sid = _sid;
            this._sname = _sname;
            this. _saddress=_saddress;

        }


        public Shop(String sname, String _saddress){


            this._sname = _sname;
            this._saddress= _saddress;

        }

        public void setsId(int _sid) {
            this._sid = _sid;
        }

        public int getsId() {
            return _sid;
        }

        public String getsName() {
            return _sname;
        }

        public void setsName(String _sname) {
            this._sname = _sname;
        }

        public  String getsAddress() {
            return _saddress;
        }

        public void setsAddress(String _saddress) {
            this._saddress= _saddress;
        }


    }

