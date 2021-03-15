package com.google.ar.core.examples.java.helloar;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;

public class GPS_Activity extends Activity {
    Button getLocationBtn;
    TextView locationText;
    LocationManager lM;
    LocationListener lL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_g_p_s_);
        getLocationBtn = (Button) findViewById(R.id.gpsBtn);
        locationText = (TextView) findViewById(R.id.GPSmessage);
        lM = (LocationManager) getSystemService(LOCATION_SERVICE);
        lL = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {

                locationText.setText("the latitude:"+location.getLatitude()+" and the longitude:"+location.getLongitude());
            }

            // called whenever location is updated.
            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }

            //
            @Override
            public void onProviderEnabled(String provider) {

            }

            @Override
            public void onProviderDisabled(String provider) {

            }
        };
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(new String[]{
                        Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.ACCESS_COARSE_LOCATION,Manifest.permission.INTERNET
                },10);
                return;
            }else{
                config();
            }
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch(requestCode){
            case 10:
                if(grantResults.length>0&&grantResults[0]==PackageManager.PERMISSION_GRANTED){
                    config();
                }
                return;
        }
    }

    private void config() {
        getLocationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    lM.requestLocationUpdates("gps", 5000, 0, lL);
                }
                catch (SecurityException se){}
            }
        });

    }
}