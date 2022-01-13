package ua.com.alevel.dao;

import ua.com.alevel.db.CourseDB;
import ua.com.alevel.db.StudentDB;
import ua.com.alevel.entity.Course;
import ua.com.alevel.entity.Student;

public class StudentDao {
    private static StudentDB STUDENT_DB = StudentDB.getInstance();
    private static CourseDB COURSE_DB = CourseDB.getInstance();

    public StudentDao() {}

    public String create(Student student, Course[] courses) {
        Course[] bufferArray=new Course[courses.length];
        int breakPoint=0;
        for(int i=0;i< courses.length;i++){
            if (null != StudentDao.COURSE_DB.findById(courses[i].getId())){
                bufferArray[breakPoint]=courses[i];
                breakPoint++;
            }
        }
        student.setCourses(bufferArray);
       return STUDENT_DB.create(student);
    }

    public Student findById(String id) {
        return STUDENT_DB.findById(id);
    }

    public Student[] findAll() {
        return STUDENT_DB.findAll();
    }

    public void update(Student student) {
        STUDENT_DB.update(student);
    }

    public void delete(String id) {
        STUDENT_DB.delete(id);
    }
}
