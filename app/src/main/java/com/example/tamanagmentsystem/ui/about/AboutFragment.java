package com.example.tamanagmentsystem.ui.about;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tamanagmentsystem.R;

import java.util.ArrayList;

public class AboutFragment extends Fragment {
    RecyclerView recyclerView;

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View root = inflater.inflate(R.layout.fragment_about, container, false);
        OurTeamRecyclerView(root);
        return root;
    }

    private void OurTeamRecyclerView(View root) {
        final ArrayList<OurTeam> ourTeamArrayList = new ArrayList<>();
        ourTeamArrayList.add(new OurTeam( "AbdelHalim Mahmoud", "Android Team", "2018030258", "https://www.linkedin.com/in/abdelhalim-mahmoud/", R.drawable.abdel_halim, R.drawable.linked));
        ourTeamArrayList.add(new OurTeam( "Ahmed Sedky", "Android Team", "2018030021", "https://www.facebook.com/ahmed.sedky.9", R.drawable.sedky, R.drawable.facebook));
        ourTeamArrayList.add(new OurTeam( "AbdelRhman Saeed", "Android Team", "2018030211", "http://www.linkedin.com/in/abdelrahman-saeed-bab9841a2", R.drawable.saeed, R.drawable.linked));
        ourTeamArrayList.add(new OurTeam( "Tarik Atef", "Android Team", "2018030064", "https://www.facebook.com/mazika.is.here", R.drawable.tarek, R.drawable.facebook));


        Context context = root.getContext();
        recyclerView = (RecyclerView) root.findViewById(R.id.our_team_recycler_view);
        if (mColumnCount <= 1) {
            recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
        } else {
            recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
        }

        final OurTeamRecyclerAdapter ourTeamRecyclerAdapter = new OurTeamRecyclerAdapter(R.layout.our_team_item, ourTeamArrayList);

        recyclerView.setAdapter(ourTeamRecyclerAdapter);


    }
}