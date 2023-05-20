package com.application.wiselaptop.models;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;
import com.google.firebase.database.PropertyName;

@IgnoreExtraProperties
public class Laptop {

    @PropertyName("laptop_id")
    public String laptopID;

    @PropertyName("laptop_name")
    public String laptopName;

    @PropertyName("laptop_price")
    public Double laptopPrice;

    @PropertyName("laptop_origin_price")
    public Double laptopOriginPrice;

    @PropertyName("laptop_cpu")
    public String laptopCPU;

    @PropertyName("laptop_gpu")
    public String laptopGPU;

    @PropertyName("laptop_ram")
    public String laptopRAM;

    @PropertyName("laptop_screen_resolution")
    public String laptopScreenResolution;

    @PropertyName("laptop_hard_disk")
    public String laptopHardDisk;

    @PropertyName("laptop_lan")
    public String laptopLAN;

    @PropertyName("laptop_wifi")
    public String laptopWifi;

    @PropertyName("laptop_communication_gateway")
    public String laptopCommunicationGateway;

    @PropertyName("laptop_keyboard")
    public String laptopKeyboard;

    @PropertyName("laptop_screen_size")
    public String laptopScreenSize;

    @PropertyName("laptop_battery")
    public String laptopBattery;

    @PropertyName("laptop_weight")
    public String laptopWeight;

    @PropertyName("laptop_image_path")
    public String laptopImagePath;

    @PropertyName("laptop_main_image")
    public String laptopMainImage;

    @PropertyName("laptop_demand_id")
    public String laptopDemandID;

    @PropertyName("laptop_brand_id")
    public Integer laptopBrandID;

    public Laptop() {
    }

    public Laptop(String laptopID, String laptopName, Double laptopPrice, Double laptopOriginPrice, String laptopCPU, String laptopGPU, String laptopRAM, String laptopScreenResolution, String laptopHardDisk, String laptopLAN, String laptopWifi, String laptopCommunicationGateway, String laptopKeyboard, String laptopScreenSize, String laptopBattery, String laptopWeight, String laptopImagePath, String laptopDemandID, Integer laptopBrandID) {
        this.laptopID = laptopID;
        this.laptopName = laptopName;
        this.laptopPrice = laptopPrice;
        this.laptopOriginPrice = laptopOriginPrice;
        this.laptopCPU = laptopCPU;
        this.laptopGPU = laptopGPU;
        this.laptopRAM = laptopRAM;
        this.laptopScreenResolution = laptopScreenResolution;
        this.laptopHardDisk = laptopHardDisk;
        this.laptopLAN = laptopLAN;
        this.laptopWifi = laptopWifi;
        this.laptopCommunicationGateway = laptopCommunicationGateway;
        this.laptopKeyboard = laptopKeyboard;
        this.laptopScreenSize = laptopScreenSize;
        this.laptopBattery = laptopBattery;
        this.laptopWeight = laptopWeight;
        this.laptopImagePath = laptopImagePath;
        this.laptopDemandID = laptopDemandID;
        this.laptopBrandID = laptopBrandID;
    }

    @Exclude
    public String getLaptopID() {
        return laptopID;
    }

    @Exclude
    public void setLaptopID(String laptopID) {
        this.laptopID = laptopID;
    }

    @Exclude
    public String getLaptopName() {
        return laptopName;
    }

    @Exclude
    public void setLaptopName(String laptopName) {
        this.laptopName = laptopName;
    }

    @Exclude
    public Double getLaptopPrice() {
        return laptopPrice;
    }

    @Exclude
    public void setLaptopPrice(Double laptopPrice) {
        this.laptopPrice = laptopPrice;
    }

    @Exclude
    public Double getLaptopOriginPrice() {
        return laptopOriginPrice;
    }

    @Exclude
    public void setLaptopOriginPrice(Double laptopOriginPrice) {
        this.laptopOriginPrice = laptopOriginPrice;
    }

    @Exclude
    public String getLaptopCPU() {
        return laptopCPU;
    }

    @Exclude
    public void setLaptopCPU(String laptopCPU) {
        this.laptopCPU = laptopCPU;
    }

    @Exclude
    public String getLaptopGPU() {
        return laptopGPU;
    }

    @Exclude
    public void setLaptopGPU(String laptopGPU) {
        this.laptopGPU = laptopGPU;
    }

    @Exclude
    public String getLaptopRAM() {
        return laptopRAM;
    }

    @Exclude
    public void setLaptopRAM(String laptopRAM) {
        this.laptopRAM = laptopRAM;
    }

    @Exclude
    public String getLaptopScreenResolution() {
        return laptopScreenResolution;
    }

    @Exclude
    public void setLaptopScreenResolution(String laptopScreenResolution) {
        this.laptopScreenResolution = laptopScreenResolution;
    }

    @Exclude
    public String getLaptopHardDisk() {
        return laptopHardDisk;
    }

    @Exclude
    public void setLaptopHardDisk(String laptopHardDisk) {
        this.laptopHardDisk = laptopHardDisk;
    }

    @Exclude
    public String getLaptopLAN() {
        return laptopLAN;
    }

    @Exclude
    public void setLaptopLAN(String laptopLAN) {
        this.laptopLAN = laptopLAN;
    }

    @Exclude
    public String getLaptopWifi() {
        return laptopWifi;
    }

    @Exclude
    public void setLaptopWifi(String laptopWifi) {
        this.laptopWifi = laptopWifi;
    }

    @Exclude
    public String getLaptopCommunicationGateway() {
        return laptopCommunicationGateway;
    }

    @Exclude
    public void setLaptopCommunicationGateway(String laptopCommunicationGateway) {
        this.laptopCommunicationGateway = laptopCommunicationGateway;
    }

    @Exclude
    public String getLaptopKeyboard() {
        return laptopKeyboard;
    }

    @Exclude
    public void setLaptopKeyboard(String laptopKeyboard) {
        this.laptopKeyboard = laptopKeyboard;
    }

    @Exclude
    public String getLaptopScreenSize() {
        return laptopScreenSize;
    }

    @Exclude
    public void setLaptopScreenSize(String laptopScreenSize) {
        this.laptopScreenSize = laptopScreenSize;
    }

    @Exclude
    public String getLaptopBattery() {
        return laptopBattery;
    }

    @Exclude
    public void setLaptopBattery(String laptopBattery) {
        this.laptopBattery = laptopBattery;
    }

    @Exclude
    public String getLaptopWeight() {
        return laptopWeight;
    }

    @Exclude
    public void setLaptopWeight(String laptopWeight) {
        this.laptopWeight = laptopWeight;
    }

    @Exclude
    public String getLaptopImagePath() {
        return laptopImagePath;
    }

    @Exclude
    public void setLaptopImagePath(String laptopImagePath) {
        this.laptopImagePath = laptopImagePath;
    }

    @Exclude
    public String getLaptopMainImage() {
        return laptopMainImage;
    }

    @Exclude
    public void setLaptopMainImage(String laptopMainImage) {
        this.laptopMainImage = laptopMainImage;
    }

    @Exclude
    public String getLaptopDemandID() {
        return laptopDemandID;
    }

    @Exclude
    public void setLaptopDemandID(String laptopDemandID) {
        this.laptopDemandID = laptopDemandID;
    }

    @Exclude
    public Integer getLaptopBrandID() {
        return laptopBrandID;
    }

    @Exclude
    public void setLaptopBrandID(Integer laptopBrandID) {
        this.laptopBrandID = laptopBrandID;
    }
}
