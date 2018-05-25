package com.example.jessica.fertiapp.database;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by Jessica on 4/5/2018.
 */
@DatabaseTable
public class Resultado {
    public static final String CODIGO = "rel_codigo";
    public static final String CaMg = "rel_camg";
    public static final String CaK = "rel_cak";
    public static final String MgK = "rel_mgk";
    public static final String CaMgK = "rel_camgk";
    public static final String SATBASES = "rel_satbases";
    public static final String PARCELA = "parl_codigo";

    @DatabaseField(generatedId = true, columnName = CODIGO)
    private int codigo;
    @DatabaseField(columnName = CaMg)
    private double camg;
    @DatabaseField(columnName = CaK)
    private double cak;
    @DatabaseField(columnName = MgK)
    private double mgk;
    @DatabaseField(columnName = CaMgK)
    private double camgk;
    @DatabaseField(columnName = SATBASES)
    private double satbases;
    @DatabaseField(foreign = true, columnName = PARCELA)
    private Parcela parcela;

    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public double getCamg() {
        return camg;
    }
    public void setCamg(double camg) {
        this.camg = camg;
    }
    public double getCak() {
        return cak;
    }
    public void setCak(double cak) {
        this.cak = cak;
    }
    public double getMgk() {
        return mgk;
    }
    public void setMgk(double mgk) {
        this.mgk = mgk;
    }
    public double getCamgk() {
        return camgk;
    }
    public void setCamgk(double camgk) {
        this.camgk = camgk;
    }
    public double getSatbases() {
        return satbases;
    }
    public void setSatbases(double satbases) {
        this.satbases = satbases;
    }
    public Parcela getParcela() {
        return parcela;
    }

    public void setParcela(Parcela parcela) {
        this.parcela = parcela;
    }
}
