package com.example.rmpnyit

import android.database.Cursor
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation


class AddReview: Fragment() {

    private var LastName : String = ""
    private var FirstName : String = ""
    private var dataViewModel: DataViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataViewModel = ViewModelProviders.of(requireActivity()).get(DataViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //Pass course number from previous fragment and write it into this fragment's title.
        val view = inflater.inflate(R.layout.add_review, container, false)
        val myDb = DatabaseHelper(context)
        val cursor : Cursor = myDb.getCourseIDs()
        val array = ArrayList<String>()
        while(cursor.moveToNext())
            array.add(cursor.getString(0))
        val adapter = context?.let { ArrayAdapter(it, android.R.layout.simple_spinner_item, array) }
        val coursespinner : Spinner = view.findViewById(R.id.courseid)
        coursespinner.adapter = adapter

        dataViewModel?.getLastName()?.observe(requireActivity(),
            Observer<String> { s -> LastName = s })
        dataViewModel?.getFirstName()?.observe(requireActivity(),
            Observer<String> { s -> FirstName = s })

        view.findViewById<TextView>(R.id.professorname).text = FirstName + " " + LastName

        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var CourseID = String()
        var Comment = String()
        var Rating = String()
        var Difficulty = String()
        val myDb = DatabaseHelper(context)

        val submit : Button = view.findViewById(R.id.submit_review)
        submit.setOnClickListener(){
            CourseID = view.findViewById<Spinner>(R.id.courseid).selectedItem.toString()
            Comment = view.findViewById<TextView>(R.id.comment).text.toString()
            Rating = view.findViewById<Spinner>(R.id.rating).selectedItem.toString()
            Difficulty = view.findViewById<Spinner>(R.id.difficulty).selectedItem.toString()

            val cursor : Cursor = myDb.getSingleProfessor(LastName, FirstName)
            if(cursor.count == 0) run {
                val invalidprofessor  = Toast.makeText(context, "Professor is not in database", Toast.LENGTH_SHORT)
                invalidprofessor.show()
            }
            else{
                if(myDb.addReview(LastName,  FirstName, CourseID,  Comment, Rating.toFloat(), Difficulty.toFloat())) {
                    val reviewadded =
                        Toast.makeText(context, "Review successfully added!", Toast.LENGTH_SHORT)
                    reviewadded.show()
                }
                else {
                    val reviewfailed =
                        Toast.makeText(context, "Failed to add review", Toast.LENGTH_SHORT)
                    reviewfailed.show()
                }
                Navigation.findNavController(view).popBackStack()
            }



        }


    }
}