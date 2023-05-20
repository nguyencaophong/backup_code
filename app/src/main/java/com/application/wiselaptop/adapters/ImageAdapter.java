package com.application.wiselaptop.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;


import com.application.wiselaptop.R;
import com.application.wiselaptop.interfaces.OnChange;
import com.application.wiselaptop.interfaces.OnClickAdapter;

import java.util.List;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageViewHolder> {
    Context context;
    List<Bitmap> lImage;
    OnClickAdapter onClickAdapter;

    OnChange onChange;

    public ImageAdapter(List<Bitmap> lImage) {
        this.lImage = lImage;
    }

    public void setOnClickAdapter(OnClickAdapter onClickAdapter) {
        this.onClickAdapter = onClickAdapter;
    }

    public void setOnChange(OnChange onChange){
        this.onChange = onChange;
    }

    @Override
    public ImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View imageView = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_holder_image, parent, false);
        ImageViewHolder imageViewHolder = new ImageViewHolder(imageView);
        return imageViewHolder;
    }

    @Override
    public void onBindViewHolder(ImageViewHolder imageViewHolder, int position) {
        Bitmap bmImage = this.lImage.get(position);
        imageViewHolder.ivImageItem.setImageBitmap(bmImage);
        OnClickDeleteImage onClickDeleteImage = new OnClickDeleteImage(this.lImage, position);
        onClickDeleteImage.setOnClickAdapter(onClickAdapter);
        onClickDeleteImage.setOnChange(onChange);
        imageViewHolder.ivClosed.setOnClickListener(onClickDeleteImage);
    }

    @Override
    public int getItemCount() {
        return this.lImage.size();
    }

    public class ImageViewHolder extends RecyclerView.ViewHolder {
        ImageView ivImageItem;
        ImageView ivClosed;


        public ImageViewHolder(View itemView) {
            super(itemView);
            this.ivImageItem = (ImageView) itemView.findViewById(R.id.ivImageItem);
            this.ivClosed = (ImageView) itemView.findViewById(R.id.ivClosed);
        }
    }

    public class OnClickDeleteImage implements View.OnClickListener{

        List<Bitmap> lImage;
        int pos;

        OnClickAdapter onClickAdapter;

        OnChange onChange;

        public OnClickDeleteImage(List<Bitmap> lImage, int pos){
            this.lImage = lImage;
            this.pos = pos;
        }

        public void setOnClickAdapter(OnClickAdapter onClickAdapter) {
            this.onClickAdapter = onClickAdapter;
        }

        public void setOnChange(OnChange onChange){
            this.onChange = onChange;
        }

        @Override
        public void onClick(View v) {
            this.lImage.remove(this.pos);
            if(this.onClickAdapter != null){
                this.onClickAdapter.onClickItem(this.pos);
            }

            if(this.onChange != null){
                this.onChange.run();
            }

            ImageAdapter.this.notifyDataSetChanged();
        }
    }
}
