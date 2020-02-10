package com.example.firtsandroidapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Button;

import com.example.firtsandroidapp.model.User;

public class MainActivity extends AppCompatActivity {

    private TextView text;
    private EditText champs;
    private Button bouton;
    private User user;

    private static final int GAME_ACTIVITY_REQUEST_CODE = 42;
    private SharedPreferences preferences;
    public static final String PREF_KEY_SCORE = "PREF_KEY_SCORE";
    public static final String PREF_KEY_FIRSTNAME = "PREF_KEY_FIRSTNAME";


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
            if (GAME_ACTIVITY_REQUEST_CODE == requestCode && RESULT_OK == resultCode) {
                // Fetch the score from the Intent
                int score = data.getIntExtra(GameActivity.BUNDLE_EXTRA_SCORE, 0);

                preferences.edit().putInt(PREF_KEY_SCORE, score).apply();

                saluer();

            }
    }

    private void saluer() {
        String firstname = preferences.getString(PREF_KEY_FIRSTNAME, null);
        System.out.println(firstname);

        if (null != firstname) {
            int score = preferences.getInt(PREF_KEY_SCORE, 0);

            String fulltext = "Re-bonjour " + firstname;
            text.setText(fulltext);
            champs.setText(firstname);
            champs.setSelection(firstname.length());
            bouton.setEnabled(true);
            System.out.println(champs.getText());
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        text = (TextView) findViewById(R.id.nomQuestion);
        champs = (EditText) findViewById(R.id.nomChamps);
        bouton = (Button) findViewById(R.id.validerBouton);

        //on cache le bouton temps que l'utilisateur n'a rien écrit dans la box
        bouton.setEnabled(false);

        user = new User(); //initialisation de l'utilisateur
        preferences = getPreferences(MODE_PRIVATE);

        champs.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                bouton.setEnabled(s.toString().length() != 0);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        bouton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user.setFirstName(champs.getText().toString());
                System.out.println(champs.getText().toString());

                preferences.edit().putString(PREF_KEY_FIRSTNAME, user.getFirstName()).apply();

                Intent gameActivity = new Intent(MainActivity.this, GameActivity.class);
                startActivityForResult(gameActivity, GAME_ACTIVITY_REQUEST_CODE);
            }

        });

    }



}