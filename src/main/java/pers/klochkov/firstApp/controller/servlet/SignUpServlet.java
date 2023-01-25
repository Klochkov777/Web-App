package pers.klochkov.firstApp.controller.servlet;
import pers.klochkov.firstApp.service.UsersService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SignUp", value = "/signUp")
public class SignUpServlet extends HttpServlet {

    UsersService usersService = new UsersService();

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
        boolean isValidDataSignUp = usersService.isValidDataSignUp(name, password, login);
        if (!isValidDataSignUp) {
            req.setAttribute("isValidData", false);
            req.getRequestDispatcher("/signUp.jsp").forward(req, resp);
        }
        else {
            createUser(name, password, login, resp);
        }
    }

    private void createUser(String name, String password, String login, HttpServletResponse resp) throws IOException {
        if (!usersService.isUserCreated(name, login, password)) {
            resp.sendError(401, "User have not been created");
        }
        resp.sendRedirect("/home");
    }
}
