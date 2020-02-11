package com.example.ardoise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class ListeDepensesActivity extends AppCompatActivity {


    private ListView mListeDepenses;
    private Button mAddDepenseButton;
    private TextView mSoldeTotalText;
    private Button mEquilibreButton;
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
        setContentView(R.layout.activity_liste_depenses);


        mListeDepenses = (ListView) findViewById(R.id.liste_depenses);
        mAddDepenseButton = (Button) findViewById(R.id.add_depenses_button);
        mSoldeTotalText = (TextView) findViewById(R.id.solde_total_text);
        mEquilibreButton = (Button) findViewById(R.id.equilibre_button);


        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(ListeDepensesActivity.this,
                android.R.layout.simple_list_item_1, prenoms);
        mListeDepenses.setAdapter(adapter);


        mEquilibreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent equilibreActivity = new Intent(ListeDepensesActivity.this, EquilibreActivity.class);
                startActivity(equilibreActivity);
            }
        });
    }
}
