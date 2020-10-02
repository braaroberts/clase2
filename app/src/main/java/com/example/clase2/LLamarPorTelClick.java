package com.example.clase2;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.util.Log;
import android.view.View;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class LLamarPorTelClick implements View.OnClickListener {
    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    MainActivity2 main;
    Integer telefono;
    public LLamarPorTelClick ( MainActivity2 main, int telefono){
        this.main = main;
        this.telefono  = telefono;
    }
    @Override
    public void onClick(View v) {
        Intent callIntent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+telefono));

        if(ContextCompat.checkSelfPermission(main.getApplicationContext(), Manifest.permission.CALL_PHONE)== PackageManager.PERMISSION_GRANTED)
        {
            Log.d("prueba","con permisos");
            main.startActivity(callIntent);
        }else{
            ActivityCompat.requestPermissions(main,new String[]{Manifest.permission.CALL_PHONE},1);
            Log.d("prueba","sin permisos");
        }


    }
}
