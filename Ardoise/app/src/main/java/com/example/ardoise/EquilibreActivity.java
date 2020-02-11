package com.example.ardoise;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equilibre);

        mEquilibreText = (TextView) findViewById(R.id.equilibre_text);
        mEquilibreList = (ListView) findViewById(R.id.equilibre_liste);

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(EquilibreActivity.this,
                android.R.layout.simple_list_item_1, prenoms);
        mEquilibreList.setAdapter(adapter);
    }
}
