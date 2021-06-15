package com.example.gitsocial;

import android.os.Bundle;

import com.example.gitsocial.domain.Goal;
import com.example.gitsocial.domain.HDMIConnector;
import com.example.gitsocial.domain.User;
import com.example.gitsocial.domain.UserActivity;
import com.example.gitsocial.domain.VGA;
import com.example.gitsocial.domain.VGAConnector;
import com.example.gitsocial.domain.VGAHDMIAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);

        User user = User.builder()
                .id(23)
                .email("imwakabira@cc.ac.mw")
                .password("12334456")
                .username("ShukranIsaac")
                .build();

        UserActivity.builder().type("").id(12).description("").build();

        Goal.builder().id(1).title("").build();

        HDMIConnector hdmiConnector = null;

        VGAConnector adapter = new VGAHDMIAdapter(hdmiConnector);
        VGA vga = new VGA();
        vga.set(adapter);

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);
    }

}