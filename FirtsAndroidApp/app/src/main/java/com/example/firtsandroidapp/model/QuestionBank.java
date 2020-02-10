package com.example.firtsandroidapp.model;

import java.util.Collections;
import java.util.List;

/**
 * Created by Chloe JOULIN.
 */
public class QuestionBank {
        private List<Question> questionList;
        private int nextQuestionIndex;

        public QuestionBank(List<Question> questionList) {
            this.questionList = questionList;
            //Collections.shuffle(this.questionList);
            nextQuestionIndex = 0;
        }

        public Question getQuestion() {
            if (nextQuestionIndex == questionList.size()) {

                nextQuestionIndex = 0;
            }

            return questionList.get(nextQuestionIndex++);
        }

}
