package com.example.clculodemdiaescolar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nota1 = (DecimalFormat) findViewById(R.id.editDecimal);
        nota2 = (EditText) findViewById(R.id.editDecimal2);
    }

    public void calculamedia(View view) {
        DecimalFormat n = nota1;
        nota2;
        DecimalFormat n2 = nota2;

    }
}