package com.application.wiselaptop.fragments;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.application.wiselaptop.R;

import java.util.ArrayList;
import java.util.List;

public class UploadSignleImageFragment extends Fragment {
    ImageView imgUploadAvatar;
    Bitmap image;
    Uri uriImage;

    public void setImage(Bitmap bitmap){
        this.imgUploadAvatar.setImageBitmap(bitmap);
    }
    public Uri getUriImage() {
        return uriImage;
    }
    public UploadSignleImageFragment(Bitmap image) {
        this.image = image;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_upload_signle_image, container, false);
        setControl(view);
        setEvent();
        return view;
    }

    private void setEvent(){
        this.imgUploadAvatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onChooseImage();
            }
        });
    }

    ActivityResultLauncher<Intent> activityImage = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.ptithcm.giohangthanhtoan.fragments.UploadImageFragment$$ExternalSyntheticLambda0
        @Override
        public final void onActivityResult(Object obj) {
            onLoadingImageFromGallery((ActivityResult) obj);
        }
    });

    public void onLoadingImageFromGallery(ActivityResult result) {
        Intent data;
        if (result.getResultCode() == -1 && (data = result.getData()) != null && data.getData() != null) {
            Uri selectedImageUri = data.getData();
            try {
                Bitmap selectedImageBitmap = MediaStore.Images.Media.getBitmap(getContext().getContentResolver(), selectedImageUri);
                uriImage = selectedImageUri;
                this.imgUploadAvatar.setImageBitmap(selectedImageBitmap);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public void onChooseImage() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction("android.intent.action.GET_CONTENT");
        this.activityImage.launch(intent);
    }

    public void renderViewImageButtonUploadImage() {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,500);
            this.imgUploadAvatar.setLayoutParams(layoutParams);
    }

    private void setControl(View view){
        this.imgUploadAvatar = view.findViewById(R.id.imgUploadAvatar);
    }
}