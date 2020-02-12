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

        //recuperation de l'evenement de l'activite precedente
        Intent intent = getIntent();
        if (intent != null) {
            evenement = intent.getParcelableExtra("evenement");
            System.out.println(evenement.toString());
        }

        //affichage des dépenses dans une liste
        this.listeDepenses = this.evenement.getListDepenses();
        DepensesAdapter adapter = new DepensesAdapter(this, listeDepenses);
        mListeDepenses.setAdapter(adapter);

        //bouton pour ajouter une depense
        mAddDepenseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //passage de l'activité ListeDepenses à l'activté AjoutDepense
                Intent ajoutActivity = new Intent(ListeDepensesActivity.this, AjoutDepenseActivity.class);

                //envoie de l'evenement pendant le passage d'une activité à l'autre
                ajoutActivity.putExtra("evenement", evenement); // la clé, la valeur
                startActivity(ajoutActivity);
                Intent ajoutDepenseActivity = new Intent(ListeDepensesActivity.this, AjoutDepenseActivity.class);
                startActivity(ajoutDepenseActivity);
            }
        });

        //bouton pour passer à l'équilibre du solde
        mEquilibreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //passage de l'activité ListeDepenses à l'activté Equilibre
                Intent equilibreActivity = new Intent(ListeDepensesActivity.this, EquilibreActivity.class);

                //envoie de l'evenement pendant le passage d'une activité à l'autre
                equilibreActivity.putExtra("evenement", evenement); // la clé, la valeur
                startActivity(equilibreActivity);
            }
        });

        if (!evenement.getListDepenses().isEmpty()) {
            System.out.println(evenement.toString());

            mSoldeTotalText.setText(mSoldeTotalText.getText() + " 0€");

            Intent intents = getIntent();
            if (intents != null) {
                Depense depense = intents.getParcelableExtra("depense");
                if (depense != null) {
                    listeDepenses.add(depense);
                    System.out.println(depense.getTitre());
                }
            }


        }
    }
}
