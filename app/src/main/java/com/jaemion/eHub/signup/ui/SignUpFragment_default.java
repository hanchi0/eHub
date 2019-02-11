package com.jaemion.eHub.signup.ui;

import androidx.lifecycle.ViewModelProviders;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
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

import com.jaemion.eHub.R;
import com.jaemion.eHub.signup.SignUpActivity;

public class SignUpFragment_default extends Fragment implements View.OnClickListener, TextView.OnEditorActionListener {
    private SignUpViewModel mViewModel;
    Button btnNext;
    EditText etId, etPw, etPwCheck;
    InputMethodManager inputMethodManager;

    public static SignUpFragment_default newInstance() {
        return new SignUpFragment_default();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.sign_up_fragment_default, container, false);
        btnNext = view.findViewById(R.id.signUp_fragment_default_btnNext);
        etId = view.findViewById(R.id.signUp_fragment_default_etID);
        etPw = view.findViewById(R.id.signUp_fragment_default_etPW);
        etPwCheck = view.findViewById(R.id.signUp_fragment_default_etPWCheck);
        etId.setOnEditorActionListener(this);
        etPw.setOnEditorActionListener(this);
        etPwCheck.setOnEditorActionListener(this);
        etId.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                mViewModel.stId = s.toString();
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
                mViewModel.stPw = s.toString();
                checkButtonAble();
            }
        });
        etPwCheck.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                mViewModel.stPwCheck = s.toString();

                if (mViewModel.stPw.equals(mViewModel.stPwCheck))
                    mViewModel.isMatched = true;
                else
                    mViewModel.isMatched = false;

                checkButtonAble();
            }
        });

        btnNext.setOnClickListener(this);
        btnNext.setEnabled(false);
        btnNext.setBackgroundColor(getResources().getColor(R.color.button_background_disable));
        btnNext.setTextColor(getResources().getColor(R.color.button_text_disable));
        inputMethodManager = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);

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
        if (mViewModel.stId != null)
            etId.setText(mViewModel.stId);
        if (mViewModel.stPw != null)
            etPw.setText(mViewModel.stPw);
        if (mViewModel.stPwCheck != null)
            etPwCheck.setText(mViewModel.stPwCheck);
        checkButtonAble();

        ((SignUpActivity) getActivity()).setToolbar("기본 정보 입력");
        ((SignUpActivity) getActivity()).getSupportActionBar().show();

    }

    @Override
    public void onPause() {
        super.onPause();
        inputMethodManager.hideSoftInputFromWindow(etId.getWindowToken(), 0);
        inputMethodManager.hideSoftInputFromWindow(etPw.getWindowToken(), 0);
        inputMethodManager.hideSoftInputFromWindow(etPwCheck.getWindowToken(), 0);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.signUp_fragment_default_btnNext:
                mViewModel.createUser(getContext());
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

    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        if (v.getId() == R.id.signUp_fragment_default_etID && actionId == EditorInfo.IME_ACTION_NEXT) {
            if (!mViewModel.stId.isEmpty())
                etPw.requestFocus();
        } else if (v.getId() == R.id.signUp_fragment_default_etPW && actionId == EditorInfo.IME_ACTION_NEXT) {
            if (!mViewModel.stPw.isEmpty())
                etPwCheck.requestFocus();
        } else if (v.getId() == R.id.signUp_fragment_default_etPWCheck && actionId == EditorInfo.IME_ACTION_DONE) {
            if (mViewModel.isMatched) {
                inputMethodManager.hideSoftInputFromWindow(etPwCheck.getWindowToken(), 0);
            } else {
                Toast.makeText(getContext(), "패스워드가 맞지 않습니다.", Toast.LENGTH_LONG).show();
            }
        }
        return true;
    }

    public void checkButtonAble() {
        if (!mViewModel.stId.isEmpty() && !mViewModel.stPw.isEmpty() && !mViewModel.stPwCheck.isEmpty() && mViewModel.isMatched) {
            btnNext.setEnabled(true);
            btnNext.setBackground(getResources().getDrawable(R.drawable.button_ripple_enable));
            btnNext.setTextColor(getResources().getColor(R.color.button_text_enable));
        } else {
            btnNext.setEnabled(false);
            btnNext.setBackgroundColor(getResources().getColor(R.color.button_background_disable));
            btnNext.setTextColor(getResources().getColor(R.color.button_text_disable));
        }
    }
}