package ru.alexandergolovnya.security.filter;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import ru.alexandergolovnya.security.token.TokenAuthentication;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author: Alexander Golovnya <mail@alexandergolovnya.ru>
 * @created: 2019/09/04
 */
@Component
public class TokenAuthenticationFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) {
    }

    /**
     * Method receives token parameter from the request header,
     * if token is not null sends it creates tokenAuthentication objects
     * and sends it to security context holder, which delegates it to token authentication provider
     *
     * @param servletRequest
     * @param servletResponse
     * @param filterChain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        final String authorizationHeader = ((HttpServletRequest) servletRequest).getHeader("Authorization");
        if (authorizationHeader != null) {
            String tokenString = authorizationHeader.substring("Bearer ".length());
            TokenAuthentication tokenAuthentication = new TokenAuthentication(tokenString);
            SecurityContextHolder.getContext().setAuthentication(tokenAuthentication);
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
