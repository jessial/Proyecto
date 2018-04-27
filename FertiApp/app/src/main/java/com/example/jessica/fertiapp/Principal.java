package com.example.jessica.fertiapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Principal extends AppCompatActivity {

    private Button ingresar;
    private Button registrarse;
    private EditText cedula;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        initComponents();
    }
    private void initComponents() {
        ingresar = findViewById(R.id.btnIngresar);
        registrarse = findViewById(R.id.btnRegistrar);
        cedula = findViewById(R.id.textCedula);

    }
    public void clicIngresar(View view)
    {
        Intent intent = new Intent();
        startActivity(intent);

    }
    public void clicRegistrarse(View view)
    {
        Intent intent = new Intent(Principal.this, Registro.class);
        startActivity(intent);
    }


}
