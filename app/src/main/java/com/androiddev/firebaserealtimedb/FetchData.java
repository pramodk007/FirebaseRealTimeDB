package com.androiddev.firebaserealtimedb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.androiddev.firebaserealtimedb.databinding.ActivityFetchDataBinding;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class FetchData extends AppCompatActivity {
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityFetchDataBinding binding = ActivityFetchDataBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.rvShowData.setLayoutManager(new LinearLayoutManager(this));
        FirebaseRecyclerOptions<DataHolder> options =
                new FirebaseRecyclerOptions.Builder<DataHolder>()
                .setQuery(FirebaseDatabase.getInstance().getReference("Students"), DataHolder.class)
                .build();
        adapter = new MyAdapter(options);
        binding.rvShowData.setAdapter(adapter);

    }
    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }
    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }
}