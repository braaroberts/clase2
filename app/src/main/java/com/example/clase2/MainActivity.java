package com.example.clase2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;


import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {
    static List<PersonaModel> personas = null;
    PersonaAdapter personAdapter = new PersonaAdapter();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    personas = new ArrayList<PersonaModel>();
        personas.add(new PersonaModel("Brian", "Roberts"));
        personas.add(new PersonaModel("Axel", "Roberts2"));
        personas.add(new PersonaModel("Alexis", "Roberts3"));
        personas.add(new PersonaModel("Alejandro", "Roberts3"));

        //TODO cuando se clickee un item lleve al dialog y llamar o mismo llamar al contacto

        //temas importantes recycler, adapter, clicks, generar patron mvc, posicionamiento de elementos

        RecyclerView rc = super.findViewById(R.id.recicler);

        personAdapter.setPersonas(personas);
        rc.setAdapter(personAdapter);

        LinearLayoutManager linearlayaoutManager =  new LinearLayoutManager(this);
        linearlayaoutManager.setOrientation(RecyclerView.VERTICAL);
        rc.setLayoutManager(linearlayaoutManager);
        PersonaViewHolder pvh = new PersonaViewHolder(rc);
        rc.setOnClickListener(pvh);
        ActionBar ab  = super.getSupportActionBar();
        ab.setTitle("Contactos");
        ab.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    protected void onResume() {
        personAdapter.notifyDataSetChanged();
       super.onResume();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_option,menu);

        MenuItem menuItem = menu.findItem(R.id.campo_buscar);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setOnQueryTextListener(this);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId()==R.id.op1){
            Intent intent = new Intent(this,MainActivity2.class);
            startActivity(intent);
            Log.d("Click","Se hizo Click en la opt1");
        }else if(item.getItemId()==R.id.op2){
            DialogGenerico dialog = new DialogGenerico("Mensaje","Titulo",false);
            dialog.show(getSupportFragmentManager(),"etiqueta");
            Log.d("Click","Se hizo Click en la opt2");

        }else if(item.getItemId()==R.id.op3){
            DialogGenerico dialog = new DialogGenerico("Mensaje","Titulo",true);
            dialog.show(getSupportFragmentManager(),"etiqueta");
        }
        else if(item.getItemId()== android.R.id.home){

            super.finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onQueryTextSubmit(String s) {
        Log.d("debug","onQueryTextSubmit "+s);
        return false;
    }

    @Override
    public boolean onQueryTextChange(String s) {
        List<PersonaModel> nuevalista = new ArrayList<PersonaModel>();
        for (PersonaModel persona :
                this.personas) {
            if(persona.getNombre().toLowerCase().startsWith(s.toLowerCase())){
                nuevalista.add(persona);
            }

        }
        personAdapter.setPersonas(nuevalista);
        personAdapter.notifyDataSetChanged();
        Log.d("debug","onQueryTextChange "+s);

        return false;
    }
}