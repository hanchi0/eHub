package com.jaemion.eHub.order.ui;

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
import com.jaemion.eHub.databinding.OrderFragmentContractBinding;
import com.jaemion.eHub.order.OrderActivity;

public class OrderFragment_Contract extends Fragment implements View.OnClickListener {
    private OrderViewModel mViewModel;

    public static OrderFragment_Contract newInstance() {
        return new OrderFragment_Contract();
    }

    OrderFragmentContractBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.order_fragment_contract, container, false);
        binding.orderFragmentContractCanvas.setTouchListener(new CustomCanvas.TouchListener() {
            @Override
            public void onTouch() {
                checkButtonAble();
            }
        });
        binding.orderFragmentContractCb1.setOnClickListener(this);
        binding.orderFragmentContractCb2.setOnClickListener(this);
        binding.orderFragmentContractCb3.setOnClickListener(this);
        binding.orderFragmentContractBtnContract.setOnClickListener(this);
        binding.orderFragmentContractBtnContract.setEnabled(false);
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(getActivity()).get(OrderViewModel.class);
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
                checkButtonAble();
                break;
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        ((OrderActivity) getActivity()).setToolbar("약관 및 계약서");
    }

    void checkButtonAble() {
        if (binding.orderFragmentContractCb1.isChecked() && binding.orderFragmentContractCb2.isChecked() && binding.orderFragmentContractCb3.isChecked() && binding.orderFragmentContractCanvas.getIsTouched()) {
            binding.orderFragmentContractBtnContract.setEnabled(true);
            binding.orderFragmentContractBtnContract.setBackground(getResources().getDrawable(R.drawable.button_ripple_enable));
            binding.orderFragmentContractBtnContract.setTextColor(getResources().getColor(R.color.button_text_enable));
        } else {
            binding.orderFragmentContractBtnContract.setEnabled(false);
            binding.orderFragmentContractBtnContract.setBackgroundColor(getResources().getColor(R.color.button_background_disable));
            binding.orderFragmentContractBtnContract.setTextColor(getResources().getColor(R.color.button_text_disable));
        }
    }
}
