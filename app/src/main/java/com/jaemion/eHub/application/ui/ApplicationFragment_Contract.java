package com.jaemion.eHub.application.ui;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;

import com.jaemion.eHub.R;
import com.jaemion.eHub.application.ApplicationActivity;
import com.jaemion.eHub.customview.CustomCanvas;
import com.jaemion.eHub.databinding.ApplicationFragmentContractBinding;

public class ApplicationFragment_Contract extends Fragment implements View.OnClickListener {
    private ApplicationViewModel mViewModel;
    ApplicationFragmentContractBinding binding;

    public static ApplicationFragment_Contract newInstance() {
        return new ApplicationFragment_Contract();
    }

    public ApplicationFragment_Contract() {
        super();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.application_fragment_contract, container, false);
        binding.applicationFragmentContractCanvas.setTouchListener(new CustomCanvas.TouchListener() {
            @Override
            public void onTouch() {
                if (binding.applicationFragmentContractCb1.isChecked() && binding.applicationFragmentContractCb2.isChecked() && binding.applicationFragmentContractCb3.isChecked() && binding.applicationFragmentContractCanvas.getIsTouched()) {
                    binding.applicationFragmentContractBtnContract.setEnabled(true);
                    binding.applicationFragmentContractBtnContract.setBackgroundColor(getResources().getColor(R.color.button_background_enable));
                    binding.applicationFragmentContractBtnContract.setTextColor(getResources().getColor(R.color.button_text_enable));
                } else {
                    binding.applicationFragmentContractBtnContract.setEnabled(false);
                    binding.applicationFragmentContractBtnContract.setBackgroundColor(getResources().getColor(R.color.button_background_disable));
                    binding.applicationFragmentContractBtnContract.setTextColor(getResources().getColor(R.color.button_text_disable));
                }
            }
        });
        binding.applicationFragmentContractCb1.setOnClickListener(this);
        binding.applicationFragmentContractCb2.setOnClickListener(this);
        binding.applicationFragmentContractCb3.setOnClickListener(this);
        binding.applicationFragmentContractBtnContract.setOnClickListener(this);
        binding.applicationFragmentContractBtnContract.setEnabled(false);
        binding.applicationFragmentContractBtnContract.setBackgroundColor(getResources().getColor(R.color.button_background_disable));
        binding.applicationFragmentContractBtnContract.setTextColor(getResources().getColor(R.color.button_text_disable));
        return binding.getRoot();
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
        ((ApplicationActivity) getActivity()).setToolbar("약관 및 계약서");
        ((ApplicationActivity) getActivity()).getSupportActionBar().show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.application_fragment_contract_btnContract:
                getActivity().getSupportFragmentManager().beginTransaction()
                        .addToBackStack(null)
                        .setCustomAnimations(R.anim.slide_right_in, R.anim.slide_left_out, R.anim.slide_left_in, R.anim.slide_right_out)
                        .replace(R.id.application_container, ApplicationFragment_Statement.newInstance())
                        .commit();
                break;
            case R.id.application_fragment_contract_cb1:
            case R.id.application_fragment_contract_cb2:
            case R.id.application_fragment_contract_cb3:
                if (binding.applicationFragmentContractCb1.isChecked() && binding.applicationFragmentContractCb2.isChecked() && binding.applicationFragmentContractCb3.isChecked() && binding.applicationFragmentContractCanvas.getIsTouched()) {
                    binding.applicationFragmentContractBtnContract.setEnabled(true);
                    binding.applicationFragmentContractBtnContract.setBackgroundColor(getResources().getColor(R.color.button_background_enable));
                    binding.applicationFragmentContractBtnContract.setTextColor(getResources().getColor(R.color.button_text_enable));
                } else {
                    binding.applicationFragmentContractBtnContract.setEnabled(false);
                    binding.applicationFragmentContractBtnContract.setBackgroundColor(getResources().getColor(R.color.button_background_disable));
                    binding.applicationFragmentContractBtnContract.setTextColor(getResources().getColor(R.color.button_text_disable));
                }
                break;
        }
    }
}

