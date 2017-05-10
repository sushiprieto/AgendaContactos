package com.trabajo.carlos.agendacontactos.bbdd;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.trabajo.carlos.agendacontactos.datos.Contacto;

/**
 * Created by Carlos Prieto on 10/05/2017.
 */

public class BDAdapter {

    private SQLiteDatabase db;
    private BDHelper helper;

    public BDAdapter(Context context) {

        helper = new BDHelper(context);

    }

    /**
     * Abrimos una conexion
     */
    public void abrirBD() {

        try {

            db = helper.getWritableDatabase();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    /**
     * Cerramos una conexion
     */
    public void cerrarBD() {

        try {

            helper.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    /**
     * Hacemos un select a la BBDD para traernos todos los datos en un cursor
     *
     * @return
     */
    public Cursor getContactos() {

        String[] columnas = {
                Constantes.Contactos.COLUMN_ID,
                Constantes.Contactos.COLUMN_NOMBRE,
                Constantes.Contactos.COLUMN_EDAD,
        };

        return db.query(Constantes.Contactos.TB_NAME, columnas, null, null, null, null, null);

    }

    /**
     * Metodo que recoge un solo contacto de la BBDD mediante un id
     *
     * @param id
     * @return
     */
    public Contacto getContacto(int id) {

        Cursor c = db.query(Constantes.Contactos.TB_NAME, new String[]{Constantes.Contactos.COLUMN_ID,
                        Constantes.Contactos.COLUMN_NOMBRE, Constantes.Contactos.COLUMN_EDAD}, Constantes.Contactos.COLUMN_ID + "=?",
                        new String[]{String.valueOf(id)}, null, null, null, null);

        if (c != null)
            c.moveToFirst();

        //De esta forma es mejor
        return new Contacto(c.getInt(0), c.getString(1), c.getString(2));
    }

    /**
     * Metodo que inserta un nuevo contacto pasandole unos parametros
     *
     * @param nombre
     * @param edad
     * @return
     */
    public boolean insertarContacto(String nombre, String edad) {

        boolean devolver = false;

        try {

            ContentValues cv = new ContentValues();
            cv.put(Constantes.Contactos.COLUMN_NOMBRE, nombre);
            cv.put(Constantes.Contactos.COLUMN_EDAD, edad);

            long resultado = db.insert(Constantes.Contactos.TB_NAME, null, cv);

            if (resultado > 0) {
                devolver = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return devolver;

    }

}
