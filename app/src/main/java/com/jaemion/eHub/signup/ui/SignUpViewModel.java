package com.jaemion.eHub.signup.ui;

import androidx.lifecycle.ViewModel;
import android.content.Context;
import android.media.Image;
import android.widget.Toast;

public class SignUpViewModel extends ViewModel {
    // TODO: Implement the ViewModel

    String stId, stPw, stPwCheck,stPhone, stBnum, stNick, stCarType, stRadius, stLocation;
    int userType;
    Image iProfile;

    Boolean isMatched, isSafe;

    public SignUpViewModel() {
        super();
        stId = stPw = stPwCheck = stPhone = stBnum = stNick = stCarType = stRadius = stLocation = "";
        isMatched = isSafe = false;

    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }

    public void createUser(Context context){
        Toast.makeText(context, "유저 생성 요청", Toast.LENGTH_SHORT).show();
    }

    public void addAdditionalData(Context context){
        Toast.makeText(context, "추가 정보 저장", Toast.LENGTH_SHORT).show();
    }
}
