package com.example.myapplication;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.security.cert.PolicyNode;
import java.util.ArrayList;
import java.util.List;

public class ReadActivity extends AppCompatActivity {


    private ListView listView;
    private ArrayAdapter<String> adapter;
    private List<String> listData;
    private DatabaseReference mDataBase;
    private String USER_KEY = "users";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
        setContentView(R.layout.activity_personal_area);
    }

    private void init() {

        listView = findViewById(R.id.ListView);
        listData = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listData);
        listView.setAdapter(adapter);
        mDataBase = FirebaseDatabase.getInstance().getReference(USER_KEY);

    }

    private void getDataFromDB(){
        ValueEventListener vListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {


                if (listData.size() > 0)listData.clear();

                for (DataSnapshot ds : dataSnapshot.getChildren()){
                    user user =ds.getValue(user.class);
                    assert user != null;
                    listData.add(user.name);
                }

                adapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        };

        mDataBase.addChildEventListener((ChildEventListener) vListener);

    }

}
