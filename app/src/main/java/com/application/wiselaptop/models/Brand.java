package com.application.wiselaptop.models;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;
import com.google.firebase.database.PropertyName;

import java.io.Serializable;

@IgnoreExtraProperties
public class Brand implements Serializable {
    @PropertyName("brand_id")
    public String brandId;
    @PropertyName("brand_name")
    public String brandName;
    @PropertyName("brand_image")
    public String brandImage;
    public Brand() {
    }
    public Brand(String brandId, String brandName, String brandImage) {
        this.brandId = brandId;
        this.brandName = brandName;
        this.brandImage = brandImage;
    }
    @Exclude
    public String getBrandId() {
        return this.brandId;
    }
    @Exclude
    public void setBrandId(String brandId) {
        this.brandId = brandId;
    }
    @Exclude
    public String getBrandName() {
        return this.brandName;
    }
    @Exclude
    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }
    @Exclude
    public String getBrandImage() {
        return this.brandImage;
    }
    @Exclude
    public void setBrandImage(String brandImage) {
        this.brandImage = brandImage;
    }
}
