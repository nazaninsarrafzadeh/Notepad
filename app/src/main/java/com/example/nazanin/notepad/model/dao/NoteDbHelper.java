package com.example.nazanin.notepad.model.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class NoteDbHelper {

    private Context context;
    private DbHelper dbHelper;
    private SQLiteDatabase db;
    public static final String CREATE_TABLE_NOTES="CREATE TABLE NOTES(ID INTEGER PRIMARY KEY AUTOINCREMENT,TITLE TEXT,BODY TEXT)";

    public NoteDbHelper(Context context) {

        this.context=context;
        dbHelper=new DbHelper(context);
    }

}
