package com.example.cadastro;

import androidx.appcompat.app.AppCompatActivity;

import android.app.FragmentBreadCrumbs;
import android.nfc.tech.NfcB;
import android.nfc.tech.NfcBarcode;
import android.os.Bundle;
import android.renderscript.Sampler;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity<arrayAdapter> extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lista = (ListView) findViewById(R.id.itensID);

        final ArrayList<String> equipes = preencherDados();

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, equipes);
        lista.setAdapter(arrayAdapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),"Item: "+ equipes.get(position).toString(), Toast.LENGTH_SHORT).show();
            }
        });

    }

private ArrayList<String> preencherDados(){
    ArrayList<String> dados = new ArrayList<String>();
    dados.add("Banana");
    dados.add("Pera");
    dados.add("Pera");
    dados.add("Pera");
    dados.add("Pera");
    dados.add("Pera");
    return dados;
}
}