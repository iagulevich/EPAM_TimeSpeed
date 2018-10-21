package controllers;

import domain.Speed;
import services.Converter;
import support.identifiers.SpeedUnit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static support.constants.Constants.SPACE;

@WebServlet("/service")
public class ServiceController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String strValue = req.getParameter("field");
        String strUnit = req.getParameter("selectFrom");

        String selectTo = req.getParameter("selectTo");
        SpeedUnit speedUnit = SpeedUnit.getUnit(selectTo);

        req.setAttribute("field", strValue);
        req.setAttribute("resultValue", new Converter().apply(strValue + SPACE + strUnit, speedUnit));

        getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}
