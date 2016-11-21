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

import java.util.ArrayList;


public class RecyclerViewFragment extends Fragment
{
    private RecyclerView recycler;
    private ArrayList<Pets> items;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.fragment_recycler_view, container, false);
        //Obtener el Recycler
        recycler = (RecyclerView) v.findViewById(R.id.reciclador);
        //  recycler.setHasFixedSize(true)
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        recycler.setLayoutManager(llm);
        inicializarMascotas();
        inicializarAdaptador();

        return  v;

    }

    public void  inicializarAdaptador()
    {
        // Crear un nuevo adaptador
        Adapter adapter = new Adapter(items);
        recycler.setAdapter(adapter);
    }
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
}
