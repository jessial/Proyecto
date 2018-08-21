package com.example.jessica.fertiapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.jessica.fertiapp.api.DatabaseHelper;
import com.example.jessica.fertiapp.api.model.CultivoSembrado;
import com.example.jessica.fertiapp.api.model.Parcela;
import com.example.jessica.fertiapp.api.model.Rol;
import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class IngresarParcelaActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private DatabaseHelper databaseHelper = null;
    private Spinner listaSpinnercultivo;
    private CultivoSembrado[] listaCultivo;
    private CultivoSembrado cultivoSeleccionado;
    private Spinner listaSpinnervariedad;
    private CultivoSembrado[] listaVariedad;
    private CultivoSembrado variedadSeleccionada;
    private EditText ubicacion;
    private EditText  parcela;
    private EditText area;
    private EditText fechaSiembra;
    private Button ingresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingresar_parcela);
        initComponents();
    }
    public void initComponents(){
        listaCultivo = getCultivoSembrados();
        listaSpinnercultivo = findViewById(R.id.spinnerCultivo);
        listaSpinnercultivo.setOnItemSelectedListener(this);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, listaCultivo);
        listaSpinnercultivo.setAdapter(arrayAdapter);
        listaSpinnervariedad = findViewById(R.id.spinnerVariedad);
        listaSpinnervariedad.setOnItemSelectedListener(this);
        ArrayAdapter arrayAdapterVariedad = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, listaVariedad);
        listaSpinnervariedad.setAdapter(arrayAdapterVariedad);
        ubicacion = findViewById(R.id.ubicacion);
        parcela = findViewById(R.id.parcela);
        area = findViewById(R.id.area);
        fechaSiembra = findViewById(R.id.fechaSiembra);
        ingresar = findViewById(R.id.ingresar);
    }
    private CultivoSembrado[] getCultivoSembrados() {
        Dao cultivoSembradoDao = null;
        List listCultivo = null;
        try {
            cultivoSembradoDao = getHelper().getCultivoSembradoDao();
            listCultivo = cultivoSembradoDao.queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        CultivoSembrado[] cultivoSembradoArrar = new CultivoSembrado[listCultivo.size()];
        cultivoSembradoArrar = (CultivoSembrado[]) listCultivo.toArray(cultivoSembradoArrar);
        return cultivoSembradoArrar;
    }
    public void OnClicIngresar(View view){
        String Ubicacion = (ubicacion.getText().toString());
        String Parcela = parcela.getText().toString();
        String Area = area.getText().toString();
        String FechaSiembra = fechaSiembra.getText().toString();
        Parcela parcela = new Parcela();
        if (Ubicacion.equals(""))
            Toast.makeText(getApplicationContext(), "Por favor ingrese una ubicación", Toast.LENGTH_SHORT).show();
        else if (Parcela.equals(""))
            Toast.makeText(getApplicationContext(), "Por favor ingrese un lote o parcela", Toast.LENGTH_SHORT).show();
        else if (Area.equals(""))
            Toast.makeText(getApplicationContext(), "Por favor ingrese el área del lote o parcela", Toast.LENGTH_SHORT).show();
        else if (FechaSiembra.equals(""))
            Toast.makeText(getApplicationContext(), "Por favor ingrese la fecha de siembra", Toast.LENGTH_SHORT).show();
        else {
        }
        try {
            final Dao<Parcela, Integer> parcelaDao = getHelper().getParcelaDao();
            parcelaDao.create(parcela);
            Toast.makeText(getApplicationContext(), "La información se guardó con éxito", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(IngresarParcelaActivity.this, MenuCultivoActivity.class);
            startActivity(intent);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        cultivoSeleccionado = listaCultivo[i];
        variedadSeleccionada = listaVariedad[i];
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

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
