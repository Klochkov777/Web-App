package pers.klochkov.firstApp.controller.servlet;

import pers.klochkov.firstApp.dao.UserDao;
import pers.klochkov.firstApp.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(value = "/table")
public class TableServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("entered");
        List<User> list = UserDao.getUserDao().getListUser();
        req.setAttribute("users", list);
        req.getRequestDispatcher("/table.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("entered");
        req.getRequestDispatcher("/table.jsp").forward(req, resp);
    }
}
