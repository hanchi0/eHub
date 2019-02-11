package com.jaemion.eHub.signup.ui;

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
import com.jaemion.eHub.main.MainActivity;
import com.jaemion.eHub.signup.SignUpActivity;

public class SignUpFragment_detail_Employee extends Fragment implements View.OnClickListener {
    private SignUpViewModel mViewModel;
    Button btnSkip, btnSignUp;

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
}
