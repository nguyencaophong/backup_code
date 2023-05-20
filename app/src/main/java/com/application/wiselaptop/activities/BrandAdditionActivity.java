package com.application.wiselaptop.activities;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
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
import com.application.wiselaptop.utils.Constant;

public class BrandAdditionActivity extends AppCompatActivity {

    ImageButton btnAddBrand;
    TextView txtViewScreenTitle;

    Bitmap bmBrandImage;

    ImageView ivBrandAddition;

    LinearLayout llUploadImageBrand;

    FrameLayout flUploadImage;

    Button btnAddBrandDone;

    int isLoadingSuccess;

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
                System.out.println(bmBrandImage);
                bmBrandImage = MediaStore.Images.Media.getBitmap(this.getApplicationContext().getContentResolver(), selectedImageUri);
                System.out.println(bmBrandImage);
                ivBrandAddition.setImageBitmap(bmBrandImage);
                llUploadImageBrand.setVisibility(View.GONE);
            }
            catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brand_addition);
        setControl();
        setEvent();
    }

    public void setControl(){
        btnAddBrand = findViewById(R.id.btnAdd);
        txtViewScreenTitle = findViewById(R.id.txtViewScreenTitle);
        ivBrandAddition = findViewById(R.id.ivBrandAddition);
        llUploadImageBrand = findViewById(R.id.llUploadImageBrand);
        flUploadImage = findViewById(R.id.flUploadImage);
        btnAddBrandDone = findViewById(R.id.btnAddBrandDone);
        bmBrandImage = null;
    }


    public Boolean validateBrandAddition(){
        if(bmBrandImage != null && txtViewScreenTitle.length() >= Constant.BRAND_MINIMUM_CHARACTERS){
            return true;
        }
        return false;
    }

    public void setEvent(){
        btnAddBrand.setVisibility(View.GONE);
        txtViewScreenTitle.setText("Thêm hãng");

        llUploadImageBrand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction("android.intent.action.GET_CONTENT");
                activityImage.launch(intent);
            }
        });


        btnAddBrandDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validateBrandAddition() ){
                    isLoadingSuccess = Constant.LOADING_DATA_PENDING;
                }
                else{
                    System.out.println("vui lòng kiểm tra số lượng kí tự và ảnh pop up lên");
                }
            }
        });
    }


    private void handleViewStatus(){
        switch (isLoadingSuccess){
            case Constant.LOADING_DATA_PENDING:
                break;
            case Constant.LOADING_DATA_SUCCESS:
                break;
            case Constant.LOADING_DATA_FAILED:
                break;
        }
    }
}