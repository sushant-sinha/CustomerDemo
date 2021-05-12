package com.example.demo.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

// add @Order(1) 2or3 to set the order of execution of filters
@Component
public class MyFilter3 implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        System.out.println("Filter 3 is called");
        filterChain.doFilter(servletRequest, servletResponse);

    }
}
