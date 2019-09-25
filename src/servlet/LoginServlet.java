package servlet;


import service.LibServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        LibServiceImpl libService=new LibServiceImpl();
        if(libService.userIsExist(username)){
            if(libService.isLogin(username,password)){
                request.getSession().setAttribute("loginUser",username);
                response.sendRedirect(request.getContextPath()+"/server.html");
            }else {
                response.getWriter().println("账号信息错误");
            }
        }else{
            response.getWriter().println("该用户不存在!");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
