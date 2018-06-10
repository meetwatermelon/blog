package cn.imust.blog.filter;

import cn.imust.blog.entity.BlogUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class CommentFilter implements Filter {

    private static final Logger logger = LoggerFactory.getLogger(CommentFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        StringBuffer url = request.getRequestURL();
        String s = url.substring(url.lastIndexOf("/") + 1);
        if(s.contains("Comment")){
            logger.info("评论拦截");
            BlogUser user = (BlogUser) request.getSession().getAttribute("user");
            if( user == null){
                response.sendRedirect("/blog/loginForm");
            }else{
                filterChain.doFilter(request, response);
            }
        }else{
            filterChain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {

    }
}
