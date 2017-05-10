package com.trabajo.carlos.agendacontactos.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.trabajo.carlos.agendacontactos.R;
import com.trabajo.carlos.agendacontactos.bbdd.BDAdapter;

public class AddContactActivity extends AppCompatActivity {

    EditText edtNombre, edtEdad;
    Button btnAceptar;

    String nombre, edad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);

        edtNombre = (EditText)findViewById(R.id.edtNombre);
        edtEdad = (EditText)findViewById(R.id.edtEdad);

        btnAceptar = (Button)findViewById(R.id.btnAceptar);

        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (edtNombre.getText().equals("") || edtEdad.getText().equals("")) {

                    Toast.makeText(getApplicationContext(), "Los campos no pueden estar vacios", Toast.LENGTH_LONG).show();

                } else {

                    nombre = edtNombre.getText().toString();
                    edad = edtEdad.getText().toString();

                    //Insertamos un nuevo contacto
                    insertar(nombre, edad);

                }

            }
        });

    }

    /**
     * Metodo que inserta un nuevo contacto llamando al metodo insertarContacto() de la manejadora de la BBDD
     *
     * @param nombre
     * @param edad
     */
    private void insertar(String nombre, String edad) {

        BDAdapter db = new BDAdapter(this);
        db.abrirBD();

        boolean guardado = db.insertarContacto(nombre, edad);

        //Si se ha guardado bien reseteamos los eddittext, sino mostramos un error
        if (guardado) {

            edtNombre.setText("");
            edtEdad.setText("");

            Toast.makeText(this, "Guardado con éxito", Toast.LENGTH_SHORT).show();

        } else {

            Toast.makeText(this, "No se puede guardar", Toast.LENGTH_SHORT).show();

        }

        db.cerrarBD();

    }

}
