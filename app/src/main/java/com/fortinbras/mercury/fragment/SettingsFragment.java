package com.fortinbras.mercury.fragment;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import com.fortinbras.mercury.R;
import com.fortinbras.mercury.activity.AboutActivity;
import com.google.android.material.switchmaterial.SwitchMaterial;

public class SettingsFragment extends Fragment implements View.OnClickListener {

    public TextView txt_oss;
    SwitchMaterial switch_dt;
    Button btn_oss,btn_about,btn_ins,btn_tuning,btn_tick,btn_kalp;

    private static SettingsFragment INSTANCE=null;

    public static SettingsFragment getInstance() {
        if (INSTANCE == null)
            INSTANCE = new SettingsFragment();
        return INSTANCE;
    }

    public SettingsFragment() {
        // Required empty public constructor
    }


    @SuppressLint("ResourceAsColor")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_settings, container, false);
        btn_about = view.findViewById(R.id.btn_about);
        btn_oss = view.findViewById(R.id.btn_oss);
        btn_tuning = view.findViewById(R.id.btn_select_tuning);
        btn_tick = view.findViewById(R.id.btn_tick_snd);
        btn_kalp= view.findViewById(R.id.button7);
        btn_ins= view.findViewById(R.id.btn_select_instrument);
        switch_dt = view.findViewById(R.id.switch_dt);
        //onclick events
        btn_oss.setOnClickListener(this);
        btn_about.setOnClickListener(this);
        btn_ins.setOnClickListener(this);
        btn_tuning.setOnClickListener(this);
        btn_tick.setOnClickListener(this);
        btn_kalp.setOnClickListener(this);
        //asfaf
        switch_dt.setText(R.string.light_theme);
        switch_dt.setTextColor(R.color.black);
        switch_dt.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        switch_dt.setChecked(false);
                        Toast.makeText(getContext(), "FUCK YOU", Toast.LENGTH_SHORT).show();
                    }
                }, 1000);
            }
        });
        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.btn_select_instrument:
                Toast.makeText(getContext(), "HEY", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_select_tuning:
                Toast.makeText(getContext(), "DROP D", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_tick_snd:
                Toast.makeText(getContext(), "Tick tick tick tick", Toast.LENGTH_SHORT).show();
                break;
            case R.id.button7:
                Toast.makeText(getContext(), "You are breathtaking!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_about:
                Intent aboutIntent = new Intent(getActivity(), AboutActivity.class);
                startActivity(aboutIntent);
                break;
            case R.id.btn_oss:
                txt_oss = new TextView(getContext());
                txt_oss.setText(getString(R.string.oss_text));
                AlertDialog.Builder dialog_oss = new AlertDialog.Builder(getContext());
                dialog_oss.setTitle(R.string.btn_oss);
                dialog_oss.setView(txt_oss);
                dialog_oss.setCancelable(true);
                dialog_oss.setNeutralButton(getString(R.string.action_close),null);
                dialog_oss.show();
                break;
        }

    }
}
