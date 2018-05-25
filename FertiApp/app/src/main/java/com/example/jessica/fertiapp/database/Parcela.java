package com.example.jessica.fertiapp.database;
import java.util.Date;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by Jessica on 4/5/2018.
 */
@DatabaseTable
public class Parcela {
    public static final String CODIGO = "parl_codigo";
    public static final String FECHA_SIEMBRA = "parl_fecha_siembra";
    public static final String CULTIVO_SEMBRADO = "cus_codigo";
    public static final String FINCA = "fin_codigo";

    @DatabaseField(generatedId = true, columnName = CODIGO)
    private int codigo;
    @DatabaseField(columnName = FECHA_SIEMBRA)
    private Date fecha_siembra;
    @DatabaseField(foreign = true, columnName = CULTIVO_SEMBRADO)
    private CultivoSembrado cultivo_sembrado;
    @DatabaseField(foreign = true, columnName = FINCA)
    private Finca finca;

    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public Date getFecha_siembra() {
        return fecha_siembra;
    }
    public void setFecha_siembra(Date fecha_siembra) {
        this.fecha_siembra = fecha_siembra;
    }
    public CultivoSembrado getCultivoSembrado() {
        return cultivo_sembrado;
    }

    public void setCultivoSembrado(CultivoSembrado cultivo_sembrado) {
        this.cultivo_sembrado = cultivo_sembrado;
    }
    public Finca getFinca() {
        return finca;
    }

    public void setFinca(Finca finca) {
        this.finca = finca;
    }

}
