package com.trabajo.carlos.agendacontactos.bbdd;

import android.provider.BaseColumns;

/**
 * Created by Carlos Prieto on 10/05/2017.
 */

final class Constantes {

    private Constantes() {

    }

    static final class Contactos implements BaseColumns {

        public Contactos() {
        }

        //Propiedades
        static final String DB_NAME = "contactos.db";
        static final String TB_NAME = "contacto";
        static final int DB_VERSION = 1;

        //Columnas
        static final String COLUMN_ID = "id";
        static final String COLUMN_NOMBRE = "nombre";
        static final String COLUMN_EDAD = "edad";
        static final String COLUMN_TELEFONO = "telefono";
        static final String COLUMN_SEXO = "sexo";


        //Crear tabla
        static final String CREATE_TB = "CREATE TABLE " + TB_NAME + " (" + COLUMN_ID +
                " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_NOMBRE + " TEXT, " +
                COLUMN_EDAD + " TEXT);";

        //Borrar tabla
        static final String DROP_TB = "DROP TABLE IF EXISTS " + TB_NAME;

    }

}
