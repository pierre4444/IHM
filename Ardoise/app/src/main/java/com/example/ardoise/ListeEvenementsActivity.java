package com.example.ardoise;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.ardoise.model.Evenement;

import java.util.List;

public class ListeEvenementsActivity extends AppCompatActivity {

    private ListView listeEvenements;
    private Button boutonAdd;
    private String[] prenoms = new String[]{
            "Antoine", "Benoit", "Cyril", "David", "Eloise", "Florent",
            "Gerard", "Hugo", "Ingrid", "Jonathan", "Kevin", "Logan",
            "Mathieu", "Noemie", "Olivia", "Philippe", "Quentin", "Romain",
            "Sophie", "Tristan", "Ulric", "Vincent", "Willy", "Xavier",
            "Yann", "Zoé"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_evenements);

        boutonAdd = (Button) findViewById(R.id.addButton);
        listeEvenements = (ListView) findViewById(R.id.liste);

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(ListeEvenementsActivity.this,
                android.R.layout.simple_list_item_1, prenoms);
        listeEvenements.setAdapter(adapter);
    }
}
