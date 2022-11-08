package com.example.tugas_besar_new1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout dl;
    private ActionBarDrawerToggle abdt;
    RecyclerView recylerView;
    String s1[], s2[],s3[];
    int images[] = {R.mipmap.kotakexoticshothair,R.mipmap.kotakmainecoon,R.mipmap.kotakbengal,R.mipmap.kotakpersia};

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dl = (DrawerLayout)findViewById(R.id.dl);
        abdt = new ActionBarDrawerToggle(this,dl,R.string.Open,R.string.Close);
        abdt.setDrawerIndicatorEnabled(true);
        dl.addDrawerListener(abdt);
        abdt.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        NavigationView nav_view = (NavigationView)findViewById(R.id.nav_view);
        nav_view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.nav_chat){
                    Intent a = new Intent(MainActivity.this, MainActivity.class);
                    startActivity(a);
                }else if (id == R.id.nav_about){
                    Intent a = new Intent(MainActivity.this, MainActivity2.class);
                    startActivity(a);
                }else if (id == R.id.nav_bug){
                    Intent a = new Intent(MainActivity.this, MainActivity3.class);
                    startActivity(a);
                }
                return true;
            }
        });
        setContentView(R.layout.activity_main);
        recylerView = findViewById(R.id.recyclerView);
        s1 = getResources().getStringArray(R.array.kucing);
        s2 = getResources().getStringArray(R.array.harga);
        s3 = getResources().getStringArray(R.array.star);
        KucingAdapter appAdapter = new KucingAdapter(this, s1, s2, s3, images);
        recylerView.setAdapter(appAdapter);
        //membuatlinier scrolview
        //recylerView.setLayoutManager(new LinearLayoutManager(this));
        //membuathorizontal scrollview
        LinearLayoutManager layoutManager = new LinearLayoutManager((this), RecyclerView.HORIZONTAL, false);
        recylerView.setLayoutManager(layoutManager);
        recylerView.setItemAnimator(new DefaultItemAnimator());
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return abdt.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);
    }
}
