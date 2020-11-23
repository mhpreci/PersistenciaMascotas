package com.mscode.myanimal.fragment;

import com.mscode.myanimal.adapter.AnimalAdaptador;
import com.mscode.myanimal.pojo.Animal;

import java.util.ArrayList;

public interface IRecyclerViewFragmentView {

    public void generarLinearLayoutVertical();

    public AnimalAdaptador crearAdaptador(ArrayList<Animal> animal);

    public void inicializarAdaptadorRV(AnimalAdaptador adaptador);
}
