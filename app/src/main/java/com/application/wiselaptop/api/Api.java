package com.application.wiselaptop.api;

import com.application.wiselaptop.utils.WLDatabase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

public class Api {

    private String path;

    private ValueEventListener valueEventListener;

    public Api() {
    }

    public Api(String path, ValueEventListener valueEventListener) {
        this.path = path;
        this.valueEventListener = valueEventListener;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public ValueEventListener getValueEventListener() {
        return valueEventListener;
    }

    public void setValueEventListener(ValueEventListener valueEventListener) {
        this.valueEventListener = valueEventListener;
        DatabaseReference databaseRef = WLDatabase.getReference(this.path);
        databaseRef.addValueEventListener(valueEventListener);
    }
}
