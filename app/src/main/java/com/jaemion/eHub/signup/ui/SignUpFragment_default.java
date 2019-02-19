package com.jaemion.eHub.signup.ui;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.jaemion.eHub.R;
import com.jaemion.eHub.databinding.SignUpFragmentDefaultBinding;
import com.jaemion.eHub.datamanager.UserDataManager;
import com.jaemion.eHub.network.NetworkInterface;
import com.jaemion.eHub.network.model.UserData;
import com.jaemion.eHub.signup.SignUpActivity;

public class SignUpFragment_default extends Fragment {
    private SignUpViewModel mViewModel;
    SignUpFragmentDefaultBinding binding;
    InputMethodManager inputMethodManager;

    public static SignUpFragment_default newInstance() {
        return new SignUpFragment_default();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.sign_up_fragment_default, container, false);



        binding.signUpFragmentDefaultInputLayoutId.setCounterEnabled(true);
        binding.signUpFragmentDefaultInputLayoutId.setCounterMaxLength(15);
        binding.signUpFragmentDefaultInputLayoutPw.setCounterEnabled(true);
        binding.signUpFragmentDefaultInputLayoutPw.setCounterMaxLength(15);
        binding.signUpFragmentDefaultInputLayoutPwCheck.setCounterEnabled(true);
        binding.signUpFragmentDefaultInputLayoutPwCheck.setCounterMaxLength(15);

        inputMethodManager = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);

        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(getActivity()).get(SignUpViewModel.class);
        // TODO: Use the ViewModel
        mViewModel.getUserData().observe(this, o -> {
            if (mViewModel.userType == SignUpFragment_Select.UserType.EMPLOYER.getValue()) {
                getActivity().getSupportFragmentManager().beginTransaction()
                        .addToBackStack(null)
                        .setCustomAnimations(R.anim.slide_right_in, R.anim.slide_left_out, R.anim.slide_left_in, R.anim.slide_right_out)
                        .replace(R.id.signUp_container, SIgnUpFragment_detail_Employer.newInstance())
                        .commit();
            } else {
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .addToBackStack(null).setCustomAnimations(R.anim.slide_right_in, R.anim.slide_left_out, R.anim.slide_left_in, R.anim.slide_right_out)
                        .replace(R.id.signUp_container, SignUpFragment_detail_Employee.newInstance())
                        .commit();
            }
        });
        binding.setViewModel(mViewModel);
    }

    @Override
    public void onResume() {
        super.onResume();
        if (mViewModel.stId != null)
            binding.signUpFragmentDefaultEtID.setText(mViewModel.stId);
        if (mViewModel.stPw != null)
            binding.signUpFragmentDefaultEtPW.setText(mViewModel.stPw);
        if (mViewModel.stPwCheck != null)
            binding.signUpFragmentDefaultEtPWCheck.setText(mViewModel.stPwCheck);
        mViewModel.checkButtonAble();
        ((SignUpActivity) getActivity()).setToolbar("기본 정보 입력");
        ((SignUpActivity) getActivity()).getSupportActionBar().show();

    }

    @Override
    public void onPause() {
        super.onPause();
        inputMethodManager.hideSoftInputFromWindow(binding.signUpFragmentDefaultEtID.getWindowToken(), 0);
        inputMethodManager.hideSoftInputFromWindow(binding.signUpFragmentDefaultEtPW.getWindowToken(), 0);
        inputMethodManager.hideSoftInputFromWindow(binding.signUpFragmentDefaultEtPWCheck.getWindowToken(), 0);
    }


}