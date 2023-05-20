package com.application.wiselaptop.api;

import com.application.wiselaptop.utils.WLDatabase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

public class BrandApi {
    public final static String KEY_BRAND_ENTITY = "brand";

    public final static DatabaseReference brandRef = WLDatabase.getReference(KEY_BRAND_ENTITY);

    public void readAllBrand(ValueEventListener valueEventListener){
        if(valueEventListener != null){
            brandRef.addValueEventListener(valueEventListener);
        }
    }

    public static Map<String, String> readBrand(){
        Map<String, String> mBrand = new HashMap<>();
        mBrand.put("1", "Sam sung");
        mBrand.put("2", "Apple");
        mBrand.put("3", "Lenovo");
        mBrand.put("4", "Xiaomi");
        mBrand.put("5", "Blackberry");
        return mBrand;
    }
}
