package com.example.disfraces;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Producto extends AppCompatActivity {

    private ListView info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_producto);

        info = (ListView) findViewById(R.id.InfoLV);

        ArrayAdapter<CharSequence> adaptador = ArrayAdapter.createFromResource(this, R.array.Arrayinfo, android.R.layout.simple_list_item_1);
        info.setAdapter(adaptador);
        info.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {

                if(i == 0){
                    Toast.makeText(parent.getContext(), "Info de " + parent.getItemAtPosition(i).toString() +
                            "\n" +"Traje clasico de 1 pieza" + "\n" + "Todas las tallas" + "\n" + "Costo de $700",Toast.LENGTH_SHORT).show();
                }else if(i == 1){
                    Toast.makeText(parent.getContext(), "Info de " + parent.getItemAtPosition(i).toString() +
                            "\n" + "Traje clasico de 5 piezas" + "\n" + "Todas las tallas" + "\n" + "Costo de 800",Toast.LENGTH_SHORT).show();
                }else if(i == 2){
                    Toast.makeText(parent.getContext(), "Info de " + parent.getItemAtPosition(i).toString() +
                            "\n" + "Traje edicion limitada de 2 piezas" + "\n" + "Todas las tallas" + "\n" +"Costo de 1500",Toast.LENGTH_SHORT).show();
                }else if(i == 3){
                    Toast.makeText(parent.getContext(), "Info de " + parent.getItemAtPosition(i).toString() +
                            "\n" + "Traje clasico de una pieza" + "\n" + "Todas las tallas" + "\n" + "Costo de $500",Toast.LENGTH_SHORT).show();
                }else if(i == 4){
                    Toast.makeText(parent.getContext(), "Info de " + parent.getItemAtPosition(i).toString() +
                            "\n" + "Traje clasico de 2 piezas" + "\n" + "Todas las tallas" + "\n" + "Costo de $900",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
    public void regresarPro(View view){
        Intent intent = new Intent(this,ActMenu.class);
        startActivity(intent);
        finish();
    }
}