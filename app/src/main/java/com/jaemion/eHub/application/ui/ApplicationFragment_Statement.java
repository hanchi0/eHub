package com.jaemion.eHub.application.ui;

import android.app.Activity;

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
import android.widget.Button;
import android.widget.TextView;

import com.jaemion.eHub.R;
import com.jaemion.eHub.application.ApplicationActivity;
import com.jaemion.eHub.databinding.ApplicationFragmentStatementBinding;

public class ApplicationFragment_Statement extends Fragment implements View.OnClickListener {
    private ApplicationViewModel mViewModel;
    ApplicationFragmentStatementBinding binding;

    public static ApplicationFragment_Statement newInstance() {
        return new ApplicationFragment_Statement();
    }

    public ApplicationFragment_Statement() {
        super();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ((ApplicationActivity) getActivity()).setToolbar("수주 확인");
        binding = DataBindingUtil.inflate(inflater, R.layout.application_fragment_statement, container, false);
        binding.applicationFragmentStatementBtnApply.setOnClickListener(this);
        binding.applicationFragmentStatementBtnHome.setOnClickListener(this);
        binding.applicationFragmentStatementBtnList.setOnClickListener(this);
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(ApplicationViewModel.class);
        // TODO: Use the ViewModel
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.application_fragment_statement_btnApply:
                break;

            case R.id.application_fragment_statement_btnHome:
                getActivity().finish();
                break;

            case R.id.application_fragment_statement_btnList:
                Intent resultIntent = new Intent();
                resultIntent.putExtra("destination", "List");
                getActivity().setResult(Activity.RESULT_OK, resultIntent);
                getActivity().finish();
                break;
        }
    }
}
