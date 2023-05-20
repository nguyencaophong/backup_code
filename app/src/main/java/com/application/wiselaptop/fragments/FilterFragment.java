package com.application.wiselaptop.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.application.wiselaptop.R;
import com.application.wiselaptop.adapters.FilterAdapter;
import com.application.wiselaptop.api.BrandApi;
import com.application.wiselaptop.api.GroupApi;
import com.application.wiselaptop.interfaces.OnListenCreateViewFragment;
import com.application.wiselaptop.models.Filter;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes7.dex */
public class FilterFragment extends Fragment {
    FilterAdapter brandFilterAdapter;
    List<String> brands;
    FilterAdapter groupFilterAdapter;
    List<String> groups;
    List<Filter> lBrandFilter;
    List<Filter> lGroupFilter;
    OnListenCreateViewFragment onListenCreateViewFragment;
    RecyclerView rvBrandItem;
    RecyclerView rvGroupItem;

    public FilterFragment() {
        setEvent();
    }


    private void readData(){

    }
    public void setOnListenCreateViewFragment(OnListenCreateViewFragment onListenCreateViewFragment) {
        this.onListenCreateViewFragment = onListenCreateViewFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private void mockData() {
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_filter, container, false);
        mockData();
        setControl(view);
        bindingDataIntoView();
        setEvent();
        OnListenCreateViewFragment onListenCreateViewFragment = this.onListenCreateViewFragment;
        if (onListenCreateViewFragment != null) {
            onListenCreateViewFragment.run();
        }
        return view;
    }

    private void setControl(View view) {
        this.rvBrandItem = (RecyclerView) view.findViewById(R.id.rvBrandItem);
        this.rvGroupItem = (RecyclerView) view.findViewById(R.id.rvGroupItem);
    }

    private void bindingDataIntoView() {
        this.rvBrandItem.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        FilterAdapter filterAdapter = new FilterAdapter(getContext(), this.lBrandFilter);
        this.brandFilterAdapter = filterAdapter;
        this.rvBrandItem.setAdapter(filterAdapter);
        this.rvGroupItem.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        FilterAdapter filterAdapter2 = new FilterAdapter(getContext(), this.lGroupFilter);
        this.groupFilterAdapter = filterAdapter2;
        this.rvGroupItem.setAdapter(filterAdapter2);
    }

    public FilterAdapter getBrandFilterAdapter() {
        return this.brandFilterAdapter;
    }

    public FilterAdapter getGroupFilterAdapter() {
        return this.groupFilterAdapter;
    }

    private void setEvent() {
    }
}
