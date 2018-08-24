package com.example.jessica.fertiapp.ui.saveUser.component;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.jessica.fertiapp.MainActivity;
import com.example.jessica.fertiapp.MenuActivity;
import com.example.jessica.fertiapp.R;
import com.example.jessica.fertiapp.api.DatabaseHelper;
import com.example.jessica.fertiapp.api.model.Rol;
import com.example.jessica.fertiapp.api.model.Usuario;
import com.example.jessica.fertiapp.ui.saveUser.SaveUser;
import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Jessica on 31/5/2018.
 */

public class SaveUserView extends AppCompatActivity implements SaveUser.UserView, AdapterView.OnItemSelectedListener {
    private SaveUserPresenter presenter = new SaveUserPresenter(new SaveUserRepo(), this) ;
    private DatabaseHelper databaseHelper = null;
    private EditText cedula;
    private EditText nombre;
    private EditText apellido;
    private EditText telefono;
    private EditText email;
    private Spinner listaSpinnerRol;
    private Rol[] listaRol;
    private Rol rol;
    private Button registrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);
        initComponents();
    }
    public void initComponents() {
        DatabaseHelper databaseHelper = null;
        presenter =  new SaveUserPresenter(new SaveUserRepo(), this);
        cedula = findViewById(R.id.cedula);
        nombre = findViewById(R.id.nombre);
        apellido = findViewById(R.id.apellido);
        telefono = findViewById(R.id.telefono);
        email = findViewById(R.id.email);
        registrar = findViewById(R.id.registrar);
        listaRol =  getRoles();
        listaSpinnerRol= findViewById(R.id.rol);
        listaSpinnerRol.setOnItemSelectedListener(this);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, listaRol);
        listaSpinnerRol.setAdapter(arrayAdapter);
        String id = getIntent().getStringExtra("usu_cedula1");
        cedula.setText(id);
    }

    private Rol[] getRoles() {
        Dao rolDao = null;
        List listRoles = null;
        try{
            rolDao = getHelper().getRolDao();
            listRoles = rolDao.queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Rol[] rolesArrar = new Rol[listRoles.size()];
        rolesArrar = (Rol[]) listRoles.toArray(rolesArrar);

        return rolesArrar;
    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        rol = listaRol[i];
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void onSaveUser(View view) {
        Usuario user = getUser();
        Dao usuDao = null;
        try{
            usuDao = getHelper().getUsuarioDao();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        presenter.saveUser(user, usuDao);
    }

     private Usuario getUser() {
        Rol role = rol;
        String Cedula = (cedula.getText().toString());
        String Nombre = nombre.getText().toString();
        String Apellido = apellido.getText().toString();
        String Telefono = telefono.getText().toString();
        String Email = email.getText().toString();
        Usuario usuario = new Usuario();
        if (Cedula.equals(""))
            cedula.setError("Ingrese cedula");
        else if (Nombre.equals(""))
            nombre.setError("Ingrese cedula");
        else if (Apellido.equals(""))
            apellido.setError("Ingrese cedula");
        else {
            usuario.setCedula(Cedula);
            usuario.setNombre(Nombre);
            usuario.setApellido(Apellido);
            usuario.setTelefono(Telefono);
            usuario.setEmail(Email);
            usuario.setRol(role);
            Toast.makeText(getApplicationContext(), "Fue guardado con éxito", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(SaveUserView.this, MenuActivity.class);
            startActivity(intent);
        }
        return usuario;
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
