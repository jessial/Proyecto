package com.example.jessica.fertiapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class Registro extends AppCompatActivity {

    private EditText cedula;
    private EditText nombre;
    private EditText apellidos;
    private EditText telefono;
    private EditText email;
    private Button registrarse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        initComponents();
    }
    public void initComponents()
    {
        cedula = findViewById(R.id.editTextCedula);
        nombre = findViewById(R.id.editTextNombres);
        apellidos = findViewById(R.id.editTextApellidos);
        telefono = findViewById(R.id.editTextTelefono);
        email = findViewById(R.id.editTextEmail);
        registrarse = findViewById(R.id.btnRegistrar);
    }
}
