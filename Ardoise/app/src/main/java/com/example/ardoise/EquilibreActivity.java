package com.example.ardoise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.ardoise.model.Evenement;


/**
 * Created by Alexis JEAN.
 */

public class EquilibreActivity extends AppCompatActivity {

    private TextView mEquilibreText;
    private ListView mEquilibreList;
    private String[] prenoms = new String[]{
            "Antoine", "Benoit", "Cyril", "David", "Eloise", "Florent",
            "Gerard", "Hugo", "Ingrid", "Jonathan", "Kevin", "Logan",
            "Mathieu", "Noemie", "Olivia", "Philippe", "Quentin", "Romain",
            "Sophie", "Tristan", "Ulric", "Vincent", "Willy", "Xavier",
            "Yann", "Zoé"
    };
    private Evenement evenement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equilibre);

        mEquilibreText = (TextView) findViewById(R.id.equilibre_text);
        mEquilibreList = (ListView) findViewById(R.id.equilibre_liste);

        //recuperation de l'evenement de l'activite precedente
        Intent i = getIntent();
        if (i != null){
            evenement = i.getParcelableExtra("evenement");
        }

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(EquilibreActivity.this,
                android.R.layout.simple_list_item_1, prenoms);
        mEquilibreList.setAdapter(adapter);
    }
}
