package com.example.pendienteconclases;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.modelos.Punto;
import com.example.modelos.Recta;

public class MainActivity extends AppCompatActivity {

    private Button btnCalcularPendiente;
    private EditText editX1;
    private EditText editX2;
    private EditText editY1;
    private EditText editY2;
    private TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iniciar();
        asignarControl();
    }

    private void asignarControl() {
        btnCalcularPendiente.setOnClickListener(v -> calcular());
    }

    private void iniciar() {
        btnCalcularPendiente = (Button) findViewById(R.id.button);
        editX1 = (EditText) findViewById(R.id.txtX1);
        editX2 = (EditText) findViewById(R.id.txtX2);
        editY1 = (EditText) findViewById(R.id.txtY1);
        editY2 = (EditText) findViewById(R.id.txtY2);
        resultado = (TextView) findViewById(R.id.lblResultado);

    }

    private void calcular(){
        Recta recta = new Recta();
        recta.setP1(
                new Punto(
                        Float.parseFloat(editX1.getText().toString()),
                        Float.parseFloat(editY1.getText().toString())
                )
        );
        recta.setP2(
                new Punto(
                        Float.parseFloat(editX2.getText().toString()),
                        Float.parseFloat(editY2.getText().toString())
                )
        );
        if(recta.isInfinito()){
            Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_LONG).show();
        } else {
            resultado.setText(String.valueOf(recta.getPendiente()));
        }

    }


}
