package com.example.ardoise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.ardoise.model.Depense;
import com.example.ardoise.model.Evenement;

import java.util.ArrayList;
import java.util.List;

public class ListeEvenementsActivity extends AppCompatActivity {

    private ListView listeEvenements;
    private Button boutonAdd;
    private String[] prenoms = new String[]{
            "Antoine", "Benoit"
    };
    private List<Depense> listeDepenses = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_evenements);

        //listeEvenements = (ListView) findViewById(R.id.liste);
        boutonAdd = (Button) findViewById(R.id.addButton);

        /*final ArrayAdapter<String> adapter = new ArrayAdapter<String>(ListeEvenementsActivity.this,
                android.R.layout.simple_list_item_1, prenoms);
        listeEvenements.setAdapter(adapter);
*/
        /*Intent intent = getIntent();
        if (intent != null){
            Depense depense = intent.getParcelableExtra("depense");
            if (depense != null){
                listeDepenses.add(depense);
            }
        }*/

/*        boutonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ListeEvenementsActivity.this, AjoutDepenseActivity.class);
                startActivity(i);
            }
        });*/

    }

}
