package com.jaemion.eHub.order.ui;

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
import com.jaemion.eHub.databinding.OrderFragmentStatementBinding;
import com.jaemion.eHub.order.OrderActivity;

public class OrderFragment_Statement extends Fragment implements View.OnClickListener {
    private OrderViewModel mViewModel;

    public static OrderFragment_Statement newInstance() {
        return new OrderFragment_Statement();
    }

    OrderFragmentStatementBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.order_fragment_statement, container, false);

        binding.orderFragmentStatementBtnHome.setOnClickListener(this);
        binding.orderFragmentStatementBtnList.setOnClickListener(this);
        binding.orderFragmentStatementBtnOrder.setOnClickListener(this);
        ((OrderActivity) getActivity()).setToolbar("발주 결과");
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
            case R.id.order_fragment_statement_btnOrder:
                break;

            case R.id.order_fragment_statement_btnHome:
                getActivity().finish();
                break;

            case R.id.order_fragment_statement_btnList:
                Intent resultIntent = new Intent();
                resultIntent.putExtra("destination", "List");
                getActivity().setResult(Activity.RESULT_OK, resultIntent);
                getActivity().finish();
                break;
        }
    }
}
