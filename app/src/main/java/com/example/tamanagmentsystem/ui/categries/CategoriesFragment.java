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
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Calendar;

public class CategoriesFragment extends Fragment {
    RecyclerView recyclerView;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    int yearVal;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_categories, container, false);
        final ArrayList<Student> arrayList = new ArrayList<>();

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

                db.collection("student")
                        .get()
                        .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                            @Override
                            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                yearVal = Calendar.getInstance().get(Calendar.YEAR) - (year.getSelectedItemPosition());
                                arrayList.clear();
                                ourTeamRecyclerAdapter.notifyDataSetChanged();
                                if (task.isSuccessful()) {
                                    for (QueryDocumentSnapshot document : task.getResult()) {
                                        Log.d("Bad", String.valueOf(document.get("ID").toString().subSequence(0, 4)), task.getException());

                                        if (String.valueOf(position + 1).equals(String.valueOf(document.get("ID").toString().charAt(5))) && document.get("ID").toString().subSequence(0, 4).equals(String.valueOf(yearVal))) {
                                            Log.d("ffff", String.valueOf(document.get("ID")), task.getException());

                                            arrayList.add(new Student(document.get("name").toString(), document.get("ID").toString(), document.get("gpa").toString(), document.get("phone").toString()));
                                            ourTeamRecyclerAdapter.notifyDataSetChanged();


                                        }
                                    }
                                } else {
                                    Log.d("Bad", "Error getting documents: ", task.getException());
                                }

                            }
                        });
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
                db.collection("student")
                        .get()
                        .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                            @Override
                            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                yearVal = Calendar.getInstance().get(Calendar.YEAR) - position;
                                arrayList.clear();
                                ourTeamRecyclerAdapter.notifyDataSetChanged();
                                if (task.isSuccessful()) {
                                    for (QueryDocumentSnapshot document : task.getResult()) {

                                        if (String.valueOf(department.getSelectedItemPosition() + 1).equals(String.valueOf(document.get("ID").toString().charAt(5))) && document.get("ID").toString().subSequence(0, 4).equals(String.valueOf(yearVal))) {
                                            Log.d("ffff", String.valueOf(document.get("ID")), task.getException());


                                            arrayList.add(new Student(document.get("name").toString(), document.get("ID").toString(), document.get("gpa").toString(), document.get("phone").toString()));
                                            ourTeamRecyclerAdapter.notifyDataSetChanged();

                                        }
                                    }
                                } else {
                                    Log.d("Bad", "Error getting documents: ", task.getException());
                                }

                            }
                        });
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        year.setAdapter(year_adapter);
        return root;
    }


}