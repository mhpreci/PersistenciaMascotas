package com.mscode.myanimal.presentador;

import android.content.Context;

import com.mscode.myanimal.adapter.AnimalAdaptador;
import com.mscode.myanimal.db.ConstructorAnimales;
import com.mscode.myanimal.fragment.IRecyclerViewFragmentView;
import com.mscode.myanimal.pojo.Animal;

import java.util.ArrayList;

public class RecyclerViewFragmentPresenter implements IRecyclerViewFragmentPresenter {

    private IRecyclerViewFragmentView iRecyclerViewFragmentView;
    private Context context;
    private ConstructorAnimales constructorAnimales;
    private ArrayList<Animal> animals;

    public RecyclerViewFragmentPresenter(IRecyclerViewFragmentView iRecyclerViewFragmentView, Context context) {
        this.iRecyclerViewFragmentView = iRecyclerViewFragmentView;
        this.context = context;
        obtenerContactosBaseDatos();
    }

    @Override
    public void obtenerContactosBaseDatos() {
        constructorAnimales = new ConstructorAnimales(context);
        animals = constructorAnimales.obtenerDatos();
        mostrarContactosRV();
    }

    @Override
    public void mostrarContactosRV() {
        iRecyclerViewFragmentView.inicializarAdaptadorRV(iRecyclerViewFragmentView.crearAdaptador(animals));
        iRecyclerViewFragmentView.generarLinearLayoutVertical();
    }
}
