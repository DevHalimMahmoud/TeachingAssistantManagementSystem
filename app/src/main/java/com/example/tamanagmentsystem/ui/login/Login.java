package com.example.tamanagmentsystem.ui.login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.CheckBox;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.tamanagmentsystem.MainActivity;
import com.example.tamanagmentsystem.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class Login extends AppCompatActivity {

    private boolean state;
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);
        TextInputEditText email = findViewById(R.id.email);
        TextInputEditText password = findViewById(R.id.gpa);
        CheckBox admin = findViewById(R.id.checkBox);

        Button login = findViewById(R.id.login);
        login.setOnClickListener(v -> {


            if (admin.isChecked()) {
                MainActivity.type=true;
                db.collection("Admin")
                        .get()
                        .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                            @Override
                            public void onComplete(@NonNull Task<QuerySnapshot> task) {

                                if (task.isSuccessful()) {
                                    for (QueryDocumentSnapshot document : task.getResult()) {

                                        if (document.get("email").toString().equals(email.getText().toString()) && document.get("password").toString().equals(password.getText().toString())) {
                                            final Intent intent;
                                            Context context = getApplicationContext();
                                            intent = new Intent(context, MainActivity.class);
                                            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                            context.startActivity(intent);
                                        }
                                    }
                                } else {
                                    Log.d("Bad", "Error getting documents: ", task.getException());
                                }

                            }
                        });

            } else {
                MainActivity.type=false;
                db.collection("ta")
                        .get()
                        .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                            @Override
                            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                if (task.isSuccessful()) {
                                    for (QueryDocumentSnapshot document : task.getResult()) {
                                        if (document.get("email").toString().equals(email.getText().toString()) && document.get("password").toString().equals(password.getText().toString())) {
                                            final Intent intent;
                                            Context context = getApplicationContext();
                                            intent = new Intent(context, MainActivity.class);
                                            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                            context.startActivity(intent);
                                        }
                                    }
                                } else {
                                    Log.d("Bad", "Error getting documents: ", task.getException());
                                }
                            }
                        });


            }


        });
    }

/*
    public boolean checkLogin(TextInputEditText email, TextInputEditText password, CheckBox admin) {


        if (admin.isChecked()) {
            db.collection("Admin")
                    .get()
                    .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<QuerySnapshot> task) {

                            if (task.isSuccessful()) {
                                for (QueryDocumentSnapshot document : task.getResult()) {

                                    if (document.get("email").toString().equals(email.getText().toString()) && document.get("password").toString().equals(password.getText().toString())) {
                                        state = true;
                                        Log.d("b", String.valueOf(state));
                                        state = true;
                                    }
                                }
                            } else {
                                Log.d("Bad", "Error getting documents: ", task.getException());
                            }

                        }
                    });

        } else {
            db.collection("ta")
                    .get()
                    .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<QuerySnapshot> task) {
                            if (task.isSuccessful()) {
                                for (QueryDocumentSnapshot document : task.getResult()) {
                                    if (document.get("email").toString().equals(email.getText().toString()) && document.get("password").toString().equals(password.getText().toString())) {
                                        state = true;
                                        Log.d("b", String.valueOf(state));
                                        state = true;
                                    }
                                }
                            } else {
                                Log.d("Bad", "Error getting documents: ", task.getException());
                            }
                        }
                    });


        }
        Log.d("a", String.valueOf(state));
        return state;
    }
    */

}

