package com.mscode.myanimal;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AnimalAdaptador extends RecyclerView.Adapter<AnimalAdaptador.AnimalViewHolder> {

    ArrayList<Animal> animales;
    Activity activity;
    int contador = 0;

    public AnimalAdaptador(ArrayList<Animal> animales, Activity activity){
        this.animales = animales;
        this.activity = activity;
    }

    @NonNull
    @Override
    //inflar el layout y lo pasará al viewHolder para el obtener los views
    public AnimalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_contacto,parent,false);
        return new AnimalViewHolder(v);
    }

    //asocia cada elemento de la lista con cada view
    @Override
    public void onBindViewHolder(@NonNull AnimalViewHolder animalViewHolder, int position) {
        final Animal animal = animales.get(position);
        animalViewHolder.imgFoto.setImageResource(animal.getFoto());
        animalViewHolder.tvNombreCV.setText(animal.getNombre());
        animalViewHolder.tvConteo.setText(String.valueOf(animal.getRanking()));

        animalViewHolder.btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(activity, "Diste like a: " +animal.getNombre(), Toast.LENGTH_SHORT).show();
                contador++;
                animal.setRanking(contador);
            }
        });

    }

    @Override
    public int getItemCount() {
        return animales.size();
    }

    public static class AnimalViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgFoto;
        private TextView tvNombreCV;
        private TextView tvConteo;
        private ImageButton btnLike;

        public AnimalViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFoto = itemView.findViewById(R.id.imgFoto);
            tvNombreCV = itemView.findViewById(R.id.txtNombre);
            tvConteo = itemView.findViewById(R.id.txtConteo);
            btnLike = itemView.findViewById(R.id.imgFavs);

        }
    }
}
