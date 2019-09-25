package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "AuthFilter")
public class AuthFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest httpServletRequest=(HttpServletRequest)req;
        HttpServletResponse httpServletResponse=(HttpServletResponse)resp;
        String loginUser=(String)httpServletRequest.getSession().getAttribute("loginUser");
        if(loginUser==null){
            httpServletResponse.sendRedirect(httpServletRequest.getContextPath()+"index.jsp?needLogin=1");
            return;
        }else {
            chain.doFilter(httpServletRequest, httpServletResponse);
            return;

        }

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
