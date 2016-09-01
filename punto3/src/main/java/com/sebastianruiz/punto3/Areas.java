package com.sebastianruiz.punto3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Areas extends AppCompatActivity  {
    RadioGroup figura;
    EditText dato1;
    EditText dato2;
    TextView result;
   // String resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_areas);
        figura = (RadioGroup) findViewById(R.id.Areas);
        dato1 = (EditText) findViewById(R.id.Dato1);
        dato2 = (EditText) findViewById(R.id.Dato2);
        result= (TextView) findViewById(R.id.Resultado);

    }

    public void click (View view){
        double area,num1,num2;
        if (view.getId()== R.id.Calcular){
            if ((dato1.getText().toString().matches("") || dato2.getText().toString().matches("")) &&
                    ( figura.getCheckedRadioButtonId()== R.id.Rectangulo || figura.getCheckedRadioButtonId() == R.id.Triangulo) ){
                result.setText(getText(R.string.Vacio));
            }
            else if( (dato1.getText().toString().matches("") &&
                    ( figura.getCheckedRadioButtonId()== R.id.Circulo || figura.getCheckedRadioButtonId() == R.id.Cuadro)  ) ){
                result.setText(getText(R.string.Vacio));
            }
            else{
                switch(figura.getCheckedRadioButtonId()) {
                    case R.id.Circulo:
                        num1=Double.valueOf(dato1.getText().toString());
                        area=Math.PI*Math.pow(num1,2);
                        result.setText(String.format("%1$.2f",area));
                        break;

                    case R.id.Cuadro:
                        num1=Double.valueOf(dato1.getText().toString());
                        area=num1*num1;
                        result.setText(String.format("%1$.2f",area));

                        break;

                    case R.id.Rectangulo:
                        num1=Double.valueOf(dato1.getText().toString());
                        num2=Double.valueOf(dato2.getText().toString());
                        area=num1*num2;
                        result.setText(String.format("%1$.2f",area));

                        break;

                    case R.id.Triangulo:
                        num1=Double.valueOf(dato1.getText().toString());//base
                        num2=Double.valueOf(dato2.getText().toString());//altura
                        area=(num1*num2)/2;
                        result.setText(String.format("%1$.2f",area));

                        break;
                    default: result.setText(getString(R.string.Vacio)); ;

                }

            }
        }
        else {

            switch (figura.getCheckedRadioButtonId()) {
                case R.id.Circulo:
                    //dato2.setEnabled(false);
                    dato2.setVisibility(View.INVISIBLE);
                    dato1.setHint(getString(R.string.Radio));
                    break;

                case R.id.Cuadro:
                    dato2.setVisibility(View.INVISIBLE);
                    dato1.setVisibility(View.VISIBLE);
                    dato1.setHint(getString(R.string.Lado));

                    break;

                case R.id.Rectangulo:
                    dato2.setVisibility(View.VISIBLE);
                    dato1.setVisibility(View.VISIBLE);
                    dato1.setHint(getString(R.string.Base));
                    dato2.setHint(getString(R.string.Altura));
                    dato2.getText().clear();

                    break;

                case R.id.Triangulo:
                    dato2.setVisibility(View.VISIBLE);
                    dato1.setVisibility(View.VISIBLE);
                    dato1.setHint(getString(R.string.Base));
                    dato2.setHint(getString(R.string.Altura));
                    dato2.getText().clear();
                    break;
                default:
                    result.setText(getString(R.string.Vacio));
                    ;


            }
        }
    }
}
