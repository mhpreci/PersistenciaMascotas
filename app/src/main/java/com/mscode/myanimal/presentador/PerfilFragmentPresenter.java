package com.mscode.myanimal.presentador;

import android.content.Context;

import com.mscode.myanimal.db.ConstructorAnimales;
import com.mscode.myanimal.fragment.IPerfilFragmentView;
import com.mscode.myanimal.pojo.Animal;

import java.util.ArrayList;

public class PerfilFragmentPresenter implements IPerfilFragmentPresenter {

    private IPerfilFragmentView IPerfilFragmentView;
    private Context context;
    private ConstructorAnimales constructorAnimales;
    private ArrayList<Animal> animals;

    public PerfilFragmentPresenter(IPerfilFragmentView IPerfilFragmentView, Context context) {
        this.IPerfilFragmentView = IPerfilFragmentView;
        this.context = context;
        obtenerContactosBaseDatos();
    }

    @Override
    public void obtenerContactosBaseDatos() {
        constructorAnimales = new ConstructorAnimales(context);
        animals = constructorAnimales.obtenerDatosGuardados();
        mostrarContactosRV();
    }

    @Override
    public void mostrarContactosRV() {
        IPerfilFragmentView.inicializarAdaptadorRV(IPerfilFragmentView.crearAdaptador(animals));
        IPerfilFragmentView.generarLinearLayoutVertical();
    }
}
