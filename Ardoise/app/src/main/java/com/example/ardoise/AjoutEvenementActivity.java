package com.example.ardoise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.ardoise.model.Depense;

public class AjoutEvenementActivity extends AppCompatActivity {

    private EditText titreArea;
    private EditText montantArea;
    private Button boutonValider;
    private Depense depense;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajout_evenement);

        titreArea = (EditText) findViewById(R.id.titreEvent);
        montantArea = (EditText) findViewById(R.id.montant);
        boutonValider = (Button) findViewById(R.id.validerButton);

        boutonValider.setEnabled(false);

        titreArea.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                boutonValider.setEnabled(s.toString().length() != 0);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        boutonValider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(AjoutEvenementActivity.this, ListeEvenementsActivity.class);

                Depense depense = new Depense(titreArea.getText().toString(), Integer.parseInt(montantArea.getText().toString()));
                intent.putExtra("depense", depense); // la clé, la valeur
                startActivity(intent);


        }

    });


}
}
