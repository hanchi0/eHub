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
import android.view.View;
import android.widget.Toast;

import com.jaemion.eHub.R;
import com.jaemion.eHub.network.NetworkInterface;
import com.jaemion.eHub.network.model.UserDataModel;

public class SignUpViewModel extends ViewModel {
    // TODO: Implement the ViewModel
    private MutableLiveData<UserDataModel> userData;

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
                Call<UserDataModel> call = NetworkInterface.retrofit.create(NetworkInterface.class).createUser(stId, stPw, userType);
                call.enqueue(new Callback<UserDataModel>() {
                    @Override
                    public void onResponse(Call<UserDataModel> call, Response<UserDataModel> response) {
                        if (response.isSuccessful())
                            userData.setValue(response.body());
                    }

                    @Override
                    public void onFailure(Call<UserDataModel> call, Throwable t) {
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
}
