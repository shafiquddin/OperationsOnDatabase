package com.example.android.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class dataBaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "contact.db";
    private static final String TABLE_NAME = "contact";
    public static final String COL_2 = "NAME";
    public static final String COL_3 = "MOBILE";
    public static final String COL_4 = "EMAIL";


    public dataBaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
//        SQLiteDatabase db=this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,MOBILE LONG,EMAIL TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertdata(String name, Long Mobile_no, String Email) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, name);
        contentValues.put(COL_3, Mobile_no);
        contentValues.put(COL_4, Email);
        Long result = db.insert(TABLE_NAME, null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }

    public Cursor getData(String mobile_number) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME +" WHERE "+COL_3+" ='" + mobile_number + "'";
        Cursor cursor = db.rawQuery(query, null);
        return cursor;
    }
    public void getDelete(String mobile_number){
        SQLiteDatabase db = this.getWritableDatabase();
       db.delete(TABLE_NAME,"MOBILE = '"+mobile_number+"'",null);
       db.close();

    }
    public void update(String number,String name,String Email){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("NAME",name);
        contentValues.put("EMAIL",Email);

        db.update(TABLE_NAME,contentValues,"MOBILE = '"+number+"'",null);
        db.close();
    }
    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME,null);
        return res;
    }

}
