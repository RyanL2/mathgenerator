package com.mathgenerator.module;

import java.util.function.Function;

public class MathQuestion {
    private int int1, int2, id, user_input, correctAns;
    private char operator;
    private String result;
    public MathQuestion(int int1, int int2, char operator){
        this(0, int1,  int2,  operator);
    }
    public MathQuestion(int id, int int1, int int2, char operator) {
        this(id,int1,int2,operator,"",0,0);
    }

    public MathQuestion(int id, int int1, int int2, char operator, String result, int user_input, int correctAns) {
        this.int1 = int1;
        this.int2 = int2;
        this.operator = operator;
        this.id = id;
        this.result = result;
        this.user_input = user_input;
        this.correctAns = correctAns;
    }
    public int getId(){
        return id;
    }
    public int getNum1(){
        return int1;
    }
    public int getNum2(){
        return int2;
    }
    public char getOperator(){
        return operator;
    }
    public String getResult(){
        return result;
    }
    public int getUser_input(){
        return user_input;
    }
    public int getAnswer(){
        return correctAns;
    }
    public Function<Object,Object> bgColour(){
        return (Object obj)->{
            int index = Integer.parseInt(obj.toString());
            return index % 2 == 0 ? "white" : "lightgrey";
        };
    }
    public Function<Object,Object> questionColour(){
        return (Object obj)->{
            String status = obj.toString();
            return status.equals("Correct") ? "green" : "red";
        };
    }
    public Function<Object,Object> questionIcon(){
        return (Object obj)->{
            String status = obj.toString();
            return "<span class=\"material-symbols-outlined\">\n" + (status.equals("Correct") ?
                    "check\n":"close\n") +
                    "</span>";
        };
    }

}
