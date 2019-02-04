package com.jaemion.eHub.application.ui;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jaemion.eHub.R;
import com.jaemion.eHub.application.ApplicationActivity;

public class ApplicationFragment_Detail extends Fragment {

    private ApplicationViewModel mViewModel;

    public static ApplicationFragment_Detail newInstance() {
        return new ApplicationFragment_Detail();
    }

    public ApplicationFragment_Detail() {
        super();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.application_fragment_detail, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(ApplicationViewModel.class);
        // TODO: Use the ViewModel
    }

    @Override
    public void onResume() {
        super.onResume();
        ((ApplicationActivity)getActivity()).getSupportActionBar().hide();
    }
}
