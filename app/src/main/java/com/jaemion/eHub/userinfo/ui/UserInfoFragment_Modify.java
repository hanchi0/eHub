package com.jaemion.eHub.userinfo.ui;

import androidx.lifecycle.ViewModelProviders;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jaemion.eHub.R;

public class UserInfoFragment_Modify extends Fragment {


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
        View view;

        if (true) {
            view = inflater.inflate(R.layout.user_info_fragment_main_employee, container, false);
        } else {
            view = inflater.inflate(R.layout.user_info_fragment_main_employer, container, false);
        }
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(UserInfoFragmentViewModel.class);

    }

}
