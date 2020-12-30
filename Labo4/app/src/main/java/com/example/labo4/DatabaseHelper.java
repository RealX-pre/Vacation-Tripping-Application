package com.example.labo4;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
 /*    public static final int DATABASE_VERSION = 1;*/
    public static final String DATABASE_NAME = "register.db";
    public static final String TABLE_NAME = "registeruser";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "username";
    public static final String COL_3 = "password";
    public static final String COL_4 = "age";
    public static final String COL_5 = "number";
    public static final String COL_6 = "gender";
    public static final String COL_7 = "dayofbirh";

/*
    public static final String CREATE_REGISTER =
            " CREATE TABLE " + RegisterDbContract.RegisterTable._ID + "INTEGER PRIMARY KEY,"
                    + RegisterDbContract.RegisterTable.COLUMN_NAME + " TEXT, "
                    + RegisterDbContract.RegisterTable.COLUMN_PASS + " TEXT, "
                    + RegisterDbContract.RegisterTable.COLUMN_AGE + " TEXT, "
                    + RegisterDbContract.RegisterTable.COLUMN_NUM + " TEXT, "
                    + RegisterDbContract.RegisterTable.COLUMN_GEN + " TEXT, "
                    + RegisterDbContract.RegisterTable.COLUMN_DOB + " TEXT) ";
    public static final String DELETE_REGISTER =
            " DROP TABLE IF EXISTS " + RegisterDbContract.RegisterTable.TABLE_NAME;

*/

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE registeruser (ID INTEGER PRIMARY KEY AUTOINCREMENT , username TEXT , password INTEGER PRIMARY KEY AUTOINCREMENT , age TEXT, number TEXT , gender TEXT , dayofbirth TEXT )");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL(" DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);

    }

    public long addUser(String user, String password, String age, String number, String gender, String dob) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", user);
        contentValues.put("password", password);
        contentValues.put("age", age);
        contentValues.put("number", number);
        contentValues.put("gender", gender);
        contentValues.put("dayofbirth", dob);
        long res = db.insert("registeruser", null, contentValues);
        db.close();
        return res;

    }

    public boolean checkUser(String user, String pwd) {
        int count = 0;
        try {

            String[] columns = {COL_1};
            SQLiteDatabase db = getReadableDatabase();
            String selection = COL_2 + "=?" + " and " + COL_3 + "=?" /*+ COL_4 + "=?" + " and " + COL_5 + "=?" + COL_6 + "=?" + " and " + COL_7 + "=?"*/;
            String[] selectionArgs;
            Log.i("sel:", selection);
            System.out.println("select:"+selection);
            selectionArgs = new String[]{user, pwd};
            Cursor cursor;
            cursor = db.query(TABLE_NAME, columns, selection, selectionArgs,  null, null, null);
            count = cursor.getCount();
            cursor.close();
            db.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        if (count > 0) {
            return true;
        } else
            return false;
    }
    public boolean updateData (String password , String user, String age, String number, String gender, String dob){
        SQLiteDatabase db  = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", user);
        contentValues.put("password", password);
        contentValues.put("age", age);
        contentValues.put("number", number);
        contentValues.put("gender", gender);
        contentValues.put("dayofbirth", dob);
        db.update(TABLE_NAME,contentValues,"password = ?" , new String[] { password });
        return true;

    }
    public boolean updatePassword(String username , String password){
        SQLiteDatabase db  = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("password", password);
        db.update(TABLE_NAME,contentValues,"username = ?" , new String[] { username });
        return true;

    }/*
        public Cursor readUser(){
        SQLiteDatabase db  = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from registeruser" , null);
        return cursor;

    }
*/
    public Cursor getdata(String username){
        SQLiteDatabase db = this.getWritableDatabase();
        String qry="select * from " +TABLE_NAME+" where username=" +username ;
        Cursor crs = db.rawQuery(qry,null);
        return crs;
    }


}
