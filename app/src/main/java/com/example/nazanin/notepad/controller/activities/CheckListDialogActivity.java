package com.example.nazanin.notepad.controller.activities;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.nazanin.notepad.R;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class CheckListDialogActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText whatToDoEditText;
    private Button ok;
    private String whatToDo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_list_dialog);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        int height = dm.heightPixels;
        getWindow().setLayout((int)(width*.6),(int)(height*.4));
        whatToDoEditText=findViewById(R.id.whatToDo);
        ok=findViewById(R.id.ok);
        ok.setOnClickListener(this);

    //    Toast.makeText(this,whatToDo,Toast.LENGTH_SHORT).show();

    }
    private boolean isEmpty(String whatToDo){
        if (TextUtils.isEmpty(whatToDo)){
            Toast.makeText(this,"فیلد مورد نظر خالی است",Toast.LENGTH_SHORT).show();
            return true;
        }
        return false;
    }

    @Override
    public void onClick(View v) {
        whatToDo=whatToDoEditText.getText().toString();
        if (!isEmpty(whatToDo)) {
            Intent intent = new Intent();
            intent.putExtra("whatToDo", whatToDo);

            setResult(RESULT_OK, intent);
            finish();
        }
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}
