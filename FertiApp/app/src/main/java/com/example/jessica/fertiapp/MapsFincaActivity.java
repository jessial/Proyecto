package com.example.jessica.fertiapp;

import android.content.Intent;
import android.location.Geocoder;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;


public class MapsFincaActivity extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnMarkerDragListener {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps_finca);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LatLng rionegro = new LatLng(6.1551499, -75.3737106);
        mMap.addMarker(new MarkerOptions().position(rionegro).title("Ubicación").draggable(true));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(rionegro));
        googleMap.setOnMarkerDragListener(this);
    }
    @Override
    public void onMarkerDragStart(Marker marker) {
        if (marker.equals(mMap)) {
            Toast.makeText(this, "START", Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    public void onMarkerDrag(Marker marker) {
        if (marker.equals(mMap)) {
            Double longitud = marker.getPosition().longitude;
            Double latitud = marker.getPosition().latitude;
            String longi = Double.toString(longitud);
            String lati = Double.toString(latitud);
            String coordenada = longi.concat("").concat(lati);
            Intent intent = new Intent(this, FincaActivity.class);
            intent.putExtra("coordenada", coordenada);
            startActivity(intent);
        }
    }
    @Override
    public void onMarkerDragEnd(Marker marker) {
        if (marker.equals(mMap)) {
            Toast.makeText(this, "END", Toast.LENGTH_SHORT).show();
        }
    }
}
