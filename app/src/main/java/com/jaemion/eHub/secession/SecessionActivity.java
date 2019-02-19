package com.jaemion.eHub.secession;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;

import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import com.jaemion.eHub.R;
import com.jaemion.eHub.databinding.SecessionActivityBinding;

public class SecessionActivity extends AppCompatActivity implements View.OnClickListener {
    SecessionActivityBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.secession_activity);

        setSupportActionBar(binding.secessionToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_left_black);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        binding.secessionBtnSecession.setOnClickListener(this);
        binding.secessionCbSecession.setOnClickListener(this);
        binding.secessionBtnSecession.setEnabled(false);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.secession_btnSecession:
                finish();
                break;
            case R.id.secession_cbSecession:
                if (binding.secessionCbSecession.isChecked()) {
                    binding.secessionBtnSecession.setEnabled(true);
                    binding.secessionBtnSecession.setBackgroundColor(getResources().getColor(R.color.button_background_enable));
                    binding.secessionBtnSecession.setTextColor(getResources().getColor(R.color.button_text_enable));
                } else {
                    binding.secessionBtnSecession.setEnabled(false);
                    binding.secessionBtnSecession.setBackgroundColor(getResources().getColor(R.color.button_background_disable));
                    binding.secessionBtnSecession.setTextColor(getResources().getColor(R.color.button_text_disable));
                }
                break;
        }
    }
}
