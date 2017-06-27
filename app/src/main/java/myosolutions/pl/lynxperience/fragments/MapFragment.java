package myosolutions.pl.lynxperience.fragments;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import myosolutions.pl.lynxperience.R;
import myosolutions.pl.lynxperience.databinding.FragmentMapBinding;

/**
 * A simple {@link Fragment} subclass.
 */
public class MapFragment extends Fragment {

    private FragmentMapBinding binding;

    public MapFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_map, container, false);
        return binding.getRoot();
    }

}
