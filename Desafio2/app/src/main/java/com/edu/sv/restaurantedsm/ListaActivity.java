package com.edu.sv.restaurantedsm;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListaActivity extends AppCompatActivity {

    ListView listaRefrescos;
    ListView listaPlatos;
    public static int pos;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);
        pos = getIntent().getIntExtra("posicion",-1);
        definirLista(pos);
    }//Fin onCreate()


    public void definirLista(int pos) {

        if (pos == 0) {
            listaRefrescos = findViewById(R.id.lista);
            ArrayAdapter<Producto> adaptador = new ArrayAdapter<Producto>(this, android.R.layout.simple_list_item_1, Producto.refrescos);
            listaRefrescos.setAdapter(adaptador);
            listaRefrescos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    if (position != -1) {
                        Intent intento = new Intent(ListaActivity.this, Lista2Activity.class);
                        intento.putExtra("posicion", String.valueOf(position));
                        intento.putExtra("producto", "refresco");
                        onPause();
                        startActivity(intento);
                    }//Fin If
                }//Fin onItemClick
            });//Fin setOn..
        }//Fin If

        if (pos == 1) {
            listaPlatos = findViewById(R.id.lista);
            ArrayAdapter<Producto> adaptador = new ArrayAdapter<Producto>(this, android.R.layout.simple_list_item_1, Producto.platos);
            listaPlatos.setAdapter(adaptador);
            listaPlatos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    if (i != -1) {
                        Intent intento = new Intent(ListaActivity.this, Lista2Activity.class);
                        intento.putExtra("posicion", String.valueOf(i));
                        intento.putExtra("producto", "plato");
                        onPause();
                        startActivity(intento);
                    }//Fin If
                }//Fin OnItemClick
            });//Fin SetOn..
        }//Fin If
    }//Fin DefinirLista()

    public void onPause(){
        super.onPause();
        //Instanciacion de SharedPreferences
        SharedPreferences datos = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = datos.edit();
        editor.putInt("posicion", pos);
        editor.apply();
    }//Fin onPause()

    public void onResume () {
        super.onResume();
        if(pos == -1){
            SharedPreferences datos = PreferenceManager.getDefaultSharedPreferences(this);
            pos = datos.getInt("posicion", 0);
            definirLista(pos);
        }else{
            definirLista(pos);
        }//Fin If
    }//Fin onResume()
}//Fin Class