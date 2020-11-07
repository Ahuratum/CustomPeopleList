package com.example.custompeoplelist;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    Button addPerson;
    Menu menu;

    MyApplication myApp = (MyApplication) this.getApplication();

    List<Human> humanList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addPerson = findViewById(R.id.btn_addPerson);

        humanList = myApp.getHumanList();

        addPerson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, EditPerson.class);
                startActivity(intent);

            }
        });

        recyclerView = findViewById(R.id.humanList);

        // Sets the view to a fixed size
        recyclerView.setHasFixedSize(true);

        //
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // Specify adapter
        mAdapter = new RecycleViewAdapter(humanList, MainActivity.this);
        recyclerView.setAdapter(mAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.sort_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.menu_aToz:

                // Sort items in list A to Z
                Collections.sort(humanList, Human.humanNameAZCompare);
                mAdapter.notifyDataSetChanged();

                Toast.makeText(MainActivity.this, "Sorted A->Z", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.menu_zToa:

                // Sort items in the list Z to A
                Collections.sort(humanList, Human.humanNameZACompare);
                mAdapter.notifyDataSetChanged();

                Toast.makeText(MainActivity.this, "Sorted Z->A", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.menu_aAge:

                // Sort items in the list by ascending age
                Collections.sort(humanList, Human.humanAgeAscendingCompare);
                mAdapter.notifyDataSetChanged();

                Toast.makeText(MainActivity.this, "Sorted Ascending", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.menu_dAge:

                // Sort items in the list by descending age
                Collections.sort(humanList, Human.humanAgeDescendingCompare);
                mAdapter.notifyDataSetChanged();

                Toast.makeText(MainActivity.this, "Sorted Descending", Toast.LENGTH_SHORT).show();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}