package servlet;

import com.alibaba.fastjson.JSON;
import model.Book;
import service.BookServiceImpl;
import service.LibServiceImpl;

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
        Book book=null;
        String bookID=request.getParameter("bookID");
        String categoryName=request.getParameter("categoryName");
        if(bookID!=null){
                book=bookService.getBookByBookId(bookID);
        }
        if(categoryName!=null){
           list=bookService.getBooksByCategoryName(categoryName);
        }
        if(book!=null){
            if(list!=null){
                list.clear();
                list.add(book);
            }
        }
        String json= JSON.toJSONString(list);
        response.getWriter().println(json);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
