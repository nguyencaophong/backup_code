package com.application.wiselaptop.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;


import com.application.wiselaptop.R;
import com.application.wiselaptop.models.Product;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes7.dex */
public class ProductFragment extends Fragment {

    EditText edtProductName;
    EditText edtProductCost;
    EditText edtProductPrice;
    ArrayAdapter<String> brandAdapter;
    ArrayAdapter<String> groupAdapter;

    EditText edtCPU;

    EditText edtOperation;

    EditText edtDisk;

    EditText edtScreen;

    EditText edtLAN;

    EditText edtConnection;

    EditText edtWeight;

    List<String> lBrand;
    List<String> lGroup;
    Product oProduct;
    Spinner spinnerItemBrand;
    Spinner spinnerItemGroup;

    public ProductFragment() {
    }

    public ProductFragment(Product oProduct) {
        this.oProduct = oProduct;
    }


    private void loadingDataFromActivity() {
        Bundle bundle = getArguments();
        if (bundle != null) {
            String sProductId = bundle.getString("product_id");
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_product, container, false);
        setControl(view);
        loadingDataFromActivity();
        return view;
    }

    private void setControl(View view) {
        initData();
        setSpinner(view);
        setEditText(view);
        setAdapter();
        bindingDataOnView();
    }

    private void setData(){
       edtProductName.setText(this.oProduct.getProductName());
       edtProductCost.setText(this.oProduct.getProductCost().toString());
       edtProductPrice.setText(this.oProduct.getProductPrice().toString());
    }

    private void setControlS(@NonNull View view ){
        edtProductName = (EditText) view.findViewById(R.id.edtProductName);
        edtProductCost= (EditText) view.findViewById(R.id.edtProductCost);
        edtProductPrice = (EditText) view.findViewById(R.id.edtProductPrice);
        edtCPU = (EditText) view.findViewById(R.id.edtCPU);
        edtDisk = (EditText) view.findViewById(R.id.edtDisk);
        edtOperation = (EditText) view.findViewById(R.id.edtOperation);
        edtScreen = (EditText) view.findViewById(R.id.edtScreen);
        edtLAN = (EditText) view.findViewById(R.id.edtLAN);
        edtWeight = (EditText) view.findViewById(R.id.edtWeight);
    }

    private void initData() {
        ArrayList arrayList = new ArrayList();
        this.lBrand = arrayList;
        arrayList.add("apple");
        this.lBrand.add("lenovo");
        this.lBrand.add("Oppo");
        this.lBrand.add("Xiaomi");
        ArrayList arrayList2 = new ArrayList();
        this.lGroup = arrayList2;
        arrayList2.add("Dien thoai");
        this.lGroup.add("May tinh bang");
        this.lGroup.add("Lap top - Workstation");
        this.lGroup.add("Server");
    }

    private void setSpinner(View view) {
        this.spinnerItemBrand = (Spinner) view.findViewById(R.id.spinnerItemBrand);
        this.spinnerItemGroup = (Spinner) view.findViewById(R.id.spinnerItemGroup);
    }

    private void setEditText(View view) {
        this.edtProductPrice = (EditText) view.findViewById(R.id.edtProductPrice);
        this.edtProductCost = (EditText) view.findViewById(R.id.edtProductName);
        this.edtProductName = (EditText) view.findViewById(R.id.edtProductName);
    }

    private void setAdapter() {
        this.brandAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, this.lGroup);
        this.groupAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, this.lBrand);
    }

    private void bindingDataOnView() {
        this.spinnerItemBrand.setAdapter((SpinnerAdapter) this.brandAdapter);
        this.spinnerItemGroup.setAdapter((SpinnerAdapter) this.groupAdapter);
    }

    private Product getProductData() {
        String productName = this.edtProductName.getText().toString();
        String productCost = this.edtProductCost.getText().toString();
        String productPrice = this.edtProductPrice.getText().toString();
        Product product = new Product("1", productName, productCost,productPrice);
        return product;
    }

    public void setData(Product oProduct) {
        this.oProduct = oProduct;
    }

    public Product getData() {
        String sProductName = this.edtProductName.getText().toString();
        String sProductCost = this.edtProductCost.getText().toString();
        String sProductPrice = this.edtProductPrice.getText().toString();
        Product product = new Product("1", sProductName,sProductCost, sProductPrice);
        return product;
    }
}
