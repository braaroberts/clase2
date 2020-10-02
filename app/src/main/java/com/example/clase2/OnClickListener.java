package com.example.clase2;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class OnClickListener implements View.OnClickListener {

    PersonaView view;
    PersonaModel model;
    MainActivity2 activity2;

    public OnClickListener(PersonaView view,PersonaModel model, MainActivity2 activity2){
      this.view = view;
      this.model = model;
      this.activity2 = activity2;

    }
    @Override
    public void onClick(View view) {

        this.view.cargarModelo();

        Log.d("click", model.toString());

        this.view.cargarPantalla();
        MainActivity.personas.add(model);
        this.activity2.finish();




    }

}
