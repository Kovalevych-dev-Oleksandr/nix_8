package ua.com.alevel.dao;

import ua.com.alevel.db.StudentDB;
import ua.com.alevel.entity.Student;

public class StudentDao {
    private final StudentDB db;

    public StudentDao() {
        this.db = StudentDB.getInstance();
    }

    public String create(Student student) {
        return db.create(student);
    }

    public Student findById(String id) {
        return db.findById(id);
    }

    public Student[] findAll() {
        return db.findAll();
    }

    public String update(Student student) {
        return db.update(student);
    }

    public String delete(String id) {
        return db.delete(id);
    }
}
