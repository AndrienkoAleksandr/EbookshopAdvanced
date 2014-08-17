package com.bookshop.servlets;

import com.bookshop.exception.ConnectionException;
import com.bookshop.model.Message;
import com.bookshop.model.User;
import com.bookshop.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ConnectException;

/**
 * Created by USER on 13.08.2014.
 */
public class RegistrationServlet extends HttpServlet{
    private UserService userService = new UserService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, ConnectionException {
        BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
        String json = "";
        Message message = new Message();
        resp.setContentType("application/json");
        ObjectMapper mapper = new ObjectMapper();
        if (br != null) {
            json = br.readLine();
        }
        User user = mapper.readValue(json, User.class);
        if (userService.validUser(user.getName())) {
            //todo
            user.setPermission(1);
            if (!userService.addUser(user)) {
                message.setMessage("Base date error! Try register later...");
//                resp.sendRedirect("/registration.html?error=Base date error! Try register later...");
                mapper.writeValue(resp.getOutputStream(), message);
            }
            message.setMessage("success!");
            mapper.writeValue(resp.getOutputStream(), message);
        } else {
            message.setMessage("registration failed!");
            mapper.writeValue(resp.getOutputStream(), message);
        }
    }
}
