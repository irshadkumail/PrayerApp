package com.sodo.kumail.prayerapp;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Location;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

import java.util.ArrayList;

/**
 * Created by kumail on 6/3/2016.
 */

public class FragmentB extends Fragment implements OnMapReadyCallback,GoogleMap.OnMapLongClickListener,GoogleMap.OnMyLocationChangeListener {

    SupportMapFragment mapFragment;
    GoogleMap mMap;

    public static final LatLng kLatLng=new LatLng(21.4225, 39.8262);
    public static final int MY_PERMISSIONS_REQUEST_READ_CONTACTS=101;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup parent, Bundle bundle)
    {
        View view=layoutInflater.inflate(R.layout.fragment_b,parent,false);


        return view;
    }
    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);

        //  mapFragment.getMapAsync(getActivity());

    }
    public void onStart()
    {
        super.onStart();
        mapFragment= (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;



      //  LatLng sydney = new LatLng(-34, 151);
       // mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));

        checkRuntimePermission();
        //setListeners();


    }
    public void setListeners()
    {
        mMap.setOnMapLongClickListener(this);
        mMap.setOnMyLocationChangeListener(this);

        mMap.setMyLocationEnabled(true);



    }

    @Override
    public void onMapLongClick(LatLng latLng) {
        if(latLng==null)
            Toast.makeText(getContext(),"LatLng NULL in onMapLongCLick",Toast.LENGTH_LONG).show();
        else {
            mMap.addMarker(new MarkerOptions().title("You are Clicking here").position(latLng));


            PolylineOptions polylineOptions= new PolylineOptions();
            polylineOptions.color(Color.GREEN);
            polylineOptions.width(4);
            ArrayList<LatLng> arrayList= new ArrayList<>();
            arrayList.add(latLng);
            arrayList.add(kLatLng);

            polylineOptions.addAll(arrayList);

            mMap.addPolyline(polylineOptions);
        }
    }

    @Override
    public void onMyLocationChange(Location location) {


        Toast.makeText(getContext(),"in onMyLocationChange()",Toast.LENGTH_LONG).show();
        mMap.clear();
        if(location==null)
            Toast.makeText(getContext(),"Location NULL in onMyLocationChange()",Toast.LENGTH_LONG).show();
        else {
            LatLng currentlatlng= new LatLng(location.getLatitude(),location.getLongitude());

            mMap.addMarker(new MarkerOptions().title("You are Here").position(currentlatlng));


            mMap.setBuildingsEnabled(true);
            PolylineOptions polylineOptions= new PolylineOptions();
            polylineOptions.color(Color.GREEN);
            polylineOptions.width(4);
            ArrayList<LatLng> arrayList= new ArrayList<>();
            arrayList.add(currentlatlng);
            arrayList.add(kLatLng);

            polylineOptions.addAll(arrayList);

            mMap.addPolyline(polylineOptions);

            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(currentlatlng,16.0f));



        }

    }
    public void checkRuntimePermission()
    {
        if(ContextCompat.checkSelfPermission(getActivity(), Manifest.permission_group.LOCATION)!=PackageManager.PERMISSION_GRANTED)
        {

            if(ActivityCompat.shouldShowRequestPermissionRationale(getActivity(),Manifest.permission.ACCESS_FINE_LOCATION))
            {

            }
            else
            {
                requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.ACCESS_COARSE_LOCATION},MY_PERMISSIONS_REQUEST_READ_CONTACTS);
               // setListeners();
            }
        }

    }
    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {

        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_READ_CONTACTS:
                setListeners();
                break;


            // other 'case' lines to check for other
            // permissions this app might request
        }
    }

}
