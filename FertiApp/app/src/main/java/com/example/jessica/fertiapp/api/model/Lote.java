package com.example.jessica.fertiapp.api.model;

import com.j256.ormlite.field.DatabaseField;

public class Lote {

    public static final String CODIGO = "lot_codigo";
    public static final String UBICACION = "lot_ubicacion";
    public static final String NUMERO = "lot_numero";

    @DatabaseField(generatedId = true, columnName = CODIGO)
    private int codigo;
    @DatabaseField(columnName = UBICACION)
    private String ubicacion;
    @DatabaseField(columnName = NUMERO)
    private int numero;

    public int getNumero() { return numero; }
    public void setNumero(int numero) { this.numero = numero; }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public String getUbicacion() {
        return ubicacion;
    }
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

}

