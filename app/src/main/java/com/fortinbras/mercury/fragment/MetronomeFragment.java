package com.fortinbras.mercury.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fortinbras.mercury.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MetronomeFragment extends Fragment {

    private static MetronomeFragment INSTANCE=null;

    public static MetronomeFragment getInstance() {
        if (INSTANCE == null)
            INSTANCE = new MetronomeFragment();
        return INSTANCE;
    }

    public MetronomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_metronome, container, false);
        // Inflate the layout for this fragment
        return view;
    }
}
