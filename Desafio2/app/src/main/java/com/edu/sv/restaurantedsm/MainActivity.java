package com.edu.sv.restaurantedsm;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    //DECLARACION DE VARIABLES
    private ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //INSTANCIAR OBJETOS DE XML A JAVA
        lista = findViewById(R.id.opciones);

        //MÉTODO QUE NOS PERMITE ACCEDER A UN ACTIVITY SEGUN LA SELECCIÓN HECHA
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                         @Override
                                         public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                             //SE EVALÚA QUE LA SELECCIÓN NO FUESE NULA
                                             if(position != -1) {
                                                 //En caso de ser cualquier opcion, excepto por el carrito, envía al Activity2
                                                 if (position != 2) {
                                                     Intent intento = new Intent(MainActivity.this, ListaActivity.class);
                                                     intento.putExtra("posicion", position);
                                                     startActivity(intento);

                                                 } else {//Caso contratio envía al ActivityStore que muestra el carrito
                                                     Intent intento = new Intent(MainActivity.this, ResumenActivity.class);
                                                     startActivity(intento);
                                                 }//Fin If
                                             }//Fin If
                                         }//Fin onItemClick()
                                     }//Fin setOnItem..
        );
    }//Fin onCreate()
}