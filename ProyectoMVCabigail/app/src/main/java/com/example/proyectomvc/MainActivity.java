package com.example.proyectomvc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.proyectomvc.Entidades.Empleados;
import com.example.proyectomvc.adaptadores.ListaEmpleadosAdapter;
import com.example.proyectomvc.db.DbEmpleados;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView listaEmpleados;
    ArrayList<Empleados> listaArrayEmpleados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listaEmpleados = findViewById(R.id.listaEmpleados);
        listaEmpleados.setLayoutManager(new LinearLayoutManager(this));

        DbEmpleados dbEmpleadoss = new DbEmpleados(MainActivity.this);

        listaArrayEmpleados = new ArrayList<>();

        ListaEmpleadosAdapter adapter = new ListaEmpleadosAdapter(dbEmpleadoss.mostrarEmpleados());
        listaEmpleados.setAdapter(adapter);
    }

    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_principal, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.menuNuevo:
                nuevoRegistro();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void nuevoRegistro(){
        Intent intent = new Intent(this, NuevoActivity.class);
        startActivity(intent);
    }

}