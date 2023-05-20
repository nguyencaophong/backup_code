package com.application.wiselaptop.api;

import androidx.annotation.NonNull;

import com.application.wiselaptop.interfaces.OnListener;
import com.application.wiselaptop.models.Account;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.List;
import java.util.UUID;

public class AccountApi {

    private final static String KEY_ACCOUNT_ENTITY = "accounts";

    public  final static DatabaseReference accountDatabase = FirebaseDatabase.getInstance().getReference("accounts");

    public static void readAccounts(List<Account> accounts, OnListener onListener){
        accountDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    for(DataSnapshot accountDS: snapshot.getChildren()){
                        Account account = accountDS.getValue(Account.class);
                        accounts.add(account);
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public static void writeNewAccount(Account account, OnListener onListener){
        String accountID = UUID.randomUUID().toString();
        account.setAccountId(accountID);
        accountDatabase.child(accountID).setValue(account).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                if(onListener != null){
                    onListener.OnSuccessListener();
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                if(onListener != null){
                    onListener.OnFailedListener();
                }
            }
        });
    }

    public static void updateAccountByID(String accountID, Account account, OnListener onListener){
        account.setAccountId(accountID);
        accountDatabase.child(accountID).setValue(account).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                if(onListener != null){
                    onListener.OnSuccessListener();
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                if(onListener != null){
                    onListener.OnFailedListener();
                }
            }
        });
    }

    public void deleteFolderNameByIDFromStorage(String folderName){

    }

    public static void deleteAccountByIDFromDatabase(String accountID, OnListener onListener){
        accountDatabase.child(accountID).removeValue().addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                onListener.OnSuccessListener();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                if(onListener != null){
                    onListener.OnFailedListener();
                }
            }
        });
    }
}
