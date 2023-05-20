package com.application.wiselaptop.activities;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.application.wiselaptop.models.Demand;
import com.application.wiselaptop.models.StoreItemManagement;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;
import com.application.wiselaptop.R;
import com.application.wiselaptop.adapters.ItemAdapter;
import com.application.wiselaptop.models.StoreItemManagement;
import com.application.wiselaptop.models.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
//import com.application.wiselaptop.utils.AppDatabase;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes3.dex */
public class ItemActivity extends AppCompatActivity {

    List<StoreItemManagement> listStoreItemManagement;
    RecyclerView rvTest;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setData();
        setControl();
        runmTest();
    }

    private void runmTest(){
        FirebaseDatabase database =FirebaseDatabase.getInstance();
        DatabaseReference dataRef = database.getReference("demands");
        Demand demand = new Demand("1", "votiendddffat", "hello");
        dataRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                dataRef.setValue(demand);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }



    private void setData() {
        ArrayList arrayList = new ArrayList();
        this.listStoreItemManagement = arrayList;
        arrayList.add(new StoreItemManagement(R.drawable.ic_chart, "Thống kê", "#1200DB"));
        this.listStoreItemManagement.add(new StoreItemManagement(R.drawable.ic_tag, "Hãng", "#EC6F29"));
        this.listStoreItemManagement.add(new StoreItemManagement(R.drawable.ic_l_box, "Sản phẩm", "#5186EC"));
        this.listStoreItemManagement.add(new StoreItemManagement(R.drawable.ic_document, "Đơn đặt hàng", "#EBA552"));
        this.listStoreItemManagement.add(new StoreItemManagement(R.drawable.ic_l_gift, "Voucher", "#00B000"));
        this.listStoreItemManagement.add(new StoreItemManagement(R.drawable.ic_l_user, "User", "#FBCA91"));
    }

    private void setControl() {
        this.rvTest = (RecyclerView) findViewById(R.id.rvTest);
        new GridLayoutManager(this, 2);
        this.rvTest.setLayoutManager(new GridLayoutManager(this, 2));
        ItemAdapter adapter = new ItemAdapter(this.listStoreItemManagement);
        this.rvTest.setAdapter(adapter);
    }


    private void setEvent() {
    }
}
