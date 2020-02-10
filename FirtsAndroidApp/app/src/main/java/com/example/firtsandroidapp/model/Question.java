package com.example.firtsandroidapp.model;

import java.util.List;

/**
 * Created by Chloe JOULIN.
 */
public class Question {

    private String question;
    private List<String> choiceList;
    private int answerIndex;

    public Question(String question, List<String> choiceList, int answerIndex) {
        this.question = question;
        this.choiceList = choiceList;
        this.answerIndex = answerIndex;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<String> getChoiceList() {
        return choiceList;
    }

    public void setChoiceList(List<String> choiceList) {
        if (choiceList == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }

        choiceList = choiceList;
    }

    public int getAnswerIndex() {
        return answerIndex;
    }

    public void setAnswerIndex(int answerIndex) {
        if (answerIndex < 0 || answerIndex >= choiceList.size()) {
            throw new IllegalArgumentException("Answer index is out of bound");
        }

        answerIndex = answerIndex;
    }

    @Override
    public String toString() {
        return "Question{" +
                "question='" + question + '\'' +
                ", choiceList=" + choiceList +
                ", answerIndex=" + answerIndex +
                '}';
    }
}
