package com.example.jessica.fertiapp.api.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable
public class Finca {
    public static final String CODIGO = "fin_codigo";
    public static final String UBICACION = "fin_ubicacion";
    public static final String AREA = "fin_area";
    public static final String NOMBRE = "fin_nombre";
    public static final String PROPIETARIO = "fin_propietario";

    @DatabaseField(generatedId = true, columnName = CODIGO)
    private int codigo;
    @DatabaseField(columnName = UBICACION)
    private String ubicacion;
    @DatabaseField(columnName = AREA)
    private double area;
    @DatabaseField(columnName = NOMBRE)
    private String nombre;
    @DatabaseField(columnName = PROPIETARIO)
    private String propietario;

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public String getUbicacion() {
        return ubicacion;
    }
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
    public double getArea() {
        return area;
    }
    public void setArea(double area) {
        this.area = area;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getPropietario() {
        return propietario;
    }
    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }
}
