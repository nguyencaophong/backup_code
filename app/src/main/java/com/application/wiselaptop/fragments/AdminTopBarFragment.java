package com.application.wiselaptop.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.application.wiselaptop.R;

public class AdminTopBarFragment extends Fragment {

    ImageButton btnBack, btnAdd;
    TextView txtViewScreenTitle;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_admin_top_bar, container, false);
        setControl(view);
        setEvent();
        return view;
    }

    private void setControl(View view) {
        btnBack = view.findViewById(R.id.btnBack);
        btnAdd = view.findViewById(R.id.btnAdd);
        txtViewScreenTitle = view.findViewById(R.id.txtViewScreenTitle);
    }

    private void setEvent() {
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().finish();
            }
        });
    }
}
