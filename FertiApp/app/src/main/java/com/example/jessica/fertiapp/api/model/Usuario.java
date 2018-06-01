package com.example.jessica.fertiapp.api.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable
public class Usuario {
    public static final String CEDULA = "_id";
    public static final String NOMBRE = "usu_nombre";
    public static final String APELLIDO = "usu_apellido";
    public static final String TELEFONO = "usu_telefono";
    public static final String EMAIL = "usu_email";
    public static final String ROL = "rol_id";

    @DatabaseField(id = true, columnName = CEDULA)
    public int id;
    @DatabaseField(columnName = NOMBRE)
    public String nombre;
    @DatabaseField(columnName = APELLIDO)
    public String apellido;

    @DatabaseField(columnName = TELEFONO)
    public String telefono;
    @DatabaseField(columnName = EMAIL)
    public String email;
    @DatabaseField( foreign = true, columnName = ROL)
    public Rol rol;

    public Usuario() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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


    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = this.rol;
    }

}

