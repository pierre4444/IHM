package com.example.ardoise.model;

import java.util.List;

/**
 * Created by Chloe JOULIN.
 */
public class Evenement {
    private String nom;
    private int nbParticipants;
    private List<Utilisateur> listParticipants;
    private List<Depense> listDepenses;



    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getNbParticipants() {
        return nbParticipants;
    }

    public void setNbParticipants(int nbParticipants) {
        this.nbParticipants = nbParticipants;
    }

    public List<Utilisateur> getListParticipants() {
        return listParticipants;
    }

    public void setListParticipants(List<Utilisateur> listParticipants) {
        this.listParticipants = listParticipants;
    }

    public List<Depense> getListDepenses() {
        return listDepenses;
    }

    public void setListDepenses(List<Depense> listDepenses) {
        this.listDepenses = listDepenses;
    }
}
