package com.mscode.myanimal.pojo;

public class Animal {


    private int id;
    private String nombre;
    private int ranking;
    private int foto;

    public Animal(String nombre, int foto ,int ranking) {
        this.nombre = nombre;
        this.ranking = ranking;
        this.foto = foto;
    }

    public Animal() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }
}
