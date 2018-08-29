package com.example.jessica.fertiapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.jessica.fertiapp.ui.saveUser.component.SaveUserView;

public class MenuActivity extends AppCompatActivity {
    private Button cultivo;
    private Button analisis;
    private Button recomendacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        initComponents();
    }
    public void initComponents(){
        cultivo = findViewById(R.id.cultivos);
        analisis = findViewById(R.id.analisis);
        recomendacion = findViewById(R.id.recomendacion);

    }
    public void OnClicCultivo(View view){
        Intent intent = new Intent(MenuActivity.this, MenuCultivoActivity.class);
        startActivity(intent);
    }
    public void OnClicAnalisis(View view){
        Intent intent = new Intent(MenuActivity.this, MenuAnalisisActivity.class);
        startActivity(intent);
    }
    public void OnClicRecomendacion(View view){
        Intent intent = new Intent(MenuActivity.this, RecomendacionActivity.class);
        startActivity(intent);
    }
    public void OnClicFinca(View view){
        Intent intent = new Intent(MenuActivity.this, MapsFincaActivity.class);
        startActivity(intent);
    }
}
