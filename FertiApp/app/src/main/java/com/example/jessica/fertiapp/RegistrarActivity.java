package com.example.jessica.fertiapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.jessica.fertiapp.database.DatabaseHelper;
import com.example.jessica.fertiapp.database.Rol;
import com.example.jessica.fertiapp.database.Usuario;
import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.List;
public class RegistrarActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private DatabaseHelper databaseHelper = null;
    private EditText cedula;
    private EditText nombre;
    private EditText apellido;
    private EditText telefono;
    private EditText email;
    private Spinner listaSpinnerRol;
    private String[] listaRol = {"Productor", "Vendedor"};
    private String rol;
    private Button registrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);
        initComponents();
    }
    public void initComponents() {
        cedula = findViewById(R.id.cedula);
        nombre = findViewById(R.id.nombre);
        apellido = findViewById(R.id.apellido);
        telefono = findViewById(R.id.telefono);
        email = findViewById(R.id.email);
        registrar = findViewById(R.id.registrar);
        listaSpinnerRol= findViewById(R.id.rol);
        listaSpinnerRol.setOnItemSelectedListener(this);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, listaRol);
        listaSpinnerRol.setAdapter(arrayAdapter);
    }
    /**public String [] getArrayRol(List<Rol> roles) {
        String[] arrayRoles = new String[roles.size()];
        for (int i = 0; i < roles.size(); ++i) {
            arrayRoles[i] = String.valueOf(roles.get(i).getNombre());
        }
        return arrayRoles;
    }*/

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
    public void clicRegistrar(View view) {
        Rol role = new Rol();
        role.setNombre(rol);
        String Cedula =(cedula.getText().toString());
        String Nombre = nombre.getText().toString();
        String Apellido = apellido.getText().toString();
        String Telefono = telefono.getText().toString();
        String Email = email.getText().toString();
        if(Cedula.equals(""))Toast.makeText(getApplicationContext(), "Ingrese cédula", Toast.LENGTH_SHORT).show();
        else if (Nombre.equals(""))Toast.makeText(getApplicationContext(), "Ingrese nombres", Toast.LENGTH_SHORT).show();
        else if (Apellido.equals(""))Toast.makeText(getApplicationContext(), "Ingrese apellidos", Toast.LENGTH_SHORT).show();
        else {
            final Usuario usuario = new Usuario();
            usuario.setCedula(Integer.parseInt(Cedula));
            usuario.setNombre(Nombre);
            usuario.setApellido(Apellido);
            usuario.setTelefono(Telefono);
            usuario.setEmail(Email);
            usuario.setRol(role);
            try {
                final Dao<Usuario, Integer> usuDao = getHelper().getUsuarioDao();
                usuDao.create(usuario);
                Toast.makeText(getApplicationContext(), "La información se guardó con éxito", Toast.LENGTH_SHORT).show();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    @Override
   public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        rol = listaRol[i];

    }
    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
    }
}




