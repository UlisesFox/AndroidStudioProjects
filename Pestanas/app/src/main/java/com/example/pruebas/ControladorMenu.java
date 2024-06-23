package com.example.pestaas;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.pruebas.FormularioFragment;
import com.example.pruebas.GaleriaFragment;
import com.example.pruebas.PrincipalFragment;

public class ControladorMenu extends FragmentStateAdapter {

    public ControladorMenu(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle){
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0: return new PrincipalFragment();
            case 1: return new GaleriaFragment();
            case 2: return new FormularioFragment();
            default: return null;
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
