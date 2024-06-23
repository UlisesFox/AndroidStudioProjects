package com.example.proyecto.ui.gallery;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.proyecto.CostruCuenta;
import com.example.proyecto.R;
import com.example.proyecto.databinding.FragmentGalleryBinding;

public class GalleryFragment extends Fragment {

    private FragmentGalleryBinding binding;
    private EditText mon;
    private TextView res;
    private CostruCuenta[] costrucuenta;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        GalleryViewModel galleryViewModel =
                new ViewModelProvider(this).get(GalleryViewModel.class);

        binding = FragmentGalleryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        costrucuenta = new CostruCuenta[1];
        costrucuenta[0] = new CostruCuenta();

        mon = root.findViewById(R.id.txtprecio);
        res = root.findViewById(R.id.txtdinero);
        Button buttonMostrarValor = root.findViewById(R.id.subir);

        buttonMostrarValor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (camposLlenos()) {
                    obtenervalor();
                } else {
                    Toast.makeText(requireContext(), "Por favor, complete todos los campos", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private boolean camposLlenos() {
        return !TextUtils.isEmpty(mon.getText());
    }

    public void obtenervalor(){
        int pre = Integer.parseInt(mon.getText().toString());
        costrucuenta[0].setAumento(pre);
        actualizar();
        mon.setText("");
    }

    public void actualizar(){
        int v1 = costrucuenta[0].getAumento();
        int v2 = costrucuenta[0].getAumneto2();
        int valor = v1 + v2;
        costrucuenta[0].setAumneto2(valor);
        res.setText(String.valueOf(valor));
    }
}