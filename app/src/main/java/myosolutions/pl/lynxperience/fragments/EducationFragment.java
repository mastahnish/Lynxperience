package myosolutions.pl.lynxperience.fragments;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import myosolutions.pl.lynxperience.R;
import myosolutions.pl.lynxperience.databinding.FragmentEducationBinding;

/**
 * A simple {@link Fragment} subclass.
 */
public class EducationFragment extends Fragment {

    private FragmentEducationBinding binding;

    public EducationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_education, container, false);
        return binding.getRoot();
    }

}
