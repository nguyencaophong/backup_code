package com.application.wiselaptop.fragments;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.application.wiselaptop.R;
import com.application.wiselaptop.adapters.ImageAdapter;
import com.application.wiselaptop.interfaces.OnChange;
import com.application.wiselaptop.interfaces.OnClickAdapter;


import java.util.ArrayList;
import java.util.List;


public class UploadImageFragment extends Fragment {

    ImageButton ibUploadImage;
    ImageAdapter imageAdapter;
    List<Bitmap> images;
    RecyclerView rvImageAdapter;

    List<Uri> uriImages;

    public UploadImageFragment() {
    }
    public UploadImageFragment(List<Bitmap> images) {
        this.images = images;
    }

    public List<Bitmap> getImages() {
        return images;
    }

    public void setImages(List<Bitmap> images) {
        this.images = images;
        System.out.println(this.images.size());
        renderViewImageButtonUploadImage();
        renderViewImageAdapter(this.rvImageAdapter, images);
    }

    public List<Uri> getUriImages() {
        return uriImages;
    }

    public void setUriImages(List<Uri> uriImages) {
        this.uriImages = uriImages;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.adapter_image, container, false);
        setControl(view);
        setEvent();
        renderViewImageButtonUploadImage();
        renderViewImageAdapter(this.rvImageAdapter, this.images);
        return view;
    }

    private void setControl(View view) {
        this.ibUploadImage = (ImageButton) view.findViewById(R.id.ibUploadImage);
        this.rvImageAdapter = (RecyclerView) view.findViewById(R.id.rvImageAdapter);
        uriImages = new ArrayList<>();
    }

    private void setEvent() {
        this.ibUploadImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleImageChoose();
            }
        });
    }

    ActivityResultLauncher<Intent> activityImage = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.ptithcm.giohangthanhtoan.fragments.UploadImageFragment$$ExternalSyntheticLambda0
        @Override
        public final void onActivityResult(Object obj) {
            onLoadingImageFromGallery((ActivityResult) obj);
            renderViewImageAdapter(rvImageAdapter, images);
            renderViewImageButtonUploadImage();
        }
    });

    public void onLoadingImageFromGallery(ActivityResult result) {
        Intent data;
        if (result.getResultCode() == -1 && (data = result.getData()) != null && data.getData() != null) {
            Uri selectedImageUri = data.getData();
            try {
                Bitmap selectedImageBitmap = MediaStore.Images.Media.getBitmap(getContext().getContentResolver(), selectedImageUri);
                System.out.println(selectedImageBitmap);
                this.images.add(selectedImageBitmap);
                uriImages.add(selectedImageUri);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public void renderViewImageButtonUploadImage() {
        if (this.images.size() == 0) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 256);
            this.ibUploadImage.setLayoutParams(layoutParams);

        } else {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(256, 256);
            this.ibUploadImage.setLayoutParams(layoutParams);
        }
    }

    public void handleImageChoose() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction("android.intent.action.GET_CONTENT");
        this.activityImage.launch(intent);
    }

    private void renderViewImageAdapter(RecyclerView rvImageAdapter, List<Bitmap> images) {
        if (rvImageAdapter != null &&  images.size() != 0) {
            rvImageAdapter.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false));
            ImageAdapter imageAdapter = new ImageAdapter(images);
            this.imageAdapter = imageAdapter;
            imageAdapter.setOnChange(new OnChange() {
                @Override
                public void run() {
                    renderViewImageButtonUploadImage();
                }
            });
            rvImageAdapter.setAdapter(imageAdapter);
        }
    }
}
