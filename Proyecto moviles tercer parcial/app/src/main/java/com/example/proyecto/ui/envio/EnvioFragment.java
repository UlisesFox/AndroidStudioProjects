package com.example.proyecto.ui.envio;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.proyecto.CostruEnvio;
import com.example.proyecto.R;

public class EnvioFragment extends Fragment {


    private EditText ca, co, ciu, cod;
    private Spinner dom;
    private String[] opcionesSpinner = {"Dirreccion 1", "Dirreccion 2", "Dirreccion 3", "Dirreccion 4", "Dirreccion 5", "Dirreccion 6", "Dirreccion 7"};
    private CostruEnvio[] costruenvios;
    private int conta = 1;

    private EnvioViewModel mViewModel;

    public static EnvioFragment newInstance() {
        return new EnvioFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(EnvioViewModel.class);
        // TODO: Use the ViewModel
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_envio, container, false);

        costruenvios = new CostruEnvio[20];

        ca = rootView.findViewById(R.id.txtcalle);
        co = rootView.findViewById(R.id.txtcolonia);
        ciu = rootView.findViewById(R.id.txtciudad);
        cod = rootView.findViewById(R.id.txtpostal);
        dom = rootView.findViewById(R.id.sporden);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                requireContext(), android.R.layout.simple_spinner_item, opcionesSpinner);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dom.setAdapter(adapter);

        Button btnEnviar = rootView.findViewById(R.id.btnGuardarDomicilio);
        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (camposLlenos()) {
                    enviar();
                } else {
                    Toast.makeText(requireContext(), "Por favor, complete todos los campos", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return rootView;
    }

    private boolean camposLlenos() {
        return !TextUtils.isEmpty(ca.getText())
                && !TextUtils.isEmpty(co.getText())
                && !TextUtils.isEmpty(ciu.getText())
                && !TextUtils.isEmpty(cod.getText());
    }

    public void enviar() {
        String ord = "";
        String cal = "";
        String col = "";
        String ciud = "";
        int post = 0;

        ord = dom.getSelectedItem().toString();
        cal = ca.getText().toString();
        col = co.getText().toString();
        ciud = ciu.getText().toString();
        post = Integer.parseInt(cod.getText().toString());

        costruenvios[conta] = new CostruEnvio(ord, cal, col, ciud, post);
        conta++;
        Mostrar();
        Limpiar();
    }

    public void Mostrar(){
        String orden = dom.getSelectedItem().toString();
        String calle = ca.getText().toString();
        String colonia = co.getText().toString();
        String ciudad = ciu.getText().toString();
        int codepostal = Integer.parseInt(cod.getText().toString());

        StringBuilder mensaje = new StringBuilder();
        mensaje.append("Envio Registrado").append("\n");
        mensaje.append("Orden: ").append(orden).append("\n");
        mensaje.append("Calle: ").append(calle).append("\n");
        mensaje.append("Colonia: ").append(colonia).append("\n");
        mensaje.append("Ciudad: ").append(ciudad).append("\n");
        mensaje.append("Codigo postal: ").append(codepostal);

        Toast.makeText(requireContext(), mensaje.toString(), Toast.LENGTH_LONG).show();

    }

    public void Limpiar(){
        ca.setText("");
        co.setText("");
        ciu.setText("");
        cod.setText("");
    }
}