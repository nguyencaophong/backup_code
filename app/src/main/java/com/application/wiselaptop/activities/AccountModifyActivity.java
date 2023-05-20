package com.application.wiselaptop.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.application.wiselaptop.R;
import com.application.wiselaptop.admin.fragments.LaptopFragment;
import com.application.wiselaptop.api.AccountApi;
import com.application.wiselaptop.fragments.AccountFragment;
import com.application.wiselaptop.fragments.UploadSignleImageFragment;
import com.application.wiselaptop.interfaces.OnListener;
import com.application.wiselaptop.models.Account;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.util.List;
import java.util.Objects;

public class AccountModifyActivity extends AppCompatActivity {
    Button btnUpdateAccount;
    AccountFragment accountFragment;
    String accountID;
    Bitmap image;
    UploadSignleImageFragment uploadSignleImageFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_modify);
        setToolbar();
        setFragment();
        setControl();
        setEvent();
    }

    private void setFragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        uploadSignleImageFragment = new UploadSignleImageFragment(image);
        fragmentTransaction.add(R.id.clUploadAvatarAddition,uploadSignleImageFragment);
        fragmentTransaction.commit();
    }

    private Account getInfoAccount(){
        Account account =  (Account)getIntent().getSerializableExtra("account");
        accountID = account.getAccountId();
        return account;
    }

    private void setToolbar(){
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Chỉnh sửa thông tin người dùng");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            this.finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setControl(){
        btnUpdateAccount = (Button)  findViewById(R.id.btnUpdateAccount);
        List<Fragment> accountModifyFragments = getSupportFragmentManager().getFragments();
        for(Fragment accountModifyFragment: accountModifyFragments){
            if(accountModifyFragment instanceof AccountFragment){
                accountFragment = (AccountFragment) accountModifyFragment;
                accountFragment.setAccount(getInfoAccount());
                Account account = getInfoAccount();
                StorageReference storageReference = FirebaseStorage.getInstance().getReference("accounts");

                storageReference.child(account.getAccountId()).child(account.getAccountUserImage()).getDownloadUrl().addOnSuccessListener(uri -> {
                    convertUriToBitmap(uri);
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                    }
                });
            }
        }
    }

    private void convertUriToBitmap(Uri uri){
        Picasso.get().load(uri).into(new Target() {
            @Override
            public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                image = bitmap;
                uploadSignleImageFragment.setImage(image);
            }
            @Override
            public void onBitmapFailed(Exception e, Drawable errorDrawable) {
                e.printStackTrace();
            }
            @Override
            public void onPrepareLoad(Drawable placeHolderDrawable) {
            }
        });
    }

    private void setEvent(){
        btnUpdateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Account account = accountFragment.getAccount();
                account.setAccountUserImage(getInfoAccount().getAccountUserImage());
                AccountApi.updateAccountByID(accountID, account, new OnListener() {
                    @Override
                    public void OnSuccessListener() {
                        finish();
                    }
                    @Override
                    public void OnFailedListener() {
                    }
                });
            }
        });
    }
}