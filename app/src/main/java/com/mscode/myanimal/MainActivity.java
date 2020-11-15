package com.mscode.myanimal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.tabs.TabLayout;
import com.mscode.myanimal.adapter.AnimalAdaptador;
import com.mscode.myanimal.adapter.PageAdapter;
import com.mscode.myanimal.fragment.PerfilFragment;
import com.mscode.myanimal.fragment.RecyclerViewFragment;
import com.mscode.myanimal.pojo.Animal;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Animal> animal;
    private RecyclerView listaAnimales;
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    public Uri onProvideReferrer() {
        return super.onProvideReferrer();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);

        setUpViewPager();
//        Toolbar miActionBar = (Toolbar) findViewById(R.id.MyActionBar);
//        setSupportActionBar(miActionBar);


    if(toolbar != null){
        setSupportActionBar(toolbar);
    }

      /*  ArrayList<String> nombresContacto = new ArrayList<>();
        for(Animal animales: animal){
            nombresContacto.add(animales.getNombre());
        }*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.mContacto:
                Intent intent = new Intent(this,ContactoActivity.class );
                startActivity(intent);
                break;
            case R.id.mAcerca:
               Intent intent2 = new Intent(this,AboutActivity.class );
               startActivity(intent2);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new RecyclerViewFragment());
        fragments.add(new PerfilFragment());

        return fragments;
    }

    private void setUpViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_list);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_top);
    }


    public void mostrarTop(){
        /*ArrayList<String> milista = new ArrayList<String>();*/
        Intent intent = new Intent(this, DetalleAnimal.class);
        intent.putExtra("miLista", animal);
        startActivity(intent);
    }
}