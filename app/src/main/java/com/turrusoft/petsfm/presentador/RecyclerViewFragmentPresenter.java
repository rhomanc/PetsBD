package com.turrusoft.petsfm.presentador;

import android.content.Context;

import com.turrusoft.petsfm.Fragments.IRecyclerViewFragmentView;
import com.turrusoft.petsfm.db.ConstructorMascotas;
import com.turrusoft.petsfm.pojo.Pets;

import java.util.ArrayList;

/**
 * Created by CFE on 25/11/2016.
 */

public class RecyclerViewFragmentPresenter implements IRecyclerViewFragmentPresenter {

    private IRecyclerViewFragmentView iRecyclerViewFragmentView;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<Pets> items;

    public RecyclerViewFragmentPresenter(IRecyclerViewFragmentView iRecyclerViewFragmentView, Context context) {
        this.iRecyclerViewFragmentView = iRecyclerViewFragmentView;
        this.context = context;
        obtenerMascotasBaseDatos();
    }

    @Override
    public void obtenerMascotasBaseDatos() {
        constructorMascotas = new ConstructorMascotas(context);
        items = constructorMascotas.obtenerDatos();
        mostrarMascotasRV();
    }

    @Override
    public void mostrarMascotasRV() {
        iRecyclerViewFragmentView.inicializarAdaptadorRV(iRecyclerViewFragmentView.crearAdaptador(items));
        iRecyclerViewFragmentView.generarLinearLayoutVertical();
    }
}
