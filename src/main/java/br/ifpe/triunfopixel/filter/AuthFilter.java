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
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(filterName = "AuthFilter", urlPatterns = { "/*" })
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
            httpRequest.setCharacterEncoding("UTF-8");

            Usr loginPerson = Util.getLoginUSer(httpRequest);
            String reqURL = httpRequest.getServletPath();
            if (loginPerson == null) {
                if (!reqURL.contains(Util.LOGIN_PAGE)) {
                    ((HttpServletResponse) response).sendRedirect(Util.LOGIN_PAGE);
                }
            }

            chain.doFilter(request, response);
        } catch (IOException | ServletException t) {
            System.err.println(t.getMessage());
        }
    }

    @Override
    public void destroy() {
    }
}
