package com.eldery.crm.config;

import org.springframework.context.annotation.Configuration;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Configuration
@WebFilter
public class CorsFilter implements Filter {
    private final String HEADERS = "Content-Type, x-requested-with, X-Custom-Header, Authorization";
    private final String METHODS = "POST, GET, OPTIONS, DELETE";

    @Override
    public void init(FilterConfig filterConfig) {
        System.out.println("init filter");

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) res;
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", METHODS);
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", HEADERS);
        if ("OPTIONS".equalsIgnoreCase(((HttpServletRequest) req).getMethod())) {
            response.setStatus(HttpServletResponse.SC_OK);
        } else {
            chain.doFilter(req, res);
        }

    }

    @Override
    public void destroy() {
        System.out.println("filter destroy");

    }

}