package com.leonus96.joseph.cocomobasico;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import mehdi.sakout.fancybuttons.FancyButton;

public class MainActivity extends AppCompatActivity {

    private RadioGroup radioGroup;
    private RadioButton radioButtonOrganico;
    private RadioButton radioButtonMedio;
    private RadioButton radioButtonEmbebido;
    private TextView textViewDescription;
    private EditText editTextKLDC;
    private FancyButton buttonPF;
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fab = (FloatingActionButton) findViewById(R.id.fab);

        /*Instanciamos Controles*/
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        radioButtonOrganico = (RadioButton) findViewById(R.id.radioButtonOrganico);
        radioButtonMedio = (RadioButton) findViewById(R.id.radioButtonMedio);
        radioButtonEmbebido = (RadioButton) findViewById(R.id.radioButtonEmbebido);
        textViewDescription = (TextView) findViewById(R.id.textViewDescription);
        editTextKLDC = (EditText) findViewById(R.id.editTextKLDC);
        buttonPF = (FancyButton) findViewById(R.id.buttonPF);

        radioButtonOrganico.setChecked(true); //Organico seleccionado primero
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        eventHandler();
    }

    private void eventHandler(){
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                onSelectTypeProject();
            }
        });

        buttonPF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, PF.class);
                intent.putExtra("itemRadio", getItemChecked());
                startActivity(intent);

            }
        });

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validar()){
                    Intent intent = new Intent(MainActivity.this, Resultados.class);
                    intent.putExtra("itemRadio", getItemChecked());
                    intent.putExtra("KLDC", Double.parseDouble(editTextKLDC.getText().toString()));
                    startActivity(intent);
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private int getItemChecked(){
        if(radioButtonOrganico.isChecked()){
            return 0;
        }else if(radioButtonMedio.isChecked()){
            return 1;
        }else if(radioButtonEmbebido.isChecked()){
            return 2;
        }
        return -1;
    }

    private void onSelectTypeProject(){
        switch (getItemChecked()){
            case 0:
                textViewDescription.setText("Son relativamente pequeños, con proyectos software sencillos en los que el equipo tiene mucha experiencia y tienen pocos requisitos estrictos.");
                break;
            case 1:
                textViewDescription.setText("Son intermedios (en tamaño y complejidad), proyecto software en los que no tienen la misma experiencia todos los miembros del equipo. Hay requisitos más y menos rígidos.");
                break;
            case 2:
                textViewDescription.setText("Son proyectos software que se deben desarrollar con unos requisitos hardware, software y de operación.");
                break;
        }
    }

    private boolean validar(){
        String cadena = editTextKLDC.getText().toString();
        if(cadena.isEmpty()){
            Toast.makeText(this, "Ingrese KLDC", Toast.LENGTH_SHORT).show();
            return false;
        }else if(Integer.parseInt(cadena) <= 0){
            Toast.makeText(this, "Ingrese un valor mayor que 0", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}
