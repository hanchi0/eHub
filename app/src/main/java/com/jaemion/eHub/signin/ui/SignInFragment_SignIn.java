package com.jaemion.eHub.signin.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.jaemion.eHub.R;
import com.jaemion.eHub.main.MainActivity;
import com.jaemion.eHub.signin.SignInActivity;
import com.jaemion.eHub.signup.SignUpActivity;

import java.util.regex.Pattern;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class SignInFragment_SignIn extends Fragment implements View.OnClickListener {
    Button btnSignIn;
    CheckBox checkBox;
    TextView tvSignUp, tvFindPw;
    EditText etId, etPw;
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
        View view = inflater.inflate(R.layout.sign_in_fragment_sign_in, container, false);

        btnSignIn = view.findViewById(R.id.signIn_fragment_signIn_btnSign);
        tvFindPw = view.findViewById(R.id.signIn_fragment_signIn_tvFindPw);
        tvSignUp = view.findViewById(R.id.signIn_fragment_signIn_tvSignUp);
        checkBox = view.findViewById(R.id.signIn_fragment_signIn_checkBox);

        etId = view.findViewById(R.id.signIn_fragment_signIn_etId);
        etPw = view.findViewById(R.id.signIn_fragment_signIn_etPw);

        stId = stPw = "";


        etId.addTextChangedListener(new TextWatcher() {
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

        etPw.addTextChangedListener(new TextWatcher() {
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

        btnSignIn.setOnClickListener(this);
        btnSignIn.setEnabled(false);
        tvSignUp.setOnClickListener(this);
        tvFindPw.setOnClickListener(this);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
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
            btnSignIn.setEnabled(true);
            btnSignIn.setBackground(getActivity().getDrawable(R.drawable.button_ripple_enable));
            btnSignIn.setTextColor(getResources().getColor(R.color.button_text_enable));
        } else {
            btnSignIn.setEnabled(false);
            btnSignIn.setBackgroundColor(getResources().getColor(R.color.button_background_disable));
            btnSignIn.setTextColor(getResources().getColor(R.color.button_text_enable));
        }
    }
}
