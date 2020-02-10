package com.example.firtsandroidapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.firtsandroidapp.model.Question;
import com.example.firtsandroidapp.model.QuestionBank;

import java.util.Arrays;

public class GameActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView text;
    private Button bouton1;
    private Button bouton2;
    private Button bouton3;
    private Button bouton4;
    private QuestionBank questionBank;
    private Question currentQuestion;
    private int nbOfQuestions;
    private int score=0;
    private int index=0;

    public static final String BUNDLE_EXTRA_SCORE = "BUNDLE_EXTRA_SCORE";
    public static final String BUNDLE_STATE_SCORE = "currentScore";
    public static final String BUNDLE_STATE_QUESTION = "currentQuestion";

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt(BUNDLE_STATE_SCORE, score);
        outState.putInt(BUNDLE_STATE_QUESTION, index);

        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        if (savedInstanceState != null) {
            score = savedInstanceState.getInt(BUNDLE_STATE_SCORE);
            index = savedInstanceState.getInt(BUNDLE_STATE_QUESTION);
        } else {
            score = 0;
            index = 0;
        }

        text = (TextView) findViewById(R.id.activity_game_question_text);
        bouton1 = (Button) findViewById(R.id.activity_game_answer1_btn);
        bouton2 = (Button) findViewById(R.id.activity_game_answer2_btn);
        bouton3 = (Button) findViewById(R.id.activity_game_answer3_btn);
        bouton4 = (Button) findViewById(R.id.activity_game_answer4_btn);

        questionBank = this.createNewQuestionBank();
        nbOfQuestions = 4;

        bouton1.setTag(0);
        bouton2.setTag(1);
        bouton3.setTag(2);
        bouton4.setTag(3);

        bouton1.setOnClickListener(this);
        bouton2.setOnClickListener(this);
        bouton3.setOnClickListener(this);
        bouton4.setOnClickListener(this);


        currentQuestion = questionBank.getQuestion();
        this.displayQuestion(currentQuestion);
    }

    private void displayQuestion(final Question question) {
        text.setText(question.getQuestion());
        bouton1.setText(question.getChoiceList().get(0));
        bouton2.setText(question.getChoiceList().get(1));
        bouton3.setText(question.getChoiceList().get(2));
        bouton4.setText(question.getChoiceList().get(3));
    }

    private QuestionBank createNewQuestionBank(){
        Question question1 = new Question("Comment s'appelle le chien des Simpson ?",
                Arrays.asList("Boule de Neige",
                        "Petit Bonhomme",
                        "Petit Papa Noël",
                        "Bonhomme de Neige"),
                2);

        Question question2 = new Question("Dans quelle ville déménagent les Simpson quand Homer devient la mascotte d'une équipe de football américain ?",
                Arrays.asList("Las Vegas City",
                        "Oklahoma City",
                        "Capital City",
                        "Philadelphia City"),
                2);

        Question question3 = new Question("À quel numéro de rue habitent les Simpsons?",
                Arrays.asList("42",
                        "101",
                        "666",
                        "742"),
                3);

        Question question4 = new Question("Comment s'appelait le groupe musical d'Homer ?",
                Arrays.asList("The Be Sharp",
                        "The Echarpe",
                        "The Homer Shape",
                        "The Eagles"),
                0);


        return new QuestionBank(Arrays.asList(question1,
                question2,
                question3, question4));
    }

    @Override
    public void onClick(View v) {

        int responseIndex = (int) v.getTag();

        if (responseIndex == this.currentQuestion.getAnswerIndex()){
            Toast.makeText(this, "Bonne réponse :)", Toast.LENGTH_SHORT).show();
            this.score ++;
        }
        else {
            Toast.makeText(this, "Mauvaise réponse :'(", Toast.LENGTH_SHORT).show();
        }


        if (--nbOfQuestions == 0) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);

            builder.setTitle("Vous avez fini le quiz !")
                    .setMessage("avec un score de " + score)
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent();
                            intent.putExtra(BUNDLE_EXTRA_SCORE, score);
                            setResult(RESULT_OK, intent);
                            finish();
                        }
                    })
                    .create()
                    .show();        }
        else {
            currentQuestion = questionBank.getQuestion();
            displayQuestion(currentQuestion);
        }


    }


    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }


/*
    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        // Always call the superclass so it can restore the view hierarchy
        super.onRestoreInstanceState(savedInstanceState);

        // Restore state members from saved instance
        score = savedInstanceState.getInt(BUNDLE_STATE_SCORE);
        nbOfQuestions = savedInstanceState.getInt(BUNDLE_STATE_QUESTION);
    }*/

}
