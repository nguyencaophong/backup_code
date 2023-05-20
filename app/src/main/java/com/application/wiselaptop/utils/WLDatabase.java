package com.application.wiselaptop.utils;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class WLDatabase {

    public final static FirebaseDatabase databaseRef = FirebaseDatabase.getInstance();

    public static DatabaseReference getReference(String path)  {
        return databaseRef.getReference(path);
    }
}
