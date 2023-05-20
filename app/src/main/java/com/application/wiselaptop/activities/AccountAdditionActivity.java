package com.application.wiselaptop.activities;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.application.wiselaptop.R;
import com.application.wiselaptop.admin.fragments.LaptopFragment;
import com.application.wiselaptop.api.AccountApi;
import com.application.wiselaptop.fragments.AccountFragment;
import com.application.wiselaptop.fragments.UploadImageFragment;
import com.application.wiselaptop.fragments.UploadSignleImageFragment;
import com.application.wiselaptop.interfaces.OnListener;
import com.application.wiselaptop.models.Account;
import com.application.wiselaptop.models.Laptop;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.UUID;

public class AccountAdditionActivity extends AppCompatActivity {
    private Button btnSubmit;
    AccountFragment accountFragment;
    private Spinner spnRole;
    StorageReference storageReference;
    Bitmap image;
    UploadSignleImageFragment uploadSignleImageFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_addition);
        setToolbar();
        setControl();
        setFragment();
        setEvent();
    }

    private void setToolbar(){
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Thêm thông tin người dùng");
    }

    private void setFragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        accountFragment = new AccountFragment();
        uploadSignleImageFragment = new UploadSignleImageFragment(image);
        fragmentTransaction.add(R.id.clAccountAddition, accountFragment);
        fragmentTransaction.add(R.id.clUploadAvatarAddition,uploadSignleImageFragment);
        fragmentTransaction.commit();
    }

    private void setEvent(){
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Account account = accountFragment.getAccount();
                Uri image = uploadSignleImageFragment.getUriImage();
                String imageID = UUID.randomUUID().toString();
                account.setAccountUserImage(imageID);
                Thread loadingDataThread1 = new Thread(() -> {
                    AccountApi.writeNewAccount(account, new OnListener() {
                        @Override
                        public void OnSuccessListener() {
                            finish();
                        }
                        @Override
                        public void OnFailedListener() {
                        }
                    });
                });
                Thread loadingImageThread1 = new Thread(() -> {
                    try{
                        uploadAvatar(account,image,imageID);
                    }
                    catch (Exception ex){
                        ex.printStackTrace();
                    }
                });
                loadingImageThread1.start();
                loadingDataThread1.start();
            }
        });
    }
    
    private void uploadAvatar(Account account,Uri image,String imageID){
        storageReference = FirebaseStorage.getInstance().getReference().getStorage().getReference("accounts");
        String accountID = account.getAccountId();
        storageReference.child(accountID).child(imageID).putFile(image).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                Toast.makeText(AccountAdditionActivity.this, "Create account success.", Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                System.out.println("failed");
            }
        });
    }

    private void setControl(){
        btnSubmit = findViewById(R.id.btnSubmitAccount);
        spnRole = findViewById(R.id.spnRole);
        List<Fragment> fragments = getSupportFragmentManager().getFragments();
        for(Fragment fragment: fragments){
            if(fragment instanceof AccountFragment){
                accountFragment = (AccountFragment) fragment;
            }
        }
    }
}