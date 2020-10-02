package com.example.clase2;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class DialogGenerico extends DialogFragment {

   private String mensaje;
   private String titulo;
   private Boolean personalizado = false;

   public DialogGenerico(String mensaje, String titulo, Boolean personalizado){
       this.mensaje = mensaje;
       this.titulo = titulo;
       this.personalizado = personalizado;

   }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(this.titulo);

        if(personalizado)
        { View dialogPersonalizado = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_personalizado,null);
            builder.setView(dialogPersonalizado);
        }else{
            builder.setMessage(this.mensaje);
            clickDialogGeneric clickDialog = new clickDialogGeneric();
            builder.setNegativeButton("negative",clickDialog);
            builder.setPositiveButton("positivo",clickDialog);
            builder.setNeutralButton("neutral",clickDialog);

        }

        return builder.create();
    }
}
