package com.example.ardoise.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Chloe JOULIN.
 */
public class Utilisateur implements Parcelable {

    private String nom;
    private double soldeTotal;

    public Utilisateur(String nom) {
        this.nom = nom;
        this.soldeTotal = 0;
    }

    protected Utilisateur(Parcel in) {
        nom = in.readString();
        soldeTotal = in.readDouble();
    }

    public static final Creator<Utilisateur> CREATOR = new Creator<Utilisateur>() {
        @Override
        public Utilisateur createFromParcel(Parcel in) {
            return new Utilisateur(in);
        }

        @Override
        public Utilisateur[] newArray(int size) {
            return new Utilisateur[size];
        }
    };

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getSoldeTotal() {
        return soldeTotal;
    }

    public void setSoldeTotal(double soldeTotal) {
        this.soldeTotal = soldeTotal;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeString(nom);
        parcel.writeDouble(soldeTotal);
    }
}
