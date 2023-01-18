package pers.klochkov.firstApp.controller;


import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
    static HashMap<String, String> map = new HashMap<>();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        map.put("asd", "123");
        super.service(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        writer.println("Vova");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("username");
        String password = req.getParameter("password");
        if (map.containsKey(name)){
//            PrintWriter writer = resp.getWriter();
//            writer.println("Vova");
            req.getRequestDispatcher("./view/inner.jsp").forward(req, resp);
        }else resp.sendError(410);

    }

    public static void main(String[] args) {
        System.out.println(map);
    }
}
