package servlet;

import service.LibServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/AddCategoryServlet")
public class AddCategoryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long id=Long.parseLong(request.getParameter("id"));
        String categoryName=request.getParameter("categoryName");
        String description=request.getParameter("description");
        LibServiceImpl libService=new LibServiceImpl();
        if(!libService.categoryIsExist(id,categoryName)){
            libService.addBookCategory(id,categoryName,description);
            response.getWriter().println("添加成功！");
        }else{
            response.getWriter().println("该分类已存在！");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
