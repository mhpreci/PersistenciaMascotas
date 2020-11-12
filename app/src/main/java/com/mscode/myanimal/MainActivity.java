package com.mscode.myanimal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Animal> animal;
    private RecyclerView listaAnimales;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.MyActionBar);
        setSupportActionBar(miActionBar);

        listaAnimales = (RecyclerView) findViewById(R.id.rvContactos);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaAnimales.setLayoutManager(llm);
        inicializarListaAnimales();
        inicializarAdaptador();

      /*  ArrayList<String> nombresContacto = new ArrayList<>();
        for(Animal animales: animal){
            nombresContacto.add(animales.getNombre());
        }*/
    }

    public void inicializarAdaptador(){
        AnimalAdaptador adaptador = new AnimalAdaptador(animal,this);
        listaAnimales.setAdapter(adaptador);
    }

    public void inicializarListaAnimales(){
        animal = new ArrayList<Animal>();

        animal.add(new Animal("Animal1",R.drawable.animal1,0));
        animal.add(new Animal("Animal2",R.drawable.animales2,0));
        animal.add(new Animal("Animal3",R.drawable.animales3,0));
        animal.add(new Animal("Animal4",R.drawable.animales4,0));
        animal.add(new Animal("Animal5",R.drawable.animales5,0));
        animal.add(new Animal("Animal6",R.drawable.animales6,0));
        animal.add(new Animal("Animal7",R.drawable.animales7,0));
    }

    public void mostrarTop(){
        /*ArrayList<String> milista = new ArrayList<String>();*/
        Intent intent = new Intent(this, DetalleAnimal.class);
        intent.putExtra("miLista", animal);
        startActivity(intent);
    }
}