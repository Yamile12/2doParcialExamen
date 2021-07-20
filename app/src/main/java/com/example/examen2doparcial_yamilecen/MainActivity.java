package com.example.examen2doparcial_yamilecen;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import java.text.BreakIterator;

public class MainActivity extends AppCompatActivity {
Button Menu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Menu = (Button)findViewById(R.id.menuprincipal);

        Menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialogo();
            }
        });

    }
    private void Dialogo()
    {
        AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
        final View customlayout = getLayoutInflater().inflate(R.layout.dialogos,null);
        alert.setView(customlayout);
        alert.setCancelable(false);
        EditText _nombre= customlayout.findViewById(R.id.nombre);
        EditText _edad = customlayout.findViewById(R.id.edad);
        EditText _genero = customlayout.findViewById(R.id.genero);
        alert.setPositiveButton("SE GUARDO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                String Nombre = _nombre.getText().toString();
                Integer Edad = _edad.getText().length();
                String Genero = _genero.getText().toString();
                Toast.makeText(getApplicationContext(),"USTED AGREGO LO SIGUIENTE:"+_nombre+_edad+_genero, Toast.LENGTH_LONG).show();
                Intent i= new Intent(getApplicationContext(),MenuPrincipal.class);
                startActivity(i);
            }
        });
        AlertDialog dialog = alert.create();
        dialog.show();

    }
}