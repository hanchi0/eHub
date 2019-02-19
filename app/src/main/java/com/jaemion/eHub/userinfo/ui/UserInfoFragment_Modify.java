package com.jaemion.eHub.userinfo.ui;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jaemion.eHub.R;
import com.jaemion.eHub.databinding.UserInfoFragmentModifyEmployeeBinding;
import com.jaemion.eHub.databinding.UserInfoFragmentModifyEmployerBinding;

public class UserInfoFragment_Modify extends Fragment {

    UserInfoFragmentModifyEmployeeBinding employeeBinding;
    UserInfoFragmentModifyEmployerBinding employerBinding;

    private UserInfoFragmentViewModel mViewModel;

    public static UserInfoFragment_Modify newInstance() {
        return new UserInfoFragment_Modify();
    }

    public UserInfoFragment_Modify() {
        super();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if (true) {
            employeeBinding = DataBindingUtil.inflate(inflater, R.layout.user_info_fragment_main_employee, container, false);
            return employeeBinding.getRoot();
        } else {
            employerBinding = DataBindingUtil.inflate(inflater, R.layout.user_info_fragment_main_employer, container, false);
            return employerBinding.getRoot();
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(UserInfoFragmentViewModel.class);

    }

}
