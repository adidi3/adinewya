package com.example.adipe.adinewya;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class hisuv extends AppCompatActivity implements AdapterView.OnItemClickListener {
    TextView tv1, tv2, tv3, tv4;
    Intent q;
    ListView lv;
    int x, bdik;
    double f, d;
    int a;
    double b;
    double s;
    double c;
    String[] listv1 = new String[20];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hisuv);
        lv = (ListView) findViewById(R.id.lv);
        tv1 = (TextView) findViewById(R.id.tv1);
        tv2 = (TextView) findViewById(R.id.tv2);
        tv3 = (TextView) findViewById(R.id.tv3);
        tv4 = (TextView) findViewById(R.id.tv4);

        if (getIntent()!= null){
            q= getIntent();
            bdik = q.getExtras().getInt("hesh/hand", 10);
            b = q.getExtras().getDouble("eivar", 9.1);
            d = q.getExtras().getDouble("hefomac", 9.0);
            tv1.setText(Double.toString(b));
            tv2.setText(Double.toString(d));
            listv1 [0]=Double.toString(b);
            if (bdik==1) {
                for (int i = 1; i < 20; i++){
                    listv1[i] = Double.toString(Double.parseDouble(listv1[i - 1]) + d);}

            }else{
                for (int i = 1; i < 20; i++){
                    listv1[i] = Double.toString(Double.parseDouble(listv1[i - 1]) * d);}}


            lv.setOnItemClickListener(this);
            lv.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
            ArrayAdapter adp = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, listv1);
            lv.setAdapter(adp); }}


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        x = i + 1;
        tv3.setText(Double.toString(x));
        if (bdik == 0) {
            if (d == 1) {
                s = b * x;
            } else {
                s = ((b * ((Math.pow(d, x)) - 1)) / (d - 1));
            }
            tv4.setText(Double.toString(s));
        }
        if (bdik == 1)
            s = ((x * ((2 * b) + d * (x - 1))) / 2);
        tv4.setText(Double.toString(s));
    }





    public void backk (View view){
            Intent t = new Intent(this, MainActivity.class);
            startActivity(t);
        }
    }

