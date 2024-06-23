package com.example.proyecto.ui.historial;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import com.example.proyecto.Carrito;
import com.example.proyecto.HistorialActivity;
import com.example.proyecto.ListAdapter;
import com.example.proyecto.ListAdapterHistory;
import com.example.proyecto.PlatillosClass;
import com.example.proyecto.R;

import java.util.ArrayList;
import java.util.List;

public class HistorialFragment extends Fragment {

    private HistorialViewModel mViewModel;
    private Button btnPagar;
    private ListView listPlatillosSeleccionados;    // Lista del Fragment
    private ListAdapterHistory listAdapterHistory;  // Lista Adaptador
    private List<Carrito> mCarrito = new ArrayList<>();
    private Carrito[] carrito = new Carrito[7];

    public static HistorialFragment newInstance() {
        return new HistorialFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(HistorialViewModel.class);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_historial, container, false);
        try {
            btnPagar = root.findViewById(R.id.btnPagarCuenta);
            listPlatillosSeleccionados = root.findViewById(R.id.listPlatillosSeleccionados);
            for(int i = 0; i<carrito.length; i++){
                if(carrito[i].getId_platillo() == 0)
                    mCarrito.add(new Carrito(R.mipmap.pozole, carrito[i].getId_platillo(), carrito[i].getPrecio_IVA()));
                else if(carrito[i].getId_platillo() == 1)
                    mCarrito.add(new Carrito(R.mipmap.tacos, carrito[i].getId_platillo(), carrito[i].getPrecio_IVA()));
                else if(carrito[i].getId_platillo() == 2)
                    mCarrito.add(new Carrito(R.mipmap.tortas, carrito[i].getId_platillo(), carrito[i].getPrecio_IVA()));
                else if(carrito[i].getId_platillo() == 3)
                    mCarrito.add(new Carrito(R.mipmap.flautas, carrito[i].getId_platillo(), carrito[i].getPrecio_IVA()));
                else if(carrito[i].getId_platillo() == 4)
                    mCarrito.add(new Carrito(R.mipmap.enchiladas, carrito[i].getId_platillo(), carrito[i].getPrecio_IVA()));
                else if(carrito[i].getId_platillo() == 5)
                    mCarrito.add(new Carrito(R.mipmap.chilaquiles, carrito[i].getId_platillo(), carrito[i].getPrecio_IVA()));
                else if(carrito[i].getId_platillo() == 6)
                    mCarrito.add(new Carrito(R.mipmap.menudo, carrito[i].getId_platillo(), carrito[i].getPrecio_IVA()));
            }

            listAdapterHistory = new ListAdapterHistory(requireContext(), R.layout.item_row_history, mCarrito);
            listPlatillosSeleccionados.setAdapter(listAdapterHistory);

            // Aquí puedes agregar cualquier interacción adicional con tu vista o ListView
        } catch (Exception exception){
            System.out.println("Error: "+ exception);
        }
        return root;
    }
}