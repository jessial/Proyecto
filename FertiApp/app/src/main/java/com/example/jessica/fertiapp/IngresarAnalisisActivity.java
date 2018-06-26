package com.example.jessica.fertiapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.jessica.fertiapp.api.DatabaseHelper;
import com.example.jessica.fertiapp.api.model.Analisis;
import com.example.jessica.fertiapp.api.model.Rol;
import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.Date;

public class IngresarAnalisisActivity extends AppCompatActivity {
    private DatabaseHelper databaseHelper = null;
    private EditText fecha;
    private EditText ph;
    private EditText mo;
    private EditText clase;
    private EditText p;
    private EditText k;
    private EditText mg;
    private EditText ca;
    private EditText al;
    private EditText na;
    private EditText s;
    private EditText fe;
    private EditText b;
    private EditText cu;
    private EditText mn;
    private EditText zn;
    private Button ingresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingresar_analisis);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        initComponents();
        
    }
    public void initComponents(){
        fecha = findViewById(R.id.fecha);
        ph = findViewById(R.id.ph);
        mo = findViewById(R.id.mo);
        clase = findViewById(R.id.clase);
        p = findViewById(R.id.p);
        k = findViewById(R.id.k);
        mg = findViewById(R.id.mg);
        ca = findViewById(R.id.ca);
        al = findViewById(R.id.al);
        na = findViewById(R.id.na);
        s = findViewById(R.id.s);
        fe = findViewById(R.id.fe);
        b = findViewById(R.id.b);
        cu = findViewById(R.id.cu);
        mn = findViewById(R.id.mn);
        zn = findViewById(R.id.zn);
        ingresar = findViewById(R.id.ingresar);
    }
    private DatabaseHelper getHelper(){
        if(databaseHelper == null){
            databaseHelper = OpenHelperManager.getHelper(this, DatabaseHelper.class);
        }
        return databaseHelper;

    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        if(databaseHelper != null){
            OpenHelperManager.releaseHelper();
            databaseHelper = null;
        }
    }
    public void OnClicIngresar(View view){
        Analisis analisis = new Analisis();
        analisis.setFecha((Date) fecha.getText());
        analisis.setPh(Double.parseDouble(ph.getText().toString()));
        analisis.setClase(clase.getText().toString());
        analisis.setMo(Double.parseDouble(mo.getText().toString()));
        analisis.setP(Double.parseDouble(p.getText().toString()));
        analisis.setK(Double.parseDouble(k.getText().toString()));
        analisis.setMg(Double.parseDouble(mg.getText().toString()));
        analisis.setCa(Double.parseDouble(ca.getText().toString()));
        analisis.setAl(Double.parseDouble(al.getText().toString()));
        analisis.setNa(Double.parseDouble(na.getText().toString()));
        analisis.setS(Double.parseDouble(s.getText().toString()));
        analisis.setFe(Double.parseDouble(fe.getText().toString()));
        analisis.setB(Double.parseDouble(b.getText().toString()));
        analisis.setCu(Double.parseDouble(cu.getText().toString()));
        analisis.setMn(Double.parseDouble(mn.getText().toString()));
        analisis.setZn(Double.parseDouble(zn.getText().toString()));

        try {
            final Dao<Analisis, Integer> analisisDao = getHelper().getAnalisisDao();
            analisisDao.create(analisis);
            Toast.makeText(getApplicationContext(), "La información se guardó con éxito", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(IngresarAnalisisActivity.this, MenuAnalisisActivity.class);
            startActivity(intent);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

