package com.example.ardoise.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by Chloe JOULIN.
 */
public class Evenement implements Parcelable {
    private String nom;
    private ArrayList<Utilisateur> listParticipants;
    private ArrayList<Depense> listDepenses;
    private double soldeTotal;

    public Evenement(String nom, ArrayList<Utilisateur> listParticipants, ArrayList<Depense> listDepenses) {
        this.nom = nom;
        this.listParticipants = listParticipants;
        this.listDepenses = listDepenses;
    }

    public Evenement(Parcel in) {
        nom = in.readString();
        listParticipants = in.createTypedArrayList(Utilisateur.CREATOR);
        listDepenses = in.createTypedArrayList(Depense.CREATOR);
        soldeTotal = in.readDouble();
    }

    public static final Creator<Evenement> CREATOR = new Creator<Evenement>() {
        @Override
        public Evenement createFromParcel(Parcel in) {
            return new Evenement(in);
        }

        @Override
        public Evenement[] newArray(int size) {
            return new Evenement[size];
        }
    };

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public ArrayList<Utilisateur> getListParticipants() {
        return listParticipants;
    }

    public void setListParticipants(ArrayList<Utilisateur> listParticipants) {
        this.listParticipants = listParticipants;
    }

    public ArrayList<Depense> getListDepenses() {
        if (this.listDepenses != null){
            return listDepenses;
        }
        else {
            return null;
        }

    }

    public void setListDepenses(ArrayList<Depense> listDepenses) {
        this.listDepenses = listDepenses;
    }

    public double getSoldeTotal() {
        return soldeTotal;
    }

    public void setSoldeTotal(Double soldeTotal) {
        this.soldeTotal = soldeTotal;
    }

    public void addDepense(Depense depense) {
        if (this.listDepenses != null) {
            listDepenses.add(depense);
        }
        else {
            this.listDepenses = new ArrayList<>();
            listDepenses.add(depense);
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeString(nom);
        parcel.writeTypedList(listParticipants);
        parcel.writeTypedList(listDepenses);
    }


}
