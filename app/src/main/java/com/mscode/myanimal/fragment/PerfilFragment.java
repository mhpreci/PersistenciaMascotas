package com.mscode.myanimal.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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

import java.util.ArrayList;


public class PerfilFragment extends Fragment {

    ArrayList<Animal> mayores;
    private RecyclerView listaMayores;

      public PerfilFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_perfil,container,false);

        Bundle bundle = this.getArguments();

        //mayores = (ArrayList<Animal>) getArguments().getSerializable("data");

        if(bundle != null){
            Log.d("hello", "entro");

            mayores = (ArrayList<Animal>) bundle.getSerializable("data");

            listaMayores = (RecyclerView) v.findViewById(R.id.rvContactos);

            LinearLayoutManager llm = new LinearLayoutManager(getActivity());
            llm.setOrientation(LinearLayoutManager.VERTICAL);

            listaMayores.setLayoutManager(llm);
            inicializarAdaptador();

        }


        return v;
    }

    public void inicializarAdaptador(){
        AnimalAdaptador adaptador = new AnimalAdaptador(mayores,getActivity());
        listaMayores.setAdapter(adaptador);
    }
}