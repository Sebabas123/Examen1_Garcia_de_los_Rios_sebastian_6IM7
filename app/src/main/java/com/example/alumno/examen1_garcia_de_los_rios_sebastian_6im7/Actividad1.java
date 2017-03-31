package com.example.alumno.examen1_garcia_de_los_rios_sebastian_6im7;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Actividad1 extends AppCompatActivity {

    EditText txtCantidad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad1);

        txtCantidad = (EditText) findViewById(R.id.Cant);
    }

    public void onClickConvertir(View vw) {
        try {
            int resultado = Integer.parseInt(txtCantidad.getText().toString());
            Toast.makeText(getApplicationContext(), "" + resultado / 18, Toast.LENGTH_LONG).show();
            Intent intento = new Intent(this, EnviarCorreo.class);
            Bundle datos = new Bundle();
            datos.putString("Resultado", "" + resultado / 18);
            intento.putExtras(datos);
            finish();
            startActivity(intento);

        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "Ocurrio un error" + e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
}
