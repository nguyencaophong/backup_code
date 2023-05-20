package com.application.wiselaptop.adapters;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.application.wiselaptop.R;
import com.application.wiselaptop.interfaces.OnDelete;
import com.application.wiselaptop.interfaces.OnModify;
import com.application.wiselaptop.models.Laptop;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.ListResult;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;


import java.util.ArrayList;
import java.util.List;

public class LaptopAdapter extends RecyclerView.Adapter<LaptopAdapter.LaptopViewHolder> {


    private final Context context;

    private List<Laptop> laptops;

    OnModify onModify;

    OnDelete onDelete;

    public LaptopAdapter(Context context){
        this.context = context;
    }

    public LaptopAdapter(Context context, List<Laptop> laptops){
        this.context = context;
        this.laptops = laptops;
    }


    public void setLaptops(List<Laptop> laptops){
        this.laptops = laptops;
        notifyDataSetChanged();
    }

    public void setOnModify(OnModify onModify){
        this.onModify = onModify;
    }

    public void setOnDelete(OnDelete onDelete){
        this.onDelete = onDelete;
    }

    @NonNull
    @Override
    public LaptopViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View laptopView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_laptop, parent, false);
        LaptopViewHolder viewHolder = new LaptopViewHolder(laptopView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull LaptopViewHolder holder, int position) {
        Laptop laptop = laptops.get(position);
        String laptopID = laptop.getLaptopID();
        String laptopMainImage = laptop.getLaptopMainImage();
        List<Uri> uriImages = new ArrayList<>();

        try{
            StorageReference storageReference = FirebaseStorage.getInstance().getReference("laptops");
            storageReference.child(laptopID).child(laptopMainImage).getDownloadUrl().addOnSuccessListener(uri -> {
                Picasso.get().load(uri).into(holder.ivLaptopImage);

            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {

                }
            });
        }
        catch (Exception ex){

        }


        holder.tvLaptopName.setText(laptop.getLaptopName());
        holder.tvLaptopPrice.setText(String.format(laptop.getLaptopPrice().toString()));
        holder.tvLaptopOriginalPrice.setText(String.format(laptop.getLaptopOriginPrice().toString()));
        holder.btnLaptopDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(onDelete != null){
                    onDelete.getId(v,laptopID);
                }
            }
        });

        holder.btnLaptopModify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(onModify != null){
                    onModify.getId(v, laptopID);
                }
            }
        });
    }


    @Override
    public int getItemCount() {
        return this.laptops.size();
    }

    public class LaptopViewHolder extends RecyclerView.ViewHolder{

        ImageView ivLaptopImage;

        TextView tvLaptopName;

        TextView tvLaptopPrice;

        TextView tvLaptopOriginalPrice;

        Button btnLaptopModify;

        Button btnLaptopDelete;

        public LaptopViewHolder(@NonNull View itemView) {
            super(itemView);
            ivLaptopImage = (ImageView) itemView.findViewById(R.id.ivLaptopImage);
            tvLaptopName = (TextView) itemView.findViewById(R.id.tvlaptopName);
            tvLaptopPrice = (TextView) itemView.findViewById(R.id.tvLaptopPrice);
            tvLaptopOriginalPrice = (TextView) itemView.findViewById(R.id.tvLaptopOriginalPrice);
            btnLaptopModify = (Button) itemView.findViewById(R.id.btnLaptopModify);
            btnLaptopDelete = (Button) itemView.findViewById(R.id.btnLaptopDelete);
        }
    }
}
