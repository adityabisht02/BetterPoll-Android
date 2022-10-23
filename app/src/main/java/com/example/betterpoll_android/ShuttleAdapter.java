package com.example.betterpoll_android;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class ShuttleAdapter extends RecyclerView.Adapter<ShuttleAdapter.ViewHolder> {

    private final Context context;
    private final ArrayList<ShuttleModel> shuttleModelArrayList;

    // Constructor
    public ShuttleAdapter(Context context, ArrayList<ShuttleModel> shuttleModelArrayList) {
        this.context = context;
        this.shuttleModelArrayList = shuttleModelArrayList;
    }

    @NonNull
    @Override
    public ShuttleAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // to inflate the layout for each item of recycler view.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ShuttleAdapter.ViewHolder holder, int position) {

        ShuttleModel model = shuttleModelArrayList.get(position);
        holder.ShuttleNameTV.setText(model.getCourse_name());

        holder.ShuttleImage.setImageResource(model.getCourse_image());
    }

    @Override
    public int getItemCount() {
        // this method is used for showing number of card items in recycler view
        return shuttleModelArrayList.size();
    }

    // View holder class for initializing of your views such as TextView and Imageview
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView ShuttleImage;
        private final TextView ShuttleNameTV;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ShuttleImage = itemView.findViewById(R.id.idIVShuttlemage);
            ShuttleNameTV = itemView.findViewById(R.id.idTVShuttleName);

        }
    }
}