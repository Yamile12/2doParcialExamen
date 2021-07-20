package com.example.examen2doparcial_yamilecen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MenuPrincipal extends AppCompatActivity {
    String minombre,migenero;
    int edad;
    ImageView CARICATURAS,TERROR,ACCION;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);
        CARICATURAS =(ImageView) findViewById(R.id.CARICATURAS_);
        TERROR =(ImageView) findViewById(R.id.TERROR_);
        ACCION =(ImageView) findViewById(R.id.ACCION_);
        CARICATURAS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(getApplicationContext(),ElReproductor.class);
                startActivity(i);
            }
        });
        TERROR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(getApplicationContext(),ElReproductor.class);
                startActivity(i);
            }
        });
        ACCION.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(getApplicationContext(),ElReproductor.class);
                startActivity(i);
            }
        });
    }
}