package com.application.wiselaptop.activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.application.wiselaptop.R;
import com.application.wiselaptop.adapters.FilterAdapter;
import com.application.wiselaptop.adapters.LaptopAdapter;
import com.application.wiselaptop.adapters.ProductAdapter;
import com.application.wiselaptop.api.BrandApi;
import com.application.wiselaptop.api.GroupApi;
import com.application.wiselaptop.api.LaptopApi;
import com.application.wiselaptop.interfaces.OnDelete;
import com.application.wiselaptop.interfaces.OnListener;
import com.application.wiselaptop.interfaces.OnModify;
import com.application.wiselaptop.models.Filter;
import com.application.wiselaptop.models.Laptop;
import com.application.wiselaptop.models.Product;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

public class LaptopManagementActivity extends AppCompatActivity {
    Animation aniCollapsedAll;
    Animation aniExpandedAll;
    FilterAdapter brandFilterAdapter;
    ConstraintLayout clFilter;
    FilterAdapter groupFilterAdapter;
    Boolean isExpandedFilter;
    List<Product> lProduct;

    List<Laptop> laptops;
    ProductAdapter productAdapter;

    LaptopAdapter laptopAdapter;
    RecyclerView rvProductManagement;
    Toolbar tbProductManagement;
    LinearLayout llToHide;
    RecyclerView rvBrandItem;

    RecyclerView rvGroupItem;

    Map<String, Boolean> mBrandItem;

    Map<String, Boolean> mGroupItem;

    List<Filter> lBrandFilter;

    List<Filter> lGroupFilter;
    private void  fetchData(){

        DatabaseReference databaseReferenceLaptop = FirebaseDatabase.getInstance().getReference("laptops");
        databaseReferenceLaptop.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    laptops.clear();
                    for(DataSnapshot dsLaptop: snapshot.getChildren()){
                        Laptop laptop = dsLaptop.getValue(Laptop.class);
                        laptops.add(laptop);
                    }
                    updateLaptopAdapter();
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void threadTest(CountDownLatch latch){
        try{
            Thread.sleep(3000);
            System.out.println("oke");
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        latch.countDown();
    }

    private void setFilter(){
        this.lGroupFilter = new ArrayList<>();
        for(String groupName: GroupApi.readGroup().values()){
            this.lGroupFilter.add(new Filter(groupName));
        }

        this.lBrandFilter = new ArrayList<>();
        for(String brandName: BrandApi.readBrand().values()){
            this.lBrandFilter.add(new Filter(brandName));
        }
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laptop_management);
        setControl();
        setToolbar();
        setFilter();
        setDefaultConfiguration();
        fetchData();
        setEvent();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.managed_item_tool_bar, menu);
        return false;
    }

    private void setDefaultConfiguration() {
        this.isExpandedFilter = false;
        this.clFilter.setVisibility(View.GONE);
    }
    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
            case R.id.toolbarFilter :
                if (this.isExpandedFilter.booleanValue()) {
                    this.clFilter.startAnimation(this.aniCollapsedAll);
                    this.clFilter.setVisibility(View.GONE);
                    this.llToHide.setVisibility(View.GONE);

                } else {
                    this.llToHide.setVisibility(View.VISIBLE);
                    this.clFilter.setVisibility(View.VISIBLE);
                    this.clFilter.startAnimation(this.aniExpandedAll);
                    this.clFilter.setScaleY(1.0f);
                }
                this.isExpandedFilter = Boolean.valueOf(!this.isExpandedFilter.booleanValue());
                break;
            case R.id.toolbarPlus:
                Intent intent = new Intent(this, LaptopAdditionActivity.class);
                startActivity(intent);
                break;
            case R.id.toolbarSave :
            default:
                System.out.println("Other event");
                break;
            case R.id.toolbarSearch:
                break;
        }
        return super.onOptionsItemSelected(item);
    }



    private void setToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.tbProductManagement);
        this.tbProductManagement = toolbar;
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("Quản lý mặt hàng");
    }



    private void setControl() {
        this.clFilter = (ConstraintLayout) findViewById(R.id.clFilter);
        this.llToHide = (LinearLayout) findViewById(R.id.llToHide);

        this.aniExpandedAll = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_expanded_all);
        this.aniCollapsedAll = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_collapsed_all);

        this.rvBrandItem = (RecyclerView) findViewById(R.id.rvBrandItem);
        this.rvGroupItem = (RecyclerView) findViewById(R.id.rvGroupItem);
        this.rvBrandItem.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        this.rvGroupItem.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        this.brandFilterAdapter = new FilterAdapter(this,lBrandFilter);
        this.groupFilterAdapter = new FilterAdapter(this,lGroupFilter);

        this.rvProductManagement = (RecyclerView) findViewById(R.id.rvProductManagement);
        this.rvProductManagement.setLayoutManager(new LinearLayoutManager(this,  LinearLayoutManager.VERTICAL, false));

        this.laptops = new ArrayList<>();
        this.laptopAdapter = new LaptopAdapter(this.getBaseContext(), laptops);

        rvProductManagement.setAdapter(laptopAdapter);
    }
    private void updateFilterAdapter(){
        this.groupFilterAdapter.setlFilter(lGroupFilter);
        this.brandFilterAdapter.setlFilter(lBrandFilter);
        this.rvGroupItem.setAdapter(this.groupFilterAdapter);
        this.rvBrandItem.setAdapter(this.brandFilterAdapter);
    }

    private void updateProductAdapter() {
        this.productAdapter.setLProduct(this.lProduct);
        this.rvProductManagement.setAdapter(this.productAdapter);
    }

    private void updateLaptopAdapter(){
        this.laptopAdapter.setLaptops(laptops);
    }

    private void setEvent() {

        this.laptopAdapter.setOnModify(new OnModify() {
            @Override
            public void getId(View v, String id) {
                Bundle bundleLaptop = new Bundle();
                bundleLaptop.putString("laptop_id", id);
                Intent laptopAlternationIntent = new Intent(v.getContext(), LaptopAlterationActivity.class);
                laptopAlternationIntent.putExtras(bundleLaptop);
                v.getContext().startActivity(laptopAlternationIntent);
            }
        });

        this.laptopAdapter.setOnDelete(new OnDelete() {
            @Override
            public void getId(View view, String id) {
               LaptopApi.deleteLaptopByIDFromDatabase(id, new OnListener() {
                    @Override
                    public void OnSuccessListener() {
                        Toast.makeText(getApplicationContext(),"Xóa sản phẩm thành công", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void OnFailedListener() {
                        Toast.makeText(getApplicationContext(),"Xóa sản phẩm không thành công", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });

    }
}
