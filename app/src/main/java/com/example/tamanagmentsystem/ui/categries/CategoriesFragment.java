package com.example.tamanagmentsystem.ui.categries;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tamanagmentsystem.R;

import java.util.ArrayList;

public class CategoriesFragment extends Fragment {
RecyclerView recyclerView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_categories, container, false);
        final ArrayList<Student> arrayList = new ArrayList<>();
        arrayList.add(new Student( "AbdelHalim Mahmoud", "Android Team", "2018030258", "https://www.linkedin.com/in/abdelhalim-mahmoud/"));
        arrayList.add(new Student( "AbdelHalim Mahmoud", "Android Team", "2018030258", "https://www.linkedin.com/in/abdelhalim-mahmoud/"));
        arrayList.add(new Student( "AbdelHalim Mahmoud", "Android Team", "2018030258", "https://www.linkedin.com/in/abdelhalim-mahmoud/"));
        arrayList.add(new Student( "AbdelHalim Mahmoud", "Android Team", "2018030258", "https://www.linkedin.com/in/abdelhalim-mahmoud/"));
        arrayList.add(new Student( "AbdelHalim Mahmoud", "Android Team", "2018030258", "https://www.linkedin.com/in/abdelhalim-mahmoud/"));
        arrayList.add(new Student( "AbdelHalim Mahmoud", "Android Team", "2018030258", "https://www.linkedin.com/in/abdelhalim-mahmoud/"));
        arrayList.add(new Student( "AbdelHalim Mahmoud", "Android Team", "2018030258", "https://www.linkedin.com/in/abdelhalim-mahmoud/"));
        arrayList.add(new Student( "AbdelHalim Mahmoud", "Android Team", "2018030258", "https://www.linkedin.com/in/abdelhalim-mahmoud/"));
        arrayList.add(new Student( "AbdelHalim Mahmoud", "Android Team", "2018030258", "https://www.linkedin.com/in/abdelhalim-mahmoud/"));
        arrayList.add(new Student( "AbdelHalim Mahmoud", "Android Team", "2018030258", "https://www.linkedin.com/in/abdelhalim-mahmoud/"));
        arrayList.add(new Student( "AbdelHalim Mahmoud", "Android Team", "2018030258", "https://www.linkedin.com/in/abdelhalim-mahmoud/"));
        arrayList.add(new Student( "AbdelHalim Mahmoud", "Android Team", "2018030258", "https://www.linkedin.com/in/abdelhalim-mahmoud/"));
        arrayList.add(new Student( "AbdelHalim Mahmoud", "Android Team", "2018030258", "https://www.linkedin.com/in/abdelhalim-mahmoud/"));
        arrayList.add(new Student( "AbdelHalim Mahmoud", "Android Team", "2018030258", "https://www.linkedin.com/in/abdelhalim-mahmoud/"));
        arrayList.add(new Student( "AbdelHalim Mahmoud", "Android Team", "2018030258", "https://www.linkedin.com/in/abdelhalim-mahmoud/"));
        arrayList.add(new Student( "AbdelHalim Mahmoud", "Android Team", "2018030258", "https://www.linkedin.com/in/abdelhalim-mahmoud/"));
        arrayList.add(new Student( "AbdelHalim Mahmoud", "Android Team", "2018030258", "https://www.linkedin.com/in/abdelhalim-mahmoud/"));
        arrayList.add(new Student( "AbdelHalim Mahmoud", "Android Team", "2018030258", "https://www.linkedin.com/in/abdelhalim-mahmoud/"));
        recyclerView = (RecyclerView) root.findViewById(R.id.cat_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(root.getContext(), LinearLayoutManager.VERTICAL, false));
        final RecyclerAdapter ourTeamRecyclerAdapter = new RecyclerAdapter(R.layout.student_item2, arrayList);
        recyclerView.setAdapter(ourTeamRecyclerAdapter);
        Spinner department = root.findViewById(R.id.department);
        Spinner year = root.findViewById(R.id.year);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(root.getContext(),
                R.array.department_array, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        department.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.d("aaaaa", "onItemSelected: ");
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        department.setAdapter(adapter);


        ArrayAdapter<CharSequence> year_adapter = ArrayAdapter.createFromResource(root.getContext(),
                R.array.year_array, android.R.layout.simple_spinner_item);
        year_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        year.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.d("aaaaa", "onItemSelected: ");
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        year.setAdapter(year_adapter);
        return root;
    }

    /*private void OurTeamRecyclerView(View root) {

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


    }*/

}