package ua.com.alevel.dao;

import ua.com.alevel.db.CourseDB;
import ua.com.alevel.db.StudentDB;
import ua.com.alevel.entity.Course;
import ua.com.alevel.entity.Student;

public class CourseDao {
    private final CourseDB db;

    public CourseDao() {
        this.db = CourseDB.getInstance();
    }

    public String create(Course course) {
        return db.create(course);
    }

    public Course findById(String id) {
        return db.findById(id);
    }

    public Course[] findAll() {
        return db.findAll();
    }

    public void update(Course course) {
        db.update(course);
    }

    public void delete(String id) {
        db.delete(id);
    }
}
