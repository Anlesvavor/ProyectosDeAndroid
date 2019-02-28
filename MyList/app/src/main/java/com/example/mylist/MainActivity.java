package com.example.mylist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // Declarar los controles de la vista
    private EditText editNombre;
    private Button btnAgregar;
    private ListView listNombres;

    // Elementos para poder manejar la lista
    private ArrayList<String> arrayNombres;
    private ArrayAdapter<String> adapterNombres;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicio();

    }

    // Enlace e inicialización de los controles
    private void inicio() {
        editNombre =(EditText) findViewById(R.id.editNombre);
        btnAgregar = (Button) findViewById(R.id.btnAgregar);
        listNombres = (ListView) findViewById(R.id.listNombres);

        // Se inicializan los elementos para controlar el ListView
        arrayNombres = new ArrayList<>();

        adapterNombres = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                arrayNombres
        );




        // Agregar listeners
        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                agregar();
            }
        });

        // Método para detectar un evento click en alguno de sus items
        listNombres.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String valorItem = (String) listNombres.getItemAtPosition(position);
                Toast.makeText(getApplicationContext(), valorItem, Toast.LENGTH_LONG).show();

            }
        });

    }

    private void agregar() {

        // Caoturar los datos de la vista del ccontrol EditView
        String dato = editNombre.getText().toString();
        arrayNombres.add(dato);
        listNombres.setAdapter(adapterNombres);

        editNombre.setText("");
    }
}
