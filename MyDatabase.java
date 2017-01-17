package com.palle.uni_project;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Alam on 1/11/2017.
 */
public class MyDatabase {
    MyHelper myHelper;
    SQLiteDatabase sqLiteDatabase;


    public MyDatabase(Context c) // context is use behalf of this
    {
        //database name

        myHelper = new MyHelper(c,"university.db",null,1); // table version no : 1
    }



    // create open method
    public void open()
    {

        sqLiteDatabase = myHelper.getWritableDatabase(); // for passing data in database
    }

    //step8:perform dml operation

    public void insertStudent(String no,String name,String mobile,String email,String subject,String description, String date)
    {
        ContentValues cv = new ContentValues(); // for insert update use ContentValues(pass data to database)
        cv.put("no", no);
        cv.put("name", name);
        cv.put("mobile", mobile);
        cv.put("email", email);
        cv.put("subject", subject);
        cv.put("description", description);
        cv.put("date",date);
        sqLiteDatabase.insert("student", null, cv);
    }

    public Cursor queryStudent(){
        Cursor c= null;
        c = sqLiteDatabase.query("student", null, null, null,null, null,null);
        return c;
    }

    public Cursor queryName(String name){
        Cursor c= null;
        try {
            c = sqLiteDatabase.query("student", null, "name=?", new String[]{name}, null, null, null);
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return c;
    }
    public Cursor queryMobile(String mobile){
        Cursor cursor = null;
        cursor = sqLiteDatabase.query("student", null, "mobile =?", new String[]{mobile}, null, null, null);
        return cursor;
    }

    public void close()
    {

        sqLiteDatabase.close();
    }
    private class MyHelper extends SQLiteOpenHelper {

        public MyHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {

            sqLiteDatabase.execSQL("create table student(_id integer primary key, no text, name text, mobile text, email text, subject text, description text, date text);");

        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        }
    }
}
