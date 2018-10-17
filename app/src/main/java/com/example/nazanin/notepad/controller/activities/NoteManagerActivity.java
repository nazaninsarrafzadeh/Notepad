package com.example.nazanin.notepad.controller.activities;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.nazanin.notepad.R;
import com.example.nazanin.notepad.controller.FileManager;
import com.example.nazanin.notepad.controller.adapters.NoteAdapter;
import com.example.nazanin.notepad.model.dto.Note;

import java.util.ArrayList;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class NoteManagerActivity extends AppCompatActivity {

    private RecyclerView notesRcyclerView;
    private NoteAdapter noteAdapter;
    private ArrayList<Note> notesList=new ArrayList<>();
    private Context context;
    private FileManager fileManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_manager);
        context=this;
        fileManager=new FileManager();
     //   Toast.makeText(this,"oncreate",Toast.LENGTH_SHORT).show();

        notesList=fileManager.prepareNotes(context);

        notesRcyclerView=findViewById(R.id.notesView);
        noteAdapter=new NoteAdapter(notesList,context);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        notesRcyclerView.setLayoutManager(mLayoutManager);
        notesRcyclerView.setItemAnimator(new DefaultItemAnimator());
   //     notesRcyclerView.addItemDecoration(new DividerItemDecoration(this,LinearLayout.VERTICAL));
        notesRcyclerView.setAdapter(noteAdapter);

    }

    public void makeNewNotepad(View view) {
        Intent intent=new Intent(NoteManagerActivity.this,NotepadActivity.class);
        startActivity(intent);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.sortByDate:
                break;
            case R.id.sortByAlphabet:
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        notesList.clear();
        notesList=fileManager.prepareNotes(context);
        noteAdapter.notifyDataSetChanged();
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

}
