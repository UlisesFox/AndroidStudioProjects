package com.example.proyecto;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class ListAdapterHistory extends ArrayAdapter<Carrito> {

    private List<Carrito> CarritoList;
    private Context context;
    private int resourceLayout;
    private PlatillosClass[] platillosClass = new PlatillosClass[7];

    public ListAdapterHistory(@NonNull Context context, int resource, List<Carrito> objects) {
        super(context, resource, objects);
        this.CarritoList = objects;
        this.context = context;
        this.resourceLayout = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(resourceLayout, parent, false);
            holder = new ViewHolder();
            holder.imagen = convertView.findViewById(R.id.imgImagenPlatillo);
            holder.nombre = convertView.findViewById(R.id.txtNombrePlatillo);
            holder.costo = convertView.findViewById(R.id.txtCostoPlatillo);
            holder.Descripcion = convertView.findViewById(R.id.txtDescripcionPlatillo);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Carrito carrito  = CarritoList.get(position);
        // Obtener el ID de los Pedidos
        int id_platillo = carrito.getId_platillo();

        holder.imagen.setImageResource(platillosClass[id_platillo].getImagen());
        holder.nombre.setText(platillosClass[id_platillo].getImagen());
        holder.costo.setText(String.valueOf(carrito.getPrecio_IVA()));

        return convertView;
    }

    private static class ViewHolder {
        ImageView imagen;
        TextView nombre;
        TextView costo;
        TextView Descripcion;
    }
}
