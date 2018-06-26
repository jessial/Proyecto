package com.example.jessica.fertiapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuAnalisisActivity extends AppCompatActivity {
    private Button ingresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_analisis);
        initComponents();
    }
    public void initComponents(){
        ingresar = findViewById(R.id.button2);
    }
    public void OnClicIngresar(View view){
        Intent intent = new Intent(MenuAnalisisActivity.this, IngresarAnalisisActivity.class);
        startActivity(intent);

    }
}
