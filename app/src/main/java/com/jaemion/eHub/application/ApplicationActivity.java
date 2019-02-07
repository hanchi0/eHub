package com.jaemion.eHub.application;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import com.jaemion.eHub.R;
import com.jaemion.eHub.application.ui.ApplicationFragment_List;

public class ApplicationActivity extends AppCompatActivity {
    Toolbar toolbar;
    TextView toolbarTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.application_activity);
        setToolbar("발주된 작업 목록");
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.application_container, ApplicationFragment_List.newInstance())
                    .commitNow();
        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                getSupportFragmentManager().popBackStack();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public TextView getToolbarTitle(){
        return toolbarTitle;
    }

    public void setToolbar(String title){
        toolbar = findViewById(R.id.application_toolbar);
        toolbarTitle = findViewById(R.id.application_toolbar_title);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbarTitle.setText(title);

    }
}
