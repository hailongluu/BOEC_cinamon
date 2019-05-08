package group.faf.bookstore.controller;

import group.faf.bookstore.model.product.book.Book;
import group.faf.bookstore.model.product.book.BookDAOImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DetailController", urlPatterns = "/detail")
public class DetailController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BookDAOImpl bookDAO = new BookDAOImpl();
        Book book = bookDAO.getBookById(Integer.parseInt(request.getParameter("id")));
        request.setAttribute("book", book);
        RequestDispatcher dispatcher = request.getRequestDispatcher("detail.jsp");
        dispatcher.forward(request,response);
    }
}
