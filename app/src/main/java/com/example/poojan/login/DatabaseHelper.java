package com.example.poojan.login;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION=1;
    private static final String DATABASE_NAME="database.db";
    private static final String SIGN_TABLE_NAME="login";
    private static final String SIGN_COLUMN_UNAME="uname";
    private static final String SIGN_COLUMN_NAME="name";
    private static final String SIGN_COLUMN_REPASS="repass";
    private static final String SIG_COLUMN_PASS="pass";
    private static final String SIGN_COLUMN_AGE="age";

    private static final String COMPLAIN_TABLE_NAME="complain";
    private static final String COMPLAIN_HOUSE_ID="hid";
    private static final String COMPLAIN_MEMBER_ID="mid";
    private static final String COMPLAIN_COMPLAIN="complain";
    private static final String COMPLAIN_SEVERITY="severity";



    private static final String SELL_TABLE_NAME="sell";
    private static final String SELL_HOUSE_ID="hid";
    private static final String SELL_SELL_ID="sid";
    private static final String SELL_PRICE="price";

    private static final String MEMBER_TABLE_NAME="member";
    private static final String MEMBER_ID="mid";
    private static final String MEMEBR_HOUSE_ID="hid";
    private static final String MEMBER_NAME="mname";
    private static final String MEMBER_TYPE="mtype";

    SQLiteDatabase sqLiteDatabase;

    public DatabaseHelper(Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);


    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String TABLE_CREATE="CREATE TABLE login (uname TEXT PRIMARY KEY,pass TEXT,repass TEXT,name TEXT,age INTEGER);";
        String TABLE_CREATE1="CREATE TABLE complain (hid INTEGER PRIMARY KEY , mid TEXT,complain TEXT,severity INTEGER);";
        String TABLE_CREATE2="CREATE TABLE sell (sid INTEGER PRIMARY KEY , hid INTEGER,price INTEGER);";
        String TABLE_CREATE3="CREATE TABLE member (mid INTEGER PRIMARY KEY , hid INTEGER,mname TEXT,mtype TEXT);";
        sqLiteDatabase.execSQL(TABLE_CREATE);
        sqLiteDatabase.execSQL(TABLE_CREATE1);
        sqLiteDatabase.execSQL(TABLE_CREATE2);
        sqLiteDatabase.execSQL(TABLE_CREATE3);
        this.sqLiteDatabase=sqLiteDatabase;
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String query= String.format("DROP TABLE IF EXISTS%s", SIGN_TABLE_NAME);
        String query1= String.format("DROP TABLE IF EXISTS%s", COMPLAIN_TABLE_NAME);
        String query2= String.format("DROP TABLE IF EXISTS%s", SELL_TABLE_NAME);
        sqLiteDatabase.execSQL(query);
        sqLiteDatabase.execSQL(query1);
        sqLiteDatabase.execSQL(query2);

        this.onCreate(sqLiteDatabase);
    }

    public  boolean insert(String uname, String name, String pass, String repass, String age){
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(SIGN_COLUMN_UNAME,uname);

        contentValues.put(SIGN_COLUMN_AGE,age);
        contentValues.put(SIGN_COLUMN_REPASS,repass);
        contentValues.put(SIGN_COLUMN_NAME,name);
        contentValues.put(SIG_COLUMN_PASS,pass);
        long ins=sqLiteDatabase.insert("login",null,contentValues);
        if (ins==-1){return false;}
        else { return true;}
    }

    public  boolean insert1(String hid, String mid, String complain, String severity){
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COMPLAIN_HOUSE_ID,hid);
        contentValues.put(COMPLAIN_MEMBER_ID,mid);
        contentValues.put(COMPLAIN_SEVERITY,complain);
        contentValues.put(COMPLAIN_SEVERITY,severity);

        long ins=sqLiteDatabase.insert("complain",null,contentValues);
        if (ins==-1){return false;}
        else { return true;}
    }

    public  boolean insert2(String sid, String hid, String price){
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(SELL_HOUSE_ID,hid);
        contentValues.put(SELL_SELL_ID,sid);
        contentValues.put(SELL_PRICE,price);
        long ins=sqLiteDatabase.insert("sell",null,contentValues);
        if (ins==-1){return false;}
        else { return true;}
    }


    public boolean insert3(String mid, String hid,String mname,String mtype){
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(MEMBER_ID,mid);
        contentValues.put(MEMEBR_HOUSE_ID,hid);
        contentValues.put(MEMBER_NAME,mname);
        contentValues.put(MEMBER_TYPE,mtype);
        long ins=sqLiteDatabase.insert("member",null,contentValues);
        if (ins==-1){return false;}
        else { return true;}
    }

    public Cursor cgetalldata(){
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        Cursor res=sqLiteDatabase.rawQuery("select * from complain",null);
        return res;
    }
    public Cursor mgetalldata(){
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        Cursor res=sqLiteDatabase.rawQuery("select * from complain",null);
        return res;
    }

    public Integer deleteData(String mid){
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        return sqLiteDatabase.delete(MEMBER_TABLE_NAME,"mid = ?",new String[] {mid});

    }


    public boolean chkusername(String uname)
    {
        SQLiteDatabase sqLiteDatabas=this.getReadableDatabase();
        Cursor cursor=sqLiteDatabas.rawQuery("select * from login where uname=?",new String[]{uname});
        if(cursor.getCount()>0){return false;}
        else {return true;}
    }
}
