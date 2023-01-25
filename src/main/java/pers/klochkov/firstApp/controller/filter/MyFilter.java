package pers.klochkov.firstApp.controller.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String pathLoginURI = request.getContextPath() + "/login";
        String pathSignUpURI = request.getContextPath() + "/signUp";

        HttpSession session = request.getSession(false);

        boolean isLogged = session != null && session.getAttribute("user") != null;
        boolean isLoginUri = request.getRequestURI().equals(pathLoginURI);
        boolean isSignUpURI = request.getRequestURI().equals(pathSignUpURI);

        if (isLogged || isLoginUri || isSignUpURI) {
            filterChain.doFilter(servletRequest, servletResponse);
        }else {
            response.sendRedirect(pathLoginURI); }
    }

    @Override
    public void destroy() {
    }
}
