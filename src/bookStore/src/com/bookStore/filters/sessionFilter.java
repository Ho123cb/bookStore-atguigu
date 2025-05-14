package com.bookStore.filters;

import com.atguigu.myssm.util.StringUtil;
import com.bookStore.pojo.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebFilter(urlPatterns = {"*.do", "*.html"},
        initParams = {
                @WebInitParam(name = "bai",
                        value = "/user.do?operate=logOut,/page.do?operate=page&page=user/login,/user.do?null,/user.do?operate=cookieLogin")
        })
public class sessionFilter implements Filter {
    private List<String> bai;

    @Override
    public void init(FilterConfig filterConfig) {
        String baiStr = filterConfig.getInitParameter("bai");
        bai = List.of(baiStr.split(","));
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {

        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpSession session = request.getSession();

        String requestURI = request.getRequestURI();
        String queryString = request.getQueryString();
        String fullRequest = requestURI + "?" + (queryString != null ? queryString : "null");
        System.out.println("当前访问路径：" + fullRequest);

        // 如果当前请求为白名单，直接放行
        if (bai.contains(fullRequest)) {
            filterChain.doFilter(request, response);
            return;
        }

        User user = (User) session.getAttribute("user");
        if (user == null) {
            // 检查Cookie
            String name = null, pwd = null;
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie c : cookies) {
                    if ("name".equals(c.getName())) {
                        name = c.getValue();
                    } else if ("pwd".equals(c.getName())) {
                        pwd = c.getValue();
                    }
                }
            }

            // 如果cookie有效，尝试自动登录
            if (StringUtil.isNotEmpty(name) && StringUtil.isNotEmpty(pwd)) {
                session.setAttribute("user",new User(name,pwd));
                response.sendRedirect(request.getContextPath() + "/user.do?operate=cookieLogin&uname="
                        + name + "&pwd=" + pwd);
                return;  // 注意这里要return，避免继续执行下面代码
            }

            // 如果cookie无效或不存在，不做强制登录，允许访问当前页面
            filterChain.doFilter(request, response);
        } else {
            // 用户已登录，更新cookie
            Cookie nameCookie = new Cookie("name", user.getUname());
            Cookie pwdCookie = new Cookie("pwd", user.getPwd());
            nameCookie.setMaxAge(60 * 60); // 1小时
            pwdCookie.setMaxAge(60 * 60);
            response.addCookie(nameCookie);
            response.addCookie(pwdCookie);

            filterChain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {

    }
}
