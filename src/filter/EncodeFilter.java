package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "EncodeFilter")
public class EncodeFilter implements Filter {
    private FilterConfig config;

    public FilterConfig getConfig() {
        return config;
    }

    public void setConfig(FilterConfig config) {
        this.config = config;
    }

    public void destroy() {
        System.out.println("characterEncodingFilter destroy");
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        req.setCharacterEncoding(config.getInitParameter("charset"));
        //resp.setCharacterEncoding(config.getInitParameter("charset"));// 设置response字符编码
        resp.setContentType("text/html;charset=utf-8");

        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {
        this.config=config;
        System.out.println("characterEncodingFilter init");

    }

}
