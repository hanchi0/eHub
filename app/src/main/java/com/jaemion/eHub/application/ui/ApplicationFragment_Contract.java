package com.jaemion.eHub.application.ui;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;

import com.jaemion.eHub.R;
import com.jaemion.eHub.application.ApplicationActivity;
import com.jaemion.eHub.customview.CustomCanvas;
import com.jaemion.eHub.order.ui.OrderFragment_Statement;

public class ApplicationFragment_Contract extends Fragment implements View.OnClickListener {
    private ApplicationViewModel mViewModel;
    Button btnContract;
    CheckBox cb1, cb2, cb3;
    CustomCanvas customCanvas;

    public static ApplicationFragment_Contract newInstance() {
        return new ApplicationFragment_Contract();
    }

    public ApplicationFragment_Contract() {
        super();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.application_fragment_contract, container, false);
        btnContract = view.findViewById(R.id.application_fragment_contract_btnContract);
        cb1 = view.findViewById(R.id.application_fragment_contract_cb1);
        cb2 = view.findViewById(R.id.application_fragment_contract_cb2);
        cb3 = view.findViewById(R.id.application_fragment_contract_cb3);
        customCanvas = view.findViewById(R.id.application_fragment_contract_canvas);
        customCanvas.setTouchListener(new CustomCanvas.TouchListener() {
            @Override
            public void onTouch() {
                if (cb1.isChecked() && cb2.isChecked() && cb3.isChecked() && customCanvas.getIsTouched()) {
                    btnContract.setEnabled(true);
                    btnContract.setBackgroundColor(getResources().getColor(R.color.button_background_enable));
                    btnContract.setTextColor(getResources().getColor(R.color.button_text_enable));
                } else {
                    btnContract.setEnabled(false);
                    btnContract.setBackgroundColor(getResources().getColor(R.color.button_background_disable));
                    btnContract.setTextColor(getResources().getColor(R.color.button_text_disable));
                }
            }
        });
        cb1.setOnClickListener(this);
        cb2.setOnClickListener(this);
        cb3.setOnClickListener(this);
        btnContract.setOnClickListener(this);
        btnContract.setEnabled(false);
        btnContract.setBackgroundColor(getResources().getColor(R.color.button_background_disable));
        btnContract.setTextColor(getResources().getColor(R.color.button_text_disable));
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
                if (cb1.isChecked() && cb2.isChecked() && cb3.isChecked() && customCanvas.getIsTouched()) {
                    btnContract.setEnabled(true);
                    btnContract.setBackgroundColor(getResources().getColor(R.color.button_background_enable));
                    btnContract.setTextColor(getResources().getColor(R.color.button_text_enable));
                } else {
                    btnContract.setEnabled(false);
                    btnContract.setBackgroundColor(getResources().getColor(R.color.button_background_disable));
                    btnContract.setTextColor(getResources().getColor(R.color.button_text_disable));
                }
                break;
        }
    }
}

