package ru.ivmiit.filtres;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Макс on 02.05.2018.
 */

@WebFilter("/addCar")

public class AddCarFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        HttpSession session = req.getSession(false);

        if( session == null || session.getAttribute("user") == null){
            req.getServletContext().getRequestDispatcher("/jsp/login.jsp").forward(req, resp);
        }

        filterChain.doFilter(req, resp);

    }

    @Override
    public void destroy() {

    }
}

