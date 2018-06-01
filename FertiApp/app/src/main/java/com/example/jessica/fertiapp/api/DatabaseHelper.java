package com.example.jessica.fertiapp.api;

import java.sql.SQLException;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.jessica.fertiapp.api.model.Analisis;
import com.example.jessica.fertiapp.api.model.CultivoSembrado;
import com.example.jessica.fertiapp.api.model.Finca;
import com.example.jessica.fertiapp.api.model.Parcela;
import com.example.jessica.fertiapp.api.model.Recomendacion;
import com.example.jessica.fertiapp.api.model.Requerimiento;
import com.example.jessica.fertiapp.api.model.Resultado;
import com.example.jessica.fertiapp.api.model.Rol;
import com.example.jessica.fertiapp.api.model.Usuario;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

public class DatabaseHelper extends OrmLiteSqliteOpenHelper {

    private static final String DATABASE_NAME = "fertiApp.db";
    private static final int DATABASE_VERSION = 1;

    private Dao<Usuario, Integer> usuarioDao;
    private Dao<Rol, Integer> rolDao;
    private Dao<Parcela, Integer> parcelaDao;
    private Dao<Finca, Integer> fincaDao;
    private Dao<Resultado, Integer> resultadoDao;
    private Dao<CultivoSembrado, Integer> cultivoSembradoDao;
    private Dao<Requerimiento, Integer> requerimientoDao;
    private Dao<Recomendacion, Integer> recomendacionDao;
    private Dao<Analisis, Integer> analisisDao;


    public DatabaseHelper(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, Usuario.class);
            TableUtils.createTable(connectionSource, Rol.class);
            TableUtils.createTable(connectionSource, Resultado.class);
            TableUtils.createTable(connectionSource, Parcela.class);
            TableUtils.createTable(connectionSource, Finca.class);
            TableUtils.createTable(connectionSource, CultivoSembrado.class);
            TableUtils.createTable(connectionSource, Requerimiento.class);
            TableUtils.createTable(connectionSource, Recomendacion.class);
            TableUtils.createTable(connectionSource, Analisis.class);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        try {
            TableUtils.dropTable(connectionSource, Usuario.class, true);
            TableUtils.dropTable(connectionSource, Rol.class, true);
            TableUtils.dropTable(connectionSource, Resultado.class, true);
            TableUtils.dropTable(connectionSource, Parcela.class, true);
            TableUtils.dropTable(connectionSource, Finca.class, true);
            TableUtils.dropTable(connectionSource, CultivoSembrado.class, true);
            TableUtils.dropTable(connectionSource, Requerimiento.class, true);
            TableUtils.dropTable(connectionSource, Recomendacion.class, true);
            TableUtils.dropTable(connectionSource, Analisis.class, true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        onCreate(db, connectionSource);
    }

    public Dao<Usuario, Integer> getUsuarioDao() throws SQLException {
        if (usuarioDao == null) {
            usuarioDao = getDao(Usuario.class);
        }
        return usuarioDao;
    }

    public Dao<Rol, Integer> getRolDao() throws SQLException {
        if (rolDao == null) {
            rolDao = getDao(Rol.class);
        }
        return rolDao;
    }
    public Dao<Resultado, Integer> getResultadoDao() throws SQLException{
        if(resultadoDao == null){
            resultadoDao = getDao(Resultado.class);
        }
        return resultadoDao;
    }
    public Dao<Parcela, Integer> getParcelaDao() throws SQLException {
        if (parcelaDao == null) {
            parcelaDao = getDao(Parcela.class);
        }
        return parcelaDao;
    }
    public Dao<Finca, Integer> getFincaDao() throws SQLException {
        if (fincaDao == null) {
            fincaDao = getDao(Finca.class);
        }
        return fincaDao;
    }
    public Dao<CultivoSembrado, Integer> getCultivoSembradoDao() throws SQLException {
        if (cultivoSembradoDao == null) {
            cultivoSembradoDao = getDao(CultivoSembrado.class);
        }
        return cultivoSembradoDao;
    }
    public Dao<Requerimiento, Integer> getRequerimientoDao() throws SQLException {
        if (requerimientoDao == null) {
            requerimientoDao = getDao(Requerimiento.class);
        }
        return requerimientoDao;
    }
    public Dao<Recomendacion, Integer> getRecomendacionDao() throws  SQLException{
        if (recomendacionDao == null){
            recomendacionDao = getDao(Recomendacion.class);
        }
        return recomendacionDao;
    }
    public Dao<Analisis, Integer> getAnalisisDao() throws  SQLException{
        if (analisisDao == null){
            analisisDao = getDao(Analisis.class);
        }
        return analisisDao;
    }
    @Override
    public void close() {
        super.close();
        usuarioDao = null;
        rolDao = null;
        resultadoDao = null;
        parcelaDao = null;
        fincaDao = null;
        usuarioDao = null;
        rolDao = null;
        cultivoSembradoDao = null;
        requerimientoDao = null;
        recomendacionDao = null;
        analisisDao = null;
    }

}


