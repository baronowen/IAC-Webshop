package Webservices.Authentication;

import java.io.IOException;

import javax.annotation.Priority;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.ext.Provider;
import javax.ws.rs.Priorities;

import Model.Account;
import Persistance.AccountController;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;

/**
 * Created by nickw on 7-3-2018.
 */
@Provider
@Priority(Priorities.AUTHENTICATION)
public class AuthenticationFilter implements ContainerRequestFilter {
    @Override

    public void filter(ContainerRequestContext requestCtx) throws IOException {
        // Users are treated as guests, unless a valid JWT is provided
        System.out.println("Starting filter...");
        boolean isSecure = requestCtx.getSecurityContext().isSecure();
        MySecurityContext msc = new MySecurityContext("Unknown", "guest", isSecure);
        // Check if the HTTP Authorization header is present and formatted
        // correctly
        String authHeader = requestCtx.getHeaderString(HttpHeaders.AUTHORIZATION);
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            // Extract the token from the HTTP Authorization header
            String token = authHeader.substring("Bearer".length()).trim();
            try {
                // Validate the token
                JwtParser parser = Jwts.parser().setSigningKey(AuthenticationResource.key);
                Claims claims = parser.parseClaimsJws(token).getBody();
                String user = claims.getSubject();
                String role = claims.get("role").toString();
                msc = new MySecurityContext(user, role, isSecure);
                System.out.println("Filter succes!...");
            } catch (JwtException | IllegalArgumentException e) {
                System.out.println("Invalid JWT, processing as guest!");
            }
        }
        requestCtx.setSecurityContext(msc);
    }

    public static Account getAccountFromHttpServletRequest(HttpServletRequest httpServletRequest) throws IOException {

        // Users are treated as guests, unless a valid JWT is provided
        System.out.println("Getting account from ContainerRequestContext");
        Account account = null;
        // Check if the HTTP Authorization header is present and formatted
        // correctly
        String authHeader = httpServletRequest.getHeader("Authorization");
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            // Extract the token from the HTTP Authorization header
            String token = authHeader.substring("Bearer".length()).trim();
            try {
                // Validate the token
                JwtParser parser = Jwts.parser().setSigningKey(AuthenticationResource.key);
                Claims claims = parser.parseClaimsJws(token).getBody();
                String user = claims.getSubject();
                account = Webservices.Resource.ACCOUNT_CONTROLLER.getAccountByEmail(user);
            } catch (JwtException | IllegalArgumentException e) {
                e.printStackTrace();
                System.out.println("Invalid JWT, processing as guest!");
            }
        }

        return account;

    }

}