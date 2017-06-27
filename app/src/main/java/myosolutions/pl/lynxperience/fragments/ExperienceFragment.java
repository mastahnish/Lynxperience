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
public class ExperienceFragment extends Fragment implements BragAdapter.OnItemClickListener{


    private static final String TAG = ExperienceFragment.class.getSimpleName();
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
            list.add(new BragItem(ContextCompat.getDrawable(ac, R.drawable.ic_myosolutions), "Retirement App - Project for customer from Germany. App assuming usage of external OCR library for scanning documents and calculating data from it.", "Android Developer", StringUtils.Blank));
            list.add(new BragItem(ContextCompat.getDrawable(ac, R.drawable.ic_myosolutions), "Concession App and HubApp - Project for customer from UK. Apps for internal usage on Zebra devices MC40, TC70. Integration with payments, Zebra printer GK420d and Scandit library.", "Android Developer", StringUtils.Blank));
            list.add(new BragItem(ContextCompat.getDrawable(ac, R.drawable.ic_myosolutions), "MoodApp - Project that uses smile recognition technology", "Android Developer", "https://play.google.com/store/apps/details?id=com.solutions.myo.ankietapp&hl=pl"));
            list.add(new BragItem(ContextCompat.getDrawable(ac, R.drawable.ic_myosolutions), "WeatherApp - This app shows basic weather info. Includes widget", "Android Developer", "https://play.google.com/store/apps/details?id=com.myos.simpleweatherforecast&hl=pl"));
            list.add(new BragItem(ContextCompat.getDrawable(ac, R.drawable.ic_myosolutions), "Compass - App that uses magnetometer and grativy to act like compass", "Android Developer", "https://play.google.com/store/apps/details?id=myos.jacek.compass&hl=pl"));
            list.add(new BragItem(ContextCompat.getDrawable(ac, R.drawable.ic_myosolutions), "CoByTu.com - Mobile menu for everyone. Implementation of own idea", "Android Developer", "https://play.google.com/store/apps/details?id=com.myo.cobytu&hl=pl"));
            list.add(new BragItem(ContextCompat.getDrawable(ac, R.drawable.ic_gsk), "IT Specialist in Application Support area. Working with SQL Server, Oracle, .Net, C#, HTML aligned with ITIL.", "IT Specialist", "https://pl.gsk.com/pl/kariera/"));
            list.add(new BragItem(ContextCompat.getDrawable(ac, R.drawable.ic_gsk), "Trainee in APS Transformation team. Working with urers rights, Active Directory and Windows Server Manager.", "Intern", "https://pl.gsk.com/pl/kariera/"));
            list.add(new BragItem(ContextCompat.getDrawable(ac, R.drawable.ic_networks), "Trainee in Planning and Optimization of Transmission Networks Section. Working mainly with SQL.", "Intern", "http://www.networks.pl/"));
            list.add(new BragItem(ContextCompat.getDrawable(ac, R.drawable.ic_plus), "Trainee in Fixed Network Section. Focused on creating relational SQL database for the team.", "Intern", "http://www.polkomtel.com.pl/"));
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
