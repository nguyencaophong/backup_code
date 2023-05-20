package com.application.wiselaptop.activities;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import com.application.wiselaptop.R;
import com.application.wiselaptop.models.Brand;
import com.squareup.picasso.Picasso;

public class BrandUpdateActivity extends AppCompatActivity {
    ImageButton btnAddBrand;
    TextView txtViewScreenTitle;
    EditText edtUpdateNameBrandManagement;
    ImageView ivUpdateBrandManagement;
    Brand itemBrand;
    Bitmap bmBrandImage;
    LinearLayout llUpdateBrandContainer;

    ActivityResultLauncher<Intent> activityImage = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {
           updateImageUri(result);
        }
    });


    private void updateImageUri(ActivityResult result){
        Intent data;
        if(result.getResultCode() == -1 && (data = result.getData()) != null && data.getData() != null){
            Uri selectedImageUri = data.getData();
            try{
                bmBrandImage = MediaStore.Images.Media.getBitmap(this.getApplicationContext().getContentResolver(), selectedImageUri);
                ivUpdateBrandManagement.setImageBitmap(bmBrandImage);
            }
            catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brand_update);
        setControl();
        setEvent();
    }
    public void setControl(){
        btnAddBrand = findViewById(R.id.btnAdd);
        txtViewScreenTitle = findViewById(R.id.txtViewScreenTitle);
        edtUpdateNameBrandManagement = findViewById(R.id.edtUpdateNameBrandManagement);
        ivUpdateBrandManagement = findViewById(R.id.ivUpdateBrandManagement);
        llUpdateBrandContainer = findViewById(R.id.llUpdateBrandContainer);
    }


    public void setEvent(){
        btnAddBrand.setVisibility(View.GONE);
        txtViewScreenTitle.setText("Chỉnh sửa");
        itemBrand = getItemBrand();
        edtUpdateNameBrandManagement.setText(itemBrand.getBrandName());
        Picasso.get().load("https://www.google.com/url?sa=i&url=https%3A%2F%2Fuxwing.com%2Fidea-icon%2F&psig=AOvVaw3Xn51c4HzINhSDaLBGGc5d&ust=1683451155362000&source=images&cd=vfe&ved=0CBEQjRxqFwoTCJjQ0bKu4P4CFQAAAAAdAAAAABAE").into(ivUpdateBrandManagement);

        llUpdateBrandContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction("android.intent.action.GET_CONTENT");
                activityImage.launch(intent);
            }
        });
    }

    public Brand getItemBrand(){
        Intent intent = getIntent();
        Brand itemBrand = (Brand) intent.getSerializableExtra("itemBrand");
        return itemBrand;
    }
}