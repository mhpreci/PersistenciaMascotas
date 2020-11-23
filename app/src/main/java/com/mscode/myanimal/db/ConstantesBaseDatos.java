package com.mscode.myanimal.db;

public final class ConstantesBaseDatos {

    public static final String DATABASE_NAME = "bdanimales";
    public static final int DATABASE_VERSION = 1;

    public static final String TABLE_ANIMALS            = "animal";
    public static final String TABLE_ANIMALS_ID         = "id";
    public static final String TABLE_ANIMALS_NOMBRE     = "nombre";
    public static final String TABLE_ANIMALS_FOTO       = "foto";


    public static final String TABLE_LIKES_ANIMALS      = "animal_likes";
    public static final String TABLE_LIKES_ANIMALS_ID   = "id";
    public static final String TABLE_LIKES_ANIMALS_ID_CONTACTO = "id_contacto";
    public static final String TABLE_LIKES_ANIMALS_LIKES = "numero_likes";
}
