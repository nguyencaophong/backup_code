package com.application.wiselaptop.admin.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.TextView;

import com.application.wiselaptop.R;
import com.application.wiselaptop.models.Laptop;
import com.google.android.material.textfield.TextInputLayout;

import org.w3c.dom.Text;


public class LaptopFragment extends Fragment {

    TextInputLayout tilLaptopName;

    TextInputLayout tilLaptopPrice;

    TextInputLayout tilLaptopOriginalPrice;

    TextInputLayout tilLaptopCPU;

    TextInputLayout tilLaptopGPU;

    TextInputLayout tilLaptopRAM;

    TextInputLayout tilLaptopWifi;

    TextInputLayout tilLaptopCommunicationGateway;

    TextInputLayout tilLaptopKeyboard;

    TextInputLayout tilLaptopScreenResolution;

    TextInputLayout tilLaptopScreenSize;

    TextInputLayout tilLaptopBattery;

    TextInputLayout tilLaptopHardDisk;

    TextInputLayout tilLaptopWeight;

    EditText edtLaptopName;

    EditText edtLaptopPrice;

    EditText edtLaptopOriginalPrice;

    EditText edtLaptopCPU;

    EditText edtLaptopGPU;

    EditText edtLaptopRAM;

    EditText edtLaptopWifi;

    EditText edtLaptopCommunicationGateway;

    EditText edtLaptopKeyboard;

    EditText edtLaptopScreenResolution;

    EditText edtLaptopScreenSize;

    EditText edtLaptopBattery;

    EditText edtLaptopHardDisk;

    EditText edtLaptopWeight;

    Laptop laptop;

    AutoCompleteTextView edtLaptopBrand;

    ArrayAdapter<String> brandAdapter;

    ArrayAdapter<String> groupAdapter;

    public LaptopFragment() {
        this.laptop = new Laptop("", "", Double.valueOf("0"), Double.valueOf("0"),"", "","", "", "", "", "", "", "", "", "", "","","",Integer.valueOf(0));

    }

    public LaptopFragment(Laptop laptop){
        this.laptop = laptop;
    }

    public void setLaptop(Laptop laptop) {
        this.laptop = laptop;
        updateLaptopFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_laptop, container, false);
        setControl(view);
        updateLaptopFragment();
        return view;
    }
    private void setControl(@NonNull View view ){

        tilLaptopName = (TextInputLayout) view.findViewById(R.id.tilLaptopName) ;
        tilLaptopPrice = (TextInputLayout) view.findViewById(R.id.tilLaptopPrice) ;
        tilLaptopOriginalPrice = (TextInputLayout)  view.findViewById(R.id.tilLaptopOriginalPrice);
        tilLaptopCPU = (TextInputLayout) view.findViewById(R.id.tilLaptopCPU);
        tilLaptopGPU = (TextInputLayout) view.findViewById(R.id.tilLaptopGPU);
        tilLaptopRAM = (TextInputLayout) view.findViewById(R.id.tilLaptopRAM);
        tilLaptopWifi = (TextInputLayout) view.findViewById(R.id.tilLaptopWifi) ;
        tilLaptopHardDisk = (TextInputLayout) view.findViewById(R.id.tilLaptopHardDisk);
        tilLaptopCommunicationGateway = (TextInputLayout) view.findViewById(R.id.tilLaptopCommunicationGateway) ;
        tilLaptopKeyboard = (TextInputLayout) view.findViewById(R.id.tilLaptopKeyboard) ;
        tilLaptopScreenResolution = (TextInputLayout) view.findViewById(R.id.tilLaptopScreenResolution);
        tilLaptopScreenSize = (TextInputLayout) view.findViewById(R.id.tilLaptopScreenSize) ;
        tilLaptopBattery = (TextInputLayout) view.findViewById(R.id.tilLaptopBattery) ;
        tilLaptopWeight = (TextInputLayout) view.findViewById(R.id.tilLaptopWeight) ;

        edtLaptopName = (EditText) view.findViewById(R.id.edtLaptopName);
        edtLaptopPrice = (EditText) view.findViewById(R.id.edtLaptopPrice);
        edtLaptopOriginalPrice = (EditText) view.findViewById(R.id.edtLaptopOriginPrice);
        edtLaptopCPU = (EditText) view.findViewById(R.id.edtLaptopCPU);
        edtLaptopGPU = (EditText) view.findViewById(R.id.edtLaptopGPU);
        edtLaptopRAM = (EditText) view.findViewById(R.id.edtLaptopRAM);
        edtLaptopWifi = (EditText) view.findViewById(R.id.edtLaptopWifi);
        edtLaptopHardDisk = (EditText) view.findViewById(R.id.edtLaptopHardDisk) ;
        edtLaptopCommunicationGateway = (EditText) view.findViewById(R.id.edtLaptopCommunicationGateway);
        edtLaptopKeyboard = (EditText) view.findViewById(R.id.edtLaptopKeyboard);
        edtLaptopScreenResolution = (EditText) view.findViewById(R.id.edtLaptopScreenResolution);
        edtLaptopScreenSize = (EditText) view.findViewById(R.id.edtLaptopScreenSize);
        edtLaptopBattery = (EditText) view.findViewById(R.id.edtLaptopBattery);
        edtLaptopWeight = (EditText) view.findViewById(R.id.edtLaptopWeight);
    }


    private void updateLaptopFragment(){
        if(this.laptop == null)  return;
        edtLaptopName.setText(laptop.getLaptopName());
        edtLaptopPrice.setText(String.format(laptop.getLaptopPrice().toString()));
        edtLaptopOriginalPrice.setText(String.format(laptop.getLaptopOriginPrice().toString()));
        edtLaptopCPU.setText(laptop.getLaptopCPU());
        edtLaptopGPU.setText(laptop.getLaptopGPU());
        edtLaptopRAM.setText(laptop.getLaptopRAM());
        edtLaptopWifi.setText(laptop.getLaptopWifi());
        edtLaptopHardDisk.setText(laptop.getLaptopHardDisk());
        edtLaptopCommunicationGateway.setText(laptop.getLaptopCommunicationGateway());
        edtLaptopKeyboard.setText(laptop.getLaptopKeyboard());
        edtLaptopScreenResolution.setText(laptop.getLaptopScreenResolution());
        edtLaptopScreenSize.setText(laptop.getLaptopScreenSize());
        edtLaptopBattery.setText(laptop.getLaptopBattery());
        edtLaptopWeight.setText(laptop.getLaptopWeight());
    }
    public Laptop getLaptop(){
        this.laptop = new Laptop();
        this.laptop.setLaptopName(edtLaptopName.getText().toString());
        this.laptop.setLaptopPrice(Double.valueOf(edtLaptopPrice.getText().toString()));
        this.laptop.setLaptopOriginPrice(Double.valueOf(edtLaptopOriginalPrice.getText().toString()));
        this.laptop.setLaptopCPU(edtLaptopCPU.getText().toString());
        this.laptop.setLaptopGPU(edtLaptopGPU.getText().toString());
        this.laptop.setLaptopHardDisk(edtLaptopHardDisk.getText().toString());
        this.laptop.setLaptopCommunicationGateway(edtLaptopCommunicationGateway.getText().toString());
        this.laptop.setLaptopBattery(edtLaptopBattery.getText().toString());
        this.laptop.setLaptopKeyboard(edtLaptopKeyboard.getText().toString());
        this.laptop.setLaptopScreenResolution(edtLaptopScreenResolution.getText().toString());
        this.laptop.setLaptopScreenSize(edtLaptopScreenSize.getText().toString());
        this.laptop.setLaptopWeight(edtLaptopWeight.getText().toString());
        this.laptop.setLaptopWifi(edtLaptopWifi.getText().toString());
        return this.laptop;
    }


}