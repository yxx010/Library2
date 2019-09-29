package servlet;

import com.alibaba.fastjson.JSON;
import model.Category;
import service.CategoryServiceImpl;
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
        String type=request.getParameter("type");
        //type不为null时，返回json，给addbook查询ajax分类使用
        if(type!=null){
            String json= JSON.toJSONString(list);
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().println(json);
        }else {
            request.setAttribute("categoryList",list);
            request.getRequestDispatcher("/categoryList.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
