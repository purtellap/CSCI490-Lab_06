package com.austin.lab_06.data;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.austin.lab_06.entities.Person;

@Database(entities = {Person.class}, version = 1)
    public abstract class LabDatabase extends RoomDatabase {

        public abstract PersonDao personDao();
    }

