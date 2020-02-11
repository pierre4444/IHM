package com.example.ardoise.model;

/**
 * Created by Chloe JOULIN.
 */
public class Utilisateur {

    private String nom;
    private double soldeTotal;

    public Utilisateur(String nom) {
        this.nom = nom;
        this.soldeTotal = 0;
    }

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
}
