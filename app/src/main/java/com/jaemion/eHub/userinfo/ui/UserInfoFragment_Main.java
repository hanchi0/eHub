package com.jaemion.eHub.userinfo.ui;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jaemion.eHub.R;
import com.jaemion.eHub.databinding.UserInfoFragmentMainEmployeeBinding;
import com.jaemion.eHub.databinding.UserInfoFragmentMainEmployerBinding;
import com.jaemion.eHub.secession.SecessionActivity;
import com.jaemion.eHub.userinfo.UserInfoActivity;


public class UserInfoFragment_Main extends Fragment implements View.OnClickListener {

    private UserInfoFragmentViewModel mViewModel;

    public static UserInfoFragment_Main newInstance() {
        return new UserInfoFragment_Main();
    }

    UserInfoFragmentMainEmployeeBinding employeeBinding;
    UserInfoFragmentMainEmployerBinding employerBinding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        if (true) {
            employeeBinding = DataBindingUtil.inflate(inflater, R.layout.user_info_fragment_main_employee, container, false);
            employeeBinding.userInfoFragmentMainEmployeeTvSecession.setOnClickListener(this);
            return employeeBinding.getRoot();
        } else {
            employerBinding = DataBindingUtil.inflate(inflater, R.layout.user_info_fragment_main_employer, container, false);
            employerBinding.userInfoFragmentMainEmployerTvSecession.setOnClickListener(this);
            return employerBinding.getRoot();
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(getActivity()).get(UserInfoFragmentViewModel.class);
        // TODO: Use the ViewModel
        if(true)
            employeeBinding.setViewModel(mViewModel);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.user_info_fragment_main_employer_tvSecession:
            case R.id.user_info_fragment_main_employee_tvSecession:
                Intent intent = new Intent(getActivity(), SecessionActivity.class);
                startActivity(intent);
                break;
        }
    }
}
