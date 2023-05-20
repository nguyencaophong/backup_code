package com.application.wiselaptop.utils;

import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class WLStorage {
    public final static FirebaseStorage storage = FirebaseStorage.getInstance();

    public static StorageReference getReference(){
        return storage.getReference();
    }
}
