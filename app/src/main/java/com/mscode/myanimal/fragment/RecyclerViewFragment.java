package com.mscode.myanimal.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.mscode.myanimal.DetalleAnimal;
import com.mscode.myanimal.R;
import com.mscode.myanimal.adapter.AnimalAdaptador;
import com.mscode.myanimal.pojo.Animal;

import java.util.ArrayList;

public class RecyclerViewFragment  extends Fragment {

    ArrayList<Animal> animal;
    private RecyclerView listaAnimales;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_recycler_view,container,false);

        listaAnimales = (RecyclerView) v.findViewById(R.id.rvContactos);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaAnimales.setLayoutManager(llm);
        inicializarListaAnimales();
        pasarValores();
        inicializarAdaptador();

        return v;
    }


    public void inicializarAdaptador(){
        AnimalAdaptador adaptador = new AnimalAdaptador(animal,getActivity());
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


        public void pasarValores(){

        PerfilFragment fragment = new PerfilFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("data", animal);
        fragment.setArguments(bundle);

        //Una vez haz creado tu instancia de TestFragment y colocado el Bundle entre sus argumentos, usas el FragmentManager para iniciarla desde tu segunda actividad.
        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.fragmen_perfil, fragment); //donde fragmentContainer_id es el ID del FrameLayout donde tu Fragment está contenido.
        fragmentTransaction.commit();

        }



}
