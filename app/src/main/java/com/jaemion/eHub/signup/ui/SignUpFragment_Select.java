package com.jaemion.eHub.signup.ui;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.jaemion.eHub.R;
import com.jaemion.eHub.signin.SignInActivity;
import com.jaemion.eHub.signup.SignUpActivity;

public class SignUpFragment_Select extends Fragment implements View.OnClickListener {
    private SignUpViewModel mViewModel;
    Button btnEmployer, btnEmployee;
    TextView tvLogin;

    public static SignUpFragment_Select newInstance() {
        return new SignUpFragment_Select();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.sign_up_fragment_select, container, false);
        btnEmployer = view.findViewById(R.id.signUp_fragment_select_btnEmployer);
        btnEmployee = view.findViewById(R.id.signUp_fragment_select_btnEmployee);
        tvLogin = view.findViewById(R.id.signUp_fragment_select_tvLogin);

        btnEmployer.setOnClickListener(this);
        btnEmployee.setOnClickListener(this);
        tvLogin.setOnClickListener(this);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(SignUpViewModel.class);
        // TODO: Use the ViewModel
    }

    @Override
    public void onResume() {
        super.onResume();
        ((SignUpActivity)getActivity()).getSupportActionBar().hide();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.signUp_fragment_select_btnEmployer:
                getActivity().getSupportFragmentManager().beginTransaction()
                        .addToBackStack(null)
                        .setCustomAnimations(R.anim.slide_right_in, R.anim.slide_left_out, R.anim.slide_left_in, R.anim.slide_right_out)
                        .replace(R.id.signUp_container, SignUpFragment_default.newInstance())
                        .commit();
                break;
            case R.id.signUp_fragment_select_btnEmployee:
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
