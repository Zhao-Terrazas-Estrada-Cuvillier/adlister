package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.EditAdServlet", urlPatterns = "/ads/update")
public class UpdateAdServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
        }
        Ad adtoEdit = DaoFactory.getAdsDao().getAdByID(Long.parseLong(request.getParameter("ad_id")));

        request.setAttribute("ad", adtoEdit);
        request.getRequestDispatcher("/WEB-INF/ads/update.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        long ad_id = Long.parseLong(request.getParameter("ad_id"));
        System.out.println(ad_id);
        Ad adToEdit = DaoFactory.getAdsDao().getAdByID(ad_id);
        String title_update = request.getParameter("title");
        String description_update = request.getParameter("description");
        //validate input
        boolean inputHasErrors = title_update.isEmpty() || description_update.isEmpty();
        if (inputHasErrors) {
            request.setAttribute("error", "title or description can't be empty");
            request.getRequestDispatcher("/WEB-INF/ads/update.jsp").forward(request, response);
            return;
        }
        adToEdit.setId(ad_id);
        adToEdit.setTitle(title_update);
        adToEdit.setDescription(description_update);
        DaoFactory.getAdsDao().updateAd(adToEdit);
        response.sendRedirect("/profile");
    }
}