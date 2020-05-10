package com.example.rmpnyit

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class SearchBy : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.search_by, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.profBtn).setOnClickListener {
            findNavController().navigate(R.id.action_SearchBy_to_ProfessorSearch)
        }
        view.findViewById<Button>(R.id.courseBtn).setOnClickListener {
            findNavController().navigate(R.id.action_SearchBy_to_CourseSearch)
        }
    }
}
