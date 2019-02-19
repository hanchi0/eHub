package com.jaemion.eHub.signin;

import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;

import android.os.PatternMatcher;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.jaemion.eHub.R;
import com.jaemion.eHub.databinding.SignInActivityBinding;
import com.jaemion.eHub.databinding.SignInFragmentSignInBinding;
import com.jaemion.eHub.main.MainActivity;
import com.jaemion.eHub.signin.ui.SignInFragment_SignIn;
import com.jaemion.eHub.signup.SignUpActivity;

import java.util.regex.Pattern;

public class SignInActivity extends AppCompatActivity {
    SignInActivityBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.sign_in_activity);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.signIn_container, SignInFragment_SignIn.newInstance())
                    .commitNow();
        }
        setSupportActionBar(binding.signInToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_left_black);
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

    public void setToolbar(String title) {
        setSupportActionBar(binding.signInToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        binding.signInToolbarTitle.setText(title);
    }
}
