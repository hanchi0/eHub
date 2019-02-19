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

import com.jaemion.eHub.R;
import com.jaemion.eHub.databinding.SignUpFragmentDetailEmployerBinding;
import com.jaemion.eHub.main.MainActivity;
import com.jaemion.eHub.signup.SignUpActivity;

public class SIgnUpFragment_detail_Employer extends Fragment implements View.OnClickListener {
    private SignUpViewModel mViewModel;
    SignUpFragmentDetailEmployerBinding binding;

    public static SIgnUpFragment_detail_Employer newInstance() {
        return new SIgnUpFragment_detail_Employer();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.sign_up_fragment_detail_employer, container, false);
        binding.signUpFragmentDetailEmployerBtnSignUp.setOnClickListener(this);
        binding.signUpFragmentDetailEmployerBtnSkip.setOnClickListener(this);
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
            case R.id.signUp_fragment_detail_employer_btnSignUp:
                intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
                getActivity().finish();
                break;

            case R.id.signUp_fragment_detail_employer_btnSkip:
                intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
                getActivity().finish();
                break;
        }
    }
}
