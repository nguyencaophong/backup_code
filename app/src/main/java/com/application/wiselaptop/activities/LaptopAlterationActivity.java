package com.application.wiselaptop.activities;

import android.content.ContentResolver;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.application.wiselaptop.R;
import com.application.wiselaptop.admin.fragments.LaptopFragment;
import com.application.wiselaptop.fragments.UploadImageFragment;
import com.application.wiselaptop.models.Laptop;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


public class LaptopAlterationActivity extends AppCompatActivity {
    ConstraintLayout clProductFragmentContent;

    String laptopID;
    Toolbar tbProductAlteration;
    Button btnLaptopModifyDelete;
    Button btnLaptopModifyUpdate;

    EditText edtProductName;

    Spinner spinnerItemBrand;

    Spinner spinnerItemGroup;

    EditText edtProductCost;

    EditText edtProductPrice;

    UploadImageFragment uploadImageFragment;

    LaptopFragment laptopFragment;

    LinearLayout llLaptopAlternationMainContent;

    Laptop laptop;

    List<Uri> images;

    List<Bitmap> imagesBM;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laptop_alteration);
        setLaptopID();
        setControl();
        setFragment();
        fetchData();
        setToolbar();
        setEvent();
    }
    private void fetchData(){
        if(laptopID == null)    return ;

        DatabaseReference databaseReferenceLaptop = FirebaseDatabase.getInstance().getReference("laptops");
        StorageReference storageReferenceLaptop = FirebaseStorage.getInstance().getReference("laptops");
        databaseReferenceLaptop.child(laptopID).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    laptop = snapshot.getValue(Laptop.class);
                    laptopFragment.setLaptop(laptop);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        storageReferenceLaptop.child(laptopID).listAll().addOnSuccessListener(results -> {
            for(StorageReference item : results.getItems()){
                item.getDownloadUrl().addOnSuccessListener(uri ->{
                    images.add(uri);
                    convertUriToBitmap(uri);
                }).addOnFailureListener(uri -> System.out.println("error"));
            }
        }).addOnFailureListener(uri -> System.out.println(uri));
    }

    private void convertUriToBitmap(Uri uri){
        Picasso.get().load(uri).into(new Target() {
            @Override
            public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                imagesBM.add(bitmap);
                uploadImageFragment.setImages(imagesBM);
            }

            @Override
            public void onBitmapFailed(Exception e, Drawable errorDrawable) {
                e.printStackTrace();
            }

            @Override
            public void onPrepareLoad(Drawable placeHolderDrawable) {

            }
        });
    }


    private void setLaptopID(){
        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            this.laptopID = bundle.getString("laptop_id");
        }
    }


    private void setToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.tbProductAlteration);
        this.tbProductAlteration = toolbar;
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("Chỉnh sửa sản phẩm");
    }

    private void setFragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        List<Bitmap> bmImages = new ArrayList<>();
        uploadImageFragment = new UploadImageFragment(bmImages);
        laptopFragment = new LaptopFragment();
        fragmentTransaction.add(R.id.clLaptopAlterationContent, laptopFragment);
        fragmentTransaction.add(R.id.clLaptopAlterationUploadImage,uploadImageFragment);
        fragmentTransaction.commit();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }



    private void setControl() {
        btnLaptopModifyDelete = (Button) findViewById(R.id.btnLaptopAlternationDelete);
        btnLaptopModifyUpdate = (Button) findViewById(R.id.btnLaptopAlterationUpdate);
        llLaptopAlternationMainContent = (LinearLayout) findViewById(R.id.llLaptopAlternationMainContent);
        images = new ArrayList<>();
        imagesBM = new ArrayList<>();
    }

    private void setEvent(){
        btnLaptopModifyDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnLaptopModifyUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });
    }
}
