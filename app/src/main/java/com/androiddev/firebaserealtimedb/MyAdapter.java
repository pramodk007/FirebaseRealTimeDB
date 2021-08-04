package com.androiddev.firebaserealtimedb;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import org.jetbrains.annotations.NotNull;

public class MyAdapter extends FirebaseRecyclerAdapter<DataHolder, MyAdapter.MyViewHolder> {

    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public MyAdapter(@NonNull @NotNull FirebaseRecyclerOptions<DataHolder> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull @NotNull MyViewHolder holder, int position, @NonNull @NotNull DataHolder model) {
        holder.name.setText("Name: "+model.getName());
        holder.course.setText("Course: "+model.getCourse());
        holder.duration.setText("duration: "+model.getDuration());
    }

    @NonNull
    @NotNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.sinle_row,parent,false);
        return new MyViewHolder(view);
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name,course,duration;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.textView_name);
            course = itemView.findViewById(R.id.textView_course);
            duration = itemView.findViewById(R.id.textView_duration);
        }
    }
}
