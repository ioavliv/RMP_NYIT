package com.example.rmpnyit

import android.database.Cursor
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.professor_view.*

class ProfessorView: Fragment() {

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
        val view = inflater.inflate(R.layout.professor_view, container, false)
        val text : TextView = view.findViewById(R.id.textview_first)
        val layout : LinearLayout = view.findViewById(R.id.ProfessorLayout)
        var LastName : String = ""
        var FirstName : String = ""

        dataViewModel?.getLastName()?.observe(requireActivity(),
            Observer<String> { s -> LastName = s })
        dataViewModel?.getFirstName()?.observe(requireActivity(),
            Observer<String> { s -> FirstName = s })

        val mydb = DatabaseHelper(activity)
        var cursor : Cursor = mydb.getReviewData(LastName, FirstName)
        while (cursor.moveToNext()){
            val card : CardView? = makeReviewCard(cursor, context, view, dataViewModel)
            layout.addView(card)
        }

        text.text = FirstName + " " + LastName

        cursor = mydb.getSingleProfessor(LastName, FirstName)
        cursor.moveToNext()
        view.findViewById<TextView>(R.id.textView2).text = "Overall Rating: " + cursor.getString(2) +
                                                            " || Overall Difficulty: " + cursor.getString(3)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val addreviewbutton : FloatingActionButton = view.findViewById(R.id.addReviewBtn)
        addreviewbutton.setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.action_ProfessorView_to_AddReview)
        }



    }


}