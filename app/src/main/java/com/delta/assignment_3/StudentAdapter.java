package com.delta.assignment_3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class StudentAdapter extends RecyclerView.Adapter <StudentAdapter.ViewHolder>{

    private ArrayList<Student> studentList;
    ItemClicked activity;

    public interface ItemClicked{
        void onItemClicked(int index);
    }

    public StudentAdapter(Context context, ArrayList<Student> list){
        studentList=list;
        activity=(ItemClicked) context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView tvStudentName,tvClass,tvRoll;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvStudentName=itemView.findViewById(R.id.tv_student_name);
            tvClass=itemView.findViewById(R.id.tv_class);
            tvRoll=itemView.findViewById(R.id.tv_roll);

        }
    }

    @NonNull
    @Override
    public StudentAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentAdapter.ViewHolder holder, int position) {
        holder.itemView.setTag(studentList.get(position));
        holder.tvStudentName.setText(String.format("Name: %s", studentList.get(position).getName()));
        holder.tvClass.setText(String.format("Class: %d", studentList.get(position).getStudentClass()));




    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }
}

