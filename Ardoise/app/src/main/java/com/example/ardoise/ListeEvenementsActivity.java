package com.example.ardoise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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


/**
 * Created by Alexis JEAN.
 */

public class ListeEvenementsActivity extends AppCompatActivity {

    private EditText titreEdit;
    private EditText participant1;
    private EditText participant2;
    private EditText participant3;
    private Button boutonAdd;
    private List<Depense> listeDepenses = new ArrayList<>();


    // TODO : tant que tous les champs de ne sont pas remplis on ne peut pas valider


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_evenements);

        titreEdit = (EditText) findViewById(R.id.titre);
        participant1 = (EditText) findViewById(R.id.participant1);
        participant2 = (EditText) findViewById(R.id.participant2);
        participant3 = (EditText) findViewById(R.id.participant3);
        boutonAdd = (Button) findViewById(R.id.boutonValider);

        boutonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ListeEvenementsActivity.this, ListeDepensesActivity.class);

                Utilisateur u1 = new Utilisateur(participant1.getText().toString());
                Utilisateur u2 = new Utilisateur(participant2.getText().toString());
                Utilisateur u3 = new Utilisateur(participant3.getText().toString());

                ArrayList<Utilisateur> listParticipants = new ArrayList<>();
                listParticipants.add(u1);
                listParticipants.add(u2);
                listParticipants.add(u3);

                ArrayList<Depense> listeDepenses = new ArrayList<>();

                Evenement evenement = new Evenement(titreEdit.getText().toString(), listParticipants, listeDepenses);
                System.out.println(evenement.toString());
                intent.putExtra("evenement", evenement); // la clé, la valeur
                startActivity(intent);
            }

        });


    }



}
