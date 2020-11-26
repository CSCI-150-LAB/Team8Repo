package com.example.myapplication43;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class DB_Controller extends SQLiteOpenHelper {


    public DB_Controller(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, "UserInfo.db", factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE USERS(ID INTEGER PRIMARY KEY AUTOINCREMENT, USERNAME TEXT UNIQUE, EMAIL TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS USERS;");
        onCreate(db);
    }
    public void insert_users(String username, String email) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("Username",username);
        contentValues.put("Email", email);
        this.getWritableDatabase().insertOrThrow("USERS", "", contentValues);
    }
    public void delete_users(String username) {
        this.getWritableDatabase().delete("USERS", "USERNAME='"+username+"'",null);
    }

    public void update_users(String old_username, String new_username) {
        this.getWritableDatabase().execSQL("UPDATE USERS SET USERNAME='"+new_username+"'WHERE USERNAME'"+old_username+"'");
    }
    public void list_all_users(TextView textView) {
        Cursor cursor = this.getReadableDatabase().rawQuery("SELECT * FROM USERS", null);
        textView.setText("");
        while(cursor.moveToNext()) {
            textView.append(cursor.getString(1)+" "+cursor.getString(2)+"\n");
        }
    }
}
