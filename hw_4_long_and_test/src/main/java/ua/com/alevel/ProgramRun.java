package ua.com.alevel;

import ua.com.alevel.controller.StudentController;
import ua.com.alevel.dao.StudentDao;
import ua.com.alevel.entity.Student;
import ua.com.alevel.service.StudentService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


import static org.apache.xalan.xsltc.compiler.util.Util.println;

public class ProgramRun {
    /*private BufferedReader reader;
    private StudentController controller;*/

  /*  public ProgramRun() {
        this.controller = new StudentController(new StudentService(new StudentDao()));
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }*/

    public void run() {
        StudentController controller = new StudentController(new StudentService(new StudentDao()));
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        println("select your option");
        String position;
        try {
            this.runNavigation();
            while (null != (position = reader.readLine())) {
                this.crud(position, reader, controller);
                position = reader.readLine();
                if (position.equals("0")) {
                    System.exit(0);
                }
                this.crud(position, reader, controller);
            }
        } catch (IOException e) {
            println("problem: = " + e.getMessage());
        }
    }

    private void runNavigation() {
        println("");
        println("if you want create Student, please enter 1");
        println("if you want update Student, please enter 2");
        println("if you want delete Student, please enter 3");
        println("if you want findById Student, please enter 4");
        println("if you want findAll Student, please enter 5");
        println("if you want exit, please enter 0");
        println("");
    }

    private void crud(String position, BufferedReader reader, StudentController controller) {
        switch (position) {

            case "1":
                createStudent(reader, controller);
                break;
            case "2":
                updateStudent(reader, controller);
                break;
            case "3":
                deleteStudent(reader, controller);
                break;
            case "4":
                findByIdStudent(reader, controller);
                break;
            case "5":
                findAllStudent(reader, controller);
                break;
        }
        this.runNavigation();
    }

    private void createStudent(BufferedReader reader, StudentController controller) {
        println("StudentController.create");
        try {
            Student student = new Student();
            student.setName(getString(reader, "Please, enter  Name:"));
            student.setSurname(getString(reader, "Please, enter  Surname:"));
            println(controller.create(student));
        } catch (IOException e) {
            println("problem: = " + e.getMessage());
        }
    }

    private void updateStudent(BufferedReader reader, StudentController controller) {
        println("StudentController.update");
        try {
            Student student = new Student();
            student.setId(getString(reader, "Please, enter id"));
            student.setName(getString(reader, "Please, enter your Name:"));
            student.setSurname(getString(reader, "Please, enter your Surname:"));
            println(controller.update(student));
        } catch (IOException e) {
            println("problem: = " + e.getMessage());
        }
    }

    private void deleteStudent(BufferedReader reader, StudentController controller) {
        try {
            println(controller.delete(getString(reader, "Please, enter id")));
        } catch (IOException e) {
            println("problem: = " + e.getMessage());
        }
    }

    private void findByIdStudent(BufferedReader reader, StudentController controller) {
        println("StudentController.findById");
        try {
            Student student = controller.findById(getString(reader, "Please, enter id"));
            if (null == student) {
                println("student = not found");
            } else {
                println("student = " + student);
            }
        } catch (IOException e) {
            println("problem: = " + e.getMessage());
        }
    }

    private void findAllStudent(BufferedReader reader, StudentController controller) {
        println("StudentController.findAll");
        Student[] students = controller.findAll();
        if (null != students && students.length != 0) {
            for (Student student : students) {
                println("student = " + student.toString());
            }
        } else {
            println("student empty");
        }
    }

    private String getString(BufferedReader reader, String messageLine) throws IOException {
        println(messageLine);
        return reader.readLine();
    }
}
