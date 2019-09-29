package servlet;

import model.Book;
import service.BookServiceImpl;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/searchBook")
public class SelectBookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BookServiceImpl bookService=new BookServiceImpl();
        List<Book> list=null;
        String categoryName=request.getParameter("categoryName");

        if(categoryName!=null){
           list=bookService.getBooksByCategoryName(categoryName);
        }else{
            list=bookService.getBooks();
        }
        request.setAttribute("bookList",list);
        System.out.println(list);
        request.getRequestDispatcher("/bookList.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
