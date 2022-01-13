package ua.com.alevel.dao;

import ua.com.alevel.db.CourseDB;
import ua.com.alevel.db.StudentDB;
import ua.com.alevel.entity.Course;
import ua.com.alevel.entity.Student;

public class CourseDao {
    private static StudentDB STUDENT_DB = StudentDB.getInstance();
    private static CourseDB COURSE_DB = CourseDB.getInstance();

    public CourseDao() {
    }

    public void create(Course course, Student[] students) {

        for(int i=0; i<students.length;i++){
            if(null != students[i] && null == STUDENT_DB.findById(students[i].getId())){
                students[i]=null;
            }
        }
        Student[] bufferArray=new Student[students.length];
        int breakPoint=0;
        for(int i=0;i< students.length;i++){
            if (null != COURSE_DB.findById(students[i].getId())){
                bufferArray[breakPoint]=students[i];
                breakPoint++;
            }
        }
        course.setStudents(bufferArray);
        COURSE_DB.create(course);
    }

    public Course findById(String id) {
        return COURSE_DB.findById(id);
    }

    public Course[] findAll() {
        return COURSE_DB.findAll();
    }

    public void update(Course course) {
        COURSE_DB.update(course);
    }

    public void delete(String id) {
        COURSE_DB.delete(id);
    }
}
