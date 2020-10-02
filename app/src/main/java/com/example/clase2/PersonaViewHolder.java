package com.example.clase2;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PersonaViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
   public TextView tvNombre;
   public TextView tvApellido;
   public Integer id;
    public PersonaViewHolder(@NonNull View itemView) {

        super(itemView);

        tvNombre= this.itemView.findViewById(R.id.tvnombre);
        tvApellido=   this.itemView.findViewById(R.id.tvapellido);

    }

    @Override
    public void onClick(View view) {
        Log.d("LLamando id = ", this.id + " - " +this.tvNombre.getText().toString());
    }

}
