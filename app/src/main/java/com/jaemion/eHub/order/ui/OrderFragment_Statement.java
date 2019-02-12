package com.jaemion.eHub.order.ui;

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
import com.jaemion.eHub.order.OrderActivity;

public class OrderFragment_Statement extends Fragment implements View.OnClickListener {
    private OrderViewModel mViewModel;

    public static OrderFragment_Statement newInstance() {
        return new OrderFragment_Statement();
    }
    TextView tvLocationData, tvDurationData, tvDurationDataSub, tvPayData, tvTypeData, tvOptionData, tvNumOfCarData, tvTotalPayData;

    Button btnList, btnHome, btnOrder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.order_fragment_statement, container, false);
        tvLocationData = view.findViewById(R.id.order_fragment_statement_tvLocationData);
        tvDurationData = view.findViewById(R.id.order_fragment_statement_tvDurationData);
        tvDurationDataSub = view.findViewById(R.id.order_fragment_statement_tvDurationDataSub);
        tvPayData = view.findViewById(R.id.order_fragment_statement_tvPayData);
        tvTypeData = view.findViewById(R.id.order_fragment_statement_tvTypeData);
        tvOptionData = view.findViewById(R.id.order_fragment_statement_tvOptionData);
        tvNumOfCarData = view.findViewById(R.id.order_fragment_statement_tvNumOfCarData);
        tvTotalPayData = view.findViewById(R.id.order_fragment_statement_tvTotalPayData);
        btnHome = view.findViewById(R.id.order_fragment_statement_btnHome);
        btnList = view.findViewById(R.id.order_fragment_statement_btnList);
        btnOrder = view.findViewById(R.id.order_fragment_statement_btnOrder);
        btnHome.setOnClickListener(this);
        btnList.setOnClickListener(this);
        btnOrder.setOnClickListener(this);
        ((OrderActivity) getActivity()).setToolbar("발주 결과");
        return view;
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
