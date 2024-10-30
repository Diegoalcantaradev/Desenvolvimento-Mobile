package com.senai.sharedpreferences.entities.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.senai.sharedpreferences.entities.Student;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {

    private final String NAME_DATABASE="db_senai.db";
    private final int VERSION_DATABASE=1;
    public DatabaseHelper(Context context){
        super(context,"db_senai.db",null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql="CREATE TABLE studant("+
                "id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "nome VARCHAR(45) NOT NULL,"+
                "email VARCHAR(45) NOT NULL,"+
                "password VARCHAR(45) NOT NULL);";

        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
    String sql = "DROP TABLE IF EXISTS student;";
    sqLiteDatabase.execSQL(sql);
    onCreate(sqLiteDatabase);
    }
}
