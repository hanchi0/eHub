package com.jaemion.eHub.signin.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.jaemion.eHub.R;
import com.jaemion.eHub.databinding.SignInFragmentSignInBinding;
import com.jaemion.eHub.main.MainActivity;
import com.jaemion.eHub.signin.SignInActivity;
import com.jaemion.eHub.signup.SignUpActivity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

public class SignInFragment_SignIn extends Fragment implements View.OnClickListener {
    private SignInViewModel mViewModel;

    SignInFragmentSignInBinding binding;
    String stId, stPw;

    public SignInFragment_SignIn() {
        super();
    }

    public static SignInFragment_SignIn newInstance() {
        return new SignInFragment_SignIn();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.sign_in_fragment_sign_in, container, false);

        stId = stPw = "";

        binding.signInFragmentSignInEtId.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                stId = s.toString();
                checkButtonAble();
            }
        });

        binding.signInFragmentSignInEtPw.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                stPw = s.toString();
                checkButtonAble();
            }
        });

        binding.signInFragmentSignInBtnSign.setOnClickListener(this);
        binding.signInFragmentSignInBtnSign.setEnabled(false);
        binding.signInFragmentSignInTvSignUp.setOnClickListener(this);
        binding.signInFragmentSignInTvFindPw.setOnClickListener(this);

        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(getActivity()).get(SignInViewModel.class);
    }

    @Override
    public void onResume() {
        super.onResume();
        ((SignInActivity) getActivity()).getSupportActionBar().hide();
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.signIn_fragment_signIn_btnSign:
                intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
                getActivity().finish();
                break;

            case R.id.signIn_fragment_signIn_tvSignUp:
                intent = new Intent(getActivity(), SignUpActivity.class);
                startActivity(intent);
                getActivity().finish();
                break;

            case R.id.signIn_fragment_signIn_tvFindPw:
                getActivity().getSupportFragmentManager().beginTransaction()
                        .addToBackStack(null)
                        .setCustomAnimations(R.anim.slide_right_in, R.anim.slide_left_out, R.anim.slide_left_in, R.anim.slide_right_out)
                        .replace(R.id.signIn_container, SignInFragment_Find.newInstance())
                        .commit();
                break;
        }

    }

    void checkButtonAble() {
        if (!stId.isEmpty() && !stPw.isEmpty()) {
            binding.signInFragmentSignInBtnSign.setEnabled(true);
            binding.signInFragmentSignInBtnSign.setBackground(getActivity().getDrawable(R.drawable.button_ripple_enable));
            binding.signInFragmentSignInBtnSign.setTextColor(getResources().getColor(R.color.button_text_enable));
        } else {
            binding.signInFragmentSignInBtnSign.setEnabled(false);
            binding.signInFragmentSignInBtnSign.setBackgroundColor(getResources().getColor(R.color.button_background_disable));
            binding.signInFragmentSignInBtnSign.setTextColor(getResources().getColor(R.color.button_text_enable));
        }
    }
}
