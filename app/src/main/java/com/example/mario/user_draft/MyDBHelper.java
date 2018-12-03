package com.example.mario.user_draft;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;
import android.content.Context;
import android.content.ContentValues;
import android.widget.Toast;

import java.util.LinkedList;
import java.util.List;


public class MyDBHelper extends SQLiteOpenHelper {


    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "BlutApp.db";
    public static final String TABLE_USERS = "users";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_USERFIRSTNAME = "userfirstname";
    public static final String COLUMN_USERLASTNAME = "userlastname";
    public static final String COLUMN_EMAIL = "email";
    public static final String COLUMN_DOB = "DOB";
    public static final String COLUMN_GEN = "GEN";

    public MyDBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_USERS + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_USERFIRSTNAME + " TEXT, " +
                COLUMN_USERLASTNAME + " TEXT, " +
                COLUMN_EMAIL + " TEXT, " +
                COLUMN_DOB + " TEXT, " +
                COLUMN_GEN + " TEXT" +
                ");";
        db.execSQL(query);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
        onCreate(db);
    }

    public void addUser(Users user) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_USERFIRSTNAME, user.get_usernamefirst());
        values.put(COLUMN_USERLASTNAME, user.get_usernamelast());
        values.put(COLUMN_EMAIL, user.get_email());
        values.put(COLUMN_DOB, user.get_DOB());
        values.put(COLUMN_GEN, user.get_GEN());

        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_USERS, null, values);
        db.close();
    }

    public void editUser(int userID, String VornameNeu, String NachnameNeu, String EmailNeu, String DOBNeu, String GENNeu){
        SQLiteDatabase db = getWritableDatabase();
        String query1 = "UPDATE "+TABLE_USERS+ " SET "+COLUMN_USERFIRSTNAME+" = '"+VornameNeu+"' WHERE "+COLUMN_ID+" ='"+userID+"'";
        String query2 = "UPDATE "+TABLE_USERS+ " SET "+COLUMN_USERLASTNAME+" = '"+NachnameNeu+"' WHERE "+COLUMN_ID+" ='"+userID+"'";
        String query3 = "UPDATE "+TABLE_USERS+ " SET "+COLUMN_EMAIL+" = '"+EmailNeu+"' WHERE "+COLUMN_ID+" ='"+userID+"'";
        String query4 = "UPDATE "+TABLE_USERS+ " SET "+COLUMN_DOB+" = '"+DOBNeu+"' WHERE "+COLUMN_ID+" ='"+userID+"'";
        String query5 = "UPDATE "+TABLE_USERS+ " SET "+COLUMN_GEN+" = '"+GENNeu+"' WHERE "+COLUMN_ID+" ='"+userID+"'";

        db.execSQL(query1);
        db.execSQL(query2);
        db.execSQL(query3);
        db.execSQL(query4);
        db.execSQL(query5);

        db.close();
    }

    public void clearTable(){
        SQLiteDatabase db = getWritableDatabase();
        db.delete(TABLE_USERS, null, null);
    }


    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + TABLE_USERS, null);
        return c;
    }

    public Cursor getID_relatedData(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM "+ TABLE_USERS + " WHERE "+COLUMN_ID+" = "+id, null);
        return c;
    }

    public String db2String() {
       Cursor c = getAllData();
       String test = "KDK";
       if(c.getCount() == 0) {
           //showMessage("Error"," Nothing found");
           return "";
       }
        StringBuffer buffer = new StringBuffer();
        while (c.moveToNext()) {
            buffer.append("ID :"+c.getString(0)+"\n");
            buffer.append("Vorname :"+c.getString(1)+"\n");
            buffer.append("Nachname :"+c.getString(2)+"\n");
            buffer.append("Email :"+c.getString(3)+"\n");
            buffer.append("Geburtsdatum :"+c.getString(4)+"\n");
            buffer.append("Geschlecht: "+c.getString(5)+"!");

        }

        test = buffer.toString();
        return test;


    }
    private ContentValues getContentValues(Users user){
        ContentValues values = new ContentValues();
        values.put(COLUMN_USERFIRSTNAME, user.get_usernamefirst());
        values.put(COLUMN_USERLASTNAME, user.get_usernamelast());
        values.put(COLUMN_EMAIL, user.get_email());
        values.put(COLUMN_DOB, user.get_DOB());
        values.put(COLUMN_GEN, user.get_GEN());

        return values;
    }
}
