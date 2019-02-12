package com.jaemion.eHub.signup.ui;

import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;

import com.jaemion.eHub.R;
import com.jaemion.eHub.main.MainActivity;
import com.jaemion.eHub.signup.SignUpActivity;

public class SignUpFragment_detail_Employee extends Fragment implements View.OnClickListener {
    private SignUpViewModel mViewModel;
    Button btnSkip, btnSignUp;
    ImageView ivProfile;
    EditText etPhone, etBnum, etNick, etCarType, etRadius, etLocation;
    CheckBox chIsSafe;

    public static SignUpFragment_detail_Employee newInstance() {
        return new SignUpFragment_detail_Employee();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.sign_up_fragment_detail_employee, container, false);
        btnSignUp = view.findViewById(R.id.signUp_fragment_detail_employee_btnSignUp);
        btnSkip = view.findViewById(R.id.signUp_fragment_detail_employee_btnSkip);
        ivProfile = view.findViewById(R.id.signUp_fragment_detail_employee_ivProfile);
        etPhone = view.findViewById(R.id.signUp_fragment_detail_employee_etPhone);
        etBnum = view.findViewById(R.id.signUp_fragment_detail_employee_etBnum);
        etNick = view.findViewById(R.id.signUp_fragment_detail_employee_etNick);
        etCarType = view.findViewById(R.id.signUp_fragment_detail_employee_etCarType);
        etRadius = view.findViewById(R.id.signUp_fragment_detail_employee_etRadius);
        etLocation = view.findViewById(R.id.signUp_fragment_detail_employee_etLocation);
        chIsSafe = view.findViewById(R.id.signUp_fragment_detail_employee_chIsSafe);
        addTextChangeListener();
        btnSignUp.setOnClickListener(this);
        btnSkip.setOnClickListener(this);
        btnSignUp.setEnabled(false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(getActivity()).get(SignUpViewModel.class);
        // TODO: Use the ViewModel
    }

    @Override
    public void onResume() {
        super.onResume();
        ((SignUpActivity) getActivity()).setToolbar("추가 정보 입력");
        ((SignUpActivity) getActivity()).getSupportActionBar().show();
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()) {
            case R.id.signUp_fragment_detail_employee_btnSignUp:
                mViewModel.isSafe = chIsSafe.isChecked();
                mViewModel.addAdditionalData(getContext());
                intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
                getActivity().finish();
                break;

            case R.id.signUp_fragment_detail_employee_btnSkip:
                intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
                getActivity().finish();
                break;
        }
    }

    void checkButtonAble() {
        if (!mViewModel.stPhone.isEmpty() && !mViewModel.stBnum.isEmpty() && !mViewModel.stNick.isEmpty() && !mViewModel.stCarType.isEmpty()
                && !mViewModel.stRadius.isEmpty() && !mViewModel.stLocation.isEmpty()){
            btnSignUp.setEnabled(true);
            btnSignUp.setBackground(getResources().getDrawable(R.drawable.button_ripple_enable));
            btnSignUp.setTextColor(getResources().getColor(R.color.button_text_enable));
        }
        else{
            btnSignUp.setEnabled(false);
            btnSignUp.setBackgroundColor(getResources().getColor(R.color.button_text_disable));
            btnSignUp.setTextColor(getResources().getColor(R.color.button_text_disable));
        }
    }

    void addTextChangeListener(){
        etPhone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                mViewModel.stPhone = s.toString();
                checkButtonAble();
            }
        });

        etBnum.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                mViewModel.stBnum = s.toString();
                checkButtonAble();
            }
        });

        etNick.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                mViewModel.stNick = s.toString();
                checkButtonAble();
            }
        });

        etCarType.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                mViewModel.stCarType = s.toString();
                checkButtonAble();
            }
        });

        etRadius.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                mViewModel.stRadius = s.toString();
                checkButtonAble();
            }
        });

        etLocation.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                mViewModel.stLocation = s.toString();
                checkButtonAble();
            }
        });
    }
}
