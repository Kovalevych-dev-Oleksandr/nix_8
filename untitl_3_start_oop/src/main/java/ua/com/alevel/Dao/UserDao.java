package ua.com.alevel.Dao;

import ua.com.alevel.db.UserDB;
import ua.com.alevel.entiti.User;

import java.util.List;

public class UserDao {

    public void create(User user) {
        UserDB.getInstance().create(user);
    }

    public void update(User user) {
        UserDB.getInstance().update(user);
    }

    public void delete(String id) {
        UserDB.getInstance().delete(id);
    }

    public User findById(String id) {
        return UserDB.getInstance().findById(id);
    }

    public List<User> finalAll() {
        return UserDB.getInstance().finalAll();
    }

}
