package com.mscode.myanimal.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.mscode.myanimal.pojo.Animal;

import java.util.ArrayList;

public class BaseDatos extends SQLiteOpenHelper {

    Context context;

    public BaseDatos(@Nullable Context context) {
        super(context, ConstantesBaseDatos.DATABASE_NAME, null, ConstantesBaseDatos.DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryCrearTablaAnimal = "CREATE TABLE "+ ConstantesBaseDatos.TABLE_ANIMALS + "(" +
                                    ConstantesBaseDatos.TABLE_ANIMALS_ID        + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                    ConstantesBaseDatos.TABLE_ANIMALS_NOMBRE    + " TEXT, "  +
                                    ConstantesBaseDatos.TABLE_ANIMALS_FOTO      + " INTEGER" +
                                    ")";

        String queryCrearTablaLikesAnimal = "CREATE TABLE "+ ConstantesBaseDatos.TABLE_LIKES_ANIMALS + "(" +
                                    ConstantesBaseDatos.TABLE_LIKES_ANIMALS_ID        + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                    ConstantesBaseDatos.TABLE_LIKES_ANIMALS_ID_CONTACTO    + " INTEGER, "  +
                                    ConstantesBaseDatos.TABLE_LIKES_ANIMALS_LIKES      + " INTEGER," +
                                    "FOREIGN KEY ("+ ConstantesBaseDatos.TABLE_LIKES_ANIMALS_ID_CONTACTO +") " +
                                    "REFERENCES " + ConstantesBaseDatos.TABLE_ANIMALS + "(" + ConstantesBaseDatos.TABLE_ANIMALS_ID + ")" +
                                    ")";

        db.execSQL(queryCrearTablaAnimal);
        db.execSQL(queryCrearTablaLikesAnimal);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + ConstantesBaseDatos.TABLE_ANIMALS);
        db.execSQL("DROP TABLE IF EXISTS " + ConstantesBaseDatos.TABLE_LIKES_ANIMALS);
        onCreate(db);
    }

    public ArrayList<Animal> obtenerTodosLosContactos(){
        ArrayList<Animal> animales = new ArrayList<>();

        String query = "SELECT * FROM "+ ConstantesBaseDatos.TABLE_ANIMALS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query,null);

        while(registros.moveToNext()){
            Animal animalActual = new Animal();
            animalActual.setId(registros.getInt(0));
            animalActual.setNombre(registros.getString(1));
            animalActual.setFoto(registros.getInt(2));

            String queryLikes = "SELECT COUNT("+ConstantesBaseDatos.TABLE_LIKES_ANIMALS_LIKES+") as likes " +
                    " FROM " + ConstantesBaseDatos.TABLE_LIKES_ANIMALS +
                    " WHERE " + ConstantesBaseDatos.TABLE_LIKES_ANIMALS_ID_CONTACTO + "=" + animalActual.getId();

            Cursor registrosLikes  = db.rawQuery(queryLikes,null);
            if( registrosLikes.moveToNext()){
                animalActual.setRanking(registrosLikes.getInt(0));
            }else {
                animalActual.setRanking(0);
            }

            animales.add(animalActual);
        }
        db.close();

        return animales;
    }


    public ArrayList<Animal> obtenerAnimalesMayorLikes(){
        ArrayList<Animal> animales = new ArrayList<>();

        //String query = "SELECT *, b.numero_likes FROM "+ ConstantesBaseDatos.TABLE_ANIMALS;
        String query = "SELECT a.id,a.nombre,a.foto,count(b.numero_likes) FROM "+ ConstantesBaseDatos.TABLE_ANIMALS + " as a" +
                " INNER JOIN " + ConstantesBaseDatos.TABLE_LIKES_ANIMALS + " as b" +
                " on a."+ ConstantesBaseDatos.TABLE_ANIMALS_ID + "= b."+ConstantesBaseDatos.TABLE_LIKES_ANIMALS_ID_CONTACTO +
                " GROUP BY a.id,a.nombre,a.foto HAVING COUNT(b.numero_likes) >= 5 ";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query,null);

        while(registros.moveToNext()){
            Animal animalActual = new Animal();
            animalActual.setId(registros.getInt(0));
            animalActual.setNombre(registros.getString(1));
            animalActual.setFoto(registros.getInt(2));
            animalActual.setRanking(registros.getInt(3));

            animales.add(animalActual);
        }
        db.close();

        return animales;
    }


    public void insertarAnimal(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_ANIMALS,null,contentValues);
        db.close();
    }

    public void insertarLikeAnimales(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_LIKES_ANIMALS,null,contentValues);
        db.close();
    }

    public int obtenerLikesAnimal(Animal animal){
        int likes = 0;
        String query =  "SELECT COUNT (" + ConstantesBaseDatos.TABLE_LIKES_ANIMALS_LIKES + ")" +
                        " FROM " + ConstantesBaseDatos.TABLE_LIKES_ANIMALS +
                        " WHERE " + ConstantesBaseDatos.TABLE_LIKES_ANIMALS_ID_CONTACTO + "=" + animal.getId();

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query,null);

        if( registros.moveToNext()){
            likes = registros.getInt(0);
        }

        db.close();

        return likes;
    }
}
