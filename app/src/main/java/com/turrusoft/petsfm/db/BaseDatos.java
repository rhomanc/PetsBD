package com.turrusoft.petsfm.db;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import com.turrusoft.petsfm.MainActivity;
import com.turrusoft.petsfm.pojo.Pets;

import java.util.ArrayList;

/**
 * Created by CFE on 26/11/2016.
 */

public class BaseDatos extends SQLiteOpenHelper {

    private Context context;
    public BaseDatos(Context context) {
        super(context, ConstantesBasesDatos.DATABASE_NAME, null, ConstantesBasesDatos.DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String queryCrearTablaMascotas = "CREATE TABLE " + ConstantesBasesDatos.TABLA_MASCOTAS + "("
                + ConstantesBasesDatos.TABLA_MASCOTAS_ID_MASCOTA + " INTEGER PRIMARY KEY, "
                + ConstantesBasesDatos.TABLA_MASCOTAS_NOMBRE     + " TEXT, "
                + ConstantesBasesDatos.TABLA_MASCOTAS_FOTO       + " INTEGER"
                + ")";

        String queryCrearTablaLikesMascotas = "CREATE TABLE " + ConstantesBasesDatos.TABLA_LIKES_MASCOTAS + "("
                + ConstantesBasesDatos.TABLA_LIKES_MASCOTAS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + ConstantesBasesDatos.TABLA_LIKES_MASCOTAS_ID_MASCOTA + " INTEGER, "
                + ConstantesBasesDatos.TABLA_LIKES_MASCOTAS_LIKES + " INTEGER, "
                + "FOREIGN KEY (" + ConstantesBasesDatos.TABLA_LIKES_MASCOTAS_ID_MASCOTA + ") "
                + "REFERENCES " + ConstantesBasesDatos.TABLA_MASCOTAS + "(" + ConstantesBasesDatos.TABLA_MASCOTAS_ID_MASCOTA + ")"
                + ")";

        db.execSQL(queryCrearTablaMascotas);
        db.execSQL(queryCrearTablaLikesMascotas);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST "+ConstantesBasesDatos.TABLA_MASCOTAS);
        db.execSQL("DROP TABLE IF EXIST "+ConstantesBasesDatos.TABLA_LIKES_MASCOTAS);
        onCreate(db);
    }

    public ArrayList<Pets> obtenerListaMascotas(){
        ArrayList<Pets> items = new ArrayList<>();

        String query = "SELECT * FROM " + ConstantesBasesDatos.TABLA_MASCOTAS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        while (registros.moveToNext()){
            Pets mascotaActual = new Pets();
            mascotaActual.setId_mascota(registros.getInt(0));
            mascotaActual.setNombre(registros.getString(1));
            mascotaActual.setMascota(registros.getInt(2));

            String queryLikes = "SELECT COUNT (" +  ConstantesBasesDatos.TABLA_LIKES_MASCOTAS_LIKES + ") as likes "
                              + " FROM " + ConstantesBasesDatos.TABLA_LIKES_MASCOTAS
                              + " WHERE " + ConstantesBasesDatos.TABLA_LIKES_MASCOTAS_ID_MASCOTA + "=" + mascotaActual.getId_mascota();

            Cursor registrosLikes = db.rawQuery(queryLikes, null);
            if (registrosLikes.moveToNext()){
                mascotaActual.setTvlikes(registrosLikes.getInt(0));
            } else {
                mascotaActual.setTvlikes(0);
            }

            items.add(mascotaActual);
        }

        db.close();

        return items;
    }

    public void insertarMascota(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBasesDatos.TABLA_MASCOTAS,null,contentValues);
        db.close();
    }

    public void insertarLikeMascota(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBasesDatos.TABLA_LIKES_MASCOTAS,null,contentValues);
        db.close();
    }

    public int obtenerLikesMascota(Pets pets){
        int likes = 0;

        String query = "SELECT COUNT (" + ConstantesBasesDatos.TABLA_LIKES_MASCOTAS_LIKES + ")"
                     + " FROM " + ConstantesBasesDatos.TABLA_LIKES_MASCOTAS
                     + " WHERE " + ConstantesBasesDatos.TABLA_LIKES_MASCOTAS_ID_MASCOTA + "=" + pets.getId_mascota();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);
        if (registros.moveToNext()){
            likes = registros.getInt(0);
        }
        db.close();

        return likes;
    }


    public ArrayList<Integer> obtener5Favoritos(){
        int size=0;
        ArrayList<Integer> ids = new ArrayList<>();
        String query = "SELECT * FROM " + ConstantesBasesDatos.TABLA_LIKES_MASCOTAS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);
        registros.moveToLast();
        int idActual = registros.getInt(1);
        while (size<5){
            boolean enlista = false;
            for (int i=0;i<size;i++){
                enlista = (idActual==ids.get(i));
                if (enlista){
                    i=size;
                }
            }
            if (!enlista){
                ids.add(idActual);
                size=ids.size();
            }
            if (registros.moveToPrevious()){
                idActual=registros.getInt(1);
            }else{
                size=5;
            }
        }

        db.close();

        return ids;
    }



}
