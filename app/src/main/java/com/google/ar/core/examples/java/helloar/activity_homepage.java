package com.google.ar.core.examples.java.helloar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class activity_homepage extends Activity {
    private Button scanBtn;
    private Button GPSBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        scanBtn = (Button) findViewById(R.id.scanning);
        scanBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openScan();
            }
        });
        GPSBtn=(Button) findViewById(R.id.navigation);
        GPSBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGPS();
            }
        });
    }
    public void openScan(){
        Intent intent = new Intent(this, HelloArActivity.class);
        startActivity(intent);
    }
    public void openGPS(){
        Intent intent = new Intent(this, GPS_Activity.class);
        startActivity(intent);
    }
}
