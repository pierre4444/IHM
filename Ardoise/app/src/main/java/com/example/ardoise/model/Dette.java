package com.example.ardoise.model;

public class Dette {

    private String titre;
    private int montant;
    private Utilisateur endette;
    private Utilisateur creancier;

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public int getMontant() {
        return montant;
    }

    public void setMontant(int montant) {
        this.montant = montant;
    }

    public Utilisateur getEndette() {
        return endette;
    }

    public void setEndette(Utilisateur endette) {
        this.endette = endette;
    }

    public Utilisateur getCreancier() {
        return creancier;
    }

    public void setCreancier(Utilisateur creancier) {
        this.creancier = creancier;
    }

    @Override
    public String toString() {
        return "Dette{" +
                "titre='" + titre + '\'' +
                ", montant=" + montant +
                ", endette=" + endette +
                ", creancier=" + creancier +
                '}';
    }

    public Dette(String titre, int montant, Utilisateur endette, Utilisateur creancier) {
        this.titre = titre;
        this.montant = montant;
        this.endette = endette;
        this.creancier = creancier;
    }
}
