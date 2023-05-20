package com.application.wiselaptop.fragments;

import android.app.DatePickerDialog;
import android.graphics.Bitmap;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.application.wiselaptop.R;
import com.application.wiselaptop.models.Account;
import com.application.wiselaptop.models.Laptop;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import de.hdodenhof.circleimageview.CircleImageView;


public class AccountFragment extends Fragment {
     Account account;
     EditText edtAccountFullName,edtAccountPhone,edtAccountEmail,edtAccountBirthday,edtAccountUsername,edtAccountPassword;
     ImageView ivUploadAvatar;
     CircleImageView circleImageView;
     Spinner spnRole;

    public AccountFragment() {
        this.account = new Account();
        this.account.setAccountFullName("");
        this.account.setAccountPhoneNumber("");
        this.account.setAccountEmail("");
        this.account.setAccountDateOfBirth("");
        this.account.setAccountUsername("");
        this.account.setAccountUsername("");
        this.account.setAccountPassword("");
        this.account.setAccountRole(0);
    }

    public void setAccount(Account account) {
        this.account = account;
        updateAccount(account);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_account, container, false);
        setControl(view);
        setEvent(view);
        return view; 
    }

    private void setControl(@NonNull View v){
        this.edtAccountFullName = (EditText) v.findViewById(R.id.edtAccountName);
        this.edtAccountPhone = (EditText) v.findViewById(R.id.edtAccountPhone);
        this.edtAccountBirthday = (EditText) v.findViewById(R.id.edtAccountBirthday);
        this.edtAccountEmail = (EditText) v.findViewById(R.id.edtAccountEmail);
        this.edtAccountUsername = (EditText) v.findViewById(R.id.edtAccountUsername);
        this.edtAccountPassword = (EditText) v.findViewById(R.id.edtAccountPassword);
        this.spnRole = (Spinner) v.findViewById(R.id.spnRole);
        this.ivUploadAvatar = (ImageView) v.findViewById(R.id.imgUploadAvatar);
        this.circleImageView = (CircleImageView) v.findViewById(R.id.civ_account);
    }

    private void setEvent(@NonNull View v){
        selectDate(v);
        execSpnRole(v);
    }

    private void selectDate(@NonNull View v){
        final Calendar calendar = Calendar.getInstance();

        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int date = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(v.getContext(), new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int date) {
                edtAccountBirthday.setText(updateDate(calendar));
            }
        },year,month,date);
        edtAccountBirthday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datePickerDialog.show();
            }
        });
    }

    private String updateDate(Calendar calendar){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.US);
        return sdf.format(calendar.getTime());
    }

    public void execSpnRole(View v){
        ArrayAdapter<String> adapterItems;
        String [] items ={"1","0"};
        adapterItems = new ArrayAdapter<String>(this.getContext(),R.layout.fragment_item_role,items);
        spnRole.setAdapter(adapterItems);
    }

    public Account getAccount() {
        this.account = new Account();
        this.account.setAccountFullName(edtAccountFullName.getText().toString());
        this.account.setAccountPhoneNumber(edtAccountPhone.getText().toString());
        this.account.setAccountDateOfBirth(edtAccountBirthday.getText().toString());
        this.account.setAccountEmail(edtAccountEmail.getText().toString());
        this.account.setAccountUsername(edtAccountUsername.getText().toString());
        this.account.setAccountPassword(edtAccountPassword.getText().toString());
        this.account.setAccountRole(Integer.parseInt(spnRole.getSelectedItem().toString()));
        return this.account;
    }

    private void updateAccount(Account account){
        edtAccountFullName.setText(account.getAccountFullName());
        edtAccountBirthday.setText(account.getAccountDateOfBirth());
        edtAccountEmail.setText(account.getAccountEmail());
        edtAccountPhone.setText(account.getAccountPhoneNumber());
        edtAccountUsername.setText(account.getAccountUsername());
        edtAccountPassword.setText(account.getAccountPassword());
    }
}