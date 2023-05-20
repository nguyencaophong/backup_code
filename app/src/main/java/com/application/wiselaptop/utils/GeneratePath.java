package com.application.wiselaptop.utils;

public class GeneratePath {

    private String parentPath;

    public GeneratePath(){
        this.parentPath = "";
    }

    public GeneratePath(String parentPath){
        this.parentPath = parentPath;
    }

    public GeneratePath child(String childPath){
        if(this.parentPath == ""){
            return new GeneratePath(this.parentPath + childPath);
        }
        return new GeneratePath(this.parentPath + "/" + childPath);
    }

    public String finish(){
        return this.parentPath;
    }
}
