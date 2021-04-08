package com.edu.sv.restaurantedsm;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista = findViewById(R.id.opciones);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                         @Override
                                         public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                             if(position != -1) {
                                                 if (position != 2) {
                                                     Intent intento = new Intent(MainActivity.this, ListaActivity.class);
                                                     intento.putExtra("posicion", position);
                                                     startActivity(intento);

                                                 } else {
                                                     Intent intento = new Intent(MainActivity.this, ResumenActivity.class);
                                                     startActivity(intento);
                                                 }//Fin If
                                             }//Fin If
                                         }//Fin onItemClick()
                                     }//Fin setOnItem..
        );
    }//Fin onCreate()
}