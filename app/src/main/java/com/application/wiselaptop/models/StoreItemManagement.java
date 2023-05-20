package com.application.wiselaptop.models;

/* loaded from: classes9.dex */
public class StoreItemManagement {
    private String colorString;
    private String storeItemManagementId;
    private String storeItemManagementName;
    private int storeItemManagementSrcImage;

    public StoreItemManagement() {
    }

    public StoreItemManagement(int storeItemManagementSrcImage, String storeItemManagementName) {
        this.storeItemManagementSrcImage = storeItemManagementSrcImage;
        this.storeItemManagementName = storeItemManagementName;
        this.colorString = "#959595";
    }

    public StoreItemManagement(int storeItemManagementSrcImage, String storeItemManagementName, String colorString) {
        this.storeItemManagementSrcImage = storeItemManagementSrcImage;
        this.storeItemManagementName = storeItemManagementName;
        this.colorString = colorString;
    }

    public String getColorString() {
        return this.colorString;
    }

    public void setColorString(String colorString) {
        this.colorString = colorString;
    }

    public int getStoreItemManagementSrcImage() {
        return this.storeItemManagementSrcImage;
    }

    public void setStoreItemManagementSrcImage(int storeItemManagementSrcImage) {
        this.storeItemManagementSrcImage = storeItemManagementSrcImage;
    }

    public String getStoreItemManagementName() {
        return this.storeItemManagementName;
    }

    public void setStoreItemManagementName(String storeItemManagementName) {
        this.storeItemManagementName = storeItemManagementName;
    }
}
