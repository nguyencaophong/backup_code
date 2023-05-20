package com.application.wiselaptop.models;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;
import com.google.firebase.database.PropertyName;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


@IgnoreExtraProperties
public class Product {

    public final static String KEY_PRODUCT_SRC_IMAGE = "product_src_image";
    public final static String KEY_PRODUCT_PRICE = "product_price";
    public final static String KEY_PRODUCT_ID = "product_id";
    public final static String KEY_PRODUCT_CPU = "product_cpu";

    public final static String KEY_PRODUCT_GROUP = "product_group";

    public final static String KEY_PRODUCT_BRAND = "product_brand";
    public final static String KEY_PRODUCT_NAME = "product_name";
    public final static String KEY_PRODUCT_DISK = "product_disk";
    public final static String KEY_PRODUCT_OPERATION = "product_operation";
    public final static String KEY_PRODUCT_LAN = "product_lan";
    public final static String KEY_PRODUCT_COST = "product_cost";
    public final static String KEY_PRODUCT_SCREEN = "product_screen";
    public final static String KEY_PRODUCT_WEIGHT = "product_weight";
    public final static String KEY_PRODUCT_CONNECTION = "product_connection";
    public final static String KEY_PRODUCT_INVENTORY = "product_inventory";
    public final static String KEY_PRODUCT_SOLD = "product_sold";

    public String productCost;
    String productSrcImge;

    @PropertyName("product_id")
    public String productId;
    public String productBrand;
    public String productGroup;
    @PropertyName("product_name")
    public String productName;
    public String productPrice;
    String productCPU;
    String productDisk;
    String productOperation;
    String productLAN;
    String productScreen;
    String productWeight;
    Integer productInventory;
    String productConnection;
    Integer productSold;

    public Product() {

    }

    public Product(String productId, String productName, String productCost, String productPrice) {
        this.productId = productId;
        this.productName = productName;
        this.productCost = productCost;
        this.productPrice = productPrice;
    }

    public Product(String productName, String productCost, String productPrice){
        UUID uuid = UUID.randomUUID();
        this.productId = uuid.toString();
        this.productName = productName;
        this.productPrice = productPrice;
        this.productCost = productCost;
    }

    @Exclude
    public String getProductId() {
        return this.productId;
    }
    @Exclude
    public void setProductId(String productId) {
        this.productId = productId;
    }

    @Exclude
    public String getProductName() {
        return this.productName;
    }
    @Exclude
    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Exclude
    public String getProductCost() {
        return this.productCost;
    }

    @Exclude
    public void setProductCost(String productCost) {
        this.productCost = productCost;
    }

    @Exclude
    public String getProductPrice() {
        return this.productPrice;
    }

    @Exclude
    public String getProductBrand() {
        return productBrand;
    }

    @Exclude
    public void setProductBrand(String productBrand) {
        this.productBrand = productBrand;
    }

    @Exclude
    public String getProductGroup() {
        return productGroup;
    }

    @Exclude
    public void setProductGroup(String productGroup) {
        this.productGroup = productGroup;
    }

    public String getProductCPU() {
        return productCPU;
    }

    public void setProductCPU(String productCPU) {
        this.productCPU = productCPU;
    }

    public String getProductOperation() {
        return productOperation;
    }

    public void setProductOperation(String productOperation) {
        this.productOperation = productOperation;
    }

    public String getProductScreen() {
        return productScreen;
    }

    public void setProductScreen(String productScreen) {
        this.productScreen = productScreen;
    }

    public String getProductLAN() {
        return productLAN;
    }

    public void setProductLAN(String productLAN) {
        this.productLAN = productLAN;
    }

    public String getProductWeight() {
        return productWeight;
    }

    public void setProductWeight(String productWeight) {
        this.productWeight = productWeight;
    }

    public String getProductConnection() {
        return productConnection;
    }

    public void setProductConnection(String productConnection) {
        this.productConnection = productConnection;
    }

    public String getProductDisk() {
        return productDisk;
    }

    public void setProductDisk(String productDisk) {
        this.productDisk = productDisk;
    }

    public Integer getProductInventory() {
        return productInventory;
    }

    public void setProductInventory(Integer productInventory) {
        this.productInventory = productInventory;
    }

    public Integer getProductSold() {
        return productSold;
    }

    public void setProductSold(Integer productSold) {
        this.productSold = productSold;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }


    public void toMap(Map<String, Object> product) {
        if (product.get(KEY_PRODUCT_SRC_IMAGE) != null) {
            this.productSrcImge = product.get(KEY_PRODUCT_SRC_IMAGE).toString();
        }
        this.productId = product.get(KEY_PRODUCT_ID).toString();
        this.productName = product.get(KEY_PRODUCT_NAME).toString();
        this.productCost = String.valueOf(product.get(KEY_PRODUCT_COST).toString());
        this.productPrice = String.valueOf(product.get(KEY_PRODUCT_PRICE).toString());
        if (product.get(KEY_PRODUCT_GROUP) != null) {
            this.productGroup = product.get(KEY_PRODUCT_GROUP).toString();
        }

        if (product.get(KEY_PRODUCT_BRAND) != null) {
            this.productBrand = product.get(KEY_PRODUCT_BRAND).toString();
        }
    }

    public String getProductSrcImge() {
        return productSrcImge;
    }

    public void setProductSrcImge(String productSrcImge) {
        this.productSrcImge = productSrcImge;
    }

    public Map<String, Object> toObject(){
        Map<String, Object> product = new HashMap<>();
        product.put(KEY_PRODUCT_ID, this.productId);
        product.put(KEY_PRODUCT_NAME, this.productName);
        product.put(KEY_PRODUCT_COST, this.productCost) ;
        product.put(KEY_PRODUCT_PRICE, this.productPrice);
        return product;
    }
}
