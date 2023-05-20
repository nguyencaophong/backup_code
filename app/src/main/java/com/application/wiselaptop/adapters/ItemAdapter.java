package com.application.wiselaptop.adapters;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.application.wiselaptop.R;
import com.application.wiselaptop.activities.AccountManagementActivity;
import com.application.wiselaptop.activities.BrandManagementActivity;
import com.application.wiselaptop.activities.LaptopManagementActivity;
import com.application.wiselaptop.models.StoreItemManagement;
import com.application.wiselaptop.utils.Constant;

import java.util.List;

/* loaded from: classes4.dex */
public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.TestViewHolder> {
    List<StoreItemManagement> tests;

    public ItemAdapter(List<StoreItemManagement> tests) {
        this.tests = tests;
    }

    @NonNull
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public TestViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_item, parent, false);
        return new TestViewHolder(view);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(TestViewHolder holder, int position) {
        StoreItemManagement storeItemManagement = this.tests.get(position);
        String colorString = storeItemManagement.getColorString();
        int resId = this.tests.get(position).getStoreItemManagementSrcImage();
        holder.ivStoreManagementSrcImage.setImageResource(resId);
        holder.ivStoreManagementSrcImage.setColorFilter(Color.parseColor(colorString));
        String title = storeItemManagement.getStoreItemManagementName();
        holder.tvStoreManagementTitle.setText(title);
        GradientDrawable drawable = (GradientDrawable) holder.tvStoreManagementTitle.getBackground();
        drawable.setColor(Color.parseColor(colorString));
        setEvent(holder, position);
    }

    private void setEvent(TestViewHolder testViewHolder, int position) {
        OnClickListenerTestViewHolder onClickListenerTestViewHolder = new OnClickListenerTestViewHolder(testViewHolder, position);
        testViewHolder.itemView.setOnClickListener(onClickListenerTestViewHolder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.tests.size();
    }

    /* loaded from: classes4.dex */
    public static class TestViewHolder extends RecyclerView.ViewHolder {
        private final ImageView ivStoreManagementSrcImage;
        private final TextView tvStoreManagementTitle;

        public TestViewHolder(View itemView) {
            super(itemView);
            this.tvStoreManagementTitle = (TextView) itemView.findViewById(R.id.tvStoreManagementItemTitle);
            this.ivStoreManagementSrcImage = (ImageView) itemView.findViewById(R.id.ivStoreManagementSrcImage);
        }
    }

    public static class OnClickListenerTestViewHolder implements View.OnClickListener {
        int position;
        TestViewHolder testViewHolder;

        public OnClickListenerTestViewHolder(TestViewHolder testViewHolder, int position) {
            this.testViewHolder = testViewHolder;
            this.position = position;
        }

        @Override
        public void onClick(View v) {
            switch (this.position) {
                case Constant.CHART_SELECTION:
                    return;
                case Constant.BRAND_SELECTION:
                    Intent brandManagementIntent = new Intent(v.getContext(), BrandManagementActivity.class);
                    v.getContext().startActivity(brandManagementIntent);
                    return;
                case Constant.LAPTOP_SELECTION:
                    Intent laptopManagementIntent = new Intent(v.getContext(), LaptopManagementActivity.class);
                    v.getContext().startActivity(laptopManagementIntent);
                    return;
                case Constant.ORDER_SELECTION:
                    return;
                case Constant.PROMOTION_SELECTION:

                    return;
                case Constant.ACCOUNT_SELECTION:
                    Intent accountManagementIntent = new Intent(v.getContext(), AccountManagementActivity.class);
                    v.getContext().startActivity(accountManagementIntent);
                    return;
                default:
            }
        }
    }
}
