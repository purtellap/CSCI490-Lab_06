package com.austin.lab_06;

import android.arch.persistence.room.Room;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.austin.lab_06.data.LabDatabase;

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
                String s = editText.getText().toString();
                Toast toast = makeText(getApplicationContext(),s,Toast.LENGTH_SHORT);
                toast.show();
            }
        });
        getList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = makeText(getApplicationContext(),"WOrking",Toast.LENGTH_SHORT);
                toast.show();
            }
        });

    }
}
