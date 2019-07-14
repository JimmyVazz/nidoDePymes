package com.example.nidodepymes;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class MainActivity extends AppCompatActivity {

    Button sinDat;
    Button conDat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sinDat = (Button) findViewById(R.id.sin);

        conDat = (Button) findViewById(R.id.con);

        sinDat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sinDat = new Intent(MainActivity.this, RegistroDeIdea.class);
                startActivity(sinDat);
            }
        });

        conDat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent conDat = new Intent(MainActivity.this, RegistroDeNegocio.class);
                startActivity(conDat);
            }
        });

    }


}
