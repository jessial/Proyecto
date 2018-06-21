package com.example.jessica.fertiapp.api.model;

import com.j256.ormlite.field.DatabaseField;

import java.util.Date;

/**
 * Created by Jessica on 4/5/2018.
 */

public class  CultivoSembrado {
    public static final String CODIGO = "cus_codigo";
    public static final String VARIEDAD = "cus_variedad";
    public static final String NOMBRE = "cus_nombre";

    @DatabaseField(generatedId = true, columnName = CODIGO)
    private int codigo;
    @DatabaseField(columnName = NOMBRE)
    private String nombre;
    @DatabaseField(columnName = VARIEDAD)
    private String variedad;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getVariedad() {
        return variedad;
    }

    public void setVariedad(String variedad) {
        this.variedad = variedad;
    }
}

