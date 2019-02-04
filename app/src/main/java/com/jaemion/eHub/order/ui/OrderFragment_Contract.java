package com.jaemion.eHub.order.ui;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;

import com.jaemion.eHub.R;
import com.jaemion.eHub.customview.CustomCanvas;
import com.jaemion.eHub.order.OrderActivity;

public class OrderFragment_Contract extends Fragment implements View.OnClickListener {
    private OrderViewModel mViewModel;
    Button btnContract;
    CheckBox cb1, cb2, cb3;
    CustomCanvas customCanvas;

    public static OrderFragment_Contract newInstance() {
        return new OrderFragment_Contract();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.order_fragment_contract, container, false);
        btnContract = view.findViewById(R.id.order_fragment_contract_btnContract);
        cb1 = view.findViewById(R.id.order_fragment_contract_cb1);
        cb2 = view.findViewById(R.id.order_fragment_contract_cb2);
        cb3 = view.findViewById(R.id.order_fragment_contract_cb3);
        customCanvas = view.findViewById(R.id.order_fragment_contract_canvas);
        customCanvas.setTouchListener(new CustomCanvas.TouchListener() {
            @Override
            public void onTouch() {
                if (cb1.isChecked() && cb2.isChecked() && cb3.isChecked() && customCanvas.getIsTouched()) {
                    btnContract.setEnabled(true);
                    btnContract.setBackgroundColor(getResources().getColor(R.color.buttonBackgroundHighlight));
                    btnContract.setTextColor(getResources().getColor(R.color.buttonTextHighlight));
                } else {
                    btnContract.setEnabled(false);
                    btnContract.setBackgroundColor(getResources().getColor(R.color.buttonBackground));
                    btnContract.setTextColor(getResources().getColor(R.color.buttonText));
                }
            }
        });
        cb1.setOnClickListener(this);
        cb2.setOnClickListener(this);
        cb3.setOnClickListener(this);
        btnContract.setOnClickListener(this);
        btnContract.setEnabled(false);
        btnContract.setBackgroundColor(getResources().getColor(R.color.buttonBackground));
        btnContract.setTextColor(getResources().getColor(R.color.buttonText));

        ((OrderActivity) getActivity()).getToolbarTitle().setText("약관 및 계약서");
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(OrderViewModel.class);
        // TODO: Use the ViewModel
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.order_fragment_contract_btnContract:
                getActivity().getSupportFragmentManager().beginTransaction()
                        .addToBackStack(null)
                        .setCustomAnimations(R.anim.slide_right_in, R.anim.slide_left_out, R.anim.slide_left_in, R.anim.slide_right_out)
                        .replace(R.id.order_container, OrderFragment_Statement.newInstance())
                        .commit();
                break;
            case R.id.order_fragment_contract_cb1:
            case R.id.order_fragment_contract_cb2:
            case R.id.order_fragment_contract_cb3:
                if (cb1.isChecked() && cb2.isChecked() && cb3.isChecked() && customCanvas.getIsTouched()) {
                    btnContract.setEnabled(true);
                    btnContract.setBackgroundColor(getResources().getColor(R.color.buttonBackgroundHighlight));
                    btnContract.setTextColor(getResources().getColor(R.color.buttonTextHighlight));
                } else {
                    btnContract.setEnabled(false);
                    btnContract.setBackgroundColor(getResources().getColor(R.color.buttonBackground));
                    btnContract.setTextColor(getResources().getColor(R.color.buttonText));
                }
                break;
        }
    }
}
