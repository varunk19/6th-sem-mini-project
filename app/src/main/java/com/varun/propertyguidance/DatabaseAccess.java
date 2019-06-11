package com.varun.propertyguidance;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;

public class DatabaseAccess {
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase db;
    private static DatabaseAccess instance;
    public Cursor c;
    //private constructor so that object creation from outside the class is avoided
    private DatabaseAccess(Context context){
        this.openHelper=new DatabaseOpenHelper(context);
    }
    //to return single instance of database
    public static DatabaseAccess  getInstance(Context context){
        if (instance==null)
            instance=new DatabaseAccess(context);
        return instance;
    }
    //to open database
    public void open(){
        this.db=openHelper.getReadableDatabase();
    }
    public void run(String query){
        c=db.rawQuery(query,null);
    }
    public ArrayList<testadapter> st(String prop){
        ArrayList<testadapter> t=new ArrayList<>();
        if(c.moveToFirst()){
            do {
                testadapter a=new testadapter(c.getString(0),prop,c.getString(1));
                t.add(a);
            }while (c.moveToNext());
        }
        return t;
    }
    public ArrayList<searchadapter> st(){
        ArrayList<searchadapter> sea=new ArrayList<>();
        if(c.moveToFirst()){
            do {
                searchadapter a=new searchadapter(c.getString(0));
                sea.add(a);
            }while (c.moveToNext());
        }
        return sea;
    }
    public ArrayList<testadapter2> st(String prop1,String prop2){
        ArrayList<testadapter2> t=new ArrayList<>();
        if(c.moveToFirst()){
            do {
                testadapter2 a=new testadapter2(c.getString(0),prop1,c.getString(1),prop2,c.getString(2));
                t.add(a);
            }while (c.moveToNext());
        }
        return t;
    }
    //to close database
    public void close(){
        if (db!=null)
            this.db.close();
    }
    //query execution for search

    //query execution to get state name
    public ArrayList<String> getdetails(){
        ArrayList<String> det=new ArrayList<String>();
        int i=0;
        String st;
            for (i=0;i<11;i++) {
                if (c.moveToFirst()){
                do {
                    st = c.getString(i);
                } while (c.moveToNext());
                det.add(st);
            }
        }
        return det;
    }
}
