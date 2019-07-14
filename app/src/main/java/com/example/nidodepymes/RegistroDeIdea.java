package com.example.nidodepymes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RegistroDeIdea extends AppCompatActivity {

    Button reg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_de_idea);

        reg = (Button) findViewById(R.id.Registro);

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent reg = new Intent(RegistroDeIdea.this, HomeEmprendedor.class);
                startActivity(reg);
            }
        });

    }

}
