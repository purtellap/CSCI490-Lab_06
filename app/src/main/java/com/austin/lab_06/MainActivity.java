package com.austin.lab_06;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.austin.lab_06.data.LabDatabase;
import com.austin.lab_06.entities.Person;

import java.util.ArrayList;

import static android.widget.Toast.makeText;

public class MainActivity extends AppCompatActivity {

    private Button submit;
    private Button getList;
    private EditText editText;

    private LabDatabase labDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        submit = findViewById(R.id.button);
        getList = findViewById(R.id.button2);

        labDB = Room.databaseBuilder(this, LabDatabase.class, "Lab6DB")
                .build();

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String name = editText.getText().toString();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Person person = new Person();
                        person.setName(name);
                        labDB.personDao().insertPerson(person);
                    }
                }).start();
            }
        });
        getList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Retrieval retrieval = new Retrieval(getApplicationContext(), labDB);
                retrieval.execute();
            }
        });

    }

    public static class Retrieval extends AsyncTask<Void, Void, ArrayList<Person>> {

        private LabDatabase labDatabase;
        Context context;

        Retrieval(Context c, LabDatabase labDB){
            this.labDatabase = labDB;
            this.context = c;
        }

        @Override
        protected ArrayList<Person> doInBackground(Void... voids) {

            ArrayList<Person> people = (ArrayList<Person>) labDatabase.personDao().getAllPersons();
            ArrayList<String> names = new ArrayList<>();
            for (Person p : people){
                names.add(p.getName());
            }
            Intent i = new Intent(context, PersonsActivity.class);
            i.putExtra("PeopleNames", names);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            try {
                context.startActivity(i);
            }
            catch (Exception e){
                e.printStackTrace();
            }
            return people;

        }

        @Override
        protected void onPostExecute(ArrayList<Person> people) {
            super.onPostExecute(people);

        }
    }

}
