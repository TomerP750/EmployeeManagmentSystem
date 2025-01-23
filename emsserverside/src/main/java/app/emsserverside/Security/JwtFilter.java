package app.emsserverside.Security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.annotation.Order;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Order(1)
public class JwtFilter extends OncePerRequestFilter {

    private SessionManager sessionManager;

    public JwtFilter(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//        try {
//            String authHeader = request.getHeader("Authorization");
//
//        } catch () {
//
//        }
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        if (request.getServletPath().startsWith("/auth")) {
            return true;
        }
        return false;
    }
}
