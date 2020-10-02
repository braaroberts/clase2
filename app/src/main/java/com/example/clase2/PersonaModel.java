package com.example.clase2;

import androidx.annotation.NonNull;

public class PersonaModel {

    private String nombre;
    private String apellido;
    private Integer dni;
    private String sexo;
    public PersonaModel (){

    }
    public PersonaModel ( String nombre, String apellido){
        this.nombre = nombre;
        this.apellido = apellido;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }


    @NonNull
    @Override
    public String toString() {
        return getDni()+" - " +getNombre()+" - "+getApellido()+" - "+getSexo();
    }
}
