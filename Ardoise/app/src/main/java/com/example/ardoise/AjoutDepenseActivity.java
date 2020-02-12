package com.example.ardoise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import com.example.ardoise.model.Depense;
import com.example.ardoise.model.Evenement;
import com.example.ardoise.model.Utilisateur;

import java.util.ArrayList;
import java.util.Date;

public class AjoutDepenseActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private EditText titreArea;
    private EditText montantArea;
    private DatePicker datePicker;
    private Button boutonValider;
    private Evenement evenement;
    private Switch participant1;
    private Switch participant2;
    private Switch participant3;
    private TextView pourQuiText;
    private Spinner menuDeroulantPayeur;
    private ArrayList<String> listNoms;
    private Utilisateur payeur;
    private Date dateDepense;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajout_depense);

        titreArea = (EditText) findViewById(R.id.titreEvent);
        montantArea = (EditText) findViewById(R.id.montant);
        boutonValider = (Button) findViewById(R.id.validerButton);
        participant1 = (Switch) findViewById(R.id.user1);
        participant2 = (Switch) findViewById(R.id.user2);
        participant3 = (Switch) findViewById(R.id.user3);
        pourQuiText = (TextView) findViewById(R.id.pourQui);
        menuDeroulantPayeur = (Spinner) findViewById(R.id.payeurList);
        datePicker = (DatePicker) findViewById(R.id.date);


        //désactivation du bouton tant que les champs ne sont pas tous remplis
        boutonValider.setEnabled(false);

        //par defaut les switchs des beneficiaires de la depense sont activés: tous les mambres du groupe sont beneficiaires
        participant1.setChecked(true);
        participant2.setChecked(true);
        participant3.setChecked(true);

        //recuperation de l'evenement de l'activite precedente
        Intent i = getIntent();
        if (i != null){
            evenement = i.getParcelableExtra("evenement");
        }

        //liste des noms des participants :
        listNoms = new ArrayList<>();
        for (int x=0;x<3;x++) {
            listNoms.add(evenement.getListParticipants().get(x).getNom());
        }

        //affichage du menu déroulant des payeurs potentiels
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, listNoms);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        menuDeroulantPayeur.setAdapter(adapter);
        //par defaut le payeur est le premier de la liste des participants au groupe

        menuDeroulantPayeur.setOnItemSelectedListener(this);

        //si aucun des EditText n'est vide, on active le bouton
        titreArea.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (titreArea.getText().length()!=0 && montantArea.getText().length()!=0){
                    boutonValider.setEnabled(true);
                }
                else{
                    boutonValider.setEnabled(false);
                }
            }
        });
        montantArea.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (titreArea.getText().length()!=0 && montantArea.getText().length()!=0){
                    boutonValider.setEnabled(true);
                }
                else{
                    boutonValider.setEnabled(false);
                }
            }
        });

        boutonValider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //passage de l'activité AjoutDepense à l'activté ListeDepenses
                Intent intent = new Intent(AjoutDepenseActivity.this, ListeDepensesActivity.class);


                //création de la liste des beneficiaires
                ArrayList<Utilisateur> beneficiaires = new ArrayList<>();
                if (participant1.isChecked()){
                    beneficiaires.add(evenement.getListParticipants().get(0));
                }
                if (participant2.isChecked()){
                    beneficiaires.add(evenement.getListParticipants().get(1));
                }
                if (participant3.isChecked()){
                    beneficiaires.add(evenement.getListParticipants().get(2));
                }


                //mise à jour du solde du payeur de la depense
                updateSoldePayeur();

                Depense depense = new Depense(titreArea.getText().toString(), Integer.parseInt(montantArea.getText().toString()), payeur, beneficiaires);

                dateDepense = new Date(datePicker.getYear(), datePicker.getMonth(), datePicker.getDayOfMonth());
                depense.setDateDepense(dateDepense);

                evenement.addDepense(depense);

                //mise à jour du solde total de l'evenement
                updateSoldeTotal();

                //envoie de l'evenement pendant le passage d'une activité à l'autre
                intent.putExtra("evenement", evenement); // la clé, la valeur
                startActivity(intent);
        }

    });

        //afficher le nom des participants sur les switchs
        this.displayParticipants(evenement);
    }

    //méthode permettant d'afficher les noms des participants à l'evenement
    private void displayParticipants(final Evenement evenement) {
        participant1.setText(listNoms.get(0));
        participant2.setText(listNoms.get(1));
        participant3.setText(listNoms.get(2));
    }

    //quand on appuie sur un des elements du menu deroulants des payeur potentiels
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        payeur = evenement.getListParticipants().get(position);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }

    private void updateSoldeTotal(){
        evenement.setSoldeTotal(evenement.getSoldeTotal() + Double.parseDouble(montantArea.getText().toString()));
    }

    private void updateSoldePayeur(){
        payeur.setSoldeTotal(payeur.getSoldeTotal() + Double.parseDouble(montantArea.getText().toString()));
    }
}
