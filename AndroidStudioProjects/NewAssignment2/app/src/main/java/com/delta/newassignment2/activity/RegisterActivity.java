package com.delta.newassignment2.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.delta.newassignment2.R;
import com.google.android.material.snackbar.Snackbar;

public class RegisterActivity extends AppCompatActivity {

    private Context mContext;
    private Activity mActivity;
    private TextView mtextView,tvWelcome,tvInfo;

    public EditText eFullName,eEmail,ePassword;
    public CheckBox checkBox;

    public ImageButton aBack;
    public Button dContinue;

    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mContext = getApplicationContext();
        mActivity = RegisterActivity.this;
        mtextView = findViewById(R.id.tv_span_register1);
        aBack=findViewById(R.id.ib_back);
        dContinue=findViewById(R.id.btn_submit);
        eFullName=findViewById(R.id.et_full_name);
        eEmail=findViewById(R.id.et_email);
        ePassword=findViewById(R.id.et_pass);
        tvWelcome=findViewById(R.id.tv_welcome);
        tvInfo=findViewById(R.id.tv_info);
        checkBox=findViewById(R.id.cb_1);

        aBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent i=new Intent(RegisterActivity.this, LogInActivity.class);
                startActivity(i);
                finish();
            }
        });


        String text = getString(R.string.register_1);

        SpannableStringBuilder ssBuilder = new SpannableStringBuilder(text);
        ClickableSpan rClickableSpan=new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget) {

                Toast.makeText(mContext, R.string.register_toast, Toast.LENGTH_SHORT).show();
                startActivity(new Intent(RegisterActivity.this,LogInActivity.class));
            }
        };



        ssBuilder.setSpan(
                rClickableSpan,0,text.length()-1,
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        );




        mtextView.setText(ssBuilder);
        mtextView.setMovementMethod(LinkMovementMethod.getInstance());

        SpannableString TermCondition=new SpannableString(
                "By Clicking You agree The Term and Condition"
        );
        ClickableSpan termAndCondition=new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget) {

            }
        };

        TermCondition.setSpan(termAndCondition,25,44,0);

        checkBox.setText(TermCondition);
        checkBox.setMovementMethod(LinkMovementMethod.getInstance());

        dContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String name = eFullName.getText().toString();
                String email = eEmail.getText().toString();
                String pass = ePassword.getText().toString();


                if (name.isEmpty()) {
                    Snackbar.make(v, getString(R.string.login_snackbar3), Snackbar.LENGTH_SHORT)
                            .setAction(getString(R.string.login_action3), null).show();


                }else if (email.isEmpty()){
                    Snackbar.make(v,getString(R.string.login_snackbar1),Snackbar.LENGTH_SHORT)
                            .setAction(getString(R.string.login_action2),null).show();

                }else
                    if (pass.isEmpty()){
                    Snackbar.make(v,getString(R.string.login_snackbar2),Snackbar.LENGTH_SHORT)
                            .setAction(getString(R.string.login_action1),null).show();
                    }else
                     if (!checkBox.isChecked()){
                        Snackbar.make(v,getString(R.string.login_snackbar4),Snackbar.LENGTH_SHORT)
                                .setAction(getString(R.string.login_action4),null).show();


                }else
                    if (eFullName.getText().toString().equals("xyz")&&eEmail.getText().toString().equals("admin@gmail.com") && ePassword.getText().toString().equals("qwertyui")&& checkBox.isChecked()){

//                    if (eEmail.getText().toString().trim().matches(emailPattern)) {
//                        Toast.makeText(getApplicationContext(), R.string.register_toast2, Toast.LENGTH_SHORT).show();
//                    }

                    Intent i=new Intent(RegisterActivity.this, OtpActivity.class);
                    startActivity(i);

                }else {

                    Toast.makeText(RegisterActivity.this, R.string.register_toast3, Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

}


