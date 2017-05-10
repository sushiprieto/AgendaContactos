package com.trabajo.carlos.agendacontactos.datos;

/**
 * Created by Carlos Prieto on 10/05/2017.
 */

public class Contacto {

    private int id;
    private String nombre, edad;

    public Contacto() {
    }

    public Contacto(int id, String nombre, String edad) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

}
