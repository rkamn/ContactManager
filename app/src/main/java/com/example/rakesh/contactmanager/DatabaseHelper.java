package com.example.rakesh.contactmanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by rakesh on 20/12/17.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME="contacts.db";
    private static final String TABLE_NAME="contacts";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null,8);


    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE "+TABLE_NAME+" (ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT,MOBILE_NUMBER INTEGER,EMAIL_ADRESS TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL("DROP TABLE IF EXISTS " +TABLE_NAME);
            onCreate(db);
    }
    public boolean insertData(String name, int mobile_number,String email){

        SQLiteDatabase db=this.getWritableDatabase();

        ContentValues contentValues=new ContentValues();
        contentValues.put("NANAE",name);
        contentValues.put("MOBILE_NUMBER",mobile_number);
        contentValues.put("EMAIL",email);

        long result= db.insert(TABLE_NAME,null,contentValues);
        return result != -1;
    }
    public Cursor getData(String mobile_number){

        SQLiteDatabase db=this.getWritableDatabase();

        String query="SELECT * FROM " +TABLE_NAME+ "WHERE MOBILE_NUMBER = ' " +mobile_number+"'";

        Cursor cursor;
        cursor = db.rawQuery(query,null);

        return cursor;
    }


}
