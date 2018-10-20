package controllers;

import sun.applet.Main;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/service")
public class ServiceController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //String res = req.getParameter("field");

        /*HttpSession session = req.getSession();
        session.setAttribute("result", res + " - doGet");*/

        req.setAttribute("result", req.getParameter("field"));

        getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);

        //System.out.println(res);
    }
}
