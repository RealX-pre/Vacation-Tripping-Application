package com.example.lab4ver;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.net.URI;

public class RegisterContentPovider extends ContentProvider {

    private static final int USER = 100;
    private static final int USER_ID = 101;

    public static final String AUTHORITY_NAME = "com.example.lab4ver";
     public static final Uri USER_URI = Uri.parse("content://" + AUTHORITY_NAME + "/" + RegisterDbContract.RegisterTable.TABLE_NAME);
    public static final Uri USER_URI_ID = Uri.parse("content://" + AUTHORITY_NAME + "/" + RegisterDbContract.RegisterTable.TABLE_NAME +"/"+USER_ID);

    private RegisterDbHelper reHelper ;
    private static final UriMatcher registerUriMatcher() = buildUriMatcher();

    private static UriMatcher buildUriMartcher(){
        final UriMatcher matcher = new UriMatcher(UriMatcher.NO_MATCH);

        matcher.addURI(AUTHORITY_NAME,RegisterDbContract.RegisterTable.TABLE_NAME,USER);
        matcher.addURI(AUTHORITY_NAME,RegisterDbContract.RegisterTable.TABLE_NAME+"/*",USER_ID);

        return matcher;
    }




    @Override
    public boolean onCreate() {
        Context context = getContext();
        reHelper = new RegisterDbHelper(context);
        return true;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
     Cursor  cursor = null;
     final SQLiteDatabase db = reHelper.getReadableDatabase();
     switch (registerUriMatcher().match(uri)){
         case USER:
             cursor=db.query(RegisterDbContract.RegisterTable.TABLE_NAME,projection,selection,selectionArgs,null,null,sortOrder);
             break;
     }
     return cursor;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        Uri turi = null;
        if (reHelper == null)
            reHelper  = new RegisterDbHelper(MainActivity.getAppContext());
        final SQLiteDatabase db = reHelper.getWritableDatabase();
        switch (registerUriMatcher().match(uri)){
            case USER:
                long _ID1 = db.insert(RegisterDbContract.RegisterTable.TABLE_NAME,null,values);
                if (_ID1>0){
                    turi = ContentUris.withAppendedId(USER_URI,_ID1);
                    getContext().getContentResolver().notifyChange(turi,null);3
                }
                break;
            default:throw new SQLException("Failed to insert row into" + uri);
        }
        return turi;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }


}
