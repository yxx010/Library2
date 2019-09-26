package servlet;


import service.CategoryServiceImpl;
import service.LibServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addCategory")
public class AddCategoryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id=request.getParameter("categoryId");
        String categoryName=request.getParameter("categoryName");
        CategoryServiceImpl categoryService=new CategoryServiceImpl();
        if(!categoryService.categoryIdIsExist(id)){
            categoryService.addCategory(id,categoryName);
            response.getWriter().println("添加成功!s");
            response.sendRedirect("/SelectCategory");
        }else{
            response.getWriter().println("该分类已存在!f");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
