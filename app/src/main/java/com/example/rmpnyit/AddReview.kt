package com.example.rmpnyit

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Spinner
import androidx.fragment.app.Fragment


class AddReview: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //Pass course number from previous fragment and write it into this fragment's title.
        return inflater.inflate(R.layout.add_review, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //addReview(String LastName, String FirstName, String CourseID, String Comment, float Rating, float Difficulty)
    }
}