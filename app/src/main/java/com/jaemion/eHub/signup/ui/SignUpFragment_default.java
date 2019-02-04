package com.jaemion.eHub.signup.ui;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.jaemion.eHub.R;
import com.jaemion.eHub.signup.SignUpActivity;

public class SignUpFragment_default extends Fragment implements View.OnClickListener {
    private SignUpViewModel mViewModel;
    Button btnNext;

    public static SignUpFragment_default newInstance() {
        return new SignUpFragment_default();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.sign_up_fragment_default, container, false);
        btnNext = view.findViewById(R.id.signUp_fragment_default_btnNext);
        btnNext.setOnClickListener(this);
        ((SignUpActivity)getActivity()).getSupportActionBar().show();
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(SignUpViewModel.class);
        // TODO: Use the ViewModel
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.signUp_fragment_default_btnNext:
                if (true) {
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
                break;

            default:
                break;
        }
    }
}