package com.example.ardoise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;

import com.example.ardoise.model.Depense;
import com.example.ardoise.model.Evenement;
import com.example.ardoise.model.Utilisateur;

import java.util.ArrayList;
import java.util.List;

public class ListeEvenementsActivity extends AppCompatActivity {

    private EditText titreEdit;
    private EditText participant1;
    private EditText participant2;
    private EditText participant3;
    private Button boutonAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_evenements);

        titreEdit = (EditText) findViewById(R.id.titre);
        participant1 = (EditText) findViewById(R.id.participant1);
        participant2 = (EditText) findViewById(R.id.participant2);
        participant3 = (EditText) findViewById(R.id.participant3);
        boutonAdd = (Button) findViewById(R.id.boutonValider);

        //désactivation du bouton tant que les champs ne sont pas tous remplis
        boutonAdd.setEnabled(false);

        //si aucun des EditText n'est vide, on active le bouton
        titreEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (titreEdit.getText().length()!=0 && participant1.getText().length()!=0 && participant2.getText().length()!=0 && participant3.getText().length()!=0){
                    boutonAdd.setEnabled(true);
                }
                else{
                    boutonAdd.setEnabled(false);
                }
            }
        });
        participant1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (titreEdit.getText().length()!=0 && participant1.getText().length()!=0 && participant2.getText().length()!=0 && participant3.getText().length()!=0){
                    boutonAdd.setEnabled(true);
                }
                else{
                    boutonAdd.setEnabled(false);
                }
            }
        });
        participant2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (titreEdit.getText().length()!=0 && participant1.getText().length()!=0 && participant2.getText().length()!=0 && participant3.getText().length()!=0){
                    boutonAdd.setEnabled(true);
                }
                else{
                    boutonAdd.setEnabled(false);
                }
            }
        });
        participant3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (titreEdit.getText().length()!=0 && participant1.getText().length()!=0 && participant2.getText().length()!=0 && participant3.getText().length()!=0){
            boutonAdd.setEnabled(true);
        }
                else{
                    boutonAdd.setEnabled(false);
                }
            }
        });

        boutonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //passage de l'activité ListeEvenements à ListeDepenses
                Intent intent = new Intent(ListeEvenementsActivity.this, ListeDepensesActivity.class);

                //récupération des participants au groupe
                Utilisateur u1 = new Utilisateur(participant1.getText().toString());
                Utilisateur u2 = new Utilisateur(participant2.getText().toString());
                Utilisateur u3 = new Utilisateur(participant3.getText().toString());

                ArrayList<Utilisateur> listParticipants = new ArrayList<>();
                listParticipants.add(u1);
                listParticipants.add(u2);
                listParticipants.add(u3);

                ArrayList<Depense> listeDepenses = new ArrayList<>();

                //envoie des données de l'evenement à l'activité suivante
                Evenement evenement = new Evenement(titreEdit.getText().toString(), listParticipants, listeDepenses);
                intent.putExtra("evenement", evenement); //la clé, la valeur
                startActivity(intent);
            }

        });


    }



}
