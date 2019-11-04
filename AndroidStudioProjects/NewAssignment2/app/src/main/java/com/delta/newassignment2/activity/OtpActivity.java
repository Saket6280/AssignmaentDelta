package com.delta.newassignment2.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.delta.newassignment2.R;

public class OtpActivity extends AppCompatActivity {

    private ImageView imgLeft;
    private TextView tvOtp,tvEnterOtp;
    private EditText etOtp1,etOtp2,etOtp3,etOtp4;
    private Button btnResend,btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);

        imgLeft = findViewById(R.id.imgleft);
        tvOtp = findViewById(R.id.tv_otp);
        tvEnterOtp = findViewById(R.id.tv_enterotp);
        etOtp1 = findViewById(R.id.et_otp1);
        etOtp2 = findViewById(R.id.et_otp2);
        etOtp3 = findViewById(R.id.et_otp3);
        etOtp4 = findViewById(R.id.et_otp4);
        btnResend = findViewById(R.id.btn_resend);
        btnSubmit = findViewById(R.id.btn_submit);

        btnResend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(OtpActivity.this, R.string.otp_toast, Toast.LENGTH_SHORT).show();

                etOtp1.setText("");
                etOtp2.setText("");
                etOtp3.setText("");
                etOtp4.setText("");
                etOtp1.requestFocus();

            }
        });

        imgLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent j=new Intent(OtpActivity.this, LogInActivity.class);
                startActivity(j);
                finish();
            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(etOtp1.getText().toString().isEmpty()||etOtp2.getText().toString().isEmpty()||etOtp3.getText().toString().isEmpty()||etOtp4.getText().toString().isEmpty()){
                    Toast.makeText(OtpActivity.this, R.string.toast_otp2, Toast.LENGTH_SHORT).show();
                }
                else if(etOtp1.getText().toString().equals("1")&&etOtp2.getText().toString().equals("2")&&etOtp3.getText().toString().equals("3")&&etOtp4.getText().toString().equals("4")){
                    startActivity(new Intent(OtpActivity.this,LogInActivity.class));
                    finish();
                }
                else{
                    Toast.makeText(OtpActivity.this, R.string.otp_toast2, Toast.LENGTH_SHORT).show();
                }

            }
        });

        etOtp1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                etOtp2.requestFocus();

            }

            @Override
            public void afterTextChanged(Editable s) {

            }

        });


        etOtp2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                etOtp3.requestFocus();

            }

            @Override
            public void afterTextChanged(Editable s) {

            }

        });
        etOtp3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                etOtp4.requestFocus();

            }

            @Override
            public void afterTextChanged(Editable s) {

            }

        });
        etOtp4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }

        });

    }
}
