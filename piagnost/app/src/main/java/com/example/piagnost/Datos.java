package com.example.piagnost;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Datos extends AppCompatActivity {

    private EditText cod;
    private TextView dat;
    private ArmasDuras[] armasduras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos);

        armasduras = new ArmasDuras[10];
        armasduras[0] = new ArmasDuras(0, "Espada de Fuego", "Espada", "Epico", "Encantado", "", "", "", "Reliquia");
        armasduras[1] = new ArmasDuras(1, "Casco de dragon", "Casco", "Legendario", "", "Bendecido", "Maldecido", "Dañado", "");

        cod = (EditText) findViewById(R.id.cods);
        dat = (TextView) findViewById(R.id.Cosulta);

    }

    public void Buscar(View view){
        if (cod.getText().length() == 0) {
            Toast.makeText(this, "Falta codigo", Toast.LENGTH_LONG).show();
        } else {
            int idk = Integer.parseInt(cod.getText().toString());
            String mostar = "Datos del objeto:\n";
            mostar += "Nombre: " + armasduras[idk].getNombre() + "\n";
            mostar += "Tipo: " + armasduras[idk].getTipo() + "\n";
            mostar += "Rareza: " + armasduras[idk].getRareza() + "\n";
            mostar += "Caracteristicas: " + armasduras[idk].getEncantado() + ", " + armasduras[idk].getBendecido() +
                    ", " + armasduras[idk].getMaldito() + ", " + armasduras[idk].getRoto() + ", " + armasduras[idk].getReliquia();

            dat.setText(mostar);
        }
    }

    public void Regresar(View view){
        Intent intent = new Intent(this,Menulateral.class);
        startActivity(intent);
        finish();
    }
}