package com.example.proyectomvcabigail.adaptadores;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyectomvc.Entidades.Empleados;
import com.example.proyectomvc.R;
import com.example.proyectomvc.VerActivity;

import java.util.ArrayList;

public class ListaEmpleadosAdapter extends RecyclerView.Adapter<ListaEmpleadosAdapter.EmpleadoViewHolder>{
    ArrayList<Empleados> listaEmpleados;

    public ListaEmpleadosAdapter(ArrayList<Empleados> listaEmpleados){
        this.listaEmpleados = listaEmpleados;
    }

    @NonNull
    @Override
    public EmpleadoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_item_empleado, null, false);
        return new EmpleadoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EmpleadoViewHolder holder, int position) {
        holder.viewNombre.setText(listaEmpleados.get(position).getNombre());
        holder.viewApellidos.setText(listaEmpleados.get(position).getApellidos());
        holder.viewEdad.setText(listaEmpleados.get(position).getEdad());
        holder.viewDireccion.setText(listaEmpleados.get(position).getDireccion());
        holder.viewPuestos.setText(listaEmpleados.get(position).getPuestos());
    }

    @Override
    public int getItemCount() {
        return listaEmpleados.size();
    }

    public class EmpleadoViewHolder extends RecyclerView.ViewHolder {

        TextView viewNombre, viewApellidos, viewEdad, viewDireccion, viewPuestos;

        public EmpleadoViewHolder(@NonNull View itemView) {
            super(itemView);

            viewNombre = itemView.findViewById(R.id.viewNombre);
            viewApellidos = itemView.findViewById(R.id.viewApellidos);
            viewEdad = itemView.findViewById(R.id.viewEdad);
            viewDireccion = itemView.findViewById(R.id.viewDireccion);
            viewPuestos = itemView.findViewById(R.id.viewPuestos);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Context context = view.getContext();
                    Intent intent = new Intent(context, VerActivity.class);
                    intent.putExtra("ID", listaEmpleados.get(getAdapterPosition()).getId());
                    context.startActivity(intent);
                }
            });
        }
    }

}
