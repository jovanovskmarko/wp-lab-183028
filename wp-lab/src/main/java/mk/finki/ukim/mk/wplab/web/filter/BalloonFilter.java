package mk.finki.ukim.mk.wplab.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter
public class BalloonFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String path = request.getServletPath();

        String color = (String) request.getSession().getAttribute("color");

        System.out.println(path);
        if (color != null || path.contains("/balloons") || path.equals("/list")) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            response.sendRedirect("/balloons");
        }


    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
