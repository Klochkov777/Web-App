package pers.klochkov.firstApp.controller;

import pers.klochkov.firstApp.controller.listner.AppContextListener;
import pers.klochkov.firstApp.dao.UserDao;
import pers.klochkov.firstApp.model.User;
import pers.klochkov.firstApp.service.UsersService;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/getList")
public class ListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UserDao userDao = UserDao.getUserDao();
        List<User> userList = userDao.getListUser();
        ServletContext servletContext = getServletContext();
        userList.add(new User("gens", "555", "123", 2l));

        req.setAttribute("users", userList);
        req.setAttribute("name", "vova");
        req.setAttribute("age", 34);
        req.getRequestDispatcher("/view/tableUsers.jsp").forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
