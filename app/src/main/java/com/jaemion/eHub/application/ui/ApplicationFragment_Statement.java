package com.jaemion.eHub.application.ui;

import android.app.Activity;
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

public class ApplicationFragment_Statement extends Fragment implements View.OnClickListener {
    private ApplicationViewModel mViewModel;
    TextView tvLocationData, tvDurationData, tvDurationDataSub, tvPayData, tvTypeData, tvOptionData, tvNumOfCarData, tvTotalPayData;
    Button btnApply, btnHome, btnList;

    public static ApplicationFragment_Statement newInstance() {
        return new ApplicationFragment_Statement();
    }

    public ApplicationFragment_Statement() {
        super();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.application_fragment_statement, container, false);
        ((ApplicationActivity) getActivity()).setToolbar("수주 확인");
        tvLocationData = view.findViewById(R.id.application_fragment_statement_tvLocationData);
        tvDurationData = view.findViewById(R.id.application_fragment_statement_tvDurationData);
        tvDurationDataSub = view.findViewById(R.id.application_fragment_statement_tvDurationDataSub);
        tvPayData = view.findViewById(R.id.application_fragment_statement_tvPayData);
        tvTypeData = view.findViewById(R.id.application_fragment_statement_tvTypeData);
        tvOptionData = view.findViewById(R.id.application_fragment_statement_tvOptionData);
        tvNumOfCarData = view.findViewById(R.id.application_fragment_statement_tvNumOfCarData);
        tvTotalPayData = view.findViewById(R.id.application_fragment_statement_tvTotalPayData);
        btnApply = view.findViewById(R.id.application_fragment_statement_btnApply);
        btnHome = view.findViewById(R.id.application_fragment_statement_btnHome);
        btnList = view.findViewById(R.id.application_fragment_statement_btnList);
        btnApply.setOnClickListener(this);
        btnHome.setOnClickListener(this);
        btnList.setOnClickListener(this);
        return view;
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
