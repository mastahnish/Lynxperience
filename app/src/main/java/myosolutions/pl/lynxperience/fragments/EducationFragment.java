package myosolutions.pl.lynxperience.fragments;


import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import myosolutions.pl.lynxperience.R;
import myosolutions.pl.lynxperience.databinding.FragmentExperienceBinding;
import myosolutions.pl.lynxperience.utils.StringUtils;

/**
 * A simple {@link Fragment} subclass.
 */
public class EducationFragment extends Fragment implements BragAdapter.OnItemClickListener{


    private static final String TAG = ExperienceFragment.class.getSimpleName();
    private FragmentExperienceBinding binding;

    public EducationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_experience, container, false);

        initViews();

        return binding.getRoot();
    }

    private void initViews() {
        binding.rvExperiences.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        BragAdapter adapter = new BragAdapter(this);
        adapter.setData(getEducation());
        binding.rvExperiences.setAdapter(adapter);
    }

    private List<BragItem> getEducation(){
        List<BragItem> list = new ArrayList<>();

        Activity ac = getActivity();
        if(ac!=null){
            list.add(new BragItem(ContextCompat.getDrawable(ac, R.drawable.ic_politechnika), "2012 - 2013 - Information and Communication Technologies", "Master Studies", "https://www4.put.poznan.pl/"));
            list.add(new BragItem(ContextCompat.getDrawable(ac, R.drawable.ic_tut), "2010 - 2011 - Radiocommunications", "Erasmus", "http://www.tut.fi/en/home"));
            list.add(new BragItem(ContextCompat.getDrawable(ac, R.drawable.ic_politechnika), "2008 - 2012 - Radiocommunications", "Bachelor Studies", "http://www.info.put.poznan.pl/system/files/Wywiad_cz.2_Prof.dr_.in%C5%BC.JANUSZ_RAJSKI.mp3"));
        }

        return list;
    }

    @Override
    public void onItemClick(BragItem item) {
        String url = item.getUrl();
        if(!StringUtils.isEmpty(url)){
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(browserIntent);
        }else{
            Snackbar.make(binding.rvExperiences, "No reference", Snackbar.LENGTH_SHORT).show();
        }
    }

}
