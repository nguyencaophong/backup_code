package com.application.wiselaptop.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.application.wiselaptop.R;
import com.application.wiselaptop.adapters.BrandManagementAdapter;
import com.application.wiselaptop.api.data;
import com.application.wiselaptop.models.Brand;
import com.application.wiselaptop.models.Demand;
import com.application.wiselaptop.utils.Constant;
import com.application.wiselaptop.utils.GeneratePath;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.List;


public class BrandManagementActivity extends AppCompatActivity {

    RecyclerView rvBrandManagement;
    ImageButton btnAddBrand;
    BrandManagementAdapter brandManagementAdapter;
    List<Brand> brands;

    int isLoadingStatus;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brand_management);
        setControl();
        fetchData();
        setFragment();
        setEvent();
    }


    private void fetchData(){
        brands = data.getListBrand();
        StorageReference storageRef = FirebaseStorage.getInstance().getReference();
        storageRef.child("images").getDownloadUrl().addOnSuccessListener(uri -> { isLoadingStatus = Constant.LOADING_DATA_SUCCESS; }).addOnFailureListener(exception -> isLoadingStatus = Constant.LOADING_DATA_FAILED);
    }

    public void setControl(){

        isLoadingStatus = Constant.LOADING_DATA_PENDING;

        rvBrandManagement = findViewById(R.id.rvBrandManagement);
        btnAddBrand = findViewById(R.id.btnAdd);
        brands = new ArrayList<>();
    }

    public void setEvent(){

        btnAddBrand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent brandAdditionIntent = new Intent(getApplicationContext(), BrandAdditionActivity.class);
                startActivity(brandAdditionIntent);
            }
        });

    }

    public void setFragment(){
        brandManagementAdapter = new BrandManagementAdapter(this);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,1);
        rvBrandManagement.setLayoutManager(gridLayoutManager);
        brandManagementAdapter.setData(brands);
        rvBrandManagement.setAdapter(brandManagementAdapter);
    }
    
    public void handleViewStatus(){
        switch (isLoadingStatus){
            case Constant.LOADING_DATA_PENDING:
                break;

            case Constant.LOADING_DATA_FAILED:
                break;

            case Constant.LOADING_DATA_SUCCESS:
                break;
        }
    }


}