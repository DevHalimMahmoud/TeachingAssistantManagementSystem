package com.example.tamanagmentsystem.ui.home;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tamanagmentsystem.MainActivity;
import com.example.tamanagmentsystem.R;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;

import java.util.ArrayList;
import java.util.List;

import static android.view.View.GONE;

public class HomeFragment extends Fragment {


    ProgressBar progressBar;
    private FirebaseFirestore db;
    RecyclerView shift_recyclerView;
    RecyclerView admin_recycler;
    private FirestoreRecyclerAdapter admin_adapter;
    RecyclerView ta_recycler;
    private FirestoreRecyclerAdapter ta_adapter;
    RecyclerView student_recycler;
    private FirestoreRecyclerAdapter student_adapter;
    LinearLayoutManager adminLayoutManager;
    LinearLayoutManager taLayoutManager;
    LinearLayoutManager studentLayoutManager;

    @SuppressLint("WrongConstant")
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        TextView admin_t = root.findViewById(R.id.admins);
        TextView ta_t = root.findViewById(R.id.ta);
        TextView shift_t = root.findViewById(R.id.shift);
        shift_recyclerView = (RecyclerView) root.findViewById(R.id.shift_recycler);
        admin_recycler = root.findViewById(R.id.admin_recycler);
        ta_recycler = root.findViewById(R.id.ta_recycler);
        student_recycler = root.findViewById(R.id.student_recycler);
        progressBar = root.findViewById(R.id.progress_bar);
        if (!MainActivity.type) {
            admin_recycler.setVisibility(GONE);
            admin_t.setVisibility(GONE);
            ta_t.setVisibility(GONE);
            ta_recycler.setVisibility(GONE);
        } else {
            shift_t.setVisibility(GONE);
            shift_recyclerView.setVisibility(GONE);

        }
        init(root.getContext());
        getAdminList(root.getContext());
        getTAList(root.getContext());
        getStudentList(root.getContext());
        shifts(root);
        return root;
    }

    private void init(Context root) {
        adminLayoutManager = new LinearLayoutManager(root.getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
        taLayoutManager = new LinearLayoutManager(root.getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
        studentLayoutManager = new LinearLayoutManager(root.getApplicationContext(), LinearLayoutManager.VERTICAL, false);

        admin_recycler.setLayoutManager(adminLayoutManager);
        ta_recycler.setLayoutManager(taLayoutManager);
        student_recycler.setLayoutManager(studentLayoutManager);
        db = FirebaseFirestore.getInstance();
    }

    private void getStudentList(Context root) {
        Query query = db.collection("student");

        FirestoreRecyclerOptions<StudentItemData> response = new FirestoreRecyclerOptions.Builder<StudentItemData>()
                .setQuery(query, StudentItemData.class)
                .build();

        student_adapter = new FirestoreRecyclerAdapter<StudentItemData, StudentHolder>(response) {
            @Override
            public void onBindViewHolder(StudentHolder holder, int position, StudentItemData model) {
                progressBar.setVisibility(GONE);
                holder.textName.setText(model.getName());
                holder.textEmail.setText(model.getID());
                holder.textPassword.setText(model.getGpa());


                holder.itemView.setOnClickListener(v -> {
                    Snackbar.make(student_recycler, model.getName() + ", " + model.getID() + " at " + model.getGpa(), Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                });
            }

            @Override
            public StudentHolder onCreateViewHolder(ViewGroup group, int i) {
                View view = LayoutInflater.from(group.getContext())
                        .inflate(R.layout.student_item, group, false);

                return new StudentHolder(view);
            }

            @Override
            public void onError(FirebaseFirestoreException e) {
                Log.e("error", e.getMessage());
            }
        };

        student_adapter.notifyDataSetChanged();
        student_recycler.setAdapter(student_adapter);
    }

    public class StudentHolder extends RecyclerView.ViewHolder {
        TextView textName;


        TextView textEmail;
        TextView textPassword;

        public StudentHolder(View itemView) {
            super(itemView);
            textName = itemView.findViewById(R.id.name);
            textEmail = itemView.findViewById(R.id.id);
            textPassword = itemView.findViewById(R.id.gpa);
        }
    }

    private void getTAList(Context root) {
        Query query = db.collection("ta");

        FirestoreRecyclerOptions<Admin_TAItemData> response = new FirestoreRecyclerOptions.Builder<Admin_TAItemData>()
                .setQuery(query, Admin_TAItemData.class)
                .build();

        ta_adapter = new FirestoreRecyclerAdapter<Admin_TAItemData, TAHolder>(response) {
            @Override
            public void onBindViewHolder(TAHolder holder, int position, Admin_TAItemData model) {
                progressBar.setVisibility(GONE);
                holder.textName.setText(model.getName());
                holder.textEmail.setText(model.getEmail());
                holder.textPassword.setText(model.getPassword());


                holder.itemView.setOnClickListener(v -> {
                    Snackbar.make(ta_recycler, model.getName() + ", " + model.getEmail() + " at " + model.getPassword(), Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                });
            }

            @Override
            public TAHolder onCreateViewHolder(ViewGroup group, int i) {
                View view = LayoutInflater.from(group.getContext())
                        .inflate(R.layout.admin_ta_item, group, false);

                return new TAHolder(view);
            }

            @Override
            public void onError(FirebaseFirestoreException e) {
                Log.e("error", e.getMessage());
            }
        };

        ta_adapter.notifyDataSetChanged();
        ta_recycler.setAdapter(ta_adapter);
    }

    public class TAHolder extends RecyclerView.ViewHolder {
        TextView textName;


        TextView textEmail;
        TextView textPassword;

        public TAHolder(View itemView) {
            super(itemView);
            textName = itemView.findViewById(R.id.name);
            textEmail = itemView.findViewById(R.id.email);
            textPassword = itemView.findViewById(R.id.password);
        }
    }

    private void getAdminList(Context root) {
        Query query = db.collection("Admin");

        FirestoreRecyclerOptions<Admin_TAItemData> response = new FirestoreRecyclerOptions.Builder<Admin_TAItemData>()
                .setQuery(query, Admin_TAItemData.class)
                .build();

        admin_adapter = new FirestoreRecyclerAdapter<Admin_TAItemData, AdminHolder>(response) {
            @Override
            public void onBindViewHolder(AdminHolder holder, int position, Admin_TAItemData model) {

                holder.textName.setText(model.getName());
                holder.textEmail.setText(model.getEmail());
                holder.textPassword.setText(model.getPassword());


                holder.itemView.setOnClickListener(v -> {
                    Snackbar.make(admin_recycler, model.getName() + ", " + model.getEmail() + " at " + model.getPassword(), Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                });
            }

            @Override
            public AdminHolder onCreateViewHolder(ViewGroup group, int i) {
                View view = LayoutInflater.from(group.getContext())
                        .inflate(R.layout.admin_ta_item, group, false);

                return new AdminHolder(view);
            }

            @Override
            public void onError(FirebaseFirestoreException e) {
                Log.e("error", e.getMessage());
            }
        };

        admin_adapter.notifyDataSetChanged();
        admin_recycler.setAdapter(admin_adapter);
    }

    public class AdminHolder extends RecyclerView.ViewHolder {
        TextView textName;


        TextView textEmail;
        TextView textPassword;

        public AdminHolder(View itemView) {
            super(itemView);
            textName = itemView.findViewById(R.id.name);
            textEmail = itemView.findViewById(R.id.email);
            textPassword = itemView.findViewById(R.id.password);
        }
    }

    private void shifts(View root) {
        final ArrayList<ShiftItem> day = new ArrayList<>();
        if(!MainActivity.type) {
            List<Boolean> days = (List<Boolean>) MainActivity.document.get("shift");
            if (days.get(0)) {
                day.add(new ShiftItem("Saturday"));
            }
            if (days.get(1)) {
                day.add(new ShiftItem("Sunday"));
            }
            if (days.get(2)) {
                day.add(new ShiftItem("Monday"));
            }
            if (days.get(3)) {
                day.add(new ShiftItem("Tuesday"));
            }
            if (days.get(4)) {
                day.add(new ShiftItem("Wednesday"));
            }
            if (days.get(5)) {
                day.add(new ShiftItem("Thursday"));
            }
        }

        Context context = root.getContext();


        shift_recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));

        final ShiftAdapter ourTeamRecyclerAdapter = new ShiftAdapter(R.layout.shift_item, day);

        shift_recyclerView.setAdapter(ourTeamRecyclerAdapter);


    }

    @Override
    public void onStart() {
        super.onStart();
        admin_adapter.startListening();
        ta_adapter.startListening();
        student_adapter.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        admin_adapter.stopListening();
        ta_adapter.stopListening();
        student_adapter.stopListening();
    }
}