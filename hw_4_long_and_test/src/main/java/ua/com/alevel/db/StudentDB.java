package ua.com.alevel.db;

import ua.com.alevel.entity.Course;
import ua.com.alevel.entity.Student;

import java.util.Objects;
import java.util.UUID;

public class StudentDB {
    private static final StudentDB instance = new StudentDB();
    private static final int START_ARRAY_SIZE = 30;
    private static Student[] students = new Student[START_ARRAY_SIZE];

    private StudentDB() {
    }

    public static StudentDB getInstance() {
        return instance;
    }

    public String create(Student student) {
        String result;
        Course[] array=student.getCourses();
        if(null == array[0]){
        result="A student does not exist without a course";
        }else {
            student.setId(generateId());
            boolean dataRecordingCapability = false;
            for (int i = 0; i < students.length; i++) {
                if (null == students[i]) {
                    students[i] = student;
                    dataRecordingCapability = true;
                    break;
                }
            }
            if (!dataRecordingCapability) {
                this.increasingArray(student);
            }
            result="The data is recorded in the database";
        }
        return result;
    }

    public static void clear() {
        students = new Student[START_ARRAY_SIZE];
    }

    private void increasingArray(Student student) {
        final Student[] newArray = new Student[students.length + START_ARRAY_SIZE];
        System.arraycopy(students, 0, newArray, 0, students.length);
        students = newArray;
        students[students.length] = student;
    }

    public void update(Student student) {//student
        Student current = this.findById(student.getId());
        if (current != null) {
            current.setCourses(student.getCourses());
            current.setSurname(student.getSurname());
            current.setName(student.getName());
        }
    }

    public Student findById(final String id) {
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

    public Student[] findAll() {
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

    public void delete(final String id) {
        int workerDeletePoint = 0;
        for (int i = 0; i < students.length; i++) {
            if (null != students[i] && id.equals(students[i].getId())) {
                students[i] = null;
                workerDeletePoint = i;
                break;
            }
        }
        Student[] newArray = new Student[students.length];

        System.arraycopy(students, 0, newArray, 0, workerDeletePoint);
        System.arraycopy(students, workerDeletePoint + 1, newArray, workerDeletePoint, students.length - (workerDeletePoint + 1));
        students = newArray;

    }

    private String generateId() {
        String id;
        do {
            id = this.generateStringUUID();
        } while (this.existId(id));
        return id;
    }

    private boolean existId(String id) {
        for (Student student : students) {
            if (null == student) break;
            if (id.equals(student.getId())) {
                return true;
            }
        }
        return false;
    }

    private String generateStringUUID() {
        return UUID.randomUUID().toString();
    }
}
