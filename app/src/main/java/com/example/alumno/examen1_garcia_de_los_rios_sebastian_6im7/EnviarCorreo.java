package com.example.alumno.examen1_garcia_de_los_rios_sebastian_6im7;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class EnviarCorreo extends AppCompatActivity {

    TextView txtRes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enviar_correo);

        try {
            Intent Recibir = getIntent();
            Bundle DatosRecibidos = Recibir.getExtras();

            txtRes = (TextView) findViewById(R.id.txtResultado);
            txtRes.setText("Sebastian Garcia de los Rios " + DatosRecibidos.getString("Resultado"));
        }catch(Exception e)
        {
            Toast.makeText(getApplicationContext(),"Ocurrio un error", Toast.LENGTH_LONG).show();
        }
    }


    public void onClickCorreo(View vw) {
        Intent intent=new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_SUBJECT, "Asunto: Examen 1 Parcial");
        intent.putExtra(Intent.EXTRA_TEXT, "Contenido del correo:\n"+txtRes.getText().toString());
        intent.putExtra(Intent.EXTRA_EMAIL, new String[] { "eoropezag@ipn.mx"} );
        startActivity(intent);
    }

}
