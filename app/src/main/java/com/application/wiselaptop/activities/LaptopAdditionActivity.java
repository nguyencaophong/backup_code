package com.application.wiselaptop.activities;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.application.wiselaptop.R;
import com.application.wiselaptop.admin.fragments.LaptopFragment;
import com.application.wiselaptop.api.LaptopApi;
import com.application.wiselaptop.fragments.UploadImageFragment;
import com.application.wiselaptop.interfaces.OnListener;
import com.application.wiselaptop.models.Laptop;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class LaptopAdditionActivity extends AppCompatActivity {

    Toolbar tbProductAddition;

    Button btnAddProduct;

    LaptopFragment laptopFragment;

    UploadImageFragment uploadImageFragment;

    StorageReference storageReference;

    List<Bitmap> images;

    Integer loadingImageSuccess;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laptop_addition);
        setToolbar();
        setControl();
        setFragment();
        setEvent();
    }
    private void setToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.tbProductAddition);
        this.tbProductAddition = toolbar;
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);
        setTitle("Thêm mới sản phẩm");
    }
    private void setControl() {
        btnAddProduct = (Button) findViewById(R.id.btnAddProduct);
        images = new ArrayList<>();
    }

    private void setFragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        laptopFragment = new LaptopFragment();
        uploadImageFragment = new UploadImageFragment(images);
        fragmentTransaction.add(R.id.clProductAdditionContent, laptopFragment);
        fragmentTransaction.add(R.id.clUploadImage, uploadImageFragment);
        fragmentTransaction.commit();
    }

    private void setEvent() {
        btnAddProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String laptopID =  generateLaptopID();
                Laptop laptop = laptopFragment.getLaptop();
                laptop.setLaptopID(laptopID);
                List<Uri> images = uploadImageFragment.getUriImages();

                Thread loadingDataThread = new Thread(() -> {
                    LaptopApi.writeNewLaptop(laptop, new OnListener() {
                        @Override
                        public void OnSuccessListener() {
                            finish();
                        }

                        @Override
                        public void OnFailedListener() {
                            System.out.println("failed");
                        }
                    });
                });

                Thread loadingImageThread = new Thread(() -> {
                    try{
                        loadingImages(laptop,images, loadingDataThread);
                    }
                    catch (Exception ex){
                        ex.printStackTrace();
                    }
                });

                loadingImageThread.start();
            }
        });
    }

    private void loadingImages(Laptop laptop,List<Uri> images, Thread t){

        storageReference = FirebaseStorage.getInstance().getReference().getStorage().getReference("laptops");
        String laptopID = laptop.getLaptopID();
        loadingImageSuccess = 0 ;
        for(int i = 0 ; i < images.size(); ++i){
            String imageID = UUID.randomUUID().toString();
            Uri imageUri = images.get(i);

            if(i == 0){
                laptop.setLaptopMainImage(imageID);
            }
            storageReference.child(laptopID).child(imageID).putFile(imageUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    loadingImageSuccess++;
                    if(loadingImageSuccess == images.size()){
                        t.start();
                    }
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    System.out.println("failed");
                }
            });
        }
    }

    private String generateLaptopID(){
        return  UUID.randomUUID().toString();
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            this.finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


}
