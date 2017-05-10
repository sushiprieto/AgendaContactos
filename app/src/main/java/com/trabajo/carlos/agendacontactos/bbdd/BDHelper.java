package com.trabajo.carlos.agendacontactos.bbdd;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Carlos Prieto on 10/05/2017.
 */

public class BDHelper extends SQLiteOpenHelper {

    public BDHelper(Context context) {
        super(context, Constantes.Contactos.DB_NAME, null, Constantes.Contactos.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        try {

            db.execSQL(Constantes.Contactos.CREATE_TB);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        try {

            db.execSQL(Constantes.Contactos.DROP_TB);
            onCreate(db);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
