package com.example.betterpoll_android;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.net.ContentHandler;
import java.util.ArrayList;

public class InteractSectionAdapter extends RecyclerView.Adapter<InteractSectionAdapter.ViewHolder> {
    private final Context context;
    private ArrayList<InteractCardItem> interactList;
    // Constructor
    public InteractSectionAdapter(Context context, ArrayList<InteractCardItem> interactList) {
        this.interactList = interactList;
        this.context=context;
    }

    // View holder class for initializing of your views such as TextView and Imageview
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private  TextView name;
        private  TextView date;
        private  TextView postContent;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            date = itemView.findViewById(R.id.postDate);
            postContent=itemView.findViewById(R.id.postContent);
        }
    }

    @NonNull
    @Override
    public InteractSectionAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.interact_card_layout,parent,false);
        ViewHolder vh=new ViewHolder(v);
        return vh;

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
    InteractCardItem currentItem=interactList.get(position);
    holder.name.setText(currentItem.getName());
    holder.date.setText(currentItem.getDate());
        holder.postContent.setText(currentItem.getPostContent());

    }

    @Override
    public int getItemCount() {
        return interactList.size();
    }
}
