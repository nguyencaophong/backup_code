package com.application.wiselaptop.models;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes9.dex */
public class User {
    Integer age;
    String email;
    Map<String, String> mappingObject;
    String name;
    String password;
    String phone;
    String userId;
    String userName;

    public User() {
    }

    public User(String userId, String userName, String password, String name, Integer age, String email, String phone) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.name = name;
        this.age = age;
        this.email = email;
        this.phone = phone;
        HashMap hashMap = new HashMap();
        this.mappingObject = hashMap;
        hashMap.put("user_id", userId);
        this.mappingObject.put("user_name", userName);
        this.mappingObject.put("name", name);
        this.mappingObject.put("password", password);
        this.mappingObject.put("age", age.toString());
        this.mappingObject.put("email", email);
        this.mappingObject.put("phone", phone);
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return this.age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Map<String, String> getMappingObject() {
        return this.mappingObject;
    }

    public void setMappingObject(Map<String, String> mappingObject) {
        this.mappingObject = mappingObject;
    }
}
