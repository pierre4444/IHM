package com.example.ardoise.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHandler extends SQLiteOpenHelper {

    //Table Participant
    public static final String PARTICIPANT_NOM_TABLE = "Participant";
    public static final String PARTICIPANT_ID = "id";
    public static final String PARTICIPANT_NOM = "nom";
    public static final String PARTICIPANT_PRENOM = "prenom";
    public static final String PARTICIPANT_ID_EVENEMENT = "idEvenement";
    public static final String PARTICIPANT_TABLE_CREATE =
            "CREATE TABLE IF NOT EXISTS " + PARTICIPANT_NOM_TABLE + " (" +
                    PARTICIPANT_ID + "INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    PARTICIPANT_NOM + " TEXT, " +
                    PARTICIPANT_PRENOM + " TEXT, " +
                    PARTICIPANT_ID_EVENEMENT + " INTEGER FOREIGN KEY);";
    public static final String PARTICIPANT_TABLE_DROP = "DROP TABLE IF EXISTS " + PARTICIPANT_NOM_TABLE + ";";

    //Table Evenement
    public static final String EVENEMENT_NOM_TABLE = "Evenement";
    public static final String EVENEMENT_ID = "id";
    public static final String EVENEMENT_NOM = "nom";
    public static final String EVENEMENT_NB_PARTICIPANT = "nbParticipant";
   /* public static final String EVENEMENT_TABLE_CREATE =
            "CREATE TABLE IF NOT EXISTS " + PARTICIPANT_NOM_TABLE + " (" +
                    PARTICIPANT_ID + "INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    PARTICIPANT_NOM + " TEXT, " +
                    PARTICIPANT_PRENOM + " TEXT, " +
                    PARTICIPANT_ID_EVENEMENT + " INTEGER FOREIGN KEY);";
    public static final String PARTICIPANT_TABLE_DROP = "DROP TABLE IF EXISTS " + PARTICIPANT_NOM_TABLE + ";";
A refactor */
    public DatabaseHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db){

        db.execSQL(PARTICIPANT_TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL(PARTICIPANT_TABLE_DROP);
        onCreate(db);
    }


}
