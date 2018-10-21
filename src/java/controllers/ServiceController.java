package controllers;

import domain.Speed;
import services.Converter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static support.constants.Constants.MS;
import static support.constants.Constants.SPACE;

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

        // req.setAttribute("result", req.getParameter("field"));
        String strValue = req.getParameter("field");
        String strUnit = req.getParameter("select");

        Speed speed = new Speed(strValue, strUnit);
        System.out.println(speed);

        req.setAttribute("field", strValue);
        req.setAttribute("resultValue", Converter.toMS(speed) + SPACE + MS);


        getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}
