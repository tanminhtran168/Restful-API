package com.hust.baseweb.security;

import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Order(1)
public class TestFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //System.out.println(((HttpServletRequest) servletRequest).getRequestURI());
        String pw = servletRequest.getParameter("password");
        if (pw != null && pw.equals("itstudent"))
                filterChain.doFilter(servletRequest, servletResponse);
        else ((HttpServletResponse) servletResponse).setStatus(401);
    }
}
