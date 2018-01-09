package com.example.mbarr.notetoself;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by mbarr on 1/8/2018.
 */

public class Note {

    private String mTitle;
    private String mDescription;
    private boolean mIdea;
    private boolean mTodo;
    private boolean mImportant;

    private static final String JSON_TITLE = "title";
    private static final String JSON_DESCRIPTION = "description";
    private static final String JSON_IDEA = "idea";
    private static final String JSON_TODO = "todo";
    private static final String JSON_IMPORTANT = "important";

    // Constructor
    // Only used when new is called with a JSONObject
    public Note(JSONObject jo) throws JSONException {

        mTitle = jo.getString(JSON_TITLE);
        mDescription = jo.getString(JSON_DESCRIPTION);
        mIdea = jo.getBoolean(JSON_IDEA);
        mTodo = jo.getBoolean(JSON_TODO);
        mImportant = jo.getBoolean(JSON_IMPORTANT);
    }
    // Now we must provide an empty default constructor
    // for when we create a Note as we provide a
    // specialized constructor that must be used.
    public Note() {}

    public JSONObject convertToJSON() throws JSONException {

        JSONObject jo = new JSONObject();
        jo.put(JSON_TITLE, mTitle);
        jo.put(JSON_DESCRIPTION, mDescription);
        jo.put(JSON_IDEA, mIdea);
        jo.put(JSON_TODO, mTodo);
        jo.put(JSON_IMPORTANT, mImportant);

        return jo;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getmDescription() {
        return mDescription;
    }

    public void setmDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    public boolean ismIdea() {
        return mIdea;
    }

    public void setmIdea(boolean mIdea) {
        this.mIdea = mIdea;
    }

    public boolean ismTodo() {
        return mTodo;
    }

    public void setmTodo(boolean mTodo) {
        this.mTodo = mTodo;
    }

    public boolean ismImportant() {
        return mImportant;
    }

    public void setmImportant(boolean mImportant) {
        this.mImportant = mImportant;
    }
}
