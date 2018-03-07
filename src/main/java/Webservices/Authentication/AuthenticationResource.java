package Webservices.Authentication;

import java.security.Key;
import java.util.Calendar;

import javax.json.Json;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;

@Path("/authentication")
public class AuthenticationResource {
    final static public Key key = MacProvider.generateKey(); //Generate a random secret key


    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response authenticateUser(	@FormParam("username") String username,
                                         @FormParam("password") String wachtwoord) {
        System.out.println("Starting authentication...");
        try {
            String role = "user";
            //TODO Authenticate the user against the database

            if (role == null) { throw new IllegalArgumentException("No user found!"); }
            JsonObjectBuilder job = Json.createObjectBuilder();
            // Issue a token for the user
            Calendar expiration = Calendar.getInstance();
            expiration.add(Calendar.MINUTE, 30);
            String token = Jwts.builder()
                    .setSubject(username)
                    .claim("role", role)
                    .setExpiration(expiration.getTime())
                    .signWith(SignatureAlgorithm.HS512, key)
                    .compact();
            // Return the token on the response
            job.add("token", token);
            return Response.ok(job.build().toString()).build();
        } catch (JwtException | IllegalArgumentException e) {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
    }
}