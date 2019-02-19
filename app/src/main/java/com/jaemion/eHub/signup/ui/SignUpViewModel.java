package com.jaemion.eHub.signup.ui;

import androidx.databinding.BindingConversion;
import androidx.databinding.ObservableBoolean;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.media.Image;
import android.nfc.cardemulation.CardEmulation;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.jaemion.eHub.R;
import com.jaemion.eHub.datamanager.UserDataManager;
import com.jaemion.eHub.network.NetworkInterface;
import com.jaemion.eHub.network.model.UserData;
import com.jaemion.eHub.signup.SignUpActivity;

public class SignUpViewModel extends ViewModel {
    // TODO: Implement the ViewModel
    private MutableLiveData<UserData> userData;

    String stId, stPw, stPwCheck, stPhone, stBnum, stNick, stCarType, stRadius, stLocation, pwPattern, pwPattern2;
    int userType;
    Image ivProfile;

    Boolean isMatched, isSafe;
    ObservableBoolean isEnable;

    public SignUpViewModel() {
        super();
        stId = stPw = stPwCheck = stPhone = stBnum = stNick = stCarType = stRadius = stLocation = "";
        isMatched = isSafe = false;
        isEnable = new ObservableBoolean();
        isEnable.set(false);
        userData = new MutableLiveData<>();

        pwPattern = "^(?=.*\\d)(?=.*[~`!@#$%\\^&*()-])(?=.*[a-z])(?=.*[A-Z]).{7,15}$";
        pwPattern2 = "(.)\\1\\1\\1";
    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }

    public void addAdditionalData(Context context) {
        Toast.makeText(context, "추가 정보 저장", Toast.LENGTH_SHORT).show();
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.signUp_fragment_default_btnNext:
                isEnable.set(false);
                //mViewModel.createUser(getContext();
                Call<UserData> call = NetworkInterface.retrofit.create(NetworkInterface.class).createUser(stId, stPw, userType);
                call.enqueue(new Callback<UserData>() {
                    @Override
                    public void onResponse(Call<UserData> call, Response<UserData> response) {
                        if (response.isSuccessful())
                            userData.setValue(response.body());
                    }

                    @Override
                    public void onFailure(Call<UserData> call, Throwable t) {
                        checkButtonAble();
                    }
                });
                break;

            default:
                break;
        }
    }

    public void onIdTextChanged(CharSequence s, int start, int before, int count) {
        stId = s.toString();
        checkButtonAble();
    }

    public void onPwTextChanged(CharSequence s, int start, int before, int count) {
        stPw = s.toString();
        checkButtonAble();

    }

    public void onPwCheckTextChanged(CharSequence s, int start, int before, int count) {
        stPwCheck = s.toString();
        if (stPw.equals(stPwCheck))
            isMatched = true;
        else
            isMatched = false;
        checkButtonAble();
    }
    
    void checkButtonAble() {
        if (!stId.isEmpty() && !stPw.isEmpty() && !stPwCheck.isEmpty() && isMatched) {
            isEnable.set(true);
        } else {
            isEnable.set(false);
        }
    }

    public ObservableBoolean getIsEnable() {
        return isEnable;
    }

    public LiveData getUserData() {
        return userData;
    }

    @BindingConversion
    public static ColorDrawable convertColorToDrawable(int color) {
        return new ColorDrawable(color);
    }
}
