package com.application.wiselaptop.api;

import com.application.wiselaptop.utils.WLDatabase;
import com.google.firebase.database.DatabaseReference;

import java.util.HashMap;
import java.util.Map;

public class GroupApi {
    public final static String KEY_GROUP_ENTITY = "group";
    public final static DatabaseReference databaseRef = WLDatabase.getReference(KEY_GROUP_ENTITY);

    public final static Map<String, String> readGroup(){
        Map<String, String> mGroup = new HashMap<>();
        mGroup.put("1", "Phone");
        mGroup.put("2", "WorkStattion") ;
        mGroup.put("3", "LAPTOP");
        mGroup.put("4", "work");
        mGroup.put("5", "microphone");
        return mGroup;
    }
}
