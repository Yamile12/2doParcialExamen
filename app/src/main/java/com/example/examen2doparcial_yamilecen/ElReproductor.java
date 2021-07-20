package com.example.examen2doparcial_yamilecen;

import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

public class ElReproductor extends AppCompatActivity {
    Boolean visto;

    Button reproducir, pausar, detener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_el_reproductor);
        reproducir = (Button) findViewById(R.id.reproduce);
        pausar = (Button) findViewById(R.id.pausar);
        detener = (Button) findViewById(R.id.detener);
        Uri myUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video);
        VideoView videoView = (VideoView) findViewById(R.id.video);
        videoView.setVideoURI(myUri);
        videoView.setMediaController(new MediaController(this));

        videoView.requestFocus();

        AlertDialog.Builder alert = new AlertDialog.Builder(ElReproductor.this);
        alert.setTitle("ATENCIÓN");
        alert.setMessage("Para poder reproducir es necesario que se agregue una foto de perfil");
        alert.setPositiveButton(R.string.dialog_positive, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "Se tomará una foto", Toast.LENGTH_SHORT).show();
                TomarFoto();
                reproducir.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        videoView.start();
                    }
                });
                pausar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        videoView.pause();
                    }
                });
                detener.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        videoView.stopPlayback();
                        videoView.seekTo(0);
                    }
                });

            }
        });
        alert.setNegativeButton(R.string.dialog_negative, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "regresando", Toast.LENGTH_SHORT).show();
                visto = true;
                Intent i = new Intent(getApplicationContext(), MenuPrincipal.class);
                startActivity(i);
            }
        });

        AlertDialog dialog = alert.create();
        dialog.show();

    }

    private void TomarFoto() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, 0);
    }
}
