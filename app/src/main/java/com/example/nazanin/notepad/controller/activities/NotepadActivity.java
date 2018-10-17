package com.example.nazanin.notepad.controller.activities;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.nazanin.notepad.R;
import com.example.nazanin.notepad.controller.FileManager;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;


public class NotepadActivity extends AppCompatActivity {
    private EditText noteTextView;
    private EditText titleTextView;
    private Button saveButton;
    private String filename,note;
    private FileManager fileManager;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notepad);
        context=this;
        fileManager=new FileManager();
        //find
        titleTextView=findViewById(R.id.titleTextView);
        noteTextView=findViewById(R.id.note);
        saveButton=findViewById(R.id.save);
        //


    }


    public void save(View view) {
        filename = titleTextView.getText().toString();
        note = noteTextView.getText().toString();

        if (!isEmpty(filename,note)) {
            fileManager.saveFile(filename, note, context);
            Toast.makeText(this, "یادداشت ذخیره شد", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    private boolean isEmpty(String filename,String note){
        if (TextUtils.isEmpty(filename)) {
            Toast.makeText(this, "لطفا عنوان یادداشت را انتخاب کنید", Toast.LENGTH_SHORT).show();
            return true;
        }
        if (TextUtils.isEmpty(note)) {
            Toast.makeText(this, "لطفا متن یادداشت را بنویسید", Toast.LENGTH_SHORT).show();
            return true;
        }
        return false;
    }


}
