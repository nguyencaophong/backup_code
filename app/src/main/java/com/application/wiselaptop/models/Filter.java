package com.application.wiselaptop.models;

public class Filter {

    String filterID;
    String filterName;
    Boolean isSelected;

    public Filter(String filterName) {
        this.filterName = filterName;
        this.isSelected = false;
    }

    public Filter(String filterID, String filterName){
        this.filterID = filterID;
        this.filterName = filterName;
    }

    public Filter(String filterID, String filterName, Boolean isSelected){
        this.filterID = filterID;
        this.filterName = filterName;
        this.isSelected = isSelected;
    }

    public String getFilterName() {
        return this.filterName;
    }

    public void setFilterName(String filterName) {
        this.filterName = filterName;
    }

    public Boolean getSelected() {
        return this.isSelected;
    }

    public void setSelected(Boolean selected) {
        this.isSelected = selected;
    }
}
