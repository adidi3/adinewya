package com.example.adipe.adinewya;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RadioButton rb1;
    RadioButton rb2;
    EditText eivar1, heformac;
    int sidra = 2;
    double  y, k;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rb1 = (RadioButton) findViewById(R.id.radioButton3);
        rb2 = (RadioButton) findViewById(R.id.radioButton4);
        eivar1 = (EditText) findViewById(R.id.editText);
        heformac = (EditText) findViewById(R.id.editText2);

    }


    public void move(View view) {
        if ((eivar1.getText().toString().equals("")) || (eivar1.getText().toString().equals(".-")) || ((eivar1.getText().toString().equals(".")) || (eivar1.getText().toString().equals("-")) || (eivar1.getText().toString().equals("-."))) ||
                ((heformac.getText().toString().equals("")) || (heformac.getText().toString().equals(".-")) || ((heformac.getText().toString().equals(".")) || (heformac.getText().toString().equals("-")) || (heformac.getText().toString().equals("-.")))))

            Toast.makeText(this, "הקלט שהכנסת לא תקין", Toast.LENGTH_SHORT).show();

        else {
            String st = eivar1.getText().toString();
            y = Double.parseDouble(st);
            String st2 = heformac.getText().toString();
            k = Double.parseDouble(st2);
            if ((!rb1.isChecked()) && (!rb2.isChecked()))
                Toast.makeText(this, "צריך לסיים למלא את הכל", Toast.LENGTH_LONG).show();
            else {
                if (rb1.isChecked())
                    sidra = 1;
                else {
                    sidra = 0;
                }
            }


        }

        Intent t = new Intent(this, hisuv.class);
        t.putExtra("hesh/hand", sidra);
        t.putExtra("eivar", y);
        t.putExtra("hefomac", k);
        startActivity(t);


    }


    public void creds(View view) {
        Intent x = new Intent(this, kreditim.class);
        startActivity(x);
    }
}




