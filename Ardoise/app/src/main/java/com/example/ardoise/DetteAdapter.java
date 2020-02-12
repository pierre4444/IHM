package com.example.ardoise;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.ardoise.model.Dette;

import java.util.ArrayList;

public class DetteAdapter extends ArrayAdapter<Dette> {
    public DetteAdapter(Context context, ArrayList<Dette> dettes) {
        super(context, 0, dettes);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Dette dette = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_dette, parent, false);
        }
        // Lookup view for data population
        TextView detteTitre = (TextView) convertView.findViewById(R.id.detteTitre);
        TextView detteMontant = (TextView) convertView.findViewById(R.id.detteMontant);
        TextView detteEndette = (TextView) convertView.findViewById(R.id.detteEndette);
        TextView detteCreancier = (TextView) convertView.findViewById(R.id.detteCreancier);
        // Populate the data into the template view using the data object
        detteTitre.setText(dette.getTitre());
        detteMontant.setText(Integer.toString(dette.getMontant())+ "€");
        detteEndette.setText(dette.getEndette().getNom());
        detteCreancier.setText(dette.getCreancier().getNom());

        // Return the completed view to render on screen
        return convertView;
    }
}
