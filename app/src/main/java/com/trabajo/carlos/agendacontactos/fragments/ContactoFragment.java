package com.trabajo.carlos.agendacontactos.fragments;


import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.trabajo.carlos.agendacontactos.R;
import com.trabajo.carlos.agendacontactos.bbdd.BDAdapter;
import com.trabajo.carlos.agendacontactos.datos.Contacto;

/**
 * A simple {@link Fragment} subclass.
 */
public class ContactoFragment extends Fragment {

    TextView txvNombre, txvEdad;

    public ContactoFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View  view = inflater.inflate(R.layout.fragment_contacto, container, false);

        txvNombre = (TextView)view.findViewById(R.id.txvNombre);
        txvEdad = (TextView)view.findViewById(R.id.txvEdad);

        getContactos();

        return view;
    }

    /**
     * Metodo donde obtenemos todos los nombres de la BBDD
     */
    private void getContactos() {


        BDAdapter db = new BDAdapter(getActivity());
        db.abrirBD();

        Cursor c = db.getContactos();

        //Va recorriendo el cursor en busca de datos
        while (c.moveToNext()) {

            int id = c.getInt(0);
            String nombre = c.getString(1);
            String edad = c.getString(2);

            Contacto contacto = new Contacto();
            contacto.setId(id);
            contacto.setNombre(nombre);
            contacto.setEdad(edad);

        }

        db.cerrarBD();


    }

}
