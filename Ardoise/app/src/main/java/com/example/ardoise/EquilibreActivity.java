package com.example.ardoise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.ardoise.model.Depense;
import com.example.ardoise.model.Dette;
import com.example.ardoise.model.Evenement;

import java.util.ArrayList;


/**
 * Created by Alexis JEAN.
 */

public class EquilibreActivity extends AppCompatActivity {

    private TextView mEquilibreText;
    private ListView mEquilibreList;

    private Evenement evenement;
    private ArrayList<Dette> listeDettes;

    private Dette exempleDette;

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


        exempleDette = new Dette("Dette", 50, evenement.getListParticipants().get(1),evenement.getListParticipants().get(2));
        listeDettes=new ArrayList<Dette>();
        this.listeDettes.add(exempleDette);
        exempleDette = new Dette("Seconde Dette", 100, evenement.getListParticipants().get(0),evenement.getListParticipants().get(2));
        this.listeDettes.add(exempleDette);
        //affichage des dépenses dans une liste
        DetteAdapter adapter = new DetteAdapter(this, listeDettes);
        mEquilibreList.setAdapter(adapter);


    }
}
