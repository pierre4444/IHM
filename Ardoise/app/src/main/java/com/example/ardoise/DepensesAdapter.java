package com.example.ardoise;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.ardoise.model.Depense;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by Chloe JOULIN.
 */
public class DepensesAdapter extends ArrayAdapter<Depense> {
    public DepensesAdapter(Context context, ArrayList<Depense> depenses) {
        super(context, 0, depenses);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Depense depense = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_depense, parent, false);
        }
        // Lookup view for data population
        TextView tvName = (TextView) convertView.findViewById(R.id.tvTitre);
        TextView tvHome = (TextView) convertView.findViewById(R.id.tvMontant);
        TextView tvPayeur = (TextView) convertView.findViewById(R.id.tvPayeur);
        // Populate the data into the template view using the data object
        tvName.setText(depense.getTitre());
        tvHome.setText(Integer.toString(depense.getMontant())+ "€");
        tvPayeur.setText(depense.getPayeur().getNom());

        // Return the completed view to render on screen
        return convertView;
    }
}
