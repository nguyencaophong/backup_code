package com.application.wiselaptop.models;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;
import com.google.firebase.database.PropertyName;

@IgnoreExtraProperties
public class Cart {
    @PropertyName("card_id")
    public String cardID;

    public Cart() {
    }

    public Cart(String cardID) {
        this.cardID = cardID;
    }

    @Exclude
    public String getCardID() {
        return cardID;
    }

    @Exclude
    public void setCardID(String cardID) {
        this.cardID = cardID;
    }
}
