package com.example.nidodepymes;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class DatosCliente extends AppCompatActivity{

    TextView sal;
    EditText cli;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_cliente);
        sal = (TextView) findViewById(R.id.Salida);
        cli = (EditText) findViewById(R.id.Cliente);
       // getData();

        String dat = "https://s0kg6zbefh.execute-api.us-east-1.amazonaws.com/dev/v1/sandbox/clients/9094578/profile";

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        URL url = null;
        HttpURLConnection conn;

        Button sol = (Button) findViewById(R.id.Solicitar);

        sol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mostrarDatos();;
            }
        });


        try {

            url = new URL(dat);

            conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("GET");

            conn.connect();
            //sal.setText("jhgfeghjknbhgvfcvgbh");

            //InputStream k = conn.getInputStream();


            //InputStreamReader inp = new InputStreamReader(k);

            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            //BufferedReader in = new BufferedReader(inp);

            //sal.setText("fhgjfsgashgkdsa");


            String inputLine;
            StringBuffer response = new StringBuffer();

            String json = "";

            while ((inputLine = in.readLine())!= null){
                response.append(inputLine);
            }

            json = response.toString();

            JSONArray jsonArra = null;

            jsonArra = new JSONArray(json);
            String datosUse = "";

            for (int i = 0; i < json.length(); i++){
                JSONObject jsonObject = jsonArra.getJSONObject(i);

                // Log.d("SALIDA", jsonObject.optString("rfc"));
                datosUse = "Datos: \n" + i + jsonObject.optString("clientProfile") + "\n";
                sal.setText(datosUse);
            }

            //sal.setText(datosUse);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void mostrarDatos(){
        String nom, num, bran, date, rfc, code, len, nac, bir, est, gen, hp, op;
        int n = Integer.parseInt(cli.getText().toString());


        if (n == 9094578){
            nom = "LUIS HACKA3 TEST";
            num = "9094578";
            bran = "5";
            date = "13/08/18";
            rfc = "MEML8603025NV";
            code = "Y";
            len = "Esp";
            nac = "MX";
            bir = "02/03/86";
            est = "S";
            gen = "M";
            hp = "5557217478";
            op = "5557217478";

            sal.setText(nom+"\n"+num+"\n"+bran+"\n"+date+"\n"+rfc+"\n"+code+"\n"+len+"\n"+nac+"\n"+bir+"\n"+est+"\n"+gen+"\n"+hp+"\n"+op);
        }

        if (n == 9094579){
            nom = "HECTO HACKA4 TEST";
            num = "9094579";
            bran = "5";
            date = "13/08/18";
            rfc = "MOFH86040168T";
            code = "Y";
            len = "Esp";
            nac = "MX";
            bir = "01/04/86";
            est = "S";
            gen = "M";
            hp = "5557217478";
            op = "5557217478";

            sal.setText(nom+"\n"+num+"\n"+bran+"\n"+date+"\n"+rfc+"\n"+code+"\n"+len+"\n"+nac+"\n"+bir+"\n"+est+"\n"+gen+"\n"+hp+"\n"+op);
        }
        if(n==0||(n!=9094578 && n!=9094579)){

            sal.setText("Numero de Cuentas NO ENCONTRADO");


        }
    }
  /*  public void getData(){
        String dat = "https://s0kg6zbefh.execute-api.us-east-1.amazonaws.com/dev/v1/sandbox/clients/9094578/profile";

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        URL url = null;
        HttpURLConnection conn;

        try {
            url = new URL(dat);
            conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("GET");

            conn.connect();

            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            String inputLine;
            StringBuffer response = new StringBuffer();

            String json = "";

            while ((inputLine = in.readLine())!= null){
                response.append(inputLine);
            }

            json = response.toString();

            JSONArray jsonArra = null;

            jsonArra = new JSONArray(json);
            String datosUse = "";

            for (int i = 0; i < json.length(); i++){
                JSONObject jsonObject = jsonArra.getJSONObject(i);

               // Log.d("SALIDA", jsonObject.optString("rfc"));
                datosUse = "Datos: \n" + i + jsonObject.optString("clientProfile") + "\n";
            }
            sal.setText("fhgjfsgashgkdsa");

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }*/
}
