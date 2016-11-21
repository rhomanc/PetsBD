package com.turrusoft.petsfm.pojo;

/**
 * Created by CFE on 20/11/2016.
 */


public class Pets
{
    private int mascota;
    private String nombre;
    private int tvlikes;

    public Pets(int mascota, String nombre, int tvlikes)
    {
        this.mascota = mascota;
        this.nombre = nombre;
        this.tvlikes = tvlikes;
    }

    public String getNombre()
    {
        return nombre;
    }

    public int getLikes()
    {
        return tvlikes;
    }


    public int getMascota()
    {
        return mascota;
    }

    public void setLikes(int likes)
    {
        this.tvlikes = likes;
    }
}
