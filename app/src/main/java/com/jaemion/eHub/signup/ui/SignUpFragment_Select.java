package com.jaemion.eHub.signup.ui;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.jaemion.eHub.R;
import com.jaemion.eHub.databinding.SignUpFragmentSelectBinding;
import com.jaemion.eHub.signin.SignInActivity;
import com.jaemion.eHub.signup.SignUpActivity;

public class SignUpFragment_Select extends Fragment implements View.OnClickListener {
    private SignUpViewModel mViewModel;
    SignUpFragmentSelectBinding binding;

    public enum UserType {
        GUSET(0),
        EMPLOYER(1),
        EMPLOYEE(2);

        private int value;

        private UserType(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    public static SignUpFragment_Select newInstance() {
        return new SignUpFragment_Select();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.sign_up_fragment_select, container, false);

        binding.signUpFragmentSelectBtnEmployer.setOnClickListener(this);
        binding.signUpFragmentSelectBtnEmployee.setOnClickListener(this);
        binding.signUpFragmentSelectTvLogin.setOnClickListener(this);
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
        ((SignUpActivity) getActivity()).getSupportActionBar().hide();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.signUp_fragment_select_btnEmployer:
                mViewModel.userType = UserType.EMPLOYER.value;
                getActivity().getSupportFragmentManager().beginTransaction()
                        .addToBackStack(null)
                        .setCustomAnimations(R.anim.slide_right_in, R.anim.slide_left_out, R.anim.slide_left_in, R.anim.slide_right_out)
                        .replace(R.id.signUp_container, SignUpFragment_default.newInstance())
                        .commit();
                break;
            case R.id.signUp_fragment_select_btnEmployee:
                mViewModel.userType = UserType.EMPLOYEE.value;
                getActivity().getSupportFragmentManager().beginTransaction()
                        .addToBackStack(null)
                        .setCustomAnimations(R.anim.slide_right_in, R.anim.slide_left_out, R.anim.slide_left_in, R.anim.slide_right_out)
                        .replace(R.id.signUp_container, SignUpFragment_default.newInstance())
                        .commit();
                break;
            case R.id.signUp_fragment_select_tvLogin:
                Intent intent = new Intent(getActivity(), SignInActivity.class);
                startActivity(intent);
                getActivity().finish();
                break;
        }
    }
}
