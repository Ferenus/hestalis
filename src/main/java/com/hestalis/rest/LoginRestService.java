package com.hestalis.rest;

import com.hestalis.dao.IUserDAO;
import com.hestalis.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.Date;


@Path("/v1")
@Controller
public class LoginRestService {

    @Autowired
    private IUserDAO userDAO;

    @Autowired
    private PasswordEncoder passwordEncoder;

/*    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public User getDefaultUserInJSON() {
        UserService userService = new UserService();
        return userService.getDefaultUser();
    }*/

    @Path("/login")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response authenticateUser(@FormParam("username") String username,
                                     @FormParam("password") String password, @Context UriInfo request) {

        try {
            // Authenticate the user using the credentials provided
            authenticate(username, password);

            // Issue a token for the user
            String token = issueToken(username);

            // Return the token on the response
            return Response.ok(token).build();
        } catch (Exception e) {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
    }

    private void authenticate(String username, String password) throws Exception {
        // Authenticate against a database, LDAP, file or whatever
        // Throw an Exception if the credentials are invalid
        User user = userDAO.getUserByUsername(username);

        if (user != null && BCrypt.checkpw(password, user.getPassword())) {
            user.setLastLogin(new Date());
            userDAO.setUser(user);
        }
        else {
            throw new Exception("Invalid login!");
        }
    }

    private String issueToken(String username) {
        // Issue a token (can be a random String persisted to a database or a JWT token)
        // The issued token must be associated to a user
        // Return the issued token
        return username;
    }

}
