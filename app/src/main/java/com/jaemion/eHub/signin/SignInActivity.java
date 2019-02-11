package com.jaemion.eHub.signin;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.jaemion.eHub.R;
import com.jaemion.eHub.main.MainActivity;
import com.jaemion.eHub.signup.SignUpActivity;

public class SignInActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnSignIn;
    CheckBox checkBox;
    TextView tvSignUp, tvCheckBox, tvFindPw;
    EditText etId, etPw;
    String id, pw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in_activity);

        btnSignIn = findViewById(R.id.signIn_btnSign);
        tvCheckBox = findViewById(R.id.signIn_tvCheckBox);
        tvFindPw = findViewById(R.id.signIn_tvFindPw);
        tvSignUp = findViewById(R.id.signIn_tvSignUp);
        checkBox = findViewById(R.id.signIn_checkBox);
        etId = findViewById(R.id.signIn_etId);
        etPw = findViewById(R.id.signIn_etPassword);

        btnSignIn.setOnClickListener(this);
        tvSignUp.setOnClickListener(this);
        tvCheckBox.setOnClickListener(this);
        tvFindPw.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.signIn_btnSign:
                id = etId.getText().toString();
                pw = etPw.getText().toString();

                if (id.isEmpty() && pw.isEmpty()) {
                    Toast.makeText(this, "빈칸을 채워주세요", Toast.LENGTH_SHORT).show();
                } else {
                    intent = new Intent(this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
                break;

            case R.id.signIn_tvSignUp:
                intent = new Intent(this, SignUpActivity.class);
                startActivity(intent);
                finish();
                break;

            case R.id.signIn_tvCheckBox:
                if (checkBox.isChecked())
                    checkBox.setChecked(false);
                else
                    checkBox.setChecked(true);
                break;

            case R.id.signIn_tvFindPw:
                Toast.makeText(this, "아직 못찾아", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
