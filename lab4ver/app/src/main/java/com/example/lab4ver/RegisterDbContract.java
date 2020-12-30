package com.example.lab4ver;

import android.provider.BaseColumns;

public class RegisterDbContract {
    private RegisterDbContract() {}

    public static class RegisterTable implements BaseColumns{
        public static final String TABLE_NAME = "registeruser";
        public static final String COLUMN_NAME = "username";
        public static final String COLUMN_PASS = "password";
        public static final String COLUMN_AGE = "age";
        public static final String COLUMN_NUM = "number";
        public static final String COLUMN_GEN = "gender";
        public static final String COLUMN_DOB = "dob";

    }
}
