package br.com.fiap.FarmaNear_Patient.infra.security;

import br.com.fiap.FarmaNear_Patient.usecases.security.TokenUseCase;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    private static final String AUTHENTICATION_SCHEME = "Bearer ";

    private final TokenUseCase tokenUseCase;

    @Autowired
    public SecurityFilter(TokenUseCase tokenUseCase) {
        this.tokenUseCase = tokenUseCase;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        String token = getAuthenticationToken(request);

        if (token != null) {
            String subject = tokenUseCase.getSubject(token);

            Authentication authentication = new UsernamePasswordAuthenticationToken(subject, null, List.of());
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

        filterChain.doFilter(request, response);
    }

    private String getAuthenticationToken(HttpServletRequest request) {
        String authorizationHeader = request.getHeader("Authorization");
        if (authorizationHeader != null) {
            return authorizationHeader.replace(AUTHENTICATION_SCHEME, "");
        }
        return null;
    }
}