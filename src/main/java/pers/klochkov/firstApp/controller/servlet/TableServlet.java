package pers.klochkov.firstApp.controller.servlet;

import pers.klochkov.firstApp.dao.UserDao;
import pers.klochkov.firstApp.dto.UserDto;
import pers.klochkov.firstApp.model.User;
import pers.klochkov.firstApp.service.UsersService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(value = "/table")
public class TableServlet extends HttpServlet {

    UsersService usersService = new UsersService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("entered");
        List<UserDto> listUserDto = usersService.getListUsersDto();
        req.setAttribute("users", listUserDto);
        req.getRequestDispatcher("/table.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("entered");
        req.getRequestDispatcher("/table.jsp").forward(req, resp);
    }
}
