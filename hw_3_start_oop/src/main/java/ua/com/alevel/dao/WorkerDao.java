package ua.com.alevel.dao;

import ua.com.alevel.db.WorkerDB;
import ua.com.alevel.entity.Worker;

import static ua.com.alevel.db.WorkerDB.generateId;

public class WorkerDao {
    private static final WorkerDB db = new WorkerDB();

    public void create(Worker worker) {

        db.create(worker);
    }

    public static Worker findById(String id) {
        return db.findById(id);
    }

    public  Worker[] findAll() {
        return db.findAll();
    }

    public void update(Worker worker) {
        db.update(worker);
    }

    public void delete(String id) {
        db.delete(id);
    }


}
