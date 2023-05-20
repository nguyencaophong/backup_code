package com.application.wiselaptop.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.application.wiselaptop.R;
import com.application.wiselaptop.adapters.AccountAdapter;
import com.application.wiselaptop.api.AccountApi;
import com.application.wiselaptop.models.Account;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AccountManagementActivity extends AppCompatActivity {
    private RecyclerView rcvAccountManagement;
    private  AccountAdapter accountAdapter;
    private ImageButton btnAddAccount,btnAddTopBar,btnOptionalAccount;
    private TextView tvScreenTitle;

    private Context mContext;

    private List<Account> accounts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_management);
        setToolbar();
        fetchData();
        setControl();
        setEvent();
    }
    private void fetchData(){
        AccountApi.accountDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    accounts.clear();
                    for(DataSnapshot accountDS: snapshot.getChildren()){
                        Account account = accountDS.getValue(Account.class);
                        accounts.add(account);
                    }
                    accountAdapter.setData(accounts);
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }

    private void setToolbar(){
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Quản lý thông tin người dùng");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            this.finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    private void setEvent(){
        btnAddAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( AccountManagementActivity.this,AccountAdditionActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menu_account_optional,menu);
    }

    private void setControl(){
        accounts = new ArrayList<>();

        rcvAccountManagement = findViewById(R.id.rvAccountManagement);
        btnAddAccount = findViewById(R.id.btnAddAccount);
        btnAddTopBar = findViewById(R.id.btnAdd);
        tvScreenTitle = findViewById(R.id.txtViewScreenTitle);
        btnOptionalAccount = findViewById(R.id.btn_optional_account);

        accountAdapter = new AccountAdapter(this);

        rcvAccountManagement.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL,false));

        accountAdapter.setData(accounts);
        rcvAccountManagement.setAdapter(accountAdapter);
    }
}