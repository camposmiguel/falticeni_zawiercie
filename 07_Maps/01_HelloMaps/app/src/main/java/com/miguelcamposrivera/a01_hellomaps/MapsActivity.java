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
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnMapClickListener, GoogleMap.OnMarkerDragListener {

    private GoogleMap mMap;
    Marker schoolMarker;
    Circle circle;
    LatLng lastPosition = null;

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
        schoolMarker.setTag("school");

        mMap.moveCamera(CameraUpdateFactory.newLatLng(salesiansSchool));

        mMap.setOnMapClickListener(this);
        mMap.setOnMarkerDragListener(this);

        // Circle shape
        CircleOptions circleOptions = new CircleOptions()
                .center(salesiansSchool)
                .radius(1000); // In meters

        // Get back the muta
        // ble Circle
        circle = mMap.addCircle(circleOptions);

        // Polylines
        // Instantiates a new Polyline object and adds points to define a rectangle
        PolylineOptions rectOptions = new PolylineOptions()
                .add(new LatLng(37.381426,-6.006705))
                .add(new LatLng(37.380531,-6.005863))  // North of the previous point, but at the same longitude
                .add(new LatLng(37.379597,-6.007006))  // Same latitude, and 30km to the west
                .add(new LatLng(37.380701,-6.008041))  // Same longitude, and 16km to the south
                .add(new LatLng(37.381426,-6.006705)); // Closes the polyline.

        // Get back the mutable Polyline
        Polyline polyline = mMap.addPolyline(rectOptions);


    }

    @Override
    public void onMapClick(LatLng latLng) {
        mMap.addMarker(new MarkerOptions()
                .position(latLng)
                .title("Marker new")
                .draggable(true)
        );

        if(lastPosition != null) {
            PolylineOptions rectOptions = new PolylineOptions()
                    .add(latLng)
                    .add(lastPosition); // Closes the polyline.

            // Get back the mutable Polyline
            Polyline polyline = mMap.addPolyline(rectOptions);
        }

        lastPosition = latLng;

        mMap.animateCamera(CameraUpdateFactory.newLatLng(latLng));
    }

    @Override
    public void onMarkerDragStart(Marker marker) {
        marker.hideInfoWindow();
    }

    @Override
    public void onMarkerDrag(Marker marker) {
        if(marker.getTag().toString() == "school") {
            circle.setCenter(marker.getPosition());
        }

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
