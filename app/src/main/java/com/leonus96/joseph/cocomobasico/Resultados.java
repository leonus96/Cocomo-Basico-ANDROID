package com.leonus96.joseph.cocomobasico;

import android.icu.text.DecimalFormat;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class Resultados extends AppCompatActivity {
    private TextView varA;
    private TextView varB;
    private TextView varC;
    private TextView varD;
    private TextView tvKldc;
    private TextView effort;
    private TextView time;
    private TextView dev;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Resultados");
        setSupportActionBar(toolbar);

        varA = (TextView) findViewById(R.id.varA);
        varB = (TextView) findViewById(R.id.varB);
        varC = (TextView) findViewById(R.id.varC);
        varD = (TextView) findViewById(R.id.varD);
        tvKldc = (TextView) findViewById(R.id.kldc);
        effort = (TextView) findViewById(R.id.effort);
        time = (TextView) findViewById(R.id.time);
        dev = (TextView) findViewById(R.id.dev);

        cocomobasico();
    }

    private void cocomobasico() {
        Bundle datos = this.getIntent().getExtras();
        double a = 0, b = 0, c = 2.5, d = 0;
        int type = datos.getInt("itemRadio");
        double kldc = datos.getDouble("KLDC");
        switch (type){
            case 0:
                a = 2.4; b = 1.05; d = 0.38;
                break;
            case 1:
                a = 3.0; b = 1.12; d = 0.35;
                break;
            case 2:
                a = 3.6; b = 1.20; d = 0.32;
                break;
        }
        double esfuerzo = a * Math.pow(kldc, b);
        double desTime = c * Math.pow(esfuerzo, d);
        double developers = esfuerzo/desTime;




        /***Llenamos datos***/

        varA.setText(Double.toString(a));
        varB.setText(Double.toString(b));
        varC.setText(Double.toString(c));
        varD.setText(Double.toString(d));
        tvKldc.setText(Integer.toString((int)kldc));
        effort.setText(Integer.toString((int)Math.ceil(esfuerzo)));
        //effort.setText(Double.toString(Math.ceil(esfuerzo)));
        time.setText(Integer.toString((int)Math.ceil(desTime)));
        dev.setText(Integer.toString((int)Math.ceil(developers)));
    }

}
