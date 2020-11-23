package com.mscode.myanimal.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mscode.myanimal.R;
import com.mscode.myanimal.adapter.AnimalAdaptador;
import com.mscode.myanimal.pojo.Animal;
import com.mscode.myanimal.presentador.IPerfilFragmentPresenter;
import com.mscode.myanimal.presentador.IRecyclerViewFragmentPresenter;
import com.mscode.myanimal.presentador.PerfilFragmentPresenter;
import com.mscode.myanimal.presentador.RecyclerViewFragmentPresenter;

import java.util.ArrayList;


public class PerfilFragment extends Fragment implements  IPerfilFragmentView{

    private ArrayList<Animal> animal;
    private RecyclerView listaAnimales;
    private IPerfilFragmentPresenter presenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_perfil,container,false);

        listaAnimales = (RecyclerView) v.findViewById(R.id.rvContactos);

        presenter = new PerfilFragmentPresenter(this, getContext());

        return v;
        }

    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaAnimales.setLayoutManager(llm);
    }

    @Override
    public AnimalAdaptador crearAdaptador(ArrayList<Animal> animal) {
        AnimalAdaptador adaptador = new AnimalAdaptador(animal,getActivity());
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(AnimalAdaptador adaptador) {
        listaAnimales.setAdapter(adaptador);
    }
}