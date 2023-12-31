package com.anjali.hs.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.HandlerExceptionResolver;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor

public class JWTAuthFilter extends OncePerRequestFilter {
    @Autowired
    private final HandlerExceptionResolver handlerExceptionResolver;
    @Autowired
    private JWTService JWTService;
    public static String JWT_TOKEN;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        System.out.println("This is JWTAuthFilter."+request.getHeader("Authorization"));
        String authHeader = request.getHeader("Authorization");//Extracting the header.
        System.out.println(request.getMethod());
        String jwtToken = null;
        String userName;
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            System.out.println("No token found! - This is HS.");
            filterChain.doFilter(request, response);
            return;
        }
        jwtToken = authHeader.substring(7);
        JWT_TOKEN=jwtToken;


        try {
            userName = JWTService.extractUsername(jwtToken);
            System.out.println("Username : " + userName);
        } catch (Exception exception) {
            handlerExceptionResolver.resolveException(request, response, null, new RuntimeException("Invalid token : " + exception.getLocalizedMessage()));
            return;

        }
        //Checking of the username's not nullability  and the authentication status of the current user.
        if (userName != null && SecurityContextHolder.getContext().getAuthentication() == null) {

            if (JWTService.validateToken(jwtToken) && JWTService.getUserRole(jwtToken).equals("HA") || JWTService.getUserRole(jwtToken).equals("PDA") || JWTService.getUserRole(jwtToken).equals("PA") || JWTService.getUserRole(jwtToken).equals("VA") || JWTService.getUserRole(jwtToken).equals("UA")) {
                System.out.println("User role : "+JWTService.getUserRole(jwtToken));
                List<SimpleGrantedAuthority>simpleGrantedAuthorities=new ArrayList<>();
                simpleGrantedAuthorities.add(new SimpleGrantedAuthority(JWTService.getUserRole(jwtToken)));
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userName, null,simpleGrantedAuthorities);
                System.out.println("auth status: " + authToken.isAuthenticated());
                System.out.println("Here is user role : "+JWTService.getUserRole(jwtToken));
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }


        }
        filterChain.doFilter(request, response);
    }

}
