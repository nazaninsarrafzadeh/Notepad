package com.example.nazanin.notepad.controller.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.example.nazanin.notepad.R;
import com.example.nazanin.notepad.controller.adapters.CheckListAdapter;
import com.example.nazanin.notepad.controller.adapters.NoteAdapter;
import com.example.nazanin.notepad.model.dto.CheckList;
import com.example.nazanin.notepad.model.dao.CheckListDbHelper;

import java.util.LinkedList;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class CheckListActivity extends AppCompatActivity {

    private String whatToDo;
//    private LinearLayout checkListLayout;
    private RecyclerView recyclerView;
    private LinkedList<CheckList> checkLists=new LinkedList<>();
    private CheckListDbHelper checkListDbHelper;
    private CheckListAdapter checkListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_list);

        recyclerView=findViewById(R.id.checkListsView);

        checkListDbHelper=new CheckListDbHelper(this);
        checkLists=checkListDbHelper.getCheckLists();

        checkListAdapter=new CheckListAdapter(checkLists,this);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(checkListAdapter);


    }

    public void save(View view) {
    }

    private void insert(){

        CheckList checkList=new CheckList();
        checkList.setDone(false);
        checkList.setWhatToDo(whatToDo);
        checkLists.add(checkList);
        checkListDbHelper.insertCheckList(checkList);
    }

    public void makeNewCheklist(View view) {
        Intent intent=new Intent(this,CheckListDialogActivity.class);
        startActivityForResult(intent,1);
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode==1 && resultCode==RESULT_OK){

            whatToDo=data.getExtras().getString("whatToDo");
            insert();
        }
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}
