package ua.com.alevel.cotroller;

import ua.com.alevel.entity.Worker;
import ua.com.alevel.service.WorkerService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WorkerController {

    private final WorkerService workerService = new WorkerService();

    public void run() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("select your option");
        String position;
        try {
            runNavigation();
            while ((position = reader.readLine()) != null) {
                crud(position, reader);
                position = reader.readLine();
                if (position.equals("0")) {
                    System.exit(0);
                }
                crud(position, reader);
            }
        } catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    private void runNavigation() {
        System.out.println();
        System.out.println("if you want create worker, please enter 1");
        System.out.println("if you want update worker, please enter 2");
        System.out.println("if you want delete worker, please enter 3");
        System.out.println("if you want findById worker, please enter 4");
        System.out.println("if you want findAll worker, please enter 5");
        System.out.println("if you want exit, please enter 0");
        System.out.println();
    }

    private void crud(String position, BufferedReader reader) {
        switch (position) {
            case "1":
                create(reader);
                break;
            case "2":
                update(reader);
                break;
            case "3":
                delete(reader);
                break;
            case "4":
                findById(reader);
                break;
            case "5":
                findAll(reader);
                break;
        }
        runNavigation();
    }

    private void create(BufferedReader reader) {
        System.out.println("WorkerController.create");
        try {
            System.out.println("Please, enter your name");
            String name = reader.readLine();
            System.out.println("Please, enter your surname");
            String surname = reader.readLine();
            Worker worker = new Worker();
            worker.setFirstName(name);
            worker.setLastName(surname);
            workerService.create(worker);
        } catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    private void update(BufferedReader reader) {
        System.out.println("WorkerController.update");
        try {
            System.out.println("Please, enter id");
            String id = reader.readLine();
            System.out.println("Please, enter your name");
            String name = reader.readLine();
            System.out.println("Please, enter your surname");
            String surname = reader.readLine();
            Worker worker = new Worker();
            worker.setId(id);
            worker.setLastName(surname);
            worker.setFirstName(name);
            workerService.update(worker);
        } catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    private void delete(BufferedReader reader) {
        System.out.println("WorkerController.delete");
        try {
            System.out.println("Please, enter id");
            String id = reader.readLine();
            workerService.delete(id);
        } catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    private void findById(BufferedReader reader) {
        System.out.println("WorkerController.findById");
        try {
            System.out.println("Please, enter id");
            String id = reader.readLine();
            Worker worker = workerService.findById(id);
            System.out.println("worker = " + worker);
        } catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    private void findAll(BufferedReader reader) {
        System.out.println("WorkerController.findAll");
        Worker[] workers = workerService.findAll();
        if (workers != null && workers.length != 0) {
            for (int i = 0; i < workers.length; i++){
                System.out.println("worker = " + workers[i]);
            }
        } else {
            System.out.println("users empty");
        }
    }
}

