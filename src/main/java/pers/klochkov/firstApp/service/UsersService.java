package pers.klochkov.firstApp.service;

import pers.klochkov.firstApp.dao.UserDao;
import pers.klochkov.firstApp.dto.UserDto;
import pers.klochkov.firstApp.model.User;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class UsersService {
    public List<UserDto> setAttributeUsersDto(HttpServletRequest request) {
        UserDao userDao = UserDao.getUserDao();
        List<UserDto> list = userDao.getListUser().stream().map(user -> new UserDto(user.getLogin(), user.getName())).toList();
        return list;
    }

    public List<UserDto> getListUsersDto() {
        return UserDao.getUserDao().getListUser().stream().map(user -> new UserDto(user.getLogin(), user.getName())).toList();
    }

    public Optional<User> getUserByLoginAndPassword(String login, String password) {
        return UserDao.getUserDao().getListUser().stream()
                .filter(user1 -> (user1.getLogin().equals(login) && user1.getPassword().equals(password))).findFirst();

    }

    public boolean isValidDataSignUp(String name, String password, String login) {
        return !isDataEmpty(name, password, login) && !isContainSameLogin(login) /*&& isValidPasswordSignUp(password)*/;
    }

    public boolean isDataEmpty(String name, String password, String login) {
        return (name.equals("") || password.equals("") || login.equals(""));
    }

//    public boolean isValidPasswordSignUp(String password) {
//        String pat = "(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9@#$%]).{4,8}";
//        return password.matches(pat);
//    }

    public boolean isContainSameLoginAndPassword(String login, String password){
        return isContainSamePassword(password) && isContainSameLogin(login);
    }

    public boolean isContainSameLogin(String login) {
        return UserDao.getUserDao().getListUser().stream().anyMatch(user -> user.getLogin().equals(login));

    }

    private boolean isContainSamePassword(String password) {
        return UserDao.getUserDao().getListUser().stream().anyMatch(user -> user.getLogin().equals(password));
    }

    public boolean isUserCreated(String name, String login, String password) {
        User user = UserDao.getUserDao().createUser(name, login, password);
        return user != null;
    }


}
