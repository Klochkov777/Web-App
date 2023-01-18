package pers.klochkov.firstApp.dao;

import pers.klochkov.firstApp.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserDao {
    private static volatile UserDao instance;




    private List<User> listUser = new ArrayList<>();

    public static UserDao getUserDao() {
        UserDao localInstance = instance;
        if (localInstance == null) {
            synchronized (UserDao.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new UserDao();
                    instance.listUser.add(new User("vova","email","123", 1l));
                }
            }
        }
        return localInstance;
    }

    public User createUser() {
         return null;
    }
    public User readUser() {
        return null;
    }
    public User updateUser() {
        return null;
    }
    public User deleteUser() {
        return null;
    }

    public List<User> getListUser() {
        return listUser;
    }


}
