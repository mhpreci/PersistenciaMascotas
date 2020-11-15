package com.mscode.myanimal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.mscode.myanimal.adapter.AnimalAdaptador;
import com.mscode.myanimal.pojo.Animal;

import java.util.ArrayList;

public class DetalleAnimal extends AppCompatActivity {

    private RecyclerView listado;
    ArrayList<Animal> lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_animal);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.MyActionBar);
        setSupportActionBar(miActionBar);

        lista = (ArrayList<Animal>) getIntent().getSerializableExtra("miLista");

        listado = (RecyclerView) findViewById(R.id.rvContactos);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listado.setLayoutManager(llm);
        inicializarListaAnimales();
    }

    public void inicializarAdaptador(){
        AnimalAdaptador adaptador = new AnimalAdaptador(lista,this);
        listado.setAdapter(adaptador);
    }

    public void inicializarListaAnimales(){
        for (int i = 0; i < lista.size (); i++){
           // tv1.setText (a.getName () + " is from " + a.getState ());
        }
    }
}