package ua.com.alevel.service;

import ua.com.alevel.dao.WorkerDao;
import ua.com.alevel.entity.Worker;

import static ua.com.alevel.db.WorkerDB.generateId;

public class WorkerService {
    private final WorkerDao workerDao = new WorkerDao();

    public void create(Worker worker) {
        worker.setId(generateId());
        workerDao.create(worker);
    }

    public Worker findById(String id) {
        return workerDao.findById(id);
    }

    public Worker[] findAll() {
        return workerDao.findAll();
    }

    public void update(Worker worker) {
        workerDao.update(worker);
    }

    public void delete(String id) {
        workerDao.delete(id);
    }

}
