package com.example.movies_efrei;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.cuberto.liquid_swipe.LiquidPager;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    /*LiquidPager pager;
    ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pager=findViewById(R.id.pager);
        viewPager = new ViewPager(getSupportFragmentManager(), 1);
        pager.setAdapter(viewPager);
    }*/

    private static final String TAG = "MovieMain";

    public static final int MENU_START = 0;
    public static final int MENU_MAIN = 1;
    public static final int FRAGMENT_LOGIN = 2;
    public static final int FRAGMENT_REGISTER = 3;
    public static final int FRAGMENT_HOME = 4;
    public static final int FRAGMENT_FAVORITES = 5;
    public static final int FRAGMENT_PROFILE = 6;

    public static FragmentManager mFragmentManager;

    public static String currentUser;
    public static int currentUserID;

    private Fragment homeFragment = new FragmentHome();

    private BottomNavigationView mBottomNavigationView;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_container);

        mFragmentManager = getSupportFragmentManager();

            if (findViewById(R.id.fragment_container)!=null) {

            if (savedInstanceState != null) {
                return;
            }

            mBottomNavigationView = findViewById(R.id.bottom_navigation_view);
            mBottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    switch (menuItem.getItemId()) {
                        case R.id.home:
                            Log.d(TAG, "Go to home");
                            mFragmentManager.beginTransaction()
                                    .replace(R.id.fragment_container, homeFragment, null)
                                    .commit();
                            break;
                    }
                    return false;
                }
            });

            mFragmentManager.beginTransaction()
                    .add(R.id.fragment_container, homeFragment, null)
                    .commit();
        }
    }

    public void setBottomNavigationMenu(int menu){
       /* mBottomNavigationView.getMenu().clear();
        switch(menu){
            case MENU_START:
                mBottomNavigationView.inflateMenu(R.menu.menu_start);
                break;
            case MENU_MAIN:
                mBottomNavigationView.inflateMenu(R.menu.menu_main);
                break;
        }

        */
    }

    public void replaceFragment(int fragment){
        switch (fragment){
            case FRAGMENT_HOME:
                mFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, homeFragment, null)
                        .commit();
                break;
        }
    }

    public static void showDetails(Movie movie){
        /*mFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, new FragmentDetails(movie), null)
                .addToBackStack(null)
                .commit();

         */
    }

    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() == 0) {
            this.finish();
        } else {
            getSupportFragmentManager().popBackStack();
        }
    }









}