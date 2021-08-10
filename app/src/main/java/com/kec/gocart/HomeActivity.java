package com.kec.gocart;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;
import com.kec.gocart.fragment.ActivityLogFragment;
import com.kec.gocart.fragment.CartFragment;
import com.kec.gocart.fragment.ProfileFragment;

public class HomeActivity extends AppCompatActivity {


    private BottomNavigationView navigationView;

    private CartFragment cartFragment = new CartFragment();
    private ProfileFragment profileFragment = new ProfileFragment();

    private ActivityLogFragment activityLogFragment;

    private Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        toolbar = findViewById(R.id.toolbar);

        activityLogFragment = ActivityLogFragment.newInstance("Hello", "World");
        setUpToolbar();
        navigationView = findViewById(R.id.navigation_view);
        initListeners();
        setUpFragment(cartFragment,"Cart");
    }

    private void setUpToolbar() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            toolbar.setTitle("App Name");
        }
    }

    private void initListeners() {


        navigationView.setOnItemSelectedListener(item -> {

            switch (item.getItemId()){


                case R.id.action_cart:
                    // home click

                    setUpFragment(cartFragment,"Cart");

                    break;

                case R.id.action_profile:

                    setUpFragment(profileFragment,"Cart");

                    // profile
                    break;

                case R.id.action_videos:

                    setUpFragment(activityLogFragment,"Cart");

                    // videos

                    break;


            }


            return true;
        });


    }


    // fragment
    private void setUpFragment(Fragment fragment, String tag) {

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
        fragmentTransaction.replace(R.id.container_fragment, fragment, tag);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

    }



}