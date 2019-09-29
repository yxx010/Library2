package servlet;

import model.Book;
import model.Category;
import service.BookServiceImpl;
import service.CategoryServiceImpl;
import service.LibServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addBook")
public class AddBookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BookServiceImpl bookService=new BookServiceImpl();
        String id=request.getParameter("bookId");
        String bookName=request.getParameter("bookName");
        String categoryId=request.getParameter("categoryId");
        CategoryServiceImpl categoryService=new CategoryServiceImpl();
        Category category=categoryService.searchCategoryById(categoryId);
        String price=request.getParameter("bookPrice");
        //bookPic
        String description=request.getParameter("remarks");
        if(bookService.getBookByBookId(id)==null){
            Book book=new Book(id,bookName,category,price,description);
            bookService.addBook(book);
            response.getWriter().println("添加成功");
            response.sendRedirect("/searchBook");
        }else {
            response.getWriter().println("该书已存在");
            response.sendRedirect("/addBook.jsp");

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
