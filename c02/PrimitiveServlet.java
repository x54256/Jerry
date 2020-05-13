package cn.x5456.catalina.c02;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author yujx
 * @date 2020/04/30 17:03
 */
public class PrimitiveServlet implements Servlet {
    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("初始化！");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        PrintWriter writer = res.getWriter();
        writer.println("Hello,World!");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("销毁方法，我都忘了什么时候会调用了。。");
    }
}
