package com.example.jessica.fertiapp.database;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by Jessica on 5/5/2018.
 */
@DatabaseTable
public class Fuente {
    private static final String CODIGO = "fue_codigo";
    private static final String PRODUCTO = "fue_producto";
    private  static final String TIPOFUENTE = "tf_codigo";

    @DatabaseField(generatedId = true, columnName = CODIGO)
    private int codigo;
    @DatabaseField(columnName = PRODUCTO)
    private String producto;
    @DatabaseField(foreign = true, columnName = TIPOFUENTE)
    private TipoFuente tipoFuente;

}
