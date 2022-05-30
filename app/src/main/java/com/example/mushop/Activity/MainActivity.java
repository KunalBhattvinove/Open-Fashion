package com.example.mushop.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.mushop.Screens.Cart;
import com.example.mushop.Screens.Login;
import com.example.mushop.R;
import com.example.mushop.Screens.Search;
import com.example.mushop.Screens.Signup;
import com.example.mushop.Screens.homepage;
import com.example.mushop.Screens.menu;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    private Toolbar toolbar;
    private ImageView imageView;
    private ImageView bag,search;
    public DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.tool);

        setSupportActionBar(toolbar);
       add(new homepage());

        drawerLayout = findViewById(R.id.drawer12);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,R.string.open,R.string.close);
        drawerLayout.setDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        drawerLayout.closeDrawer(Gravity.LEFT,false);

       findViewById(R.id.bag).setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               addcart(new Cart());
           }


       });

       findViewById(R.id.search).setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               addsearch(new Search());
           }
       });
       findViewById(R.id.logo).setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
              addpage(new homepage());

           }

           private void addpage(homepage homepage) {
               FragmentManager fm = getSupportFragmentManager();
               FragmentTransaction ft = fm.beginTransaction();
               ft.add(R.id.frame1,homepage);
               ft.commit();
               ft.addToBackStack(null);
           }
       });
    }

    private void addsearch(Search search) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.frame1,search);
        ft.commit();
        ft.addToBackStack(null);
    }

    private void addcart(Cart cart) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.frame1,cart);
        ft.commit();
        ft.addToBackStack(null);
    }


    private void addmenu(menu menu) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.frame1,menu);
        ft.commit();
        ft.addToBackStack(null);
    }

    private void add(homepage homepage) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.frame1,homepage);
        ft.commit();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.nav_login)
        {
            replacefragment(new Login());
            drawerLayout.closeDrawer(Gravity.LEFT,false);

        }
        if(id == R.id.nav_Register)
        {
            replacefragment2(new Signup());
            drawerLayout.closeDrawer(Gravity.LEFT,false);

        }
        if(id == R.id.nav_category)
        {
            replacefragment3(new menu());
            drawerLayout.closeDrawer(Gravity.LEFT,false);        }

        if(id == R.id.nav_logout)
        {
            replacefragment4(new homepage());
            drawerLayout.closeDrawer(Gravity.LEFT,false);
        }
        return false;
    }

    private void replacefragment2(Signup signup) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.frame1,signup);
        ft.commit();
        ft.addToBackStack(null);
    }

    private void replacefragment(Login login) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.frame1,login);
        ft.commit();
        ft.addToBackStack(null);


    }

    private void replacefragment3(menu menu) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.frame1,menu);
        ft.commit();
        ft.addToBackStack(null);
    }

    private void replacefragment4(homepage homepage) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.frame1,homepage);
        ft.commit();
        ft.addToBackStack(null);
        Toast.makeText(this, "You logged out", Toast.LENGTH_SHORT).show();


    }


}
