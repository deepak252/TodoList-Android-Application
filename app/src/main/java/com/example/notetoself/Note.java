package com.example.notetoself;

public class Note {
    private String mTitle,mDescription;
    private Boolean mIdea,mTodo,mImportant;

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    public Boolean isIdea() {
        return mIdea;
    }

    public void setIdea(Boolean mIdea) {
        this.mIdea = mIdea;
    }

    public Boolean isTodo() {
        return mTodo;
    }

    public void setTodo(Boolean mTodo) {
        this.mTodo = mTodo;
    }

    public Boolean isImportant() {
        return mImportant;
    }

    public void setImportant(Boolean mImportant) {
        this.mImportant = mImportant;
    }
}
