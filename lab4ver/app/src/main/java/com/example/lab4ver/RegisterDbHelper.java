package com.example.lab4ver;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class RegisterDbHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAMAE = "register.db";


    public RegisterDbHelper( Context context) {
        super(context, DATABASE_NAMAE, null, DATABASE_VERSION);
    }

    public static final String CREATE_REGISTER =
            " CREATE TABLE " + RegisterDbContract.RegisterTable.TABLE_NAME + " (" +
                    RegisterDbContract.RegisterTable._ID + " INTEGER PRIMARY KEY,"
                    + RegisterDbContract.RegisterTable.COLUMN_NAME + " TEXT, "
                    + RegisterDbContract.RegisterTable.COLUMN_PASS + " TEXT, "
                    + RegisterDbContract.RegisterTable.COLUMN_AGE + " TEXT, "
                    + RegisterDbContract.RegisterTable.COLUMN_NUM + " TEXT, "
                    + RegisterDbContract.RegisterTable.COLUMN_GEN + " TEXT, "
                    + RegisterDbContract.RegisterTable.COLUMN_DOB + " TEXT) ";
    public static final String DELETE_REGISTER =
            " DROP TABLE IF EXISTS " + RegisterDbContract.RegisterTable.TABLE_NAME;


    @Override
    public void onCreate(SQLiteDatabase db) { db.execSQL(CREATE_REGISTER); }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DELETE_REGISTER);
        onCreate(db);

    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

}
