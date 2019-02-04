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

import com.jaemion.eHub.R;
import com.jaemion.eHub.main.MainActivity;

public class SIgnUpFragment_detail_Employer extends Fragment implements View.OnClickListener{
    private SignUpViewModel mViewModel;
    Button btnSkip, btnSignUp;

    public static SIgnUpFragment_detail_Employer newInstance() {
        return new SIgnUpFragment_detail_Employer();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.sign_up_fragment_detail_employer, container, false);
        btnSignUp = view.findViewById(R.id.signUp_fragment_detail_employer_btnSignUp);
        btnSkip = view.findViewById(R.id.signUp_fragment_detail_employer_btnSkip);
        btnSignUp.setOnClickListener(this);
        btnSkip.setOnClickListener(this);
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
        Intent intent = null;
        switch(v.getId()){
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
