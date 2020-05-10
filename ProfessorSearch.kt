package com.example.rmpnyit

import android.database.Cursor
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.cardview.widget.CardView

class ProfessorSearch : Fragment() {

    private lateinit var viewModel: DataViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.professor_search, container, false);
        val mydb = DatabaseHelper(activity);
        val layout :LinearLayout = view.findViewById(R.id.ProfessorLayout)
        var cursor : Cursor = mydb.allProfessorData

        while (cursor.moveToNext()){
            layout.addView(activity?.let { makeProfessorCard(cursor, it) })
        }
        return view;
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<CardView>(R.id.prof1).setOnClickListener {
            findNavController().navigate(R.id.action_ProfessorSearch_to_ProfessorView)
        }
    }
}
