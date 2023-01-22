package pers.klochkov.firstApp.controller.servlet;

import pers.klochkov.firstApp.model.User;
import pers.klochkov.firstApp.service.ReviserData;
import pers.klochkov.firstApp.service.UsersService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Optional;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {

    UsersService usersService = new UsersService();
    ReviserData reviserData = new ReviserData();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String password = req.getParameter("password");
        String login = req.getParameter("login");
        Optional<User> optionalUser = usersService.getUserByLoginAndPassword(login, password);
        if (optionalUser.isPresent()) {
            HttpSession session = req.getSession();
            session.setAttribute("user", optionalUser.get());
            req.getRequestDispatcher("/home").forward(req, resp);
        } else {
            sendErrorWrongEnterData(login, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/login.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
    }

    private void sendErrorWrongEnterData(String login, HttpServletResponse response) throws IOException {
        if (!reviserData.isContainSameLogin(login)){
            response.sendError(401, "You are not registered");}
        else response.sendError(401, "Your password is wrong");
    }
}
