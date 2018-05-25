package com.example.jessica.fertiapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.example.jessica.fertiapp.database.DatabaseHelper;
import com.example.jessica.fertiapp.database.Usuario;

import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.query.In;

import java.sql.SQLException;

public class MainActivity extends AppCompatActivity {
    private DatabaseHelper databaseHelper = null;
    private EditText cedula;
    private Button ingresar;
    private Button registrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponents();
    }

    public void initComponents() {
        cedula = findViewById(R.id.cedula);
        ingresar = findViewById(R.id.ingresar);
        registrar = findViewById(R.id.registrar);
    }

    private DatabaseHelper getHelper() {
        if (databaseHelper == null) {
            databaseHelper = OpenHelperManager.getHelper(this, DatabaseHelper.class);
        }
        return databaseHelper;

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (databaseHelper != null) {
            OpenHelperManager.releaseHelper();
            databaseHelper = null;
        }
    }

    private Dao<Usuario, Integer> usuarioDao;
    private Usuario usu;

    public void OnclickIngresar(View view) throws SQLException {
        //usu = usuarioDao.queryForId(Integer.parseInt(cedula.getText().toString()));
        if (usu != null) {
            Intent intent = new Intent(MainActivity.this, MenuActivity.class);
            startActivity(intent);
        } else {
            Toast.makeText(getApplicationContext(), "Por favor registrese", Toast.LENGTH_SHORT).show();
        }
    }
    public void OnClickRegistrar(View view){
        Intent intent = new Intent(MainActivity.this, RegistrarActivity.class);
        startActivity(intent);
    }
}
