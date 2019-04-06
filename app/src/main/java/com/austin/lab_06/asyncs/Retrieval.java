package com.austin.lab_06.asyncs;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import com.austin.lab_06.PersonsActivity;
import com.austin.lab_06.entities.Person;

import java.util.ArrayList;

public class Retrieval extends AsyncTask<Void, Void, ArrayList<Person>> {

    public Retrieval(){

    }

    @Override
    protected ArrayList<Person> doInBackground(Void... voids) {
        ArrayList<String> personNames = new ArrayList<>();
        for(Person p: persons) {
            personNames.add(p.getName());
        }

        Intent i = new Intent(this, PersonsActivity.class);
        i.putExtra("Persons", personNames);
        context.startActivity(i);
    }
}
