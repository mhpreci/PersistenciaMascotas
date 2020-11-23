package com.mscode.myanimal.fragment;

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

import com.mscode.myanimal.R;
import com.mscode.myanimal.adapter.AnimalAdaptador;
import com.mscode.myanimal.pojo.Animal;
import com.mscode.myanimal.presentador.IRecyclerViewFragmentPresenter;
import com.mscode.myanimal.presentador.RecyclerViewFragmentPresenter;

import java.util.ArrayList;

public class RecyclerViewFragment  extends Fragment implements IRecyclerViewFragmentView{

    private ArrayList<Animal> animal;
    private RecyclerView listaAnimales;
    private IRecyclerViewFragmentPresenter presenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_recycler_view,container,false);

        listaAnimales = (RecyclerView) v.findViewById(R.id.rvContactos);

        presenter = new RecyclerViewFragmentPresenter(this, getContext());

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
