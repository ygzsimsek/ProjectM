package com.fortinbras.mercury;

import android.os.Bundle;
import android.text.style.BackgroundColorSpan;
import android.text.style.MetricAffectingSpan;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;

import com.fortinbras.mercury.fragment.BackingTracksFragment;
import com.fortinbras.mercury.fragment.MetronomeFragment;
import com.fortinbras.mercury.fragment.SettingsFragment;
import com.fortinbras.mercury.fragment.TunerFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class HomeActivity extends AppCompatActivity {

    ImageButton btn_settings,btn_metronome,btn_tuner;
    FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        frameLayout = (FrameLayout) findViewById(R.id.layout_frame_main);
        //@TODO: DELETE THIS
        BottomNavigationView navigation = (BottomNavigationView)findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        btn_tuner = (ImageButton)findViewById(R.id.btn_nav_tuner);
        btn_metronome =(ImageButton)findViewById(R.id.btn_nav_metro);
        btn_settings=(ImageButton)findViewById(R.id.btn_nav_settings);

        btn_tuner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TunerFragment tunerFragment = new  TunerFragment();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.layout_frame_main, tunerFragment);
                transaction.commit();

                btn_tuner.setImageResource(R.drawable.ic_guitar_pick_white);
                btn_metronome.setImageResource(R.drawable.ic_metronome_tick_white);
                btn_settings.setImageResource(R.drawable.ic_settings_outline_white);
            }
        });

        btn_metronome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MetronomeFragment metronomeFragment = new MetronomeFragment();
                FragmentTransaction transaction1 = getSupportFragmentManager().beginTransaction();
                transaction1.replace(R.id.layout_frame_main, metronomeFragment);
                transaction1.commit();

                btn_metronome.setImageResource(R.drawable.ic_metronome_white);
                btn_tuner.setImageResource(R.drawable.ic_guitar_pick_outline_white);
                btn_settings.setImageResource(R.drawable.ic_settings_outline_white);
            }
        });

        btn_settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SettingsFragment settingsFragment = new SettingsFragment();
                FragmentTransaction transaction3 = getSupportFragmentManager().beginTransaction();
                transaction3.replace(R.id.layout_frame_main, settingsFragment);
                transaction3.commit();

                btn_metronome.setImageResource(R.drawable.ic_metronome_tick_white);
                btn_tuner.setImageResource(R.drawable.ic_guitar_pick_outline_white);
                btn_settings.setImageResource(R.drawable.ic_pie_chart_white);
            }
        });

        //set fragment at start
        TunerFragment tunerFragment = new  TunerFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.layout_frame_main, tunerFragment);
        transaction.commit();
    }

    //@TODO: DELETE THIS
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_tuner:
                    TunerFragment tunerFragment = new  TunerFragment();
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.layout_frame_main, tunerFragment);
                    transaction.commit();
                    return true;
                case R.id.navigation_metronome:
                    MetronomeFragment metronomeFragment = new MetronomeFragment();
                    FragmentTransaction transaction1 = getSupportFragmentManager().beginTransaction();
                    transaction1.replace(R.id.layout_frame_main, metronomeFragment);
                    transaction1.commit();
                    return true;
                case R.id.navigation_backing_tracks:
                    BackingTracksFragment backingTracksFragment = new BackingTracksFragment();
                    FragmentTransaction transaction2 = getSupportFragmentManager().beginTransaction();
                    transaction2.replace(R.id.layout_frame_main, backingTracksFragment);
                    transaction2.commit();
                    return true;
                case R.id.navigation_settings:
                    SettingsFragment settingsFragment = new SettingsFragment();
                    FragmentTransaction transaction3 = getSupportFragmentManager().beginTransaction();
                    transaction3.replace(R.id.layout_frame_main, settingsFragment);
                    transaction3.commit();
                    return true;
            }
            return false;
        }
    };

}
