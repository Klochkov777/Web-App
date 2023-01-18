package pers.klochkov.firstApp.service;

import pers.klochkov.firstApp.dao.UserDao;
import pers.klochkov.firstApp.dto.UserDto;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class UsersService {
    public List<UserDto> setAttributeUsersDto(HttpServletRequest request) {
        UserDao userDao = UserDao.getUserDao();
        List<UserDto> list = userDao.getListUser().stream().map(user -> new UserDto(user.getLogin(), user.getName())).toList();
        return list;
    }
}
