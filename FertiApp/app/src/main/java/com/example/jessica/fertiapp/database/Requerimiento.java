package com.example.jessica.fertiapp.database;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by Jessica on 4/5/2018.
 */
@DatabaseTable
public class Requerimiento {
    public static final String CODIGO = "req_codigo";
    public static final String NUTRIENTE = "req_nutriente";
    public static final String CANTIDAD = "req_cantidad";
    public static final String CULTIVOSEMBRADO = "cus_codigo";

    @DatabaseField(generatedId = true, columnName = CODIGO)
    private int codigo;
    @DatabaseField(columnName = NUTRIENTE)
    private String nutriente;
    @DatabaseField(columnName = CANTIDAD)
    private double cantidad;
    @DatabaseField(foreign = true, columnName = CULTIVOSEMBRADO)
    private CultivoSembrado cultivoSembrado;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNutriente() {
        return nutriente;
    }

    public void setNutriente(String nutriente) {
        this.nutriente = nutriente;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public CultivoSembrado getCultivoSembrado() {
        return cultivoSembrado;
    }

    public void setCultivoSembrado(CultivoSembrado cultivoSembrado) {
        this.cultivoSembrado = cultivoSembrado;
    }
}
