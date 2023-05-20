package com.application.wiselaptop.api;

import androidx.annotation.NonNull;

import com.application.wiselaptop.models.Product;
import com.application.wiselaptop.utils.WLDatabase;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

public class ProductApi {
    public final static String KEY_PRODUCT_ENTITY = "products";
    public final static DatabaseReference productRef = WLDatabase.getReference(KEY_PRODUCT_ENTITY);

    public void readAllProduct(ValueEventListener valueEventListener){
        if(valueEventListener != null){
            productRef.addValueEventListener(valueEventListener);
        }
    }

    public void createProduct(Product product){
        productRef.child(product.getProductId()).setValue(product.toObject());
    }

    public void updateProduct(Product product){
        productRef.child(product.getProductId()).setValue(product.toObject());
    }

    public void deleteProduct(String key, Object value){

    }
}
