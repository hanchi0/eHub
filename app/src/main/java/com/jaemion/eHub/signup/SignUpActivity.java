package com.jaemion.eHub.signup;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;

import android.view.MenuItem;
import android.widget.TextView;

import com.jaemion.eHub.R;
import com.jaemion.eHub.databinding.SignUpActivityBinding;
import com.jaemion.eHub.signup.ui.SignUpFragment_Select;

public class SignUpActivity extends AppCompatActivity {
    SignUpActivityBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.sign_up_activity);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.signUp_container, SignUpFragment_Select.newInstance())
                    .commitNow();
        }

        setSupportActionBar(binding.signUpToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_left_black);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                if (getSupportFragmentManager().getBackStackEntryCount() <= 0)
                    finish();
                else
                    getSupportFragmentManager().popBackStack();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void setToolbar(String title) {
        setSupportActionBar(binding.signUpToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        binding.signUpToolbarTitle.setText(title);
    }
}
