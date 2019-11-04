package com.delta.newassignment2.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.delta.newassignment2.R;
import com.google.android.material.snackbar.Snackbar;

public class LogInActivity extends AppCompatActivity {

    private Context mContext;
    private Activity mActivity;
    private TextView mtextView;

    public Button btnLogin;
    public EditText userId;
    public EditText uPassword;

    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);


        userId=findViewById(R.id.et_user_id);
        uPassword=findViewById(R.id.et_login_pass);
        btnLogin=findViewById(R.id.btn_login);
        mContext = getApplicationContext();
        mActivity = LogInActivity.this;
        mtextView = findViewById(R.id.tv_span_register);


        String text = getString(R.string.login_register1);

        SpannableStringBuilder ssBuilder = new SpannableStringBuilder(text);
        ClickableSpan rClickableSpan=new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget) {

                Toast.makeText(mContext, "Register", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(LogInActivity.this, RegisterActivity.class));
            }
        };

        ssBuilder.setSpan(
                rClickableSpan,
                text.indexOf("Register"),
                text.indexOf("Register") + String.valueOf("Register").length(),
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        );

        mtextView.setText(ssBuilder);
        mtextView.setMovementMethod(LinkMovementMethod.getInstance());

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email=userId.getText().toString();
                String pass=uPassword.getText().toString();

                if (email.isEmpty()){
                    Snackbar.make(v,getString(R.string.login_snackbar1),Snackbar.LENGTH_SHORT)
                            .setAction(getString(R.string.login_action2),null).show();
                }else if (pass.isEmpty()){
                    Snackbar.make(v,getString(R.string.login_snackbar2),Snackbar.LENGTH_SHORT)
                            .setAction(getString(R.string.login_action1),null).show();

                }else
                    if (userId.getText().toString().equals("admin@gmail.com") && uPassword.getText().toString().equals("qwertyui")){

                        Intent i=new Intent(LogInActivity.this,RegisterActivity.class);
                        startActivity(i);

                }else {

                        Toast.makeText(LogInActivity.this, R.string.login_toast2, Toast.LENGTH_SHORT).show();

                    }
                }
        });

    }
}
