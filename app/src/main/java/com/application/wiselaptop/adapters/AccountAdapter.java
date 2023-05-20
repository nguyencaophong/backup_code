package com.application.wiselaptop.adapters;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.application.wiselaptop.R;
import com.application.wiselaptop.activities.AccountAdditionActivity;
import com.application.wiselaptop.activities.AccountModifyActivity;
import com.application.wiselaptop.api.AccountApi;
import com.application.wiselaptop.interfaces.OnListener;
import com.application.wiselaptop.models.Account;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import de.hdodenhof.circleimageview.CircleImageView;

public class AccountAdapter extends RecyclerView.Adapter<AccountAdapter.AccountAdapterViewHolder> {
    private final Context mContext;
    private List<Account> accounts;
    public AccountAdapter(Context mContext){
        this.mContext = mContext;
    }

    @SuppressLint("NotifyDataSetChanged")
    public void setData(List<Account> accounts){
        this.accounts = accounts;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public AccountAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_hoder_account,parent,false);
        return new AccountAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AccountAdapterViewHolder holder, int position) {
        Account account = accounts.get(position);
        if(account == null){
            return;
        }
        try{
            StorageReference storageReference = FirebaseStorage.getInstance().getReference("accounts");
            storageReference.child(account.getAccountId()).child(account.getAccountUserImage()).getDownloadUrl().addOnSuccessListener(uri -> {
                Picasso.get().load(uri).into(holder.civAccount);
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {

                }
            });
        }
        catch (Exception ex){

        }

        holder.tvNameAccount.setText(account.getAccountFullName());
        holder.llItemAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoAccountDetail(account);
            }
        });
        execBtnOptionAccount(holder,account);
    }

    private void execBtnOptionAccount(AccountAdapterViewHolder holder,Account account){
        holder.btnOptionalAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopMenu(holder,account);
            }
        });
    }

    private void showPopMenu(AccountAdapterViewHolder view,Account account){
        PopupMenu popupMenu = new PopupMenu(mContext,view.btnOptionalAccount);
        popupMenu.getMenuInflater().inflate(R.menu.menu_account_optional,popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.menu_update_account:
                        gotoAccountDetail(account);
                        break;
                    case R.id.menu_delete_account:
                        openDialogVerify(Gravity.CENTER, account);
                        break;
                }
                return false;
            }
        });
        popupMenu.show();
    }

    private void openDialogVerify(int gravity, Account account){
        final Dialog dialog = new Dialog(mContext);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(androidx.core.R.layout.custom_dialog);

        Window window = dialog.getWindow();
        if(window == null){
            return;
        }
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT,WindowManager.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);

        WindowManager.LayoutParams windowAttributes = window.getAttributes();
        windowAttributes.gravity = gravity;
        dialog.setCancelable(false);
        dialog.show();

        Button btnAccept = dialog.findViewById(R.id.btn_accept_dialog);
        Button btnCancel = dialog.findViewById(R.id.btn_cancel_dialog);

        btnAccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String accountID = account.getAccountId();
                AccountApi.deleteAccountByIDFromDatabase(accountID, new OnListener() {
                    @Override
                    public void OnSuccessListener() {
                        System.out.println("Xóa thành công");
                        dialog.cancel();
                    }

                    @Override
                    public void OnFailedListener() {
                        System.out.println("Xóa không thành cônng");
                        dialog.cancel();
                    }
                });
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.cancel();
            }
        });
    }



    @Override
    public int getItemCount() {
        if(accounts != null){
            return accounts.size();
        }
        return 0;
    }

    private void gotoAccountDetail(Account account){
        Intent intent = new Intent(mContext, AccountModifyActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("account",account);
        intent.putExtras(bundle);
        mContext.startActivity(intent);
    }

    public class AccountAdapterViewHolder extends RecyclerView.ViewHolder{
        private TextView tvNameAccount;
        private CircleImageView civAccount;
        private CardView itemAccount;
        private ImageButton imgEditAccount;
        private LinearLayout llItemAccount;
        private ImageButton btnOptionalAccount;
        private Button btnAcceptDialog, btnCancelDialog;
        private EditText datePicker;

        public AccountAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            setControl(itemView);
        }

        private void setControl(View view){
            tvNameAccount = view.findViewById(R.id.tv_name_account);
            itemAccount = view.findViewById(R.id.cvAccount);
            llItemAccount = view.findViewById(R.id.ll_item_account);
            btnOptionalAccount = view.findViewById(R.id.btn_optional_account);
            btnAcceptDialog = view.findViewById(R.id.btn_accept_dialog);
            btnCancelDialog = view.findViewById(R.id.btn_cancel_dialog);
            datePicker = view.findViewById(R.id.edtAccountBirthday);
            civAccount= view.findViewById(R.id.civ_account);
        }
    }
}