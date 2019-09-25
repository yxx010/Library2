package servlet;

import model.Book;
import service.LibServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/AddBookServlet")
public class AddBookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LibServiceImpl libService=new LibServiceImpl();
        String id=request.getParameter("id");
        String bookName=request.getParameter("bookName");
        String categoryName=request.getParameter("categoryName");
        String price=request.getParameter("price");
        String description=request.getParameter("description");
        if(!libService.bookIsExist(id,bookName)){
            Book book=new Book(id,bookName,categoryName,price,description);
            libService.addBook(book);
            response.getWriter().println("添加成功");
            response.sendRedirect("/showBooks.html");
        }else {
            response.getWriter().println("该书已存在");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
