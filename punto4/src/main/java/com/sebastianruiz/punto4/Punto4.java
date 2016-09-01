package com.sebastianruiz.punto4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class Punto4 extends AppCompatActivity {

    EditText eUsuario, ePassword, eRepetirContrasena, eCorreo;
    TextView tMostrarDatos;
    CheckBox checkMasculino,checkFemenino, checkFutbol, checkNadar, checkCorrer, checkBici;
    Spinner Ciudades;
    DatePicker dFecha;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_punto4);

        eUsuario = (EditText)findViewById(R.id.eUsuario);
        ePassword= (EditText)findViewById(R.id.ePassword);
        eRepetirContrasena= (EditText)findViewById(R.id.eRepetirContrasena);
        eCorreo= (EditText)findViewById(R.id.eCorreo);

        checkMasculino = (CheckBox)findViewById(R.id.checkMasculino);
        checkFemenino = (CheckBox)findViewById(R.id.checkFemenino);
        checkFutbol = (CheckBox)findViewById(R.id.checkFutbol);
        checkNadar = (CheckBox)findViewById(R.id.checkNadar);
        checkCorrer = (CheckBox)findViewById(R.id.checkCorrer);
        checkBici = (CheckBox)findViewById(R.id.checkBici);

        Ciudades = (Spinner) findViewById(R.id.spinner);

        dFecha= (DatePicker)findViewById(R.id.dFecha);

        tMostrarDatos = (TextView) findViewById(R.id.tMostrarDatos);


    }

    public void click(View view){
        String falta="",sexo="",hobbies="",nacimiento="",lugar="";
        if (eUsuario.getText().toString().matches("") ){

            falta= getString(R.string.Ingrese)+getString(R.string.Usuario)+getString(R.string.Enter);
        }
        if(ePassword.getText().toString().matches("")){

            falta= falta + getString(R.string.Ingrese)+getString(R.string.Password)+getString(R.string.Enter);
        }
        if (eRepetirContrasena.getText().toString().matches("")){
            falta= falta + getString(R.string.Ingrese)+getString(R.string.tRepetirContrasena)+getString(R.string.Enter);

        }

        if (eCorreo.getText().toString().matches("")){

            falta= falta + getString(R.string.Ingrese)+getString(R.string.tCorreo)+getString(R.string.Enter);
        }
        if ( ( (checkMasculino.isChecked() == true ) && (checkFemenino.isChecked() == true) ) ||
                  ( (checkMasculino.isChecked() == false) && (checkFemenino.isChecked() == false) )){

            falta= falta + getString(R.string.Ingrese)+getString(R.string.tSexo)+getString(R.string.Enter);
        }

        if ( checkFutbol.isChecked() == false && checkNadar.isChecked()==false && checkCorrer.isChecked() == false &&
                  checkBici.isChecked() == false){
            falta= falta + getString(R.string.Ingrese)+getString(R.string.tHobbies)+getString(R.string.Enter);
        }

        if (falta == ""){

             if (!(ePassword.getText().toString().equals(eRepetirContrasena.getText().toString())  )  ){

                falta= getString(R.string.ErroContrasena);
            }
            else {


                if (checkMasculino.isChecked()){ sexo=getString(R.string.SexoM);}//verifica el sexo
                else {sexo=getString(R.string.SexoF);}



                if (checkFutbol.isChecked()){ hobbies = getString(R.string.checkFutbol)+" ";}//verifica los hobbies
                if (checkNadar.isChecked()){ hobbies = hobbies+getString(R.string.checkNadar)+" ";}
                if (checkCorrer.isChecked()){ hobbies= hobbies+getString(R.string.checkCorrer)+" ";}
                if (checkBici.isChecked()){ hobbies= hobbies+getString(R.string.checkBici)+" ";}

                 //se Obtiene la fecha de nacimiento
                nacimiento= String.valueOf(dFecha.getDayOfMonth())+"/"+String.valueOf(dFecha.getMonth()+1)+"/"+String.valueOf(dFecha.getYear());

                 //se obtiene el lugar de nacimiento
                 lugar=Ciudades.getSelectedItem().toString();



                 falta = getString(R.string.Usuario)+ ": "   + eUsuario.getText().toString() +getString(R.string.Enter)+
                         getString(R.string.Password)+": "   + ePassword.getText().toString()+getString(R.string.Enter)+
                         getString(R.string.tCorreo)+ ": "   + eCorreo.getText().toString()  +getString(R.string.Enter)+
                         getString(R.string.tSexo)+": "      + sexo+ getString(R.string.Enter)+
                         getString(R.string.tHobbies)+": "   + hobbies+ getString(R.string.Enter)+
                         getString(R.string.tFecha)+": "     + nacimiento+ getString(R.string.Enter)+
                         getString(R.string.tNacimiento)+": "+lugar+ getString(R.string.Enter) ;



             }
        }
        tMostrarDatos.setText(falta);
    }

    public  void Check_click(View v){ }
}
