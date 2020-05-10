package com.example.rmpnyit

import android.database.Cursor
import android.os.Bundle
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.ScrollView
import android.widget.TextView
import androidx.annotation.Nullable
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders

private var dataViewModel: DataViewModel? = null

class CourseView: Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataViewModel = ViewModelProviders.of(requireActivity()).get(DataViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.course_view, container, false)
        val text : TextView = view.findViewById(R.id.textview_first)
        val layout : LinearLayout = view.findViewById(R.id.CourseLayout)
        var CourseID : String = ""

        dataViewModel?.getCourseID()?.observe(requireActivity(),
            Observer<String> { s -> CourseID = s })

        val mydb = DatabaseHelper(activity)
        var cursor : Cursor = mydb.getProfessorCourse(CourseID)
        while (cursor.moveToNext()){
            val card : CardView? = makeProfessorCourseCard(cursor, context, view, dataViewModel)
            layout.addView(card)
        }

        return view
    }

}