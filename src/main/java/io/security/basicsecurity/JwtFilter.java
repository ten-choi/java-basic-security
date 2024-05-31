package io.security.basicsecurity;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;
import java.io.IOException;

//@RequiredArgsConstructor
//@Component
//public class JwtFilter extends GenericFilterBean {
//
//    private static final Logger logger = LoggerFactory.getLogger(JwtFilter.class);
//
//    public static final String AUTHORIZATION_HEADER = "Authorization";
//
//    private TokenProvider jwtProvider;
//
//    public
//
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//
//    }
//}