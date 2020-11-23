package com.mscode.myanimal.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mscode.myanimal.db.ConstructorAnimales;
import com.mscode.myanimal.pojo.Animal;
import com.mscode.myanimal.R;

import java.util.ArrayList;

public class AnimalAdaptador extends RecyclerView.Adapter<AnimalAdaptador.AnimalViewHolder> {

    ArrayList<Animal> animales;
    Activity activity;

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
    public void onBindViewHolder(@NonNull final AnimalViewHolder animalViewHolder, int position) {
        final Animal animal = animales.get(position);
        animalViewHolder.imgFoto.setImageResource(animal.getFoto());
        animalViewHolder.tvNombreCV.setText(animal.getNombre());
        /*animalViewHolder.tvConteo.setText(String.valueOf(animal.getRanking())); */

        animalViewHolder.tvLikes.setText(String.valueOf(animal.getRanking()) + " " + activity.getString(R.string.plikes));

        animalViewHolder.btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(activity, "Diste like a: " +animal.getNombre(), Toast.LENGTH_SHORT).show();

                ConstructorAnimales constructorAnimales = new ConstructorAnimales(activity);
                constructorAnimales.darLikeAnimal(animal);
                animalViewHolder.tvLikes.setText(constructorAnimales.obtenerLikesAnimal(animal) + " " + activity.getString(R.string.plikes));
                constructorAnimales.obtenerDatosGuardados();
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
        //private TextView tvConteo;
        private ImageButton btnLike;
        private TextView tvLikes;

        public AnimalViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFoto = itemView.findViewById(R.id.imgFoto);
            tvNombreCV = itemView.findViewById(R.id.txtNombre);
            //tvConteo = itemView.findViewById(R.id.txtConteo);
            btnLike = itemView.findViewById(R.id.imgHueso);
            tvLikes = itemView.findViewById(R.id.imgFavs);
        }
    }
}
