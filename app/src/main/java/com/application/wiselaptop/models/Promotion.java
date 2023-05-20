package com.application.wiselaptop.models;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;
import com.google.firebase.database.PropertyName;

import java.util.Date;

@IgnoreExtraProperties
public class Promotion {
    @PropertyName("promotion_id")
    public String promotionID;

    @PropertyName("promotion_name")
    public String promotionName;

    @PropertyName("promotion_quantity")
    public String promotionQuantity;

    @PropertyName("promotion_end_date")
    public Date promotionEndDate;

    public Promotion() {
    }


    public Promotion(String promotionID, String promotionName, String promotionQuantity, Date promotionEndDate) {
        this.promotionID = promotionID;
        this.promotionName = promotionName;
        this.promotionQuantity = promotionQuantity;
        this.promotionEndDate = promotionEndDate;
    }


    @Exclude
    public String getPromotionID() {
        return promotionID;
    }

    @Exclude
    public void setPromotionID(String promotionID) {
        this.promotionID = promotionID;
    }

    @Exclude
    public String getPromotionName() {
        return promotionName;
    }

    @Exclude
    public void setPromotionName(String promotionName) {
        this.promotionName = promotionName;
    }

    @Exclude
    public String getPromotionQuantity() {
        return promotionQuantity;
    }

    @Exclude
    public void setPromotionQuantity(String promotionQuantity) {
        this.promotionQuantity = promotionQuantity;
    }

    @Exclude
    public Date getPromotionEndDate() {
        return promotionEndDate;
    }

    @Exclude
    public void setPromotionEndDate(Date promotionEndDate) {
        this.promotionEndDate = promotionEndDate;
    }
}


