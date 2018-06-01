package com.example.jessica.fertiapp.api.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;

@DatabaseTable
public class Recomendacion {
    public static final String CODIGO = "rec_codigo";
    public static final String PRODUCTO = "rec_producto";
    public static final String CANTIDAD = "rec_cantidad";
    public static final String FECHA = "rec_fecha";
    public static final String PARCELA = "parl_codigo";

    @DatabaseField(generatedId = true, columnName = CODIGO)
    private int codigo;
    @DatabaseField(columnName = PRODUCTO)
    private String producto;
    @DatabaseField(columnName = CANTIDAD)
    private double cantidad;
    @DatabaseField(columnName = FECHA)
    private Date fecha;
    @DatabaseField(foreign = true, columnName = PARCELA)
    private Parcela parcela;
}
