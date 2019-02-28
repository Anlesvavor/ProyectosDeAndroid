package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //Elementos de la vista
    private TextView saludo;
    private EditText editNombre;
    private Button saludar;
    private EditText editEstatura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iniciar();
        asignarControl();
    }

    private void iniciar() {
        //Enlaces de los controles con los elementos de la vista
        saludo = (TextView) findViewById(R.id.saludo);
        editNombre = (EditText)findViewById(R.id.editNombre);
        editEstatura = (EditText)findViewById(R.id.editEstatura);
        saludar = (Button) findViewById(R.id.saludar);
    }

    public void asignarControl() {
        saludar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saludar();
            }
        });
    }

    private void saludar() {

        float estatura = Float.parseFloat(editEstatura.getText().toString());
        String mensaje;

        if(estatura >= 65){
            mensaje = "gigante de los pirineos";
        } else {
            mensaje = "enano";
        }

        String nombre = editNombre.getText().toString();
        saludo.setText(String.format("Hola %s, eres un %s",nombre, mensaje));
    }

}
