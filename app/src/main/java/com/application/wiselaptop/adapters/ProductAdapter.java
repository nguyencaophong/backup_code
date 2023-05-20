package com.application.wiselaptop.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.application.wiselaptop.R;
import com.application.wiselaptop.interfaces.OnDelete;
import com.application.wiselaptop.interfaces.OnModify;
import com.application.wiselaptop.interfaces.OnRun;
import com.application.wiselaptop.models.Product;
import com.squareup.picasso.Picasso;

import java.util.List;


public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {
    Context context;
    List<Product> lProduct;

    OnModify onModify;

    OnDelete onDelete;

    OnRun onRun;

    public void setOnRun(OnRun onRun){
        this.onRun = onRun;
    }
    public void setOnModify(OnModify onModify){
        this.onModify = onModify;
    }
   public void setOnDelete(OnDelete onDelete) {
        this.onDelete = onDelete;
   }


    public ProductAdapter(List<Product> lProduct) {
        this.lProduct = lProduct;
    }

    public void setLProduct(List<Product> lProduct){
        this.lProduct = lProduct;
        notifyDataSetChanged();
    }

    public ProductAdapter(Context context, List<Product> lProduct) {
        this.context = context;
        this.lProduct = lProduct;
    }

    public void ProductAdapter(Context context, List<Product> lProduct, OnModify onModify, OnDelete onDelete){
        this.context = context;
        this.lProduct = lProduct;
        this.onModify = onModify;
        this.onDelete = onDelete;
    }



    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View productView = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_product, parent, false);
        ProductViewHolder productViewHolder = new ProductViewHolder(productView);
        return productViewHolder;
    }

    @Override
    public void onBindViewHolder(ProductViewHolder productViewHolder, int position) {
        Product product = this.lProduct.get(position);
        String sProductId = product.getProductId();
        String sProductName = product.getProductName();
        String sProductPrice = product.getProductPrice();
        String sProductCost = product.getProductCost();
        String link = "https://firebasestorage.googleapis.com/v0/b/gio-hang-thanh-toan.appspot.com/o/images?alt=media&token=c986be3a-3352-4903-b2f8-2d97098adb47";
        Picasso.get().load(link).into(productViewHolder.ivProductSrcImage);

        productViewHolder.tvProductName.setText(sProductName);
        productViewHolder.tvProductPrice.setText(sProductPrice);
        productViewHolder.tvProductCost.setText(sProductCost);
        productViewHolder.tvProductPrice.setText(sProductPrice);
        productViewHolder.btnProductModify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(onModify != null){
                    onModify.getId(v, sProductId);
                }
            }
        });
        productViewHolder.btnProductDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(onDelete != null){
                    onDelete.getId(v, sProductId);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.lProduct.size();
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder {

        ImageView ivProductSrcImage;
        TextView tvProductCost;
        TextView tvProductGroup;
        TextView tvProductName;
        TextView tvProductPrice;
        Button btnProductModify;
        Button btnProductDelete;

        public ProductViewHolder(View itemView) {
            super(itemView);
            this.ivProductSrcImage = (ImageView) itemView.findViewById(R.id.productSrcImage);
            this.tvProductName = (TextView) itemView.findViewById(R.id.tvProductName);
            this.tvProductPrice = (TextView) itemView.findViewById(R.id.tvProductPrice);
            this.tvProductCost = (TextView) itemView.findViewById(R.id.tvProductCost);
            this.tvProductGroup = (TextView) itemView.findViewById(R.id.tvProductGroup);
            this.btnProductModify = (Button) itemView.findViewById(R.id.btnProductModify);
            this.btnProductDelete = (Button) itemView.findViewById(R.id.btnProductDelete);
        }
    }
}
