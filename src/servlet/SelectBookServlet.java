package servlet;

import com.alibaba.fastjson.JSON;
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
        Book book=null;
        String categoryName=request.getParameter("categoryName");
        String bookId=request.getParameter("bookId");
        //bookId不为空时，返回数据给ajax用
        if(bookId!=null){
            book=bookService.getBookByBookId(bookId);
            String json= JSON.toJSONString(book);
            response.getWriter().println(json);
        }else {
            if(categoryName!=null){
                list=bookService.getBooksByCategoryName(categoryName);
            }else{
                list=bookService.getBooks();
            }
            request.setAttribute("bookList",list);
            request.getRequestDispatcher("/bookList.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
