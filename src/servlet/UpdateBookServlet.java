package servlet;

import model.Book;
import service.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updateBook")
public class UpdateBookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String bookId=request.getParameter("bookId");
        BookServiceImpl bookService=new BookServiceImpl();
        Book book=bookService.getBookByBookId(bookId);
        request.setAttribute("book",book);
        request.setAttribute("updateFlag","1");
        request.getRequestDispatcher("/addBook.jsp?updateFlag=1").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
