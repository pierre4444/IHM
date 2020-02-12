package com.example.ardoise.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

public class UserDAO extends DAOBase {

    //Table Participant
    public static final String NOM_TABLE = "Participant";
    public static final String ID = "id";
    public static final String NOM = "nom";
    public static final String PRENOM = "prenom";
    public static final String ID_EVENEMENT = "idEvenement";


    public UserDAO(Context pContext) {
        super(pContext);
    }

    /**
     * @param m le métier à ajouter à la base
     */
    public void ajouter(User p) {
        ContentValues value = new ContentValues();
        value.put(UserDAO.NOM, p.getNom());
        value.put(UserDAO.PRENOM, p.getPrenom());
        value.put(UserDAO.ID_EVENEMENT, p.getIdEvenement());
        mDb.insert(UserDAO.NOM_TABLE, null, value);

    }

    /**
     * @param id l'identifiant du métier à supprimer
     */
    public void supprimer(long id) {
        mDb.delete(NOM_TABLE, ID + " = ?", new String[] {String.valueOf(id)});

    }

    /**
     * @param id l'identifiant du métier à récupérer
     */
    public String recupererNom(long id) {
        return(mDb.rawQuery("select " + NOM + " from " + NOM_TABLE + " where id=?;", new String[]{ID}).getExtras().getString(NOM));

    }


}
