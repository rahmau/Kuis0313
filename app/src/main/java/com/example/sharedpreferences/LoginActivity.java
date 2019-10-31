package com.example.sharedpreferences;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sharedpreferences.helper.SharedPref;

public class LoginActivity extends AppCompatActivity {
    EditText mUsername;
    EditText mPassword;
    Button  mBtnLogin;

    private SharedPref sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mUsername = findViewById(R.id.etUsername);
        mPassword = findViewById(R.id.etPassword);
        mBtnLogin = findViewById(R.id.btnLogin);

        login();
        if (SharedPref.getInstance(LoginActivity.this).isLogin()) {
            startActivity(new Intent(this, HomeActivity.class));
            finish();
        }
    }
        public void login (){
        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n = mUsername.getText().toString();
                String e = mPassword.getText().toString();

                if (n.equals("admin")&& e.equals("admin123")){
                    Toast.makeText(getApplicationContext(),"Berhasil Masuk",Toast.LENGTH_SHORT).show();
                    SharedPref.getInstance(LoginActivity.this).setName(n);
                    SharedPref.getInstance(LoginActivity.this).setLogin(true);
                    startActivity(new Intent(LoginActivity.this,HomeActivity.class));
                }else{
                    Toast.makeText(LoginActivity.this, "Gagal Masuk", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
