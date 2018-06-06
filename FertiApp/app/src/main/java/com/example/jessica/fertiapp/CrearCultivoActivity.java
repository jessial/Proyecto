package com.example.jessica.fertiapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.jessica.fertiapp.api.DatabaseHelper;
import com.example.jessica.fertiapp.api.model.CultivoSembrado;
import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;

public class CrearCultivoActivity extends AppCompatActivity {
    private DatabaseHelper databaseHelper = null;
    private EditText cultivo;
    private EditText variedad;
    private Button crear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_cultivo);
        initComponents();
    }
    public void initComponents(){
        cultivo = findViewById(R.id.cultivo);
        variedad = findViewById(R.id.variedad);
        crear = findViewById(R.id.crear);
    }
    public void OnClicCrear(View view){
        CultivoSembrado cultivoSembrado = new CultivoSembrado();
        cultivoSembrado.setNombre(cultivo.getText().toString());
        cultivoSembrado.setVariedad(variedad.getText().toString());
        try {
            final Dao<CultivoSembrado, Integer> cultivoSembradoDao = getHelper().getCultivoSembradoDao();
            cultivoSembradoDao.create(cultivoSembrado);
            Toast.makeText(getApplicationContext(), "La información se guardó con éxito", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(CrearCultivoActivity.this, MenuActivity.class);
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
