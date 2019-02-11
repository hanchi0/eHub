package com.jaemion.eHub.application.ui;

import androidx.lifecycle.ViewModelProviders;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.appcompat.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.jaemion.eHub.R;
import com.jaemion.eHub.application.ApplicationActivity;

public class ApplicationFragment_Detail extends Fragment implements View.OnClickListener {

    private ApplicationViewModel mViewModel;
    Button btnApply;

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
        Toolbar bar = view.findViewById(R.id.application_fragment_detail_toolbar);
        ((ApplicationActivity) getActivity()).getSupportActionBar().hide();
        ((ApplicationActivity) getActivity()).setSupportActionBar(bar);
        ((ApplicationActivity) getActivity()).getSupportActionBar().setDisplayShowTitleEnabled(false);
        ((ApplicationActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ((ApplicationActivity) getActivity()).getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close_black);
        ((ApplicationActivity) getActivity()).getSupportActionBar().show();
        btnApply = view.findViewById(R.id.application_fragment_detail_btnApply);
        btnApply.setOnClickListener(this);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(ApplicationViewModel.class);
        // TODO: Use the ViewModel
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                getActivity().getSupportFragmentManager().popBackStack();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.application_fragment_detail_btnApply:
                getActivity().getSupportFragmentManager().beginTransaction()
                        .addToBackStack(null)
                        .replace(R.id.application_container, new ApplicationFragment_Contract())
                        .commit();
                break;
        }
    }
}
