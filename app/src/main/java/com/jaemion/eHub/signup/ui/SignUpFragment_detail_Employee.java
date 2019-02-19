package com.jaemion.eHub.signup.ui;

import androidx.databinding.DataBindingUtil;
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
import com.jaemion.eHub.databinding.SignUpFragmentDetailEmployeeBinding;
import com.jaemion.eHub.main.MainActivity;
import com.jaemion.eHub.signup.SignUpActivity;

public class SignUpFragment_detail_Employee extends Fragment implements View.OnClickListener {
    private SignUpViewModel mViewModel;
    SignUpFragmentDetailEmployeeBinding binding;

    public static SignUpFragment_detail_Employee newInstance() {
        return new SignUpFragment_detail_Employee();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.sign_up_fragment_detail_employee, container, false);

        addTextChangeListener();
        binding.signUpFragmentDetailEmployeeBtnSignUp.setOnClickListener(this);
        binding.signUpFragmentDetailEmployeeBtnSkip.setOnClickListener(this);
        binding.signUpFragmentDetailEmployeeBtnSignUp.setEnabled(false);
        return binding.getRoot();
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
                mViewModel.isSafe = binding.signUpFragmentDetailEmployeeChIsSafe.isChecked();
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
            binding.signUpFragmentDetailEmployeeBtnSignUp.setEnabled(true);
            binding.signUpFragmentDetailEmployeeBtnSignUp.setBackground(getResources().getDrawable(R.drawable.button_ripple_enable));
            binding.signUpFragmentDetailEmployeeBtnSignUp.setTextColor(getResources().getColor(R.color.button_text_enable));
        }
        else{
            binding.signUpFragmentDetailEmployeeBtnSignUp.setEnabled(false);
            binding.signUpFragmentDetailEmployeeBtnSignUp.setBackgroundColor(getResources().getColor(R.color.button_text_disable));
            binding.signUpFragmentDetailEmployeeBtnSignUp.setTextColor(getResources().getColor(R.color.button_text_disable));
        }
    }

    void addTextChangeListener(){
        binding.signUpFragmentDetailEmployeeEtPhone.addTextChangedListener(new TextWatcher() {
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

        binding.signUpFragmentDetailEmployeeEtBnum.addTextChangedListener(new TextWatcher() {
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

        binding.signUpFragmentDetailEmployeeEtNick.addTextChangedListener(new TextWatcher() {
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

        binding.signUpFragmentDetailEmployeeEtCarType.addTextChangedListener(new TextWatcher() {
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

        binding.signUpFragmentDetailEmployeeEtRadius.addTextChangedListener(new TextWatcher() {
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

        binding.signUpFragmentDetailEmployeeEtLocation.addTextChangedListener(new TextWatcher() {
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
