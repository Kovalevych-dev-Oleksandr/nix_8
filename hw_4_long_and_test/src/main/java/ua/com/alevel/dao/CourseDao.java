package ua.com.alevel.dao;

import ua.com.alevel.db.CourseDB;
import ua.com.alevel.entity.Course;

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

    public String update(Course course) {
        return db.update(course);
    }

    public String delete(String id) {
        return db.delete(id);
    }
}
