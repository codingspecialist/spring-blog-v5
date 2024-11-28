package com.metacoding.authblog._core.filter;

import jakarta.servlet.*;

import java.io.IOException;

public class MerongFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("메롱");
    }
}
