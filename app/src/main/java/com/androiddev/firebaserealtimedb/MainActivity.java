package com.androiddev.firebaserealtimedb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.androiddev.firebaserealtimedb.databinding.ActivityMainBinding;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataHolder dataHolder = new DataHolder(binding.editTextName.getText().toString(),
                                binding.editTextCourse.getText().toString(),
                                binding.editTextDuration.getText().toString());

                FirebaseDatabase db = FirebaseDatabase.getInstance();
                DatabaseReference root = db.getReference("Students");
                root.child(binding.editTextRoll.getText().toString()).setValue(dataHolder);
                startActivity(new Intent(MainActivity.this,FetchData.class));
            }
        });

    }
}