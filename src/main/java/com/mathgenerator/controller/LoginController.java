package com.mathgenerator.controller;

import com.mathgenerator.dao.UserDAO;
import com.mathgenerator.module.User;
import io.dropwizard.hibernate.UnitOfWork;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Optional;
import java.util.UUID;

@Path("/login")
public class LoginController {
    private UserDAO userDAO;
    public LoginController(UserDAO userDAO){
        this.userDAO = userDAO;
    }
    @GET
    @Produces(MediaType.TEXT_HTML)
    @UnitOfWork
    public String login(){
        User user = userDAO.findById(UUID.fromString("7a04d841-aeed-4800-b02e-b17c854f1cc7")).get();
        return "<html>" +
                "<body>" +
                "<form> <input type='text'> " +
                "<input type='submit' value='submit'>" +
                user.getEmail() +
                user.getName() +
                "</form>" +
                "</body>" +
                "</html>";
    }
}
