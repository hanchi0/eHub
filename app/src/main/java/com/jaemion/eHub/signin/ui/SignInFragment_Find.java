package com.jaemion.eHub.signin.ui;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.jaemion.eHub.R;
import com.jaemion.eHub.signin.SignInActivity;

import org.w3c.dom.Text;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class SignInFragment_Find extends Fragment implements View.OnClickListener {
    public SignInFragment_Find() {
        super();
    }

    EditText etEmail;
    TextInputLayout inputLayout_email;
    Button btnSend;

    public static SignInFragment_Find newInstance() {
        return new SignInFragment_Find();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.sign_in_fragment_find, container, false);
        etEmail = view.findViewById(R.id.signIn_fragment_find_etEmail);
        inputLayout_email = view.findViewById(R.id.signIn_fragment_find_inputLayout_email);
        btnSend = view.findViewById(R.id.signIn_fragment_find_btnSend);
        btnSend.setOnClickListener(this);
        btnSend.setEnabled(false);
        inputLayout_email.setErrorEnabled(true);

        etEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (Patterns.EMAIL_ADDRESS.matcher(s.toString()).matches()) {
                    inputLayout_email.setError(null);
                    btnSend.setEnabled(true);
                    btnSend.setBackground(getResources().getDrawable(R.drawable.button_ripple_enable));
                    btnSend.setTextColor(getResources().getColor(R.color.button_text_enable));
                } else {
                    inputLayout_email.setError("이메일 형식이 맞지 않습니다.");
                    btnSend.setEnabled(false);
                    btnSend.setBackgroundColor(getResources().getColor(R.color.button_background_disable));
                    btnSend.setTextColor(getResources().getColor(R.color.button_text_disable));
                }
            }
        });
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
        ((SignInActivity) getActivity()).setToolbar("비밀번호 찾기");
        ((SignInActivity) getActivity()).getSupportActionBar().show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.signIn_fragment_find_btnSend:
                Toast.makeText(getContext(), "메일 보내기~~", Toast.LENGTH_SHORT);
                break;
        }
    }
}
