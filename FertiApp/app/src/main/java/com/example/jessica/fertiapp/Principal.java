package com.example.jessica.fertiapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Principal extends AppCompatActivity {

<<<<<<< HEAD
    private Button ingresar;
    private Button registrarse;
    private EditText cedula;

=======
>>>>>>> origin/master
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
<<<<<<< HEAD
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
=======
>>>>>>> origin/master
    }
}
