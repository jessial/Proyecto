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
import com.example.jessica.fertiapp.api.model.Finca;
import com.example.jessica.fertiapp.api.model.Parcela;
import com.example.jessica.fertiapp.api.model.Rol;
import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IngresarParcelaActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private DatabaseHelper databaseHelper = null;
    private Spinner listaSpinnercultivo;
    private CultivoSembrado[] listaCultivo;
    private CultivoSembrado cultivoSeleccionado;
    private Spinner listaSpinnervariedad;
    private CultivoSembrado[] listaVariedad;
    private CultivoSembrado variedadSeleccionada;
    private Spinner listaSpinnerFinca;
    private Finca[] listaFinca;
    private Finca fincaSeleccionada;
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
        ArrayAdapter arrayAdapterCultivoSembrado = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, listaCultivo);
        listaSpinnercultivo.setAdapter(arrayAdapterCultivoSembrado);
        listaFinca = getFinca();
        listaSpinnerFinca = findViewById(R.id.spinnerFinca);
        listaSpinnerFinca.setOnItemSelectedListener(this);
        ArrayAdapter arrayAdapterFinca = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, listaFinca);
        listaSpinnerFinca.setAdapter(arrayAdapterFinca);
        listaVariedad = getVariedadDeCultivo();
        listaSpinnervariedad = findViewById(R.id.spinnerVariedad);
        listaSpinnervariedad.setOnItemSelectedListener(this);
        ArrayAdapter arrayAdapterCultivoSembradoV = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, listaVariedad);
        listaSpinnervariedad.setAdapter(arrayAdapterCultivoSembradoV);
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
    private CultivoSembrado[] getVariedadDeCultivo() {
            Dao cultivoSembradoDao = null;
            List listVariedad = null;
            try {
                cultivoSembradoDao = getHelper().getCultivoSembradoDao();
                QueryBuilder queryBuilder = cultivoSembradoDao.queryBuilder();
                queryBuilder.setWhere(queryBuilder.where().eq(CultivoSembrado.VARIEDAD, "Hass"));
                listVariedad = cultivoSembradoDao.query(queryBuilder.prepare());
            } catch (SQLException e) {
                e.printStackTrace();
            }
            CultivoSembrado[] cultivoSembradoVArrar = new CultivoSembrado[listVariedad.size()];
            cultivoSembradoVArrar = (CultivoSembrado[]) listVariedad.toArray(cultivoSembradoVArrar);
            return cultivoSembradoVArrar;
    }
        private Finca[] getFinca() {
        Dao fincaDao = null;
        List listFinca = null;
        try {
            fincaDao = getHelper().getFincaDao();
            listFinca = fincaDao.queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Finca[] fincaArrar = new Finca[listFinca.size()];
        fincaArrar = (Finca[]) listFinca.toArray(fincaArrar);
        return fincaArrar;
    }
    public void OnClicIngresar(View view){
        String Parcela = parcela.getText().toString();
        String Area = area.getText().toString();
        String FechaSiembra = fechaSiembra.getText().toString();
        Parcela parcela = new Parcela();
        if (Parcela.equals(""))
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
        Spinner spinner = (Spinner) adapterView;
        if(spinner.getId() == R.id.spinnerCultivo)
        {
            cultivoSeleccionado = listaCultivo[i];
        }
        else if(spinner.getId() == R.id.spinnerFinca)
        {
            fincaSeleccionada = listaFinca[i];
        }
        else if(spinner.getId() == R.id.spinnerVariedad){
            variedadSeleccionada = listaVariedad[i];

        }
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
