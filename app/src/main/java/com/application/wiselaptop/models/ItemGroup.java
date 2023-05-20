package com.application.wiselaptop.models;

/* loaded from: classes9.dex */
public class ItemGroup {
    private String itemGroupId;
    private String itemGroupName;

    public ItemGroup() {
    }

    public ItemGroup(String itemGroupId, String itemGroupName) {
        this.itemGroupId = itemGroupId;
        this.itemGroupName = itemGroupName;
    }

    public String getItemGroupId() {
        return this.itemGroupId;
    }

    public void setItemGroupId(String itemGroupId) {
        this.itemGroupId = itemGroupId;
    }

    public String getItemGroupName() {
        return this.itemGroupName;
    }

    public void setItemGroupName(String itemGroupName) {
        this.itemGroupName = itemGroupName;
    }
}
