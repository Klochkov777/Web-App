package pers.klochkov.firstApp.service;

import pers.klochkov.firstApp.dao.UserDao;

public class ReviserData {


    public boolean isValidDataSignUp(String name, String password, String login) {
        return !isDataEmpty(name, password, login) && !isContainSameLogin(login) /*&& isValidPasswordSignUp(password)*/;
    }

    public boolean isDataEmpty(String name, String password, String login) {
        return (name.equals("") || password.equals("") || login.equals(""));
    }

    public boolean isValidPasswordSignUp(String password) {
        String pat = "(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9@#$%]).{4,8}";
        return password.matches(pat);
    }

    public boolean isContainSameLoginAndPassword(String login, String password){
        return isContainSamePassword(password) && isContainSameLogin(login);
    }

    public boolean isContainSameLogin(String login) {
        //System.out.println(UserDao.getUserDao().getListUser().get(UserDao.getUserDao().getListUser().size()));
        return UserDao.getUserDao().getListUser().stream().anyMatch(user -> user.getLogin().equals(login));

    }
    private boolean isContainSamePassword(String password) {
        return UserDao.getUserDao().getListUser().stream().anyMatch(user -> user.getLogin().equals(password));
    }

}
