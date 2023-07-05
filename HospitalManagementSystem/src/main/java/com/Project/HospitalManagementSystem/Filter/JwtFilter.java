/*
 * Author Name: Philip Meshach
 * Date: 03-07-2023
 * Praise The Lord
 */
package com.Project.HospitalManagementSystem.Filter;

import javax.servlet.*;
import io.jsonwebtoken.Jwts;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.filter.GenericFilterBean;

import java.io.IOException;

public class JwtFilter  extends GenericFilterBean {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        String authHeader = httpServletRequest.getHeader("Authorization");
        ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();
        if (authHeader == null || !authHeader.startsWith("Bearer")) {
            httpServletResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            servletOutputStream.print("Invalid Token");
            servletOutputStream.close();
        } else {
            String jwt = authHeader.substring(7);
            String name = Jwts.parser().setSigningKey("security key").parseClaimsJws(jwt).getBody().getSubject();
            httpServletRequest.setAttribute("Name", name);
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }
}
