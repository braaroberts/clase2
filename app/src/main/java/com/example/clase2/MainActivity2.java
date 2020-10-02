package com.example.clase2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("SegundoAct","Aca estoy");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        PersonaModel modelo = new PersonaModel();

        PersonaView vista = new PersonaView(this,modelo);
        vista.onClickListenerGuardar();
      //  ActionBar ab  = super.getSupportActionBar();
      //  ab.setTitle("Nuevo Contacto");
       // ab.setDisplayHomeAsUpEnabled(true);
        Log.d("SegundoAct","Aca estoy, mas abajo");
        Button btnllamar = super.findViewById(R.id.llamar);
        btnllamar.setOnClickListener(new LLamarPorTelClick(this,123123123));

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
       // getMenuInflater().inflate(R.menu.menu_option,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()== android.R.id.home){
            super.finish();
        }
        return super.onOptionsItemSelected(item);
    }
}