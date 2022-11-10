package mk.finki.ukim.mk.wplab.web.servlet;


import mk.finki.ukim.mk.wplab.service.BalloonService;
import org.thymeleaf.Thymeleaf;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "balloon-list-servlet", urlPatterns = "/list")
public class BalloonListServlet extends HttpServlet {

    public final SpringTemplateEngine springTemplateEngine;
    private final BalloonService balloonService;


    public BalloonListServlet(SpringTemplateEngine springTemplateEngine, BalloonService balloonService) {
        this.springTemplateEngine = springTemplateEngine;
        this.balloonService = balloonService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        WebContext context = new WebContext(req, resp, req.getServletContext());
        context.setVariable("balloons", balloonService.listAll());
        this.springTemplateEngine.process("listBalloons.html", context, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.setAttribute("color",req.getParameter("color"));
        resp.sendRedirect("/selectBalloon");
    }
}
