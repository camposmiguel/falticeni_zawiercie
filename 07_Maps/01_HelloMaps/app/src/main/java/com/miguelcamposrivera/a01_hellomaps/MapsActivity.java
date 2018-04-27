package com.miguelcamposrivera.a01_hellomaps;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnMapClickListener, GoogleMap.OnMarkerDragListener {

    private GoogleMap mMap;
    Marker schoolMarker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng salesiansSchool = new LatLng(37.380427,-6.006953);
        schoolMarker = mMap.addMarker(new MarkerOptions()
                .position(salesiansSchool)
                .title("Marker in Salesians School")
                .snippet("here is Gabriel")
                .draggable(true)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.pink_marker))
        );
        mMap.moveCamera(CameraUpdateFactory.newLatLng(salesiansSchool));

        mMap.setOnMapClickListener(this);
        mMap.setOnMarkerDragListener(this);

        // Circle shape
        CircleOptions circleOptions = new CircleOptions()
                .center(salesiansSchool)
                .radius(1000); // In meters

        // Get back the muta
        // ble Circle
        Circle circle = mMap.addCircle(circleOptions);

    }

    @Override
    public void onMapClick(LatLng latLng) {
        mMap.addMarker(new MarkerOptions()
                .position(latLng)
                .title("Marker new")
                .draggable(true)
        );

        mMap.animateCamera(CameraUpdateFactory.newLatLng(latLng));
    }

    @Override
    public void onMarkerDragStart(Marker marker) {
        marker.hideInfoWindow();
    }

    @Override
    public void onMarkerDrag(Marker marker) {
        LatLng markerPosition = marker.getPosition();
        Log.i("MARKER","Position: "
                + markerPosition.latitude
                +","
                + markerPosition.longitude
        );
    }

    @Override
    public void onMarkerDragEnd(Marker marker) {
        marker.showInfoWindow();
    }
}
