package com.example.calculodependiente;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button calcularPendiente;
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

    private void iniciar(){
        calcularPendiente = (Button) findViewById(R.id.btnCalcular);
        editX1 = (EditText) findViewById(R.id.txtX1);
        editX2 = (EditText) findViewById(R.id.txtX2);
        editY1 = (EditText) findViewById(R.id.txtY1);
        editY2 = (EditText) findViewById(R.id.txtY2);
        resultado = (TextView) findViewById(R.id.txtPendiente);
    }

    private void asignarControl() {
        calcularPendiente.setOnClickListener(v -> calcular());
    }

    private void calcular() {
        float x1, x2, y1, y2;
        x1 = Float.parseFloat(editX1.getText().toString());
        x2 = Float.parseFloat(editX2.getText().toString());
        y1 = Float.parseFloat(editY1.getText().toString());
        y2 = Float.parseFloat(editY2.getText().toString());

        resultado.setText(String.format("%s", calculoDePendiente(x1, x2, y1, y2)));
    }

    private float calculoDePendiente(float x1, float x2, float y1, float y2) {
        return (y2 - y1)/(x2 - x1);
    }
}
