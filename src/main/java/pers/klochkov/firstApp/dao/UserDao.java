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
                }
            }
        }
        return localInstance;
    }

    public User createUser(String name, String login, String password) {
        long id = listUser.size() + 1;
        User user = new User(name, login, password, id);
        listUser.add(user);
         return user;
    }
    public User readUser(String login) {
        User user = listUser.stream().filter(user1 -> user1.getLogin().equals(login)).findFirst().get();
        return user;
    }
    public User updateUser() {
        return null;
    }
    public User deleteUser(String login) {
        User user = listUser.stream().filter(user1 -> user1.getLogin().equals(login)).findFirst().get();
        listUser.remove(user);
        return user;
    }

    public List<User> getListUser() {
        return listUser;
    }


}
