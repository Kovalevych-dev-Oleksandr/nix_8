package ua.com.alevel.entity;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Course {


    private String id;
    private String courseName;
    private Student[] students;

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Course{" +
                "Id='" + getId() + '\'' +
                " Course name='" + courseName + '\'' +
                ", Students(" + studentArrayToString() +
                '}';
    }

    private String studentArrayToString() {
        String res = null;
        if (students==null){
            return null;
        }
        for(int i=0;i<students.length;i++){
            res=res+"Name="+students[i].getName()+";";
        }
        return res;
    }
}
