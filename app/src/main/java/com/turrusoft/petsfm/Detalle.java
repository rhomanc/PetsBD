package com.turrusoft.petsfm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.turrusoft.petsfm.Adapter.Adapter;
import com.turrusoft.petsfm.pojo.Pets;

import java.util.ArrayList;
import java.util.List;

public class Detalle extends AppCompatActivity
{
    private TextView txtbar;
    private ImageView imgTop;
    private RecyclerView recycler;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager lManager;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        Toolbar ActionBar= (Toolbar)findViewById(R.id.ActionBar);
        setSupportActionBar(ActionBar);

        txtbar = (TextView) findViewById(R.id.txtbar);
        txtbar.setText("Favoritas");

        imgTop = (ImageView) findViewById(R.id.imgtop);
        imgTop.setVisibility(View.INVISIBLE);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setLogo(R.drawable.dog_footprint_filled_50);

        // Inicializar Animes
        List<Pets> items = new ArrayList<>();

        items.add(new Pets(R.drawable.perro4, "Spooky", 5));
        items.add(new Pets(R.drawable.perro5, "Roco", 10));
        items.add(new Pets(R.drawable.perro6, "Campeón", 15));
        items.add(new Pets(R.drawable.perro1, "Firulais", 20));
        items.add(new Pets(R.drawable.perro2, "Dogo", 25));


        // Obtener el Recycler
        recycler = (RecyclerView) findViewById(R.id.rvDetalle);
        recycler.setHasFixedSize(false);


        // Usar un administrador para LinearLayout
        lManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(lManager);

        // Crear un nuevo adaptador
        adapter = new Adapter(items);
        recycler.setAdapter(adapter);
    }
}

