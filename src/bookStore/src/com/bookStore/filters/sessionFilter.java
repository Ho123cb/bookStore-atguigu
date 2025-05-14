package com.bookStore.filters;

import com.bookStore.pojo.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebFilter(urlPatterns = {"*.do","*.html"},
        initParams = {
                @WebInitParam(name = "bai",
                        value = "/book.do?null,/page.do?operate=page&page=user/login,/user.do?null")
        })
public class sessionFilter implements Filter {
    List<String> bai;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String baiStr = filterConfig.getInitParameter("bai");
        String[] baiS = baiStr.split(",");
        bai = List.of(baiS);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpServletRequest request = (HttpServletRequest) servletRequest;

        String requestURI = request.getRequestURI();
        String queryString = request.getQueryString();
        String RQstr= requestURI+"?"+queryString;
        System.out.println(RQstr);
        if(bai.contains(RQstr)) {
            filterChain.doFilter(servletRequest,servletResponse);
        }
        else {
            HttpSession session = request.getSession();
            User user = (User)session.getAttribute("user");
            if(user == null) {
                response.sendRedirect("/page.do?operate=page&page=user/login");
            }else {
                filterChain.doFilter(servletRequest,servletResponse);
            }
        }

    }

    @Override
    public void destroy() {

    }
}
