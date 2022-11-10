package mk.finki.ukim.mk.wplab.web.servlet;

import mk.finki.ukim.mk.wplab.service.OrderService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "confirmation-servlet", urlPatterns = "/ConfirmationInfo")
public class ConfirmationInfoServlet extends HttpServlet {
    public final SpringTemplateEngine springTemplateEngine;
    public final OrderService orderService;

    public ConfirmationInfoServlet(SpringTemplateEngine springTemplateEngine, OrderService orderService) {
        this.springTemplateEngine = springTemplateEngine;
        this.orderService = orderService;
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WebContext context = new WebContext(req, resp, req.getServletContext());
        context.setVariable("ipAdress", req.getRemoteAddr());
        context.setVariable("userBrowser", req.getHeader("User-Agent"));
        HttpSession session = req.getSession();
        String color = (String) session.getAttribute("color");
        String clientName = (String) session.getAttribute("clientName");
        String clientAddress = (String) session.getAttribute("clientAddress");
        orderService.addNewOrder(color, clientName, clientAddress);
        springTemplateEngine.process("confirmationInfo.html", context, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().invalidate();
        resp.sendRedirect("/balloons");
    }
}
