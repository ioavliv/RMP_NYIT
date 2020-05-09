package com.example.rmpnyit

import android.content.Context
import android.database.Cursor
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.navigation.fragment.findNavController
import com.example.rmpnyit.DatabaseHelper

class ProfessorSearch : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val mydb = DatabaseHelper(activity);
        val allProfessors = mydb.getAllProfessorData();

        return inflater.inflate(R.layout.professor_search, container, false);
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<CardView>(R.id.prof1).setOnClickListener {
            findNavController().navigate(R.id.action_ProfessorSearch_to_ProfessorView)
        }
    }
}
