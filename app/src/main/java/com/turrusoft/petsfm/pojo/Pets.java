package com.turrusoft.petsfm.pojo;

/**
 * Created by CFE on 20/11/2016.
 */


public class Pets
{
    private int id;
    private int mascota;
    private int id_mascota;
    private String nombre;
    private int tvlikes;

    public Pets(int mascota, int id_mascota, String nombre, int tvlikes)
    {
        this.mascota = mascota;
        this.id_mascota = id_mascota;
        this.nombre = nombre;
        this.tvlikes = tvlikes;
    }

    public Pets() {

    }

    public int getId_mascota() {
        return id_mascota;
    }

    public void setId_mascota(int id_mascota) {
        this.id_mascota = id_mascota;
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getLikes()
    {
        return tvlikes;
    }

    public void setTvlikes(int tvlikes) {
        this.tvlikes = tvlikes;
    }

    public int getMascota()
    {
        return mascota;
    }

    public void setMascota(int mascota) {
        this.mascota = mascota;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
