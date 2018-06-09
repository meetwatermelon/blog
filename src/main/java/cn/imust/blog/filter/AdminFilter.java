package cn.imust.blog.filter;

import cn.imust.blog.entity.BlogUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 进入后台负责过滤是否是管理员
 */
@Component
public class AdminFilter implements Filter {

    private static final Logger logger = LoggerFactory.getLogger(AdminFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        StringBuffer url = request.getRequestURL();
        String s = url.substring(url.lastIndexOf("/"));
        logger.info("后台管理员拦截");
        if ("/admin".equals(s)) {
            BlogUser user = (BlogUser) request.getSession().getAttribute("user");
            if (user != null && user.isAdmin()) {
                //放行
                filterChain.doFilter(request, response);
            } else {
                response.sendRedirect("/blog/index");
            }
        }else{
            filterChain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {

    }
}
