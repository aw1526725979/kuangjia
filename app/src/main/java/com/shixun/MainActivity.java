package com.shixun;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;
import com.shixun.R;
import com.shixun.view.Cart.CartFragment;
import com.shixun.view.classify.ClassifyFragment;
import com.shixun.view.home.HomeFragment;
import com.shixun.view.login.RegisterActivity;
import com.shixun.view.own.OwnFragment;
import com.shixun.view.special.SpecialFragment;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("                       仿网易严选");
        BottomNavigationView navView = findViewById(R.id.nav_view);

        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_topic, R.id.navigation_sort,
                R.id.navigation_shop,R.id.navigation_me)
                .build();

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);

      /*  Intent intent  = new Intent(this, RegisterActivity.class);
        startActivity(intent);
*/

    }

}
