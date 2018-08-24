package com.example.jessica.fertiapp;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.jessica.fertiapp.api.DatabaseHelper;
import com.example.jessica.fertiapp.api.model.Usuario;
import com.example.jessica.fertiapp.ui.saveUser.component.SaveUserView;
import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.List;

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

    private List<Usuario> usu;

    public void OnclickIngresar(View view) throws SQLException {
        Dao<Usuario, Integer> usuarioDao = getHelper().getUsuarioDao();
        String cedulaConsultar = cedula.getText().toString();
        if(cedulaConsultar.equals(""))
            cedula.setError("Ingrese su cedula");
        try {
            usu = usuarioDao.queryForEq("usu_cedula", cedulaConsultar);
            if (usu.size() != 0) {
                Intent intent = new Intent(MainActivity.this, MenuActivity.class);
                startActivity(intent);
            } else {
                Toast.makeText(getApplicationContext(), "Por favor registrese", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, SaveUserView.class);
                intent.putExtra("usu_cedula1",cedulaConsultar);
                startActivity(intent);

            }
        } catch (SQLException e){
            e.printStackTrace();
    }
    }
    public void OnClickRegistrar(View view){
        Intent intent = new Intent(MainActivity.this, SaveUserView.class);
        startActivity(intent);
    }
    public void OnClicCrearRol(View view){
        Intent intent = new Intent(MainActivity.this, RolActivity.class );
        startActivity(intent);
    }
    public void OnClicCrearCultivo(View view){
        Intent intent = new Intent(MainActivity.this, CrearCultivoActivity.class );
        startActivity(intent);
    }
}