package com.edu.sv.restaurantedsm;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import static java.security.AccessController.getContext;

public class Lista2Activity extends AppCompatActivity {
    //DECLARACIÓN DE VARIABLES
    private Producto producto = new Producto();
    private Producto[] refrescos = producto.refrescos;
    private Producto[] platos = producto.platos;
    private TextView nombre,detalle,precio,cant;
    private ImageView imagen1;
    private String valor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista2);

        nombre = findViewById(R.id.txt_nombre);
        detalle = findViewById(R.id.txt_desc);
        imagen1 = findViewById(R.id.imagen1);
        precio = findViewById(R.id.txt_precio);
        cant = findViewById(R.id.txt_cantidad);

        Bundle bundle = getIntent().getExtras();
        int id = Integer.parseInt(bundle.getString("posicion"));
        String producto  = bundle.getString("producto");

        Producto bebida = Producto.refrescos[id];
        Producto pizza = Producto.platos[id];


        if (producto.equals("refresco")) {

            nombre.setText(bebida.getNombre());
            detalle.setText(bebida.getDescripcion());
            imagen1.setImageResource(bebida.getImagenID());
            valor = String.valueOf(bebida.getPrecio());
            precio.setText("Precio: $" + valor);
        }//Fin If

        if (producto.equals("plato")) {
            nombre.setText(pizza.getNombre());
            detalle.setText(pizza.getDescripcion());
            imagen1.setImageResource(pizza.getImagenID());
            valor = String.valueOf(pizza.getPrecio());
            precio.setText("Precio: $" + valor);
        }//Fin If
    }//Fin onCreate()

    public void agregar(View view){
        String valor = cant.getText().toString();
        int aux = Integer.parseInt(valor);
        cant.setText(""+(aux+1));
    }//Fin agregar()

    public void restar(View view){
        String valor = cant.getText().toString();
        int aux = Integer.parseInt(valor);
        if (aux == 1){
            cant.setText(""+1);
        }else {
            cant.setText("" + (aux - 1));
        }//Fin If
    }//Fin restar()

    HelperBD helperBD = new HelperBD(this);

    public void agregarcarrito(View view){
        SQLiteDatabase db = helperBD.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(EstructuraBD.COLUMNA2, nombre.getText().toString());
        values.put(EstructuraBD.COLUMNA3, detalle.getText().toString());
        values.put(EstructuraBD.COLUMNA4, cant.getText().toString());
        values.put(EstructuraBD.COLUMNA5, valor);
        long newRowId = db.insert(EstructuraBD.TABLE_NAME, null, values);
        Toast.makeText(getApplicationContext(),"Se ha añadido a la lista de pedidos" ,Toast.LENGTH_LONG).show();
    }//Fin agregarcarrito()
}