package com.senai.sharedpreferences.entities.database;

import com.senai.sharedpreferences.entities.Student;

import java.util.ArrayList;

public class DatabaseHelper {
    private ArrayList<Object> senaiDatabase;

    public DatabaseHelper(ArrayList<Object>database){
        senaiDatabase = database;
    }

    public Object findAllObject(){
        return this.senaiDatabase;
    }
    public void saveObject(Object object){
        this.senaiDatabase.add(object);
    }
    public Object findObjectById(Object obj){
        for(Object object: senaiDatabase){
            Student student = (Student) object;
        if(student.equals(obj)){
            return student;
        }
        }
        return null;
    }

}
