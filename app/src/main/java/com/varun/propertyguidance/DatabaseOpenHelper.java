package com.varun.propertyguidance;

import android.content.Context;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

public class DatabaseOpenHelper extends SQLiteAssetHelper {
    private static final String dbname="minip5.db";
    private static final int dbversion=1;

    public DatabaseOpenHelper(Context context){
        super(context,dbname,null,dbversion);
    }
}
