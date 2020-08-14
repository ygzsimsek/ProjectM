package com.fortinbras.mercury.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fortinbras.mercury.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the  factory method to
 * create an instance of this fragment.
 */
public class BackingTracksFragment extends Fragment {

    private static BackingTracksFragment INSTANCE=null;
    public static BackingTracksFragment getInstance() {
        if(INSTANCE == null)
            INSTANCE = new BackingTracksFragment();
        return INSTANCE;
    }


    public BackingTracksFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_backing_tracks, container, false);
        // Inflate the layout for this fragment
        return view;
    }
}
