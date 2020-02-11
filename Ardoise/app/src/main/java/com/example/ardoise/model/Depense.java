package com.example.ardoise.model;

import java.util.List;

/**
 * Created by Chloe JOULIN.
 */
public class Depense {

    private String titre;
    private double montant;
    private Utilisateur payeur;
    private List<Utilisateur> beneficiaires;

    public Depense(String titre, double montant, Utilisateur payeur, List<Utilisateur> beneficiaires) {
        this.titre = titre;
        this.montant = montant;
        this.payeur = payeur;
        this.beneficiaires = beneficiaires;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public Utilisateur getPayeur() {
        return payeur;
    }

    public void setPayeur(Utilisateur payeur) {
        this.payeur = payeur;
    }

    public List<Utilisateur> getBeneficiaires() {
        return beneficiaires;
    }

    public void setBeneficiaires(List<Utilisateur> beneficiaires) {
        this.beneficiaires = beneficiaires;
    }
}
