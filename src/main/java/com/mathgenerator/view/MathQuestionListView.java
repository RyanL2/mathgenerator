package com.mathgenerator.view;

import com.mathgenerator.module.MathQuestion;
import io.dropwizard.views.View;

import java.util.*;

public class MathQuestionListView extends View {
    private List<MathQuestion> mathQuestionList = new ArrayList<>();
    private int score;
    public MathQuestionListView(String templateName, List<MathQuestion> mathQuestionList, int score){
        super(templateName);
        this.mathQuestionList = mathQuestionList;
        this.score = score;
    }
    public MathQuestionListView(String templateName, List<MathQuestion> mathQuestionList){
        this(templateName, mathQuestionList, 0);
    }

    public List<MathQuestion> getQuestion(){
        return mathQuestionList;
    }
    public Set<Map.Entry<Integer, MathQuestion>> getQuestion2(){
        Map<Integer, MathQuestion> map = new HashMap<>();
        for(int i=1;i<mathQuestionList.size()+1;i++){
            map.put(i,mathQuestionList.get(i-1));
        }
        return map.entrySet();
    }
    public String getScore(){
        int totalQuestions = mathQuestionList.size();
        return score + "/" + totalQuestions;
    }
}
