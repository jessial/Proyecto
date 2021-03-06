package com.example.jessica.fertiapp.api.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;

@DatabaseTable
public class Analisis {
    public static final String CODIGO = "ana_codigo";
    public static final String FECHA = "ana_fecha";
    public static final String PH = "ana_ph";
    public static final String CLASE = "ana_clase";
    public static final String MO = "ana_mo";
    public static final String N = "ana_n";
    public static final String P = "ana_p";
    public static final String K = "ana_k";
    public static final String MG = "ana_mg";
    public static final String CA = "ana_ca";
    public static final String AL = "ana_al";
    public static final String NA = "ana_na";
    public static final String S = "ana_s";
    public static final String FE = "ana_fe";
    public static final String B = "ana_b";
    public static final String CU = "ana_cu";
    public static final String MN = "ana_mn";
    public static final String ZN = "ana_zn";
    public static final String PARCELA = "parl_codigo";

    @DatabaseField(generatedId = true, columnName = CODIGO)
    private int codigo;
    @DatabaseField(columnName = FECHA)
    private String fecha;
    @DatabaseField(columnName = PH)
    private double ph;
    @DatabaseField(columnName = MO)
    private double mo;
    @DatabaseField(columnName = CLASE)
    private String clase;
    @DatabaseField(columnName = N)
    private double n;
    @DatabaseField(columnName = P)
    private double p;
    @DatabaseField(columnName = K)
    private double k;
    @DatabaseField(columnName = MG)
    private double mg;
    @DatabaseField(columnName = CA)
    private double ca;
    @DatabaseField(columnName = AL)
    private double al;
    @DatabaseField(columnName = NA)
    private double na;
    @DatabaseField(columnName = S)
    private double s;
    @DatabaseField(columnName = FE)
    private double fe;
    @DatabaseField(columnName = B)
    private double b;
    @DatabaseField(columnName = CU)
    private double cu;
    @DatabaseField(columnName = MN)
    private double mn;
    @DatabaseField(columnName = ZN)
    private double zn;
    @DatabaseField(foreign = true, columnName = PARCELA)
    private Parcela parcela;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getPh() {
        return ph;
    }

    public void setPh(double ph) {
        this.ph = ph;
    }

    public double getMo() {
        return mo;
    }

    public void setMo(double mo) {
        this.mo = mo;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public double getN() {
        return n;
    }

    public void setN(double n) {
        this.n = n;
    }

    public double getP() {
        return p;
    }

    public void setP(double p) {
        this.p = p;
    }

    public double getK() {
        return k;
    }

    public void setK(double k) {
        this.k = k;
    }

    public double getMg() {
        return mg;
    }

    public void setMg(double mg) {
        this.mg = mg;
    }

    public double getCa() {
        return ca;
    }

    public void setCa(double ca) {
        this.ca = ca;
    }

    public double getAl() {
        return al;
    }

    public void setAl(double al) {
        this.al = al;
    }

    public double getNa() {
        return na;
    }

    public void setNa(double na) {
        this.na = na;
    }

    public double getS() {
        return s;
    }

    public void setS(double s) {
        this.s = s;
    }

    public double getFe() {
        return fe;
    }

    public void setFe(double f) {
        this.fe = fe;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getCu() {
        return cu;
    }

    public void setCu(double cu) {
        this.cu = cu;
    }

    public double getMn() {
        return mn;
    }

    public void setMn(double mn) {
        this.mn = mn;
    }

    public double getZn() {
        return zn;
    }

    public void setZn(double zn) {
        this.zn = zn;
    }

    public Parcela getParcela() {
        return parcela;
    }

    public void setParcela(Parcela parcela) {
        this.parcela = parcela;
    }
}
