package com.application.wiselaptop.models;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;
import com.google.firebase.database.PropertyName;

import java.util.Date;

@IgnoreExtraProperties
public class Order {

    @PropertyName("order_id")
    public String orderID;

    @PropertyName("order_account_id")
    public String orderAccountID;

    @PropertyName("order_receiver_name")
    public String orderReceiverName;

    @PropertyName("order_receiver_phone_number")
    public String orderReceiverPhoneNumber;

    @PropertyName("order_receiver_address")
    public String orderReceiverAddress;

    @PropertyName("order_date")
    public Date orderDate;

    @PropertyName("order_status")
    public Integer orderStatus;

    @PropertyName("order_payment_method")
    public Integer orderPaymentMethod;

    @PropertyName("order_total_amount")
    public Double orderTotalAmount;

    public Order() {
    }

    public Order(String orderID, String orderAccountID, String orderReceiverName, String orderReceiverPhoneNumber, String orderReceiverAddress, Date orderDate, Integer orderStatus, Integer orderPaymentMethod, Double orderTotalAmount) {
        this.orderID = orderID;
        this.orderAccountID = orderAccountID;
        this.orderReceiverName = orderReceiverName;
        this.orderReceiverPhoneNumber = orderReceiverPhoneNumber;
        this.orderReceiverAddress = orderReceiverAddress;
        this.orderDate = orderDate;
        this.orderStatus = orderStatus;
        this.orderPaymentMethod = orderPaymentMethod;
        this.orderTotalAmount = orderTotalAmount;
    }

    public String getOrderID() {
        return orderID;
    }

    @Exclude
    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    @Exclude
    public String getOrderAccountID() {
        return orderAccountID;
    }

    @Exclude
    public void setOrderAccountID(String orderAccountID) {
        this.orderAccountID = orderAccountID;
    }

    @Exclude
    public String getOrderReceiverName() {
        return orderReceiverName;
    }

    @Exclude
    public void setOrderReceiverName(String orderReceiverName) {
        this.orderReceiverName = orderReceiverName;
    }

    @Exclude
    public String getOrderReceiverPhoneNumber() {
        return orderReceiverPhoneNumber;
    }

    @Exclude
    public void setOrderReceiverPhoneNumber(String orderReceiverPhoneNumber) {
        this.orderReceiverPhoneNumber = orderReceiverPhoneNumber;
    }

    @Exclude
    public String getOrderReceiverAddress() {
        return orderReceiverAddress;
    }

    @Exclude
    public void setOrderReceiverAddress(String orderReceiverAddress) {
        this.orderReceiverAddress = orderReceiverAddress;
    }

    @Exclude
    public Date getOrderDate() {
        return orderDate;
    }

    @Exclude
    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    @Exclude
    public Integer getOrderStatus() {
        return orderStatus;
    }

    @Exclude
    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Exclude
    public Integer getOrderPaymentMethod() {
        return orderPaymentMethod;
    }

    @Exclude
    public void setOrderPaymentMethod(Integer orderPaymentMethod) {
        this.orderPaymentMethod = orderPaymentMethod;
    }

    @Exclude
    public Double getOrderTotalAmount() {
        return orderTotalAmount;
    }

    @Exclude
    public void setOrderTotalAmount(Double orderTotalAmount) {
        this.orderTotalAmount = orderTotalAmount;
    }
}
