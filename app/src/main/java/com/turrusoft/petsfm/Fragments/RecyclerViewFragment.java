package com.turrusoft.petsfm.Fragments;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.turrusoft.petsfm.Adapter.Adapter;
import com.turrusoft.petsfm.R;
import com.turrusoft.petsfm.pojo.Pets;
import com.turrusoft.petsfm.presentador.IRecyclerViewFragmentPresenter;
import com.turrusoft.petsfm.presentador.RecyclerViewFragmentPresenter;

import java.util.ArrayList;


public class RecyclerViewFragment extends Fragment implements IRecyclerViewFragmentView
{
    private RecyclerView recycler;
    private ArrayList<Pets> items;
    private IRecyclerViewFragmentPresenter presenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.fragment_recycler_view, container, false);
        //Obtener el Recycler
        recycler = (RecyclerView) v.findViewById(R.id.reciclador);
        presenter = new RecyclerViewFragmentPresenter(this, getContext());
        return  v;

    }

/*
    public  void inicializarMascotas()
    {
        // Inicializar Animes
        items = new ArrayList<>();

        items.add(new Pets(R.drawable.perro1, "Firulais", 20));
        items.add(new Pets(R.drawable.perro2, "Dogo", 25));
        items.add(new Pets(R.drawable.perro3, "Cirilo", 4));
        items.add(new Pets(R.drawable.perro4, "Spooky", 5));
        items.add(new Pets(R.drawable.perro5, "Roco", 10));
        items.add(new Pets(R.drawable.perro6, "Campeón", 15));
        items.add(new Pets(R.drawable.perro7, "Einstein", 3));
        items.add(new Pets(R.drawable.perro8, "Rufo", 8));
    }
*/
    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recycler.setLayoutManager(llm);
    }

    @Override
    public Adapter crearAdaptador(ArrayList<Pets> items) {
        Adapter adapter = new Adapter(items, getActivity());
        return adapter;
    }

    @Override
    public void inicializarAdaptadorRV(Adapter adapter) {
        recycler.setAdapter(adapter);
    }
}
