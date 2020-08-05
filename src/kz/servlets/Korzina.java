package kz.servlets;

import kz.db.DBManager;
import kz.db.Items;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/korzinaitems")
public class Korzina extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        ArrayList<Items> korzina=(ArrayList<Items>)session.getAttribute("korzina");
        session.setAttribute("korzina",korzina);
        request.getRequestDispatcher("/korzina.jsp").forward(request,response);
    }
}
