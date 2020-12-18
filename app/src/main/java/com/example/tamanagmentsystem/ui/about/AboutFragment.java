package com.example.tamanagmentsystem.ui.about;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

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
        ourTeamArrayList.add(new OurTeam( "AbdelHalim Mahmoud", "Android Devaloper", "2018030258", "https://www.linkedin.com/in/abdelhalim-mahmoud/?lipi=urn%3Ali%3Apage%3Ad_flagship3_feed%3BU%2B%2B6svsCTEe1oxfOrIkeHw%3D%3D", R.drawable.abdel_halim, R.drawable.linked));
        ourTeamArrayList.add(new OurTeam( "Ahmed Sedky", "Android Devaloper", "2018030021", "https://www.linkedin.com/in/abdelhalim-mahmoud/?lipi=urn%3Ali%3Apage%3Ad_flagship3_feed%3BU%2B%2B6svsCTEe1oxfOrIkeHw%3D%3D", R.drawable.logo, R.drawable.linked));
        ourTeamArrayList.add(new OurTeam( "AbdelRhman Saeed", "Android Devaloper", "2018030211", "https://www.linkedin.com/in/abdelhalim-mahmoud/?lipi=urn%3Ali%3Apage%3Ad_flagship3_feed%3BU%2B%2B6svsCTEe1oxfOrIkeHw%3D%3D", R.drawable.logo, R.drawable.linked));
        ourTeamArrayList.add(new OurTeam( "Tarik", "Android Devaloper", "2018030064", "https://www.linkedin.com/in/abdelhalim-mahmoud/?lipi=urn%3Ali%3Apage%3Ad_flagship3_feed%3BU%2B%2B6svsCTEe1oxfOrIkeHw%3D%3D", R.drawable.logo, R.drawable.linked));


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