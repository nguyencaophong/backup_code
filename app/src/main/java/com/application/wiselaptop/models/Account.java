package com.application.wiselaptop.models;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;
import com.google.firebase.database.PropertyName;

import java.io.Serializable;

@IgnoreExtraProperties
public class Account implements Serializable {
    @PropertyName("account_id")
    public String accountId;
    @PropertyName("account_username")
    public String accountUsername;
    @PropertyName("account_password")
    public String accountPassword;
    @PropertyName("account_role")
//    Role 0 = client, 1 = admin
    public int accountRole;
    @PropertyName("account_full_name")
    public String accountFullName;
    @PropertyName("account_date_of_birth")
    public String accountDateOfBirth;
    @PropertyName("account_email")
    public String accountEmail;
    @PropertyName("account_phone_number")
    public String accountPhoneNumber;
    @PropertyName("account_user_image")
    public String accountUserImage;
    @PropertyName("timestamp")
    public String accountTimestamp;

    public Account() {
    }

    @Exclude
    public String getAccountTimestamp() {
        return accountTimestamp;
    }
    @Exclude
    public void setAccountTimestamp(String accountTimestamp) {
        this.accountTimestamp = accountTimestamp;
    }

    public Account(String accountId, String accountUsername, String accountPassword, int accountRole, String accountFullName, String accountDateOfBirth, String accountEmail, String accountPhoneNumber, String accountUserImage) {
        this.accountId = accountId;
        this.accountUsername = accountUsername;
        this.accountPassword = accountPassword;
        this.accountRole = accountRole;
        this.accountFullName = accountFullName;
        this.accountDateOfBirth = accountDateOfBirth;
        this.accountEmail = accountEmail;
        this.accountPhoneNumber = accountPhoneNumber;
        this.accountUserImage = accountUserImage;
    }
    @Exclude
    public String getAccountId() {
        return accountId;
    }
    @Exclude
    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }
    @Exclude
    public String getAccountUsername() {
        return accountUsername;
    }
    @Exclude
    public void setAccountUsername(String accountUsername) {
        this.accountUsername = accountUsername;
    }
    @Exclude
    public String getAccountPassword() {
        return accountPassword;
    }
    @Exclude
    public void setAccountPassword(String accountPassword) {
        this.accountPassword = accountPassword;
    }
    @Exclude
    public int getAccountRole() {
        return accountRole;
    }
    @Exclude
    public void setAccountRole(int accountRole) {
        this.accountRole = accountRole;
    }
    @Exclude
    public String getAccountFullName() {
        return accountFullName;
    }
    @Exclude
    public void setAccountFullName(String accountFullName) {
        this.accountFullName = accountFullName;
    }
    @Exclude
    public String getAccountDateOfBirth() {
        return accountDateOfBirth;
    }

    @Exclude
    public void setAccountDateOfBirth(String accountDateOfBirth) {
        this.accountDateOfBirth = accountDateOfBirth;
    }
    @Exclude
    public String getAccountEmail() {
        return accountEmail;
    }
    @Exclude
    public void setAccountEmail(String accountEmail) {
        this.accountEmail = accountEmail;
    }
    @Exclude
    public String getAccountPhoneNumber() {
        return accountPhoneNumber;
    }
    @Exclude
    public void setAccountPhoneNumber(String accountPhoneNumber) {
        this.accountPhoneNumber = accountPhoneNumber;
    }
    @Exclude
    public String getAccountUserImage() {
        return accountUserImage;
    }
    @Exclude
    public void setAccountUserImage(String accountUserImage) {
        this.accountUserImage = accountUserImage;
    }
}