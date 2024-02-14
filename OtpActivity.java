package com.ags.loyalitymanagement;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.content.ContextCompat;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class OtpActivity extends Activity {
    TextView tv_phone_otp, tv_timer_otp;
    AppCompatButton apc_btn_proceed_otp;
    EditText edt_otp;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);
        mAuth = FirebaseAuth.getInstance();
        //Counter
        counterTime();
        //Actionbar Color
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(ContextCompat.getColor(OtpActivity.this, R.color.dark_blue_spl));
        }
        //declaration
        tv_phone_otp = findViewById(R.id.tv_phone_otp);
        edt_otp = findViewById(R.id.edt_otp);
        tv_timer_otp = findViewById(R.id.tv_timer_otp);
        apc_btn_proceed_otp = findViewById(R.id.apc_btn_proceed_otp);
        //getting data previos Ativity
        Intent i = getIntent();
        String phoneNumber = i.getStringExtra("phoneNumber");
        tv_phone_otp.setText("OTP Sent to " + phoneNumber);

        apc_btn_proceed_otp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(OtpActivity.this, DetailsActivity.class);
                startActivity(i);
            }
        });

    }
    public void counterTime(){
        new CountDownTimer(100000, 1000) {
            public void onTick(long millisUntilFinished) {
                NumberFormat f = new DecimalFormat("00");
                long hour = (millisUntilFinished / 3600000) % 24;
                long min = (millisUntilFinished / 60000) % 60;
                long sec = (millisUntilFinished / 1000) % 60;
                tv_timer_otp.setText(f.format(min) + ":" + f.format(sec));
            }
            public void onFinish() {
                tv_timer_otp.setText("00:00");
//                tv_timer_otp.setTextColor(getColor(R.color.dark_blue_spl));
            }
        }.start();
    }

}