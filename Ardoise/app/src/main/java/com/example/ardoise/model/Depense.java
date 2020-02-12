package com.example.ardoise.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;
import java.util.List;

/**
 * Created by Chloe JOULIN.
 */
public class Depense implements Parcelable{

    private String titre;
    private int montant;
    private Utilisateur payeur;
    private Date dateDepense;
    private List<Utilisateur> beneficiaires;

    public Depense(String titre, int montant, Utilisateur payeur, List<Utilisateur> beneficiaires) {
        this.titre = titre;
        this.montant = montant;
        this.payeur = payeur;
        this.beneficiaires = beneficiaires;
    }

    protected Depense(Parcel in) {
        titre = in.readString();
        montant = in.readInt();
        payeur = in.readParcelable(Utilisateur.class.getClassLoader());
        beneficiaires = in.createTypedArrayList(Utilisateur.CREATOR);
    }

    public static final Creator<Depense> CREATOR = new Creator<Depense>() {
        @Override
        public Depense createFromParcel(Parcel in) {
            return new Depense(in);
        }

        @Override
        public Depense[] newArray(int size) {
            return new Depense[size];
        }
    };

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

    public Date getDateDepense() {
        return dateDepense;
    }

    public void setDateDepense(Date dateDepense) {
        this.dateDepense = dateDepense;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeString(titre);
        parcel.writeInt(montant);
        parcel.writeParcelable(payeur, flags);
        parcel.writeTypedList(beneficiaires);
    }
}
