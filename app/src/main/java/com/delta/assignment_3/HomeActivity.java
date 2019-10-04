package com.delta.assignment_3;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class HomeActivity extends AppCompatActivity implements StudentAdapter.ItemClicked {


    RecyclerView recyclerView;
    RecyclerView.Adapter myAdapter;
    RecyclerView.LayoutManager layoutManager;

    ArrayList<Student> studentList=new ArrayList<Student>();

    Button btnAddStudent;
    ImageView imgSorticon,imgListicon;
    TextView tvEmpty;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        init();





        imgSorticon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(HomeActivity.this,imgSorticon);
                popupMenu.getMenuInflater().inflate(R.menu.menu,popupMenu.getMenu());

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {

                        switch (item.getItemId()){
                            case R.id.sort_name:
                                Collections.sort(studentList, new Comparator<Student>() {
                                    @Override
                                    public int compare(Student o1, Student o2) {
                                        return o1.getName().compareToIgnoreCase(o2.getName());
                                    }
                                });

                                myAdapter.notifyDataSetChanged();
                                return true;

                            case R.id.sort_rollno:
                                Collections.sort(studentList, new Comparator<Student>() {
                                    @Override
                                    public int compare(Student o1, Student o2) {

                                        String rollNo = String.valueOf(o1.getRollNo());
                                        String rollNo2 = String.valueOf(o2.getRollNo());
                                        return rollNo.compareToIgnoreCase(rollNo2);
                                    }
                                });

                                myAdapter.notifyDataSetChanged();
                                return true;
                                default:
                                    return false;


                        }




                    }
                });
                popupMenu.show();
            }
        });






        recyclerView=findViewById(R.id.recycler_list);
        recyclerView.setHasFixedSize(true);

        layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);


        myAdapter=new StudentAdapter(this,studentList);
        recyclerView.setAdapter(myAdapter);

        btnAddStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(HomeActivity.this,AddStudentActivity.class);
                startActivityForResult(intent,3);

            }
        });

    }

    public void init(){

        btnAddStudent=findViewById(R.id.btn_addstudent);
        imgSorticon = findViewById(R.id.ib_sort_icon);
        imgListicon = findViewById(R.id.ib_list_icon);
        tvEmpty = findViewById(R.id.tv_emptyrecycler);

        tvEmpty.setText("No Student List Yet");
    }


    @Override
    public void onItemClicked(int index) {
        Dialog dialog=new Dialog(this);
        dialog.setContentView(R.layout.dialog);
        dialog.show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 3){
            if(resultCode == RESULT_OK){
                Student student= data.getParcelableExtra("Key");
                studentList.add(student);
                createview();

            }
        }
    }
    public void createview(){
        if(studentList.size()==0){
            recyclerView.setVisibility(View.INVISIBLE);
            tvEmpty.setVisibility(View.VISIBLE);

        }else {
            recyclerView.setVisibility(View.VISIBLE);
            tvEmpty.setVisibility(View.INVISIBLE);
        }
    }
}
