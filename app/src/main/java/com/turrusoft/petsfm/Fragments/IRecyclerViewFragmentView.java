package com.turrusoft.petsfm.Fragments;

import com.turrusoft.petsfm.Adapter.Adapter;
import com.turrusoft.petsfm.pojo.Pets;

import java.util.ArrayList;

/**
 * Created by CFE on 25/11/2016.
 */

public interface IRecyclerViewFragmentView {

    public void generarLinearLayoutVertical();

    public Adapter crearAdaptador(ArrayList<Pets> items);

    public void inicializarAdaptadorRV(Adapter adapter);

}
