package com.example.rmpnyit

import android.database.Cursor
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.RelativeLayout
import androidx.cardview.widget.CardView
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController

class ProfessorSearch : Fragment() {

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
        val view = inflater.inflate(R.layout.professor_search, container, false);
        val layout : LinearLayout = view.findViewById(R.id.ProfessorLayout)

        val mydb = DatabaseHelper(activity);
        var cursor : Cursor = mydb.allProfessorData

        while (cursor.moveToNext()){
            val card : CardView? = makeProfessorCard(cursor, context, view, dataViewModel)
            layout.addView(card)
        }

        return view;
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}
