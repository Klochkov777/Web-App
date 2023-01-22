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


}
