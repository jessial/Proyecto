package com.example.jessica.fertiapp.services;

import android.preference.PreferenceActivity;
import android.widget.ArrayAdapter;

import com.example.jessica.fertiapp.api.model.Rol;
import com.example.jessica.fertiapp.util.Constantes;
import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import cz.msebera.android.httpclient.Header;


public class ServicioRol {
    private List<Rol> listaRol;

    private void sendInfoListar() {
        final AsyncHttpClient client = new AsyncHttpClient();
        String url = Constantes.URIConsultarRol;
        client.get(url, null, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                if (statusCode == 200) {
                    try {
                        for (int i = 0; i < response.length(); i++) {
                            Gson gson = new Gson();
                            Rol rol = gson.fromJson(response.getJSONObject(i).toString(), Rol.class);
                            listaRol.add(rol);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                super.onFailure(statusCode, headers, throwable, errorResponse);
            }
        });

    }
}






