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
import com.jaemion.eHub.signup.SignUpActivity;

import java.util.regex.Pattern;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class SignInFragment_SignIn extends Fragment implements View.OnClickListener{
    Button btnSignIn;
    CheckBox checkBox;
    TextView tvSignUp, tvCheckBox, tvFindPw;
    EditText etId, etPw;
    String stId, stPw, pwPattern, pwPattern2;

    public SignInFragment_SignIn() {
        super();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.sign_in_fragment_sign_in,container,false);

        btnSignIn = view.findViewById(R.id.signIn_btnSign);
        tvCheckBox = view.findViewById(R.id.signIn_tvCheckBox);
        tvFindPw = view.findViewById(R.id.signIn_tvFindPw);
        tvSignUp = view.findViewById(R.id.signIn_tvSignUp);
        checkBox = view.findViewById(R.id.signIn_checkBox);

        etId = view.findViewById(R.id.signIn_etId);
        etPw = view.findViewById(R.id.signIn_etPassword);

        stId = stPw = "";
        pwPattern = "^(?=.*\\d)(?=.*[~`!@#$%\\^&*()-])(?=.*[a-z])(?=.*[A-Z]).{7,15}$";
        pwPattern2 = "(.)\\1\\1\\1";

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
                if(Pattern.matches(getString(R.string.id_pattern),stId)){
                    Log.d("asdf","match");
                }
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
                if(Pattern.matches(pwPattern,stPw))
                    Log.d("asdf","match");
                checkButtonAble();
            }
        });

        btnSignIn.setOnClickListener(this);
        btnSignIn.setEnabled(false);
        tvSignUp.setOnClickListener(this);
        tvCheckBox.setOnClickListener(this);
        tvFindPw.setOnClickListener(this);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }


    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.signIn_btnSign:
                intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
                getActivity().finish();

                break;

            case R.id.signIn_tvSignUp:
                intent = new Intent(getActivity(), SignUpActivity.class);
                startActivity(intent);
                getActivity().finish();
                break;

            case R.id.signIn_tvFindPw:
                Toast.makeText(getActivity(), "아직 못찾아", Toast.LENGTH_SHORT).show();
                break;
        }

    }

    void checkButtonAble() {
        if (!stId.isEmpty() && !stPw.isEmpty()){
            btnSignIn.setEnabled(true);
            btnSignIn.setBackground(getActivity().getDrawable(R.drawable.button_ripple_enable));
            btnSignIn.setTextColor(getResources().getColor(R.color.button_text_enable));
        }
        else{
            btnSignIn.setEnabled(false);
            btnSignIn.setBackgroundColor(getResources().getColor(R.color.button_background_disable));
            btnSignIn.setTextColor(getResources().getColor(R.color.button_text_enable));
        }
    }
}
