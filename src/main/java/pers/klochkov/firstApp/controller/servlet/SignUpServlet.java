package pers.klochkov.firstApp.controller.servlet;

import pers.klochkov.firstApp.dao.UserDao;
import pers.klochkov.firstApp.model.User;
import pers.klochkov.firstApp.service.ReviserData;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SignUp", value = "/signUp")
public class SignUpServlet extends HttpServlet {

    private ReviserData reviserData = new ReviserData();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/signUp.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String name = req.getParameter("name");
        boolean isValidDataSignUp = reviserData.isValidDataSignUp(name, password, login);
        if (!isValidDataSignUp) {
            req.setAttribute("isValidData", isValidDataSignUp);
            req.getRequestDispatcher("/signUp.jsp").forward(req, resp);
        }
        else {
            User user = UserDao.getUserDao().createUser(name, login, password);
            if (user == null) {
                resp.sendError(500, "User have not been created");
            }
            resp.sendRedirect("/home");
        }
    }
}
