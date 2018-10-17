package com.example.nazanin.notepad.model.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.nazanin.notepad.model.dto.CheckList;

import java.util.LinkedList;

public class CheckListDbHelper {

    private Context context;
    private DbHelper dbHelper;
    private SQLiteDatabase db;
    private LinkedList<CheckList> checkLists;
    public static final String CREATE_TABLE_CheckLists="CREATE TABLE CHECKLISTS(ID INTEGER PRIMARY KEY AUTOINCREMENT,WHATTODO TEXT,DONE INTEGER)";

    public CheckListDbHelper(Context context){
        this.context=context;
        dbHelper=new DbHelper(context);
    }

    public void insertCheckList(CheckList checkList){
        db=dbHelper.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("done",checkList.isDone()? 1:0);
        values.put("whatToDo",checkList.getWhatToDo());
        db.insert("CHECKLISTS",null,values);
    }

    public LinkedList<CheckList> getCheckLists(){
        db=dbHelper.getReadableDatabase();
        checkLists=new LinkedList<>();
        Cursor cursor=db.rawQuery("SELECT * FROM CHECKLISTS",null);
        if (cursor.moveToFirst()){
            while (!cursor.isAfterLast()){
                CheckList checkList=new CheckList();
                checkList.setId(cursor.getInt(cursor.getColumnIndex("ID")));
                checkList.setDone(cursor.getInt(cursor.getColumnIndex("DONE"))==1 ? true:false);
                checkList.setWhatToDo(cursor.getString(cursor.getColumnIndex("WHATTODO")));
                checkLists.add(checkList);
                cursor.moveToNext();
            }
        }
        return checkLists;
    }

    public void delete(int position){
        db=dbHelper.getWritableDatabase();
        db.delete("CHECKLISTS","ID="+position,null);
    }

}
