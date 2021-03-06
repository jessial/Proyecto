package com.example.jessica.fertiapp;

import android.content.Intent;
import android.location.Geocoder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.jessica.fertiapp.api.DatabaseHelper;
import com.example.jessica.fertiapp.api.model.Finca;
import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.Dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Locale;

public class FincaActivity extends AppCompatActivity {
    private DatabaseHelper databaseHelper = null;
    private EditText ubicacion;
    private EditText nombreFinca;
    private Button crear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finca);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        initComponents();
    }
    public void initComponents(){
        ubicacion = findViewById(R.id.ubicacion);
        nombreFinca = findViewById(R.id.nombre);
        crear = findViewById(R.id.crear);
        String coordenadas = getIntent().getStringExtra("coordenada");
        ubicacion.setText(coordenadas);
    }

    public void OnClicCrear(View view){
        Finca finca = new Finca();
        finca.setUbicacion(ubicacion.getText().toString());
        finca.setNombre(nombreFinca.getText().toString());
        if (finca.equals("")){nombreFinca.setError("Ingrese nombre de la finca");}
        if (ubicacion.equals("")){ubicacion.setError("Ingrese la ubicacion");}
        try {
            final Dao<Finca, Integer> fincaDao = getHelper().getFincaDao();
            fincaDao.create(finca);
            Toast.makeText(getApplicationContext(), "La información se guardó con éxito", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(FincaActivity.this, MenuActivity.class);
            startActivity(intent);

        } catch (SQLException e) {
            e.printStackTrace();
        }
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
}

