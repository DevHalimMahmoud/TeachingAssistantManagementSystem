package com.example.tamanagmentsystem.ui.about;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;


import com.example.tamanagmentsystem.R;

import java.util.ArrayList;

public class OurTeamRecyclerAdapter extends RecyclerView.Adapter<OurTeamRecyclerAdapter.ViewHolder> {

    //All methods in this adapter are required for a bare minimum recyclerview adapter
    private int listItemLayout;
    private ArrayList<OurTeam> itemList;

    // Constructor of the class
    public OurTeamRecyclerAdapter(int layoutId, ArrayList<OurTeam> itemList) {
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
    public OurTeamRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(listItemLayout, parent, false);

        return new OurTeamRecyclerAdapter.ViewHolder(view);
    }

    // load data in each row element
    @Override
    public void onBindViewHolder(final OurTeamRecyclerAdapter.ViewHolder holder, final int listPosition) {
        ImageView linkedin_image = holder.linkedin_image;
        ImageView team_image = holder.team_image;
        TextView name = holder.name;

        TextView title = holder.title;
        TextView text = holder.text;
        linkedin_image.setImageResource(itemList.get(listPosition).getLinkedin_image());

        team_image.setImageResource(itemList.get(listPosition).getTeam_image());
        title.setText(itemList.get(listPosition).getTitle());
        text.setText(itemList.get(listPosition).getText());
        name.setText(itemList.get(listPosition).getName());
    }

    // Static inner class to initialize the views of rows
    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView text, title, name;

        public ImageView team_image, linkedin_image;
        private final Context context;

        public ViewHolder(View itemView) {
            super(itemView);
            context = itemView.getContext();
            itemView.setOnClickListener(this);
            name = (TextView) itemView.findViewById(R.id.team_name);
            text = (TextView) itemView.findViewById(R.id.team_text);
            title = (TextView) itemView.findViewById(R.id.team_title);
            team_image = (ImageView) itemView.findViewById(R.id.team_image);
            linkedin_image = itemView.findViewById(R.id.team_linkedin_image);
        }

        @Override
        public void onClick(View view) {
            Log.d("onclick", "onClick " + getLayoutPosition() + " " + title.getText());
            context.startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse(itemList.get(getLayoutPosition()).getUrl())));
        }
    }
}
