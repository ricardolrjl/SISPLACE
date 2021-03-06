package com.uisrael.sisplaceapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class InformacionActivity extends AppCompatActivity {
    TextView user;
    Integer idPersonal;

    String cedula,nombreUsuario;

    Bundle datoRecibir;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacion);
        //Obtenemos la ActionBar instalada por AppCompatActivity
        ActionBar actionBar = getSupportActionBar();
        //Establecemos el icono en la ActionBar
        actionBar.setIcon(R.mipmap.ic_logo_launcher);
        actionBar.setDisplayShowHomeEnabled(true);
        // Activar flecha ir atrás (ir a la Parent Activity declarada en el manifest)
        actionBar.setDisplayHomeAsUpEnabled(true);
        user=findViewById(R.id.tvUsuario);

        datoRecibir=getIntent().getExtras();
        cedula=datoRecibir.getString("usuario");
        nombreUsuario=datoRecibir.getString("nombre");
        idPersonal=datoRecibir.getInt("idpersonal");
        user.setText(nombreUsuario);
    }

    public void irInformacionPersonal(View v){
        Intent intentEnvio= new Intent(InformacionActivity.this, InformacionPersonalActivity.class);
        intentEnvio.putExtra("usuario",cedula);
        intentEnvio.putExtra("nombre",nombreUsuario);
        intentEnvio.putExtra("idpersonal",idPersonal);
        startActivity(intentEnvio);
    }

    public void irActualizarFoto(View v){
        Intent intentEnvio= new Intent(InformacionActivity.this, ActualizarFotoActivity.class);
        intentEnvio.putExtra("usuario",cedula);
        intentEnvio.putExtra("nombre",nombreUsuario);
        intentEnvio.putExtra("idpersonal",idPersonal);
        startActivity(intentEnvio);
    }

    public void irInicio(View v){
        Intent intentEnvio= new Intent(InformacionActivity.this, InicioActivity.class);
        intentEnvio.putExtra("usuario",cedula);
        intentEnvio.putExtra("nombre",nombreUsuario);
        intentEnvio.putExtra("idpersonal",idPersonal);
        startActivity(intentEnvio);
     //   Toast.makeText(getApplicationContext(),"Ir al Inicio",Toast.LENGTH_SHORT).show();
    }
}
