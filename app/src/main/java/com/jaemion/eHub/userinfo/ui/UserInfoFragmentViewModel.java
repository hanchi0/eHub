package com.jaemion.eHub.userinfo.ui;

import android.view.View;

import com.jaemion.eHub.R;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class UserInfoFragmentViewModel extends ViewModel {
    // TODO: Implement the ViewModel

    private MutableLiveData<String> stName;
    private MutableLiveData<String> stPhoneNum;
    private MutableLiveData<String> stBnum;


    public UserInfoFragmentViewModel() {
        super();

        stName = new MutableLiveData<>();
        stPhoneNum = new MutableLiveData<>();
        stBnum = new MutableLiveData<>();

        stName.setValue("홍길동");
        stPhoneNum.setValue("01012345687");
        stBnum.setValue("01010101202");
    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }

    public LiveData<String> getName() {
        return stName;
    }

    public void setName(String name) {
        stName.setValue(name);
    }

    public LiveData<String> getPhoneNum() {
        return stPhoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        stPhoneNum.setValue(phoneNum);
    }

    public LiveData<String> getBnum() {
        return stBnum;
    }

    public void setBnum(String bNum) {
        stBnum.setValue(bNum);
    }

    void onClick(View v) {
        switch (v.getId()) {
            case R.id.user_info_fragment_modify_employee_btnModify:
                break;
            case R.id.user_info_fragment_modify_employer_btnModify:
                break;
        }
    }
}
