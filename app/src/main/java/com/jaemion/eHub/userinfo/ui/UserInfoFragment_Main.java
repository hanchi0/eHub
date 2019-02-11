package com.jaemion.eHub.userinfo.ui;

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
import com.jaemion.eHub.secession.SecessionActivity;


public class UserInfoFragment_Main extends Fragment implements View.OnClickListener {

    private UserInfoFragmentViewModel mViewModel;

    public static UserInfoFragment_Main newInstance() {
        return new UserInfoFragment_Main();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view;
        if (true) {
            view = inflater.inflate(R.layout.user_info_fragment_main_employee, container, false);
            view.findViewById(R.id.user_info_fragment_main_employee_tvSecession).setOnClickListener(this);
        } else {
            view = inflater.inflate(R.layout.user_info_fragment_main_employer, container, false);
            view.findViewById(R.id.user_info_fragment_main_employer_tvSecession).setOnClickListener(this);
        }

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(UserInfoFragmentViewModel.class);
        // TODO: Use the ViewModel
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
