package com.ags.loyalitymanagement;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.content.ContextCompat;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends Activity {
AppCompatButton app_btn_enterphone_login;
EditText edt_phone_login;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(ContextCompat.getColor(LoginActivity.this,R.color.dark_blue_spl));
        }
        app_btn_enterphone_login = findViewById(R.id.app_btn_enterphone_login);
        edt_phone_login = findViewById(R.id.edt_phone_login);
        app_btn_enterphone_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginActivity.this,OtpActivity.class);
                String phoneNumber = edt_phone_login.getText().toString().replace(" ","");
                i.putExtra("phoneNumber",phoneNumber);
                startActivity(i);
            }
        });
    }
}