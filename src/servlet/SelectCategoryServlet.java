package servlet;

import com.alibaba.fastjson.JSON;
import model.Category;
import service.CategoryServiceImpl;
import service.LibServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet( "/selectCategory")
public class SelectCategoryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CategoryServiceImpl categoryService=new CategoryServiceImpl();
        List<Category> list=categoryService.getCategoryList();
        String json= JSON.toJSONString(list);
        //request.setAttribute("categoryList",list);
        //request.getRequestDispatcher("/categoryList.jsp").forward(request,response);

        response.setContentType("text/html;charset=utf-8");
        response.getWriter().println(json);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
