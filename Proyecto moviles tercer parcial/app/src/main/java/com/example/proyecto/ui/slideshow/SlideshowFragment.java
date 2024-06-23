package com.example.proyecto.ui.slideshow;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.proyecto.ListAdapter;
import com.example.proyecto.PlatillosClass;
import com.example.proyecto.R;
import com.example.proyecto.databinding.FragmentSlideshowBinding;

import java.util.ArrayList;
import java.util.List;

public class SlideshowFragment extends Fragment {

    private FragmentSlideshowBinding binding;
    private ListView listView;
    private ListAdapter listAdapter;
    private List<PlatillosClass> mPlatillos = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        SlideshowViewModel slideshowViewModel = new ViewModelProvider(this).get(SlideshowViewModel.class);

        binding = FragmentSlideshowBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        listView = binding.listPlatillos;

        mPlatillos.add(new PlatillosClass(R.mipmap.pozole,"Pozole",2000.00,"Caldo/Sopa de maíz y carne, acompañada de condimentos"));
        mPlatillos.add(new PlatillosClass(R.mipmap.tacos,"Tacos",2000.00,"Tortillas rellenas con carne, que se les puede poner distintos acompañamientos"));
        mPlatillos.add(new PlatillosClass(R.mipmap.tortas,"Tortas",2000.00,"Birote remojado en salsa de tomate, con carne por dentro"));
        mPlatillos.add(new PlatillosClass(R.mipmap.flautas,"Flautas",2000.00,"Tortilla dorada rellana de pollo"));
        mPlatillos.add(new PlatillosClass(R.mipmap.enchiladas,"Enchiladas",2000.00,"Tortilla dorada acompañada de salsa y crema"));
        mPlatillos.add(new PlatillosClass(R.mipmap.enchiladas,"Enchiladas",2000.00,"Tortilla dorada acompañada de salsa y crema"));

        // Inicializador de adaptador
        listAdapter = new ListAdapter(requireContext(), R.layout.item_row, mPlatillos);

        listView.setAdapter(listAdapter);

        //final TextView textView = binding.textView17; //.textSlideshow;
        //slideshowViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}