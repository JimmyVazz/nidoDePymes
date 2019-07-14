package com.example.nidodepymes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomePyme extends AppCompatActivity {

    Button apeHSBC;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_pyme);

        apeHSBC = (Button) findViewById(R.id.cuenta);

        apeHSBC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent apeHSBC = new Intent(HomePyme.this, DatosCliente.class);
                startActivity(apeHSBC);
            }
        });
    }
}