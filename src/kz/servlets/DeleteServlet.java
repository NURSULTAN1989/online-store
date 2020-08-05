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

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id=Long.parseLong(request.getParameter("id"));
        HttpSession session=request.getSession();
        ArrayList<Items> korzina=(ArrayList<Items>)session.getAttribute("korzina");
        if (korzina!=null){
            for (Items kor:korzina) {
                if (kor.getId()==id){
                    korzina.remove(kor);
                    break;
                }
            }
        }

        session.removeAttribute("korzina");
        session.setAttribute("korzina",korzina);
        response.sendRedirect("/korzinaitems");



    }

}
