package com.example.bottom_navigation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    private NavController navController;
    private AppBarConfiguration appBarConfiguration;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar=findViewById(R.id.topAppBar);
        setSupportActionBar(toolbar);
        DrawerLayout drawerLayout=findViewById(R.id.drawerLayout);
        NavigationView navigationView=findViewById(R.id.navigationView);

        //for the fragment
        appBarConfiguration=new AppBarConfiguration.Builder(
                R.id.firstFragment,R.id.secondFragment,R.id.thirdFragment
        ).setOpenableLayout(drawerLayout).build();
        //Navigation  Controller
        navController= Navigation.findNavController(MainActivity.this,R.id.fragment);
//        //Top Navigation
        NavigationUI.setupActionBarWithNavController(MainActivity.this,navController,appBarConfiguration);
        NavigationUI.setupWithNavController(navigationView,navController);

        //bottom Navigation
        BottomNavigationView bottomNavigationView=findViewById(R.id.navBottom);
        // Connect the NavController to the BottomNavigationView
        NavigationUI.setupWithNavController(bottomNavigationView, navController);
    }

    @Override
    public boolean onSupportNavigateUp() {
        navController= Navigation.findNavController(MainActivity.this,R.id.fragment);
        return NavigationUI.navigateUp(navController,appBarConfiguration) || super.onSupportNavigateUp();
    }
}