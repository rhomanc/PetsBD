package com.turrusoft.petsfm.db;

import android.content.ContentValues;
import android.content.Context;

import com.turrusoft.petsfm.R;
import com.turrusoft.petsfm.pojo.Pets;

import java.util.ArrayList;

/**
 * Created by CFE on 25/11/2016.
 */

public class ConstructorMascotas {

    private static final int LIKE = 1;
    private Context context;
    public ConstructorMascotas(Context context){
        this.context = context;
    }

    public ArrayList<Pets> obtenerDatos(){
       /* ArrayList items = new ArrayList<>();
        items.add(new Pets(R.drawable.perro1,101, "Firulais", 20));
        items.add(new Pets(R.drawable.perro2,102, "Dogo", 25));
        items.add(new Pets(R.drawable.perro3,103, "Cirilo", 4));
        items.add(new Pets(R.drawable.perro4,104, "Spooky", 5));
        items.add(new Pets(R.drawable.perro5,105, "Roco", 10));
        items.add(new Pets(R.drawable.perro6,106, "Campeón", 15));
        items.add(new Pets(R.drawable.perro7,107, "Einstein", 3));
        items.add(new Pets(R.drawable.perro8,108, "Rufo", 8)); */
        BaseDatos db = new BaseDatos(context);
        insertarMascotas(db);
        return db.obtenerListaMascotas();
    }

    public ArrayList<Pets> leerMascotas(){
        BaseDatos db = new BaseDatos(context);
        return db.obtenerListaMascotas();
    }

    public ArrayList<Integer> obtenerFavoritos(){
        BaseDatos db = new BaseDatos(context);
        return db.obtener5Favoritos();
    }

    public void insertarMascotas(BaseDatos db){
        ContentValues contentValues = new ContentValues();

        contentValues.put(ConstantesBasesDatos.TABLA_MASCOTAS_ID_MASCOTA, 101);
        contentValues.put(ConstantesBasesDatos.TABLA_MASCOTAS_NOMBRE, "Firulais");
        contentValues.put(ConstantesBasesDatos.TABLA_MASCOTAS_FOTO, R.drawable.perro1);
        db.insertarMascota(contentValues);

        contentValues.put(ConstantesBasesDatos.TABLA_MASCOTAS_ID_MASCOTA, 102);
        contentValues.put(ConstantesBasesDatos.TABLA_MASCOTAS_NOMBRE, "Dogo");
        contentValues.put(ConstantesBasesDatos.TABLA_MASCOTAS_FOTO, R.drawable.perro2);
        db.insertarMascota(contentValues);

        contentValues.put(ConstantesBasesDatos.TABLA_MASCOTAS_ID_MASCOTA, 103);
        contentValues.put(ConstantesBasesDatos.TABLA_MASCOTAS_NOMBRE, "Cirilo");
        contentValues.put(ConstantesBasesDatos.TABLA_MASCOTAS_FOTO, R.drawable.perro3);
        db.insertarMascota(contentValues);

        contentValues.put(ConstantesBasesDatos.TABLA_MASCOTAS_ID_MASCOTA, 104);
        contentValues.put(ConstantesBasesDatos.TABLA_MASCOTAS_NOMBRE, "Spooky");
        contentValues.put(ConstantesBasesDatos.TABLA_MASCOTAS_FOTO, R.drawable.perro4);
        db.insertarMascota(contentValues);

        contentValues.put(ConstantesBasesDatos.TABLA_MASCOTAS_ID_MASCOTA, 105);
        contentValues.put(ConstantesBasesDatos.TABLA_MASCOTAS_NOMBRE, "Roco");
        contentValues.put(ConstantesBasesDatos.TABLA_MASCOTAS_FOTO, R.drawable.perro5);
        db.insertarMascota(contentValues);

        contentValues.put(ConstantesBasesDatos.TABLA_MASCOTAS_ID_MASCOTA, 106);
        contentValues.put(ConstantesBasesDatos.TABLA_MASCOTAS_NOMBRE, "Campeón");
        contentValues.put(ConstantesBasesDatos.TABLA_MASCOTAS_FOTO, R.drawable.perro6);
        db.insertarMascota(contentValues);

        contentValues.put(ConstantesBasesDatos.TABLA_MASCOTAS_ID_MASCOTA, 107);
        contentValues.put(ConstantesBasesDatos.TABLA_MASCOTAS_NOMBRE, "Einstein");
        contentValues.put(ConstantesBasesDatos.TABLA_MASCOTAS_FOTO, R.drawable.perro7);
        db.insertarMascota(contentValues);

        contentValues.put(ConstantesBasesDatos.TABLA_MASCOTAS_ID_MASCOTA, 108);
        contentValues.put(ConstantesBasesDatos.TABLA_MASCOTAS_NOMBRE, "Rufo");
        contentValues.put(ConstantesBasesDatos.TABLA_MASCOTAS_FOTO, R.drawable.perro8);
        db.insertarMascota(contentValues);

    }

    public void darLikeMascota(Pets pets){
        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBasesDatos.TABLA_MASCOTAS_ID_MASCOTA,pets.getId_mascota());
        contentValues.put(ConstantesBasesDatos.TABLA_LIKES_MASCOTAS_LIKES, LIKE);
        db.insertarLikeMascota(contentValues);
    }

    public int obtenerLikesMascota(Pets pets){
        BaseDatos db = new BaseDatos(context);
        return db.obtenerLikesMascota(pets);
    }

}
