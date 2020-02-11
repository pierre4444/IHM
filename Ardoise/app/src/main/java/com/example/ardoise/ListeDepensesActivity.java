package com.example.ardoise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.ardoise.model.Depense;
import com.example.ardoise.model.Evenement;

import java.util.ArrayList;
import java.util.List;

public class ListeDepensesActivity extends AppCompatActivity {


    private ListView mListeDepenses;
    private Button mAddDepenseButton;
    private TextView mSoldeTotalText;
    private Button mEquilibreButton;
    private Evenement evenement;
    private ArrayList<Depense> listeDepenses = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_depenses);

        mListeDepenses = (ListView) findViewById(R.id.liste_depenses);
        mAddDepenseButton = (Button) findViewById(R.id.add_depenses_button);
        mSoldeTotalText = (TextView) findViewById(R.id.solde_total_text);
        mEquilibreButton = (Button) findViewById(R.id.equilibre_button);

        DepensesAdapter adapter = new DepensesAdapter(this, listeDepenses);
        mListeDepenses.setAdapter(adapter);

        mAddDepenseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ajoutActivity = new Intent(ListeDepensesActivity.this, AjoutDepenseActivity.class);
                ajoutActivity.putExtra("evenement", evenement); // la clé, la valeur
                startActivity(ajoutActivity);
            }
        });

        mEquilibreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent equilibreActivity = new Intent(ListeDepensesActivity.this, EquilibreActivity.class);
                startActivity(equilibreActivity);
            }
        });

        Intent intent = getIntent();
        if (intent != null){
            evenement = intent.getParcelableExtra("evenement");
        }

    }
}
