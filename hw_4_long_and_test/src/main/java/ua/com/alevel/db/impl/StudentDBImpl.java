package ua.com.alevel.db.impl;

import ua.com.alevel.db.StudentDB;
import ua.com.alevel.entity.HomeWork;
import ua.com.alevel.entity.Student;

import java.util.Collection;
import java.util.Objects;

public class StudentDBImpl implements StudentDB {
    public static StudentDBImpl instance=new StudentDBImpl();
    private static final int START_ARRAY_SIZE = 42;
    private static Student[] students = new Student[START_ARRAY_SIZE];

    private StudentDBImpl(){}

    public static StudentDBImpl getInstance() {
        return StudentDBImpl.instance;
    }

  /*  public static void clear() {
        students = new Student[START_ARRAY_SIZE];
    }*/

    @Override
    public void create(Student student) {
        boolean dataRecordingCapability = false;
        for (int i = 0; i < students.length; i++) {
            if (students[i] == null) {
                students[i] = student;
                dataRecordingCapability = true;
                break;
            }
        }
        if (dataRecordingCapability) {
            return;
        }
        this.increasingArray(student);
    }


    private void increasingArray(Student student) {
        Student[] newArray = new Student[students.length + START_ARRAY_SIZE];
        System.arraycopy(students, 0, newArray, 0, students.length);
        students = newArray;
        students[students.length] = student;
    }

    @Override
    public Student findById(String id) {
        int i;
        for (i = 0; i < students.length; i++) {
            if (students[i] == null) {
                break;
            }
            if (Objects.equals(students[i].getId(), id)) {
                return students[i];
            }
        }
        return null;
    }

    @Override
    public void update(Student student) {
        Student current = findById(student.getId());
        if (current != null) {
            current.setName(student.getName());
            current.setSurname(student.getSurname());
            current.setHomeWorks(student.getHomeWorks());
        }
    }

    @Override
    public void delete(String id) {
        int homeWorkDeletePoint = 0;
        for (int i = 0; i < students.length; i++) {
            if (null != students[i] && id.equals(students[i].getId())) {
                students[i] = null;
                homeWorkDeletePoint = i;
                break;
            }
        }
        Student[] newArray = new Student[students.length];

        System.arraycopy(students, 0, newArray, 0, homeWorkDeletePoint);
        System.arraycopy(students, homeWorkDeletePoint + 1, newArray, homeWorkDeletePoint, students.length - (homeWorkDeletePoint + 1));
        students = newArray;

    }



    @Override
    public Student[] finalAll() {
        int sizeResultArray = 0;
        for (int i = 0; i < students.length; i++) {
            if (students[i] == null) {
                sizeResultArray = i;
                break;
            }
        }
         Student[] newResultArray = new Student[sizeResultArray];
        System.arraycopy(students, 0, newResultArray, 0, sizeResultArray);
        return newResultArray;
    }
}
