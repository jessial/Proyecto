package com.example.jessica.fertiapp.api.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by Jessica on 5/5/2018.
 */
@DatabaseTable
public class TipoFuente {
    private static final String CODIGO = "tf_codigo";
    private static final String NOMBRE = "tf_nombre";
    private static final String APORTE = "tf_aporte";

    @DatabaseField(generatedId = true, columnName = CODIGO)
    private int codigo;
    @DatabaseField(columnName = NOMBRE)
    private String nombre;
    @DatabaseField(columnName = APORTE)
    private double aporte;

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

    public double getAporte() {
        return aporte;
    }

    public void setAporte(double aporte) {
        this.aporte = aporte;
    }
}
