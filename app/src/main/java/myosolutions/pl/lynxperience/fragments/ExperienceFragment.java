package myosolutions.pl.lynxperience.fragments;


import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
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
public class ExperienceFragment extends Fragment implements BragAdapter.OnItemClickListener{


    private FragmentExperienceBinding binding;

    public ExperienceFragment() {
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
        adapter.setData(getExperiences());
        binding.rvExperiences.setAdapter(adapter);
    }

    private List<BragItem> getExperiences(){
        List<BragItem> list = new ArrayList<>();

        Activity ac = getActivity();
        if(ac!=null){
            list.add(new BragItem(ContextCompat.getDrawable(ac, R.drawable.ic_launcher_ankiet_app), "Project that uses smile recognition technology", "Android Developer", "https://play.google.com/store/apps/details?id=com.solutions.myo.ankietapp&hl=pl"));
            list.add(new BragItem(ContextCompat.getDrawable(ac, R.drawable.ic_launcher_weather_app), "This app shows basic weather info. Includes widget", "Android Developer", "https://play.google.com/store/apps/details?id=com.myos.simpleweatherforecast&hl=pl"));
            list.add(new BragItem(ContextCompat.getDrawable(ac, R.drawable.ic_launcher_compass), "App that uses magnetometer and grativy to act like compass", "Android Developer", "https://play.google.com/store/apps/details?id=myos.jacek.compass&hl=pl"));
            list.add(new BragItem(ContextCompat.getDrawable(ac, R.drawable.ic_launcher_cobytu), "Mobile menu for everyone. Implementation of own idea", "Android Developer", "https://play.google.com/store/apps/details?id=com.myo.cobytu&hl=pl"));

        }

        return list;
    }

    @Override
    public void onItemClick(BragItem item) {
        String url = item.getUrl();
        if(!StringUtils.isEmpty(url)){
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(browserIntent);
        }
    }
}
