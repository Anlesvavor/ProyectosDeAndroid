package com.example.conversor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Seccion de atributos
    private EditText editMonerda;
    private EditText editTipoCambio;
    private TextView txtDolares;
    private Button btnConvertir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Conectar la vista con el controlador
    private void conectarVista() {
        setEditMonerda((EditText)findViewById(R.id.editMonedaNacional));
        setEditTipoCambio((EditText)findViewById(R.id.editTipoCambio));
        setBtnConvertir((Button)findViewById(R.id.btnConvertir));
        setTxtDolares((TextView) findViewById(R.id.txtDolares));

        // Agregar al boton el controlador del eevento OnClick
        btnConvertir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertir();
            }
        });
    }

    private void convertir() {
        double monedaNacional = Double.parseDouble(getEditMonerda().getText().toString());
        double tipoCambio = Double.parseDouble(getEditTipoCambio().getText().toString());

        if(getEditTipoCambio().getText().toString().isEmpty()){
            Toast toast = Toast.makeText(getApplicationContext(), "truena", Toast.LENGTH_LONG);
            toast.setMargin(50, 50);
            toast.show();
        }

        // Se llama al método de clase convertirADolar(), de la clase Conversor
        double dolares = Conversor.convertirADolar(monedaNacional, tipoCambio);

        txtDolares.setText("$" + dolares + "USD");
    }

    public TextView getTxtDolares() {
        return txtDolares;
    }

    public void setTxtDolares(TextView txtDolares) {
        this.txtDolares = txtDolares;
    }

    public EditText getEditMonerda() {
        return editMonerda;
    }

    public void setEditMonerda(EditText editMonerda) {
        this.editMonerda = editMonerda;
    }

    public EditText getEditTipoCambio() {
        return editTipoCambio;
    }

    public void setEditTipoCambio(EditText editTipoCambio) {
        this.editTipoCambio = editTipoCambio;
    }

    public Button getBtnConvertir() {
        return btnConvertir;
    }

    public void setBtnConvertir(Button btnConvertir) {
        this.btnConvertir = btnConvertir;
    }
}
