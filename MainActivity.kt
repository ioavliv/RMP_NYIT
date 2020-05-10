package com.example.rmpnyit

import android.os.Bundle
import android.provider.ContactsContract
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        //create database
        val myDb = DatabaseHelper (this);

        //add initial courses
        myDb.addCourse("CSCI 120", "Programming I");
        myDb.addCourse("CSCI 130", "Computer Organization");
        myDb.addCourse("CSCI 260", "Data Structures");
        myDb.addCourse("CSCI 330", "Operating Systems");
        myDb.addCourse("CSCI 345", "Computer Networks");

        //add initial professors
        myDb.addProfessor("A", "Mr.");
        myDb.addProfessor("B", "Mr.");
        myDb.addProfessor("C", "Mr.");
        myDb.addProfessor("D", "Mr.");
        myDb.addProfessor("E", "Mr.");

        //add initial reviews
        myDb.addReview("A", "Mr.", "CSCI 120", "Test A", 5F, 5F);
        myDb.addReview("A", "Mr.", "CSCI 120", "Test B", 3F, 2F);
        myDb.addReview("A", "Mr.", "CSCI 130", "Test C", 5F, 5F);
        myDb.addReview("B", "Mr.", "CSCI 120", "Test D", 5F, 5F);
        myDb.addReview("C", "Mr.", "CSCI 260", "Test E", 5F, 5F);

    }

}
