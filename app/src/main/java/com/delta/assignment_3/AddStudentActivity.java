package com.delta.assignment_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class AddStudentActivity extends AppCompatActivity {

    EditText etStudentName,etClass,etRoll;
    Button btnSubmit;


    ArrayList<Student> studentList=new ArrayList<Student>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);
        init();




        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String studentName = etStudentName.getText().toString().trim();
                int studentClass = Integer.parseInt(etClass.getText().toString());
                int rollNo = Integer.parseInt(etRoll.getText().toString());
                Student student = new Student(rollNo, studentClass, studentName);
                Intent intent = new Intent(AddStudentActivity.this, HomeActivity.class);
                intent.putExtra("Key", student);
                setResult(RESULT_OK, intent);
                finish();

            }
        });
    }
    public void init(){
        etStudentName=findViewById(R.id.et_addstudent);
        etClass=findViewById(R.id.et_addclass);
        etRoll=findViewById(R.id.et_addroll);
        btnSubmit=findViewById(R.id.btn_submitstudent);
        btnSubmit.requestFocus();
    }


    public void validate(){
        String Name_Pattern = ("^[a-zA-Z\\s]*$");
        String Class_Pattern = ("[1-12]");
        if(etStudentName.getText().toString().isEmpty()){
            etStudentName.setError("Please fill this field");
        }
        else if(!etStudentName.getText().toString().matches(Name_Pattern)){
            etStudentName.setError("Invalid Name");
        }else if(etClass.getText().toString().isEmpty()){
            etClass.setError("Please fill this field");
        }
        else if(!etClass.getText().toString().matches(Class_Pattern)){
            etClass.setError("Invalid Name");
        }
        else if(etRoll.getText().toString().isEmpty()){
            etRoll.setError("Please fill this field");
        }


    }
}