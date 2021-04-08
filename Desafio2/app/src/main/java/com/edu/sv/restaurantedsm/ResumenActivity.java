package com.edu.sv.restaurantedsm;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ResumenActivity extends AppCompatActivity {

    Cursor cursor;
    ListView lista;
    TextView total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumen);
        definirLista();
    }//Fin onCreate()

    public void ejecutarQuery(){
        HelperBD helper = new HelperBD(this);
        SQLiteDatabase db = helper.getReadableDatabase();
        String[] projection = {
                EstructuraBD.COLUMNA2,
                EstructuraBD.COLUMNA4,
                EstructuraBD.COLUMNA5
        };

        cursor = db.query(
                EstructuraBD.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null
        );
    }//Fin ejecutarQuery()


    public void definirLista(){
        try {

            ejecutarQuery();
            cursor.moveToFirst();
            lista = findViewById(R.id.lista);
            total = findViewById(R.id.txt_total);
            int acum = 0;
            ArrayList<String> producto = new ArrayList<String>();
            do{

                int cant = Integer.parseInt(cursor.getString(1));
                int precio = Integer.parseInt(cursor.getString(2));
                producto.add(cursor.getString(0) + " \nCantidad: " + cant + " \nPrecio unitario: $" + precio +
                        " \nSubtotal: $" + (precio * cant));
                acum = acum + (precio * cant);
            }while (cursor.moveToNext());//Fin Do-While
            ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, producto);
            lista.setAdapter(adaptador);
            total.setText(total.getText() + "$" + acum);

            cursor.close();
        }catch(Exception e ){
            Toast.makeText(this,"Aun no hay pedidos",Toast.LENGTH_LONG).show();
        }//Fin Try-Catch
    }//Fin definirLista()


    public void borrarPedido(View view){
        try {
            HelperBD helper = new HelperBD(this);
            SQLiteDatabase db = helper.getReadableDatabase();
            db.execSQL(EstructuraBD.SQL_DELETE_REGISTERS);
            onCreate(null);
        }catch (Exception e){
            Toast.makeText(this,"Se ha descartado el pedido",Toast.LENGTH_LONG).show();
            Intent intento = new Intent(this,MainActivity.class);
            startActivity(intento);
        }//Fin Try-Catch
    }//Fin borrarPedido()
}