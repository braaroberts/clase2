package com.example.clase2;

import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.List;

public class PersonaView {
    MainActivity2 activity;
    PersonaModel modelo;


    public PersonaView (MainActivity2 activity, PersonaModel modelo){

    this.activity = activity;
    this.modelo = modelo;
    }

    public  void cargarModelo(){
        EditText nombre = this.activity.findViewById(R.id.nombre);
        EditText apellido = this.activity.findViewById(R.id.apellido);
        EditText dni = this.activity.findViewById(R.id.dni);
        RadioGroup sexo = this.activity.findViewById(R.id.radioGroupSexo);

        modelo.setNombre(nombre.getText().toString());
        modelo.setApellido(apellido.getText().toString());

        Integer dniNum=0;
        try{
            dniNum= Integer.parseInt(dni.getText().toString());
        }catch(Exception e ){
            Log.d("error",e.getMessage());
        }

        modelo.setDni(dniNum);
        RadioButton sexoSelected  = this.activity.findViewById(sexo.getCheckedRadioButtonId());
        if(sexoSelected!=null)
            modelo.setSexo(sexoSelected.getText().toString());

    }
    public  void cargarPantalla(){

        TextView personaTxt = this.activity.findViewById(R.id.toString);
        personaTxt.setText(modelo.toString());
    }
    public void onClickListenerGuardar(){
        OnClickListener listener = new OnClickListener(this,this.modelo,this.activity);
        Button btn_guardar =  this.activity.findViewById(R.id.Guardar);
        btn_guardar.setOnClickListener(listener);


    }

}
