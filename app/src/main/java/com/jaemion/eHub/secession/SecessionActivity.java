package com.jaemion.eHub.secession;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import com.jaemion.eHub.R;

public class SecessionActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnSecession;
    CheckBox cbSecession;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.secession_activity);
        toolbar = findViewById(R.id.secession_toolbar);
        btnSecession = findViewById(R.id.secession_btnSecession);
        cbSecession = findViewById(R.id.secession_cbSecession);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_left_black);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        btnSecession.setOnClickListener(this);
        cbSecession.setOnClickListener(this);
        btnSecession.setEnabled(false);
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
                if (cbSecession.isChecked()) {
                    btnSecession.setEnabled(true);
                    btnSecession.setBackgroundColor(getResources().getColor(R.color.button_background_enable));
                    btnSecession.setTextColor(getResources().getColor(R.color.button_text_enable));
                } else {
                    btnSecession.setEnabled(false);
                    btnSecession.setBackgroundColor(getResources().getColor(R.color.button_background_disable));
                    btnSecession.setTextColor(getResources().getColor(R.color.button_text_disable));
                }
                break;
        }
    }
}
