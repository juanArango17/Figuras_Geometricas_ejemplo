package com.programacionmoviles.juanpabloarangoa.figuras_geometricas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import java.text.DecimalFormat;

/*
* Falta mirar si lo que se envia desde texto es nulo...rev. 12/12/17
*
* */

public class MainActivity extends AppCompatActivity {

    int estadoActual = R.id.radioButton_circle;

    public double roundFourDecimals(double d)
    {
        DecimalFormat twoDForm = new DecimalFormat("#.####");
        return Double.valueOf(twoDForm.format(d));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RadioGroup radioGroup = findViewById(R.id.Botones);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
            {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {

                    TextView t1 = findViewById(R.id.textView_Result3);
                    TextView t2 = findViewById(R.id.VolumeText);

                    t1.setVisibility(View.INVISIBLE);
                    t2.setVisibility(View.INVISIBLE);

                    LinearLayout squareLinearLayout = findViewById(R.id.square_LinearLayout);
                    LinearLayout circleLinearLayout = findViewById(R.id.circle_LinearLayout);
                    LinearLayout triangLinearLayout = findViewById(R.id.triangle_LinearLayout);
                    LinearLayout cubeLinearLayout   = findViewById(R.id.cube_LinearLayout);

                    TextView areaText = findViewById(R.id.AreaText);
                    TextView perimText = findViewById(R.id.PerimText);
                    TextView volumenText = findViewById(R.id.VolumeText);

                    estadoActual = checkedId;
                    switch (checkedId) {
                        case R.id.radioButton_square:
                            EditText ladoView = findViewById(R.id.ladoValue);
                            ladoView.setText("");

                            squareLinearLayout.setVisibility(View.VISIBLE);
                            circleLinearLayout.setVisibility(View.INVISIBLE);
                            triangLinearLayout.setVisibility(View.INVISIBLE);
                            cubeLinearLayout.setVisibility(  View.INVISIBLE);

                            break;
                        case R.id.radioButton_circle:
                            EditText radioView = findViewById(R.id.radioValue);
                            radioView.setText("");

                            squareLinearLayout.setVisibility(View.INVISIBLE);
                            circleLinearLayout.setVisibility(View.VISIBLE);
                            triangLinearLayout.setVisibility(View.INVISIBLE);
                            cubeLinearLayout.setVisibility(  View.INVISIBLE);
                            break;
                        case R.id.radioButton_triangle:
                            EditText baseView   = findViewById(R.id.baseValue);
                            baseView.setText("");
                            EditText alturaView = findViewById(R.id.alturaValue);
                            alturaView.setText("");

                            squareLinearLayout.setVisibility(View.INVISIBLE);
                            circleLinearLayout.setVisibility(View.INVISIBLE);
                            triangLinearLayout.setVisibility(View.VISIBLE);
                            cubeLinearLayout.setVisibility(  View.INVISIBLE);
                            break;
                        case R.id.radioButton_cube:
                            EditText aristaView = findViewById(R.id.aristaValue);
                            aristaView.setText("");

                            squareLinearLayout.setVisibility(View.INVISIBLE);
                            circleLinearLayout.setVisibility(View.INVISIBLE);
                            triangLinearLayout.setVisibility(View.INVISIBLE);
                            cubeLinearLayout.setVisibility(  View.VISIBLE);

                            t1.setVisibility(View.VISIBLE);
                            t2.setVisibility(View.VISIBLE);

                            break;

                    }
                    areaText.setText("0");
                    perimText.setText("0");
                    volumenText.setText("0");
                }
            }
        );
    }

    public void calculateSolver(View vista){

        TextView areaText = findViewById(R.id.AreaText);
        TextView perimText = findViewById(R.id.PerimText);
        TextView volumenText = findViewById(R.id.VolumeText);
        switch (estadoActual){
            case R.id.radioButton_square:
                EditText ladoView = findViewById(R.id.ladoValue);
                double lado = Double.parseDouble(ladoView.getText().toString());

                areaText.setText(String.valueOf(lado*lado));
                perimText.setText(String.valueOf(4*lado));
                break;
            case R.id.radioButton_circle:
                EditText radioView = findViewById(R.id.radioValue);
                double radio = Double.parseDouble(radioView.getText().toString());

                areaText.setText(String.valueOf(roundFourDecimals(Math.PI*radio*radio)));
                perimText.setText(String.valueOf(roundFourDecimals(2*Math.PI*radio)));
                break;
            case R.id.radioButton_triangle:
                EditText baseView = findViewById(R.id.baseValue);
                double base = Double.parseDouble(baseView.getText().toString());
                EditText alturaView = findViewById(R.id.alturaValue);
                double altura = Double.parseDouble(alturaView.getText().toString());

                areaText.setText(String.valueOf((base*altura)));
                perimText.setText(String.valueOf(2*base+2*altura));
                break;
            case R.id.radioButton_cube:
                EditText aristaView = findViewById(R.id.aristaValue);
                double arista = Double.parseDouble(aristaView.getText().toString());

                areaText.setText(String.valueOf(6*arista*arista));
                perimText.setText(String.valueOf(12*arista));
                volumenText.setText(String.valueOf(arista*arista*arista));
                break;
        }


    }



}
