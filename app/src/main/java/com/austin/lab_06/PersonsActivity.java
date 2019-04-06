package com.austin.lab_06;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.austin.lab_06.entities.Person;

import java.util.ArrayList;

public class PersonsActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayAdapter<ArrayList<String>> adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_persons);
        listView = findViewById(R.id.personName);

        ArrayList<String> i = (ArrayList<String>) getIntent().getExtras().get("PeopleNames");
        System.out.println(i);
        if(i != null) {
            adapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, i);
            listView.setAdapter(adapter);
        }

    }
}
