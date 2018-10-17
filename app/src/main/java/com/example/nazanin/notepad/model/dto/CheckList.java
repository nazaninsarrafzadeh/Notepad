package com.example.nazanin.notepad.model.dto;

public class CheckList {

    private boolean done;
    private int id;
    private String whatToDo;

    public CheckList(){

    }

    public CheckList(boolean done, int id, String whatToDo) {
        this.done = done;
        this.id = id;
        this.whatToDo = whatToDo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public String getWhatToDo() {
        return whatToDo;
    }

    public void setWhatToDo(String whatToDo) {
        this.whatToDo = whatToDo;
    }
}
