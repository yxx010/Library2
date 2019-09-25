package servlet;

import com.alibaba.fastjson.JSON;
import service.LibServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet( "/SelectCategoryServlet")
public class SelectCategoryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LibServiceImpl libService=new LibServiceImpl();
        List<Map<String,Object>> list=libService.getAllBookCategory();
        String json= JSON.toJSONString(list);
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().println(json);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
