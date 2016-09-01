package com.sebastianruiz.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int num1,num2;
    String result;
    EditText eNum;
    EditText eNum2;
    RadioGroup opcion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        eNum = (EditText) findViewById(R.id.eNum1);
        eNum2 = (EditText) findViewById(R.id.eNum2);
        final  TextView tResul = (TextView) findViewById(R.id.tResultado);
        Button bCalcular = (Button) findViewById(R.id.bCalcular);
        opcion=(RadioGroup) findViewById(R.id.operacion);


        bCalcular.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                if (eNum.getText().toString().matches("") || eNum2.getText().toString().matches("") ){

                    result=getString(R.string.opcion);
                }
                else {
                    num1= Integer.valueOf(eNum.getText().toString());
                    num2= Integer.valueOf(eNum2.getText().toString());
                    double aux;


                    // Is the button now checked?
                    //boolean checked = ((RadioButton) view).isChecked();

                    // Check which radio button was clicked
                    switch(opcion.getCheckedRadioButtonId()) {
                        case R.id.bSuma:

                                result = String.valueOf(num1+num2);

                            break;

                        case R.id.bResta:

                                result = String.valueOf(num1-num2);

                            break;

                        case R.id.bMulti:

                                result = String.valueOf(num1*num2);

                            break;

                        case R.id.bDiv:

                                if (num2==0){
                                    result = getString(R.string.Error);
                                }
                                else {

                                    //result = String.valueOf( aux );
                                    result= String.format("%1$.2f",( (double)num1 / (double) num2 ));
                                }

                            break;
                        default: result= getString(R.string.opcion);

                    }

                }

                tResul.setText(result);
            }
        });
    }


    public void click (View view){ //esta funcion deja clickear los RadioButtons

    }
}
