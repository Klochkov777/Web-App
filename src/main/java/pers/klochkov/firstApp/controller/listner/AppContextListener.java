package pers.klochkov.firstApp.controller.listner;

import pers.klochkov.firstApp.model.User;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.ArrayList;
import java.util.List;

@WebListener
public class AppContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        List<User> list = new ArrayList<>();
        list.add(new User("maxim", "max@", "123", 1l));
        servletContextEvent.getServletContext().setAttribute("lists", list);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
