package com.delta.assignment_3;

import android.os.Parcel;
import android.os.Parcelable;

public class Student implements Parcelable {

    int rollNo,studentClass;
    String name;

    public Student(int rollNo, int studentClass, String name) {
        this.rollNo = rollNo;
        this.studentClass = studentClass;
        this.name = name;
    }

    protected Student(Parcel in) {
        rollNo = in.readInt();
        studentClass = in.readInt();
        name = in.readString();
    }

    public static final Creator<Student> CREATOR = new Creator<Student>() {
        @Override
        public Student createFromParcel(Parcel in) {
            return new Student(in);
        }

        @Override
        public Student[] newArray(int size) {
            return new Student[size];
        }
    };

    public int getRollNo() {
        return rollNo;
    }

    public int getStudentClass() {
        return studentClass;
    }

    public String getName() {
        return name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(rollNo);
        parcel.writeInt(studentClass);
        parcel.writeString(name);
    }
}