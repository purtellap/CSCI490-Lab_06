package com.austin.lab_06.asyncs;

import android.os.AsyncTask;

import com.austin.lab_06.entities.Person;

import java.util.ArrayList;

public class Async1 extends AsyncTask<Void, Void, ArrayList<Person>> {

    public Async1(){

    }

    @Override
    protected ArrayList<Person> doInBackground(Void... voids) {
        database.personDao().insertPerson(person);
        return null;
    }
}
