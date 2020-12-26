package com.example.tamanagmentsystem.ui.categries;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.tamanagmentsystem.R;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    //All methods in this adapter are required for a bare minimum recyclerview adapter
    private int listItemLayout;
    private ArrayList<Student> itemList;

    // Constructor of the class
    public RecyclerAdapter(int layoutId, ArrayList<Student> itemList) {
        listItemLayout = layoutId;
        this.itemList = itemList;
    }

    // get the size of the list
    @Override
    public int getItemCount() {

        return itemList.size();
    }


    // specify the row layout file and click for each row
    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(listItemLayout, parent, false);

        return new RecyclerAdapter.ViewHolder(view);
    }

    // load data in each row element
    @Override
    public void onBindViewHolder(final RecyclerAdapter.ViewHolder holder, final int listPosition) {

        TextView name = holder.name;
        TextView id = holder.id;
        TextView gpa = holder.gpa;
        TextView phone = holder.phone;
        name.setText(itemList.get(listPosition).getName());
        id.setText(itemList.get(listPosition).getId());
        gpa.setText(itemList.get(listPosition).getGpa());
        phone.setText(itemList.get(listPosition).getPhone());
    }

    // Static inner class to initialize the views of rows
    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView  name,id,gpa,phone;

        private final Context context;

        public ViewHolder(View itemView) {
            super(itemView);
            context = itemView.getContext();
            itemView.setOnClickListener(this);
            name = (TextView) itemView.findViewById(R.id.name);
            id = (TextView) itemView.findViewById(R.id.id);
            phone = (TextView) itemView.findViewById(R.id.phone);
            gpa = (TextView) itemView.findViewById(R.id.gpa);
        }

        @Override
        public void onClick(View view) {
            Log.d("onclick", "onClick " + getLayoutPosition());

        }
    }
}
