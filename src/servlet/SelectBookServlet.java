package servlet;

import com.alibaba.fastjson.JSON;
import model.Book;
import service.LibServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/SelectBookServlet")
public class SelectBookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LibServiceImpl libService=new LibServiceImpl();
        String bookID=request.getParameter("bookID");
        System.out.println("ID是"+bookID);
        String bookName=request.getParameter("bookName");
        System.out.println("name是"+bookName);
        String categoryName=request.getParameter("categoryName");
        List<Book> list=libService.getBooksByCondition(bookID,bookName,categoryName);
        String json= JSON.toJSONString(list);
        response.getWriter().println(json);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
