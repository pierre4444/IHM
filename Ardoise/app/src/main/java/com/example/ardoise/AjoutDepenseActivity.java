package com.example.ardoise;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import com.example.ardoise.model.Depense;

public class AjoutDepenseActivity extends AppCompatActivity {

    private EditText titreArea;
    private EditText montantArea;
    private DatePicker datePicker;
    private Button boutonValider;
    private Depense depense;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajout_depense);

        titreArea = (EditText) findViewById(R.id.titreEvent);
        montantArea = (EditText) findViewById(R.id.montant);
        boutonValider = (Button) findViewById(R.id.validerButton);
        datePicker = (DatePicker) findViewById(R.id.date);

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
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(AjoutDepenseActivity.this, ListeDepensesActivity.class);

                Depense depense = new Depense(titreArea.getText().toString(), Integer.parseInt(montantArea.getText().toString()));
                intent.putExtra("depense", depense); // la clé, la valeur
                startActivity(intent);
        }

    });


}
}
