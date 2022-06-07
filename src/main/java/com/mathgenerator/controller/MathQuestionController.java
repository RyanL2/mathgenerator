package com.mathgenerator.controller;

import com.mathgenerator.module.MathQuestion;
import com.mathgenerator.view.MathQuestionListView;
import io.dropwizard.views.View;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.util.ArrayList;
import java.util.List;

@Path("/questionList")
public class MathQuestionController {
    private int randomInt(int lowerBound,int upperBound){
        return (int)(Math.random() * (upperBound - lowerBound) + lowerBound);
    }
    private List<Integer> getFactors(int n){
        List<Integer> factors = new ArrayList<>();
        for(int i=1;i<Math.sqrt(n)+1;i++){
            if(n % i == 0){
                factors.add(i);
                factors.add(n / i);
            }
        }
        return factors;
    }
    @GET
    public View get(){
        List<MathQuestion> mathQuestionList = new ArrayList<>();
        char[] operators = {'+','-','*','/'};
        for(int i=0;i<10;i++){
            int int1,int2;
            char nowOperator = operators[randomInt(0,4)];
            if(nowOperator =='/'){  // division needs careful treatment so no repeating decimals
                int dividend = randomInt(2,100);
                List<Integer> factors = getFactors(dividend);
                while(factors.size() == 2){
                    dividend = randomInt(2,100);
                    factors = getFactors(dividend);
                }
                int divisor = factors.get(randomInt(0, factors.size()));
                int1 = dividend; int2 = divisor; // assign the two ints
            }else if(nowOperator == '*'){
                int1 = randomInt(0,10);
                int2 = randomInt(0,10);
            }else{
                int1 = randomInt(0,100);
                int2 = randomInt(0,int1);
            }
            mathQuestionList.add(new MathQuestion(i, int1, int2, nowOperator));
        }
        return new MathQuestionListView("/views/mathQuestionM.mustache", mathQuestionList);
    }
//    @POST
//
}

