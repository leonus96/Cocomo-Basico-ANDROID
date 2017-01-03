package com.leonus96.joseph.cocomobasico;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import java.lang.reflect.Array;

public class PF extends AppCompatActivity {
    private SeekBar seekBarEntSimp;
    private SeekBar seekBarEntMed;
    private SeekBar seekBarEntComp;
    private SeekBar seekBarSalSimp;
    private SeekBar seekBarSalMed;
    private SeekBar seekBarSalComp;
    private SeekBar seekBarConsSimp;
    private SeekBar seekBarConsMed;
    private SeekBar seekBarConsComp;
    private SeekBar seekBarArchSimp;
    private SeekBar seekBarArchMed;
    private SeekBar seekBarArchComp;
    private SeekBar seekBarInterSimp;
    private SeekBar seekBarInterMed;
    private SeekBar seekBarInterComp;

    private TextView textEntSimp;
    private TextView textEntMed;
    private TextView textEntComp;
    private TextView textSalSimp;
    private TextView textSalMed;
    private TextView textSalComp;
    private TextView textConsSimp;
    private TextView textConsMed;
    private TextView textConsComp;
    private TextView textArchSimp;
    private TextView textArchMed;
    private TextView textArchComp;
    private TextView textIntSimp;
    private TextView textIntMed;
    private TextView textIntComp;

    private Spinner spinerLang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pf);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Puntos de Funcion");
        setSupportActionBar(toolbar);

        seekBarEntSimp = (SeekBar) findViewById(R.id.seekBarEntSimp);
        seekBarEntMed = (SeekBar) findViewById(R.id.seekBarEntMed);
        seekBarEntComp = (SeekBar) findViewById(R.id.seekBarEntComp);
        seekBarSalSimp = (SeekBar) findViewById(R.id.seekBarSalSimp);
        seekBarSalMed = (SeekBar) findViewById(R.id.seekBarSalMed);
        seekBarSalComp = (SeekBar) findViewById(R.id.seekBarSalComp);
        seekBarConsSimp = (SeekBar) findViewById(R.id.seekBarConsSimp);
        seekBarConsMed = (SeekBar) findViewById(R.id.seekBarConsMed);
        seekBarConsComp = (SeekBar) findViewById(R.id.seekBarConsComp);
        seekBarArchSimp = (SeekBar) findViewById(R.id.seekBarArchSimp);
        seekBarArchMed = (SeekBar) findViewById(R.id.seekBarArchMed);
        seekBarArchComp = (SeekBar) findViewById(R.id.seekBarArchComp);
        seekBarInterSimp = (SeekBar) findViewById(R.id.seekBarInterSimp);
        seekBarInterMed = (SeekBar) findViewById(R.id.seekBarInterMed);
        seekBarInterComp = (SeekBar) findViewById(R.id.seekBarInterComp);

        textEntSimp = (TextView) findViewById(R.id.textEntSim);
        textEntMed = (TextView) findViewById(R.id.textEntMed);
        textEntComp = (TextView) findViewById(R.id.textEntComp);
        textSalSimp = (TextView) findViewById(R.id.textSalSim);
        textSalMed = (TextView) findViewById(R.id.textSalMed);
        textSalComp = (TextView) findViewById(R.id.textSalComp);
        textConsSimp = (TextView) findViewById(R.id.textConsSimp);
        textConsMed = (TextView) findViewById(R.id.textConsMed);
        textConsComp = (TextView) findViewById(R.id.textConsComp);
        textArchSimp = (TextView) findViewById(R.id.textArchSimp);
        textArchMed = (TextView) findViewById(R.id.textArchMed);
        textArchComp = (TextView) findViewById(R.id.textArchComp);
        textIntSimp = (TextView) findViewById(R.id.textIntSimp);
        textIntMed = (TextView) findViewById(R.id.textIntMed);
        textIntComp = (TextView) findViewById(R.id.textIntComp);

        spinerLang = (Spinner) findViewById(R.id.spinnerLang);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.lang, R.layout.support_simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinerLang.setAdapter(adapter);


        eventHandler();
    }

    private void eventHandler() {
        bindBarText(seekBarEntSimp, textEntSimp);
        bindBarText(seekBarEntMed, textEntMed);
        bindBarText(seekBarEntComp, textEntComp);
        bindBarText(seekBarSalSimp, textSalSimp);
        bindBarText(seekBarSalMed, textSalMed);
        bindBarText(seekBarSalComp, textSalComp);
        bindBarText(seekBarArchSimp, textArchSimp);
        bindBarText(seekBarArchMed, textArchMed);
        bindBarText(seekBarArchComp, textArchComp);
        bindBarText(seekBarInterSimp, textIntSimp);
        bindBarText(seekBarInterMed, textIntMed);
        bindBarText(seekBarInterComp, textIntComp);
        bindBarText(seekBarConsSimp, textConsSimp);
        bindBarText(seekBarConsMed, textConsMed);
        bindBarText(seekBarConsComp, textConsComp);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle type = getIntent().getExtras();
                Intent intent = new Intent(PF.this, Resultados.class);
                intent.putExtra("itemRadio", type.getInt("itemRadio"));
                intent.putExtra("KLDC", pf2KLDC());
                startActivity(intent);
            }
        });
    }

    private void bindBarText(SeekBar sb, final TextView tv){
        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                tv.setText(Integer.toString(i));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    private double pf2KLDC(){
        double rpta = 0;
        rpta += seekBarEntSimp.getProgress()*3;
        rpta += seekBarEntMed.getProgress()*4;
        rpta += seekBarEntComp.getProgress()*6;
        rpta += seekBarSalSimp.getProgress()*4;
        rpta += seekBarSalMed.getProgress()*5;
        rpta += seekBarSalComp.getProgress()*7;
        rpta += seekBarConsSimp.getProgress()*3;
        rpta += seekBarConsMed.getProgress()*4;
        rpta += seekBarConsComp.getProgress()*6;
        rpta += seekBarArchSimp.getProgress()*7;
        rpta += seekBarArchMed.getProgress()*10;
        rpta += seekBarArchComp.getProgress()*15;
        rpta += seekBarInterSimp.getProgress()*5;
        rpta += seekBarInterMed.getProgress()*7;
        rpta += seekBarInterComp.getProgress()*10;

        switch (spinerLang.getSelectedItem().toString()){
            case "C":
                rpta *= 128;
                break;
            case "C++":
                rpta *= 29;
                break;
            case "Ensamblador":
                rpta *= 320;
                break;
            case "Java":
                rpta *= 53;
                break;
            case "Oracle":
                rpta *= 40;
                break;
            case "Pascal":
                rpta *= 91;
                break;
            case "Visual Basic":
                rpta *= 32;
                break;
            case "Visual C++":
                rpta *= 34;
                break;
        }

        return rpta/100;
    }
}
