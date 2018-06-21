package com.example.jessica.fertiapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.jessica.fertiapp.ui.saveUser.component.SaveUserView;

public class MenuCultivoActivity extends AppCompatActivity {
    private Button ingresar;
    private Button editar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_cultivo);
        initComponents();
    }
    public void initComponents(){
        ingresar = findViewById(R.id.ingresar);
        editar = findViewById(R.id.editar);
    }
    public void OnClicIngresar(View view){
        Intent intent = new Intent(MenuCultivoActivity.this, IngresarParcelaActivity.class);
        startActivity(intent);

    }
    public void OnClicEditar(View view){
        Intent intent = new Intent(MenuCultivoActivity.this, SaveUserView.class);
        startActivity(intent);

    }
}
