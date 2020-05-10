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

private var dataViewModel: DataViewModel? = null


class CourseSearch: Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataViewModel = ViewModelProviders.of(requireActivity()).get(DataViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.course_search, container, false)

        //button to add course
        val layout : LinearLayout = view.findViewById(R.id.CourseLayout)
        val CourseScroll : ScrollView = view.findViewById(R.id.Scroll)

        val mydb = DatabaseHelper(activity)
        var cursor : Cursor = mydb.allCourseData
        while (cursor.moveToNext()){
            val card : CardView? = makeCourseCard(cursor, context, view, dataViewModel)
            layout.addView(card)
        }

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
/*        cardArray[0].setOnClickListener {
            findNavController().navigate(R.id.action_CourseSearch_to_CourseView)
        }*/

    }


}