package com.jaemion.eHub.signin.ui;

import com.jaemion.eHub.network.model.UserDataModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

public class SignInViewModel extends ViewModel {
    private LiveData<UserDataModel> userData;

    public SignInViewModel() {
        super();
    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }
}
