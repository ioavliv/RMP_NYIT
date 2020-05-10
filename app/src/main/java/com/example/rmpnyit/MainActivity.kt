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
        myDb.destroy()
        getInitialData(myDb)
    }

    override fun onResume() {
        super.onResume()
        val myDb = DatabaseHelper (this);
        myDb.destroy()
        getInitialData(myDb)
    }

    override fun onDestroy() {
        super.onDestroy()
        val myDb = DatabaseHelper (this);
        myDb.destroy()
        getInitialData(myDb)
    }

    private fun getInitialData(myDb : DatabaseHelper){
        myDb.addCourse("CSCI 120", "Programming I");
        myDb.addCourse("CSCI 130", "Computer Organization");
        myDb.addCourse("CSCI 260", "Data Structures");
        myDb.addCourse("CSCI 330", "Operating Systems");
        myDb.addCourse("CSCI 345", "Computer Networks");

        //add initial professors
        myDb.addProfessor("Jaramillo", "Remi");
        myDb.addProfessor("Valencia", "Faisal");
        myDb.addProfessor("Senior", "Jon-Paul");
        myDb.addProfessor("Mahoney", "Caprice");
        myDb.addProfessor("Emery", "Tolga");

        //add initial reviews
        myDb.addReview("Jaramillo", "Remi", "CSCI 120", "He is the best so far, highly recommend him.", 5F, 1F);
        myDb.addReview("Jaramillo", "Remi", "CSCI 120", "Took his online class. Expect weekly assignment.", 3F, 4F);
        myDb.addReview("Jaramillo", "Remi", "CSCI 130", "Great teacher, makes class fun.", 5F, 2F);
        myDb.addReview("Valencia", "Faisal", "CSCI 120", "very easy to get an A...makes class fun...", 5F, 1F);
        myDb.addReview("Senior", "Jon-Paul", "CSCI 120", "Honestly one of the best professors ever. She is super inspiring and I recommend everyone to take her class.", 5F, 2F);

    }

}
