package com.example.rmpnyit

import android.database.Cursor
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.ScrollView
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders


class CourseSearch: Fragment() {

    private val viewModel = DataViewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.course_search, container, false)

        //button to add course
        val layout : LinearLayout = view.findViewById(R.id.CourseLayout)
        val CourseScroll : ScrollView = view.findViewById(R.id.CourseScroll)

        val mydb = DatabaseHelper(activity)
        var cursor : Cursor = mydb.allCourseData
        while (cursor.moveToNext()){
            layout.addView(makeCourseCard(cursor, activity))
        }

        val viewModel = ViewModelProviders.of(requireActivity()).get(DataViewModel::class.java)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        view.findViewById<CardView>(R.id.course1).setOnClickListener {
            findNavController().navigate(R.id.action_CourseSearch_to_CourseView)
        }


    }
}