package com.example.jessica.fertiapp.api.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable
public class Finca {
    public static final String CODIGO = "fin_codigo";
    public static final String UBICACION = "fin_ubicacion";
    public static final String NOMBRE = "fin_nombre";

    @DatabaseField(generatedId = true, columnName = CODIGO)
    private int codigo;
    @DatabaseField(columnName = UBICACION)
    private String ubicacion;
    @DatabaseField(columnName = NOMBRE)
    private String nombre;

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public String getUbicacion() {
        return ubicacion;
    }
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString(){
        return nombre;
    }
}
