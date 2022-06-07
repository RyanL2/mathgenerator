package com.mathgenerator.controller;

import com.mathgenerator.module.MathQuestion;
import com.mathgenerator.view.MathQuestionListView;
import io.dropwizard.views.View;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MultivaluedMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Path("/grade")
public class QuestionGradeController {
    private int getAnswer(int num1,int num2, char ope){
        if(ope == '+'){
            return num1 + num2;
        }else if(ope == '-'){
            return num1 - num2;
        }else if(ope == '*'){
            return num1 * num2;
        }else{
            return num1 / num2;
        }
    }
    @POST
    @Consumes("application/x-www-form-urlencoded")
    public View gradeQuestion(MultivaluedMap<String, String> formParams){
        int score = 0;
        List<MathQuestion> mathQuestionAns = new ArrayList<>();
        for(int id=1;id<formParams.size()/4 + 1;id++){
            // getting the data
            int input = Integer.parseInt(formParams.get("value_" + id).get(0));
            int num1 = Integer.parseInt(formParams.get("num1_" + id).get(0));
            int num2 = Integer.parseInt(formParams.get("num2_" + id).get(0));
            char ope = formParams.get("ope_" + id).get(0).charAt(0);
            // calculating result
            String status;
            int answer = getAnswer(num1,num2,ope);
            if(answer == input){
                status = "Correct";
                score ++;
            }else{
                status = "Incorrect";
            }
            // adding back
            mathQuestionAns.add(new MathQuestion(id,num1,num2,ope,status,input,answer));

        }
        return new MathQuestionListView("/views/mathQuestionGrade.mustache", mathQuestionAns, score);
    }

}
