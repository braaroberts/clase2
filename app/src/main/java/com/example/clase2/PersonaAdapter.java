package com.example.clase2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PersonaAdapter extends RecyclerView.Adapter<PersonaViewHolder> {
    private List<PersonaModel> personas;


    public PersonaAdapter(){//, RecyclerView recyclerView){


    }
    public void setPersonas(List<PersonaModel> personas){
        this.personas = personas;
    }
    @NonNull
    @Override
    public PersonaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view =  LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        PersonaViewHolder pvh = new PersonaViewHolder(view);
         view.setOnClickListener(pvh);
        return pvh;
    }


    @Override
    public void onBindViewHolder(@NonNull PersonaViewHolder holder, int position) {

        holder.id = position;
        holder.tvNombre.setText(personas.get(position).getNombre());
        holder.tvApellido.setText(personas.get(position).getApellido());
    }


    @Override
    public int getItemCount() {
        return this.personas.size();
    }
}
