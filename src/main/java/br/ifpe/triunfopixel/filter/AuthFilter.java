package br.ifpe.triunfopixel.filter;

import br.ifpe.triunfopixel.util.Util;
import br.ifpe.triunfopixel.model.Usr;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebFilter(filterName = "AuthFilter", urlPatterns = { "*.xhtml" })
public class AuthFilter implements Filter {
    
    public AuthFilter() {
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        try {
            HttpServletRequest httpRequest = (HttpServletRequest) request;
            HttpServletResponse httpResponse = (HttpServletResponse) response;
            httpRequest.setCharacterEncoding("UTF-8");

            Usr loginPerson = Util.getLoginUSer(httpRequest);
            String reqURL = httpRequest.getServletPath();
            
            System.out.println(httpRequest.getContextPath());
            if (loginPerson == null) {
                if (!reqURL.contains(Util.LOGIN_PAGE)) {
                    httpResponse.sendRedirect(httpRequest.getContextPath() + Util.LOGIN_PAGE);
                }
            } else {
                httpResponse.sendRedirect(httpRequest.getContextPath() + Util.HOME_PAGE);
            }
            
            

            chain.doFilter(httpRequest, httpResponse);
        } catch (Exception t) {
            System.err.println(t.getMessage());
        }
    }


    @Override
    public void destroy() {
    }
}
