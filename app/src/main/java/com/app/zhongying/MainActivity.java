package com.app.zhongying;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_shop, R.id.navigation_ticketing, R.id.navigation_live, R.id.navigation_own)
                .build();
        final NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
//        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);
        LinearLayout layoutTitle = findViewById(R.id.layout_top);
        final TextView tvTitle = findViewById(R.id.tv_title);
        navView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                navController.navigate(item.getItemId());
                switch (item.getItemId()){
                    case R.id.navigation_home:
                        //tvTitle.setText(getResources().getString(R.string.title_home));
                        layoutTitle.setVisibility(View.GONE);
                        break;
                    case R.id.navigation_shop:
                        tvTitle.setText(getResources().getString(R.string.title_shop));
                        layoutTitle.setVisibility(View.VISIBLE);
                        break;
                    case R.id.navigation_ticketing:
                        tvTitle.setText(getResources().getString(R.string.title_ticketing));
                        layoutTitle.setVisibility(View.GONE);
                        break;
                    case R.id.navigation_live:
                        tvTitle.setText(getResources().getString(R.string.title_live));
                        layoutTitle.setVisibility(View.VISIBLE);
                        break;
                    case R.id.navigation_own:
                        tvTitle.setText(getResources().getString(R.string.title_own));
                        layoutTitle.setVisibility(View.VISIBLE);
                        break;
                }
                return false;
            }
        });
    }

}