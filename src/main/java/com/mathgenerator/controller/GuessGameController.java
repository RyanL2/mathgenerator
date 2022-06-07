package com.mathgenerator.controller;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.util.Random;

@Path("/guess")
public class GuessGameController {
    Random rand = new Random();
    int num = rand.nextInt(100) + 1;
    @GET
    public String getView(){
        return "<html>" +
                "<body>" +
                "<form action=/guess method='post'>Please guess a number between 1 and 100: <input autofocus type='text' name='value'>" +
                "<input type='submit' value='submit'>" +
                "</form>" +
                num+
                "</body>" +
                "<br>" +
                "<br>" +
                "<br>" +
                "<br>" +
                "<br>" +
                "<br>" +
                "<br>" +
                "<br>" +
                "<p style='color:red'> yesss </p>" +
                "</html>";
    }
    @POST
    public String returnNum(@FormParam("value") String value){
        int number = Integer.parseInt(value);
        if(number < num){
            return getView() + "<br>Too small";
        }
        else if(number == num){
            num = rand.nextInt(100)+1;
            return "You got it! A new number will be generated." +
                    "<form action=/guess method='get'>" +
                    "<input type='submit' value='restart'>" +
                    "</form>";
        }
        else{
            return getView() + "<br>Too big";
        }
    }

}
