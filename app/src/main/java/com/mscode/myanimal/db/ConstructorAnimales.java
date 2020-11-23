package com.mscode.myanimal.db;

import android.content.ContentValues;
import android.content.Context;

import com.mscode.myanimal.R;
import com.mscode.myanimal.pojo.Animal;

import java.util.ArrayList;

public class ConstructorAnimales {

    private static final Integer LIKE = 1;
    private Context context;

    public ConstructorAnimales(Context context){
        this.context = context;
    }

    public ArrayList<Animal> obtenerDatos(){
        BaseDatos db = new BaseDatos(context);
        insertarTresAnimales(db);
        return db.obtenerTodosLosContactos();
    }

    public ArrayList<Animal> obtenerDatosGuardados(){
        BaseDatos db = new BaseDatos(context);
        return db.obtenerAnimalesMayorLikes();
    }

    public void insertarTresAnimales(BaseDatos db){
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_ANIMALS_NOMBRE,"Animal Primero");
        contentValues.put(ConstantesBaseDatos.TABLE_ANIMALS_FOTO,R.drawable.animal1);

        db.insertarAnimal(contentValues);

        contentValues.put(ConstantesBaseDatos.TABLE_ANIMALS_NOMBRE,"Animal Segundo");
        contentValues.put(ConstantesBaseDatos.TABLE_ANIMALS_FOTO,R.drawable.animales2);

        db.insertarAnimal(contentValues);

        contentValues.put(ConstantesBaseDatos.TABLE_ANIMALS_NOMBRE,"Animal Tercero");
        contentValues.put(ConstantesBaseDatos.TABLE_ANIMALS_FOTO,R.drawable.animales3);

        db.insertarAnimal(contentValues);
    }

    public void darLikeAnimal(Animal animal){
        BaseDatos bd = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_ANIMALS_ID_CONTACTO,animal.getId());
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_ANIMALS_LIKES,LIKE);
        bd.insertarLikeAnimales(contentValues);
    }

    public int obtenerLikesAnimal(Animal animal){
        BaseDatos db = new BaseDatos(context);
        return db.obtenerLikesAnimal(animal);
    }

}
