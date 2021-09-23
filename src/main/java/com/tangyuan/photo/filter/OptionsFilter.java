package com.tangyuan.photo.filter;

import com.alibaba.druid.support.http.WebStatFilter;
import org.apache.catalina.connector.RequestFacade;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// 注入spring容器
@Component
// 定义filterName 和过滤的url
@WebFilter(filterName = "OptionsFilter", urlPatterns = "/*")
public class OptionsFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if (!((RequestFacade) servletRequest).getServletPath().startsWith("/file")){
            ((HttpServletResponse) servletResponse).setHeader("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
            ((HttpServletResponse) servletResponse).setHeader("Access-Control-Allow-Origin", "*");
            ((HttpServletResponse) servletResponse).setHeader("Access-Control-Allow-Headers", "Content-Type, accept, headers, Authorization");
            ((HttpServletResponse) servletResponse).setHeader("Access-Control-Max-Age", "1800");
            ((HttpServletResponse) servletResponse).setStatus(200);
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
