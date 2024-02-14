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

public class DetailsActivity extends Activity {
    AppCompatButton apc_btn_proceed_details;
    private EditText edt_firstname_details;
    private EditText edt_lastname_details;
    private EditText edt_email_details;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(ContextCompat.getColor(DetailsActivity.this,R.color.dark_blue_spl));
        }
        edt_firstname_details = findViewById(R.id.edt_firstname_details);
        edt_lastname_details = findViewById(R.id.edt_lastname_details);
        edt_email_details = findViewById(R.id.edt_email_details);
        apc_btn_proceed_details = findViewById(R.id.apc_btn_proceed_details);
        apc_btn_proceed_details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstName= edt_firstname_details.getText().toString();
                String lastName = edt_lastname_details.getText().toString();
                String emailid= edt_email_details.getText().toString();
                Intent i = new Intent(DetailsActivity.this,DashBoardActivity.class);
                i.putExtra("FirstName",firstName);
                i.putExtra("LastName",lastName);
                i.putExtra("Email",emailid);
                startActivity(i);
            }
        });

    }
}