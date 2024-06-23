package com.example.pruebas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.example.pestaas.ControladorMenu;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    TabLayout menu;
    ViewPager2 escenario;
    com.example.pestaas.ControladorMenu menuCtrl;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        menu = (TabLayout) findViewById(R.id.tabMenu);
        escenario = (ViewPager2) findViewById(R.id.princi);
        menuCtrl = new ControladorMenu(getSupportFragmentManager(),getLifecycle());
        escenario.setAdapter(menuCtrl);

        escenario.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                menu.selectTab(menu.getTabAt(position));
            }
        });

        menu.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                escenario.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}