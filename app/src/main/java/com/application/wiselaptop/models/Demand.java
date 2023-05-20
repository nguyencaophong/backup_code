package com.application.wiselaptop.models;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;
import com.google.firebase.database.PropertyName;

import java.io.Serializable;

@IgnoreExtraProperties
public class Demand {
    @PropertyName("demand_id")
    public String demandId;
    @PropertyName("demand_name")
    public String demandName;
    @PropertyName("demand_image")
    public  String demandImage;

    public Demand(){

    }
    public Demand(String demandId, String demandName, String demandImage){
        this.demandId = demandId;
        this.demandName = demandName;
        this.demandImage = demandImage;
    }

    @Exclude
    public String getDemandId() {
        return demandId;
    }

    @Exclude
    public void setDemandId(String demandId) {
        this.demandId = demandId;
    }

    @Exclude
    public String getDemandName() {
        return demandName;
    }

    @Exclude
    public void setDemandName(String demandName) {
        this.demandName = demandName;
    }

    @Exclude
    public String getDemandImage() {
        return demandImage;
    }

    @Exclude
    public void setDemandImage(String demandImage) {
        this.demandImage = demandImage;
    }
}
