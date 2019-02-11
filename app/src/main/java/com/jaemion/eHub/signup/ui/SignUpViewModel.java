package com.jaemion.eHub.signup.ui;

import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

public class SignUpViewModel extends ViewModel {
    // TODO: Implement the ViewModel

    String stId, stPw, stPwCheck;
    Boolean isMatched;

    public SignUpViewModel() {
        super();
        stId = stPw = stPwCheck = "";
        isMatched = false;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }

    public void createUser(Context context){
        Toast.makeText(context, "유저 생성 요청", Toast.LENGTH_SHORT).show();
    }
}
