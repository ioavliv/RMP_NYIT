package com.example.rmpnyit

import android.content.Context
import android.database.Cursor
import android.graphics.Color
import android.provider.ContactsContract
import android.view.Gravity
import android.view.View
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.navigation.Navigation.findNavController


fun makeCourseCard(cursor: Cursor, context: Context?, view : View, dataViewModel : DataViewModel?): CardView? {

    //card
    val card = context?.let { CardView(it) }
    val cardlp : RelativeLayout.LayoutParams = RelativeLayout.LayoutParams(
        RelativeLayout.LayoutParams.MATCH_PARENT,
        RelativeLayout.LayoutParams.WRAP_CONTENT
    )
    card?.layoutParams = cardlp
    card?.setCardBackgroundColor(Color.rgb(0, 51, 25))
    card?.setContentPadding(0,10,0,10)
    card?.useCompatPadding = true

    //horizontal layout
    val horilayout = LinearLayout(context)
    val horilp : RelativeLayout.LayoutParams = RelativeLayout.LayoutParams(
        RelativeLayout.LayoutParams.MATCH_PARENT,
        RelativeLayout.LayoutParams.MATCH_PARENT
    )
    horilayout.layoutParams = horilp
    horilayout.orientation = LinearLayout.HORIZONTAL
    horilayout.setBackgroundColor(4)

    //prof text
    val courseidtext = TextView(context)

    courseidtext.layoutParams = RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
        200)
    courseidtext.text = cursor.getString(0) + " : " + cursor.getString(1)
    courseidtext.setTextColor(Color.WHITE)
    courseidtext.textSize = 20f
    courseidtext.gravity = Gravity.CENTER

    horilayout.addView(courseidtext)
    if (card != null) {
        card.addView(horilayout)
    }

    val CourseID : String = cursor.getString(0)

    card?.setOnClickListener { val toast = Toast.makeText(context, "It works at least", Toast.LENGTH_SHORT)
        toast.show()
        dataViewModel?.setCourseID(CourseID);
        findNavController(view).navigate(R.id.action_CourseSearch_to_CourseView)
    }

    return card
}


fun makeProfessorCard(cursor: Cursor, context: Context?, view : View, dataViewModel : DataViewModel?): CardView? {

    //card
    val card = context?.let { CardView(it) }
    val cardlp : RelativeLayout.LayoutParams = RelativeLayout.LayoutParams(
        RelativeLayout.LayoutParams.MATCH_PARENT,
        RelativeLayout.LayoutParams.WRAP_CONTENT
    )
    card?.layoutParams = cardlp
    card?.setCardBackgroundColor(Color.rgb(0, 51, 25))
    card?.setContentPadding(0,10,0,10)
    card?.useCompatPadding = true


    //vertical layout
    val vertlayout = LinearLayout(context)
    val vertlp : RelativeLayout.LayoutParams = RelativeLayout.LayoutParams(
        RelativeLayout.LayoutParams.MATCH_PARENT,
        RelativeLayout.LayoutParams.WRAP_CONTENT
    )
    vertlayout.layoutParams = vertlp
    vertlayout.orientation = LinearLayout.VERTICAL
    //vertlayout.setBackgroundColor(Color.GREEN)

    //prof text
    val proftext = TextView(context)
    val proflp : RelativeLayout.LayoutParams = RelativeLayout.LayoutParams(
        RelativeLayout.LayoutParams.MATCH_PARENT,
        RelativeLayout.LayoutParams.WRAP_CONTENT
    )
    proftext.layoutParams = proflp
    proftext.text = cursor.getString(1) + " " + cursor.getString(0)
    proftext.setTextColor(Color.WHITE)
    proftext.textSize = 30f

    //horizontal layout
    val horilayout = LinearLayout(context)
    val horilp : RelativeLayout.LayoutParams = RelativeLayout.LayoutParams(
        RelativeLayout.LayoutParams.MATCH_PARENT,
        RelativeLayout.LayoutParams.WRAP_CONTENT
    )
    horilayout.layoutParams = horilp
    horilayout.orientation = LinearLayout.VERTICAL
    horilayout.gravity = Gravity.CENTER_VERTICAL

    //rating text
    val ratingtext = TextView(context)
    val ratinglp : RelativeLayout.LayoutParams = RelativeLayout.LayoutParams(
        RelativeLayout.LayoutParams.WRAP_CONTENT,
        RelativeLayout.LayoutParams.WRAP_CONTENT
    )
    ratingtext.layoutParams = ratinglp
    ratingtext.text = "Rating : " + cursor.getString(2)
    ratingtext.setTextColor(Color.WHITE)
    ratingtext.textSize = 20f
    ratingtext.gravity = Gravity.CENTER_VERTICAL

    //difficulty text
    val difftext = TextView(context)
    val difflp : RelativeLayout.LayoutParams = RelativeLayout.LayoutParams(
        RelativeLayout.LayoutParams.WRAP_CONTENT,
        RelativeLayout.LayoutParams.WRAP_CONTENT
    )
    difftext.layoutParams = ratinglp
    difftext.text = "Difficulty : " + cursor.getString(3)
    difftext.setTextColor(Color.WHITE)
    difftext.textSize = 20f
    difftext.gravity = Gravity.CENTER_VERTICAL

    horilayout.addView(ratingtext)
    horilayout.addView(difftext)

    vertlayout.addView(proftext)
    vertlayout.addView(horilayout)

    card?.addView(vertlayout)


    var LastName : String = cursor.getString(0)
    var FirstName : String = cursor.getString(1)
    card?.setOnClickListener { val toast = Toast.makeText(context, "It works at least", Toast.LENGTH_SHORT)
        toast.show()
        dataViewModel?.setLastName(LastName);
        dataViewModel?.setFirstName(FirstName)
        findNavController(view).navigate(R.id.action_ProfessorSearch_to_ProfessorView)
    }

    return card
}


fun makeProfessorCourseCard(cursor: Cursor, context: Context?, view : View, dataViewModel : DataViewModel?): CardView? {

    //card
    val card = context?.let { CardView(it) }
    val cardlp : RelativeLayout.LayoutParams = RelativeLayout.LayoutParams(
        RelativeLayout.LayoutParams.MATCH_PARENT,
        RelativeLayout.LayoutParams.WRAP_CONTENT
    )
    card?.layoutParams = cardlp
    card?.setCardBackgroundColor(Color.rgb(0, 51, 25))
    card?.setContentPadding(0,10,0,10)
    card?.useCompatPadding = true


    //vertical layout
    val vertlayout = LinearLayout(context)
    val vertlp : RelativeLayout.LayoutParams = RelativeLayout.LayoutParams(
        RelativeLayout.LayoutParams.MATCH_PARENT,
        RelativeLayout.LayoutParams.WRAP_CONTENT
    )
    vertlayout.layoutParams = vertlp
    vertlayout.orientation = LinearLayout.VERTICAL
    //vertlayout.setBackgroundColor(Color.GREEN)

    //prof text
    val proftext = TextView(context)
    val proflp : RelativeLayout.LayoutParams = RelativeLayout.LayoutParams(
        RelativeLayout.LayoutParams.MATCH_PARENT,
        RelativeLayout.LayoutParams.WRAP_CONTENT
    )
    proftext.layoutParams = proflp
    proftext.text = cursor.getString(1) + " " + cursor.getString(0)
    proftext.setTextColor(Color.WHITE)
    proftext.textSize = 30f

    //horizontal layout
    val horilayout = LinearLayout(context)
    val horilp : RelativeLayout.LayoutParams = RelativeLayout.LayoutParams(
        RelativeLayout.LayoutParams.MATCH_PARENT,
        RelativeLayout.LayoutParams.WRAP_CONTENT
    )
    horilayout.layoutParams = horilp
    horilayout.orientation = LinearLayout.VERTICAL
    horilayout.gravity = Gravity.CENTER_VERTICAL

    //rating text
    val ratingtext = TextView(context)
    val ratinglp : RelativeLayout.LayoutParams = RelativeLayout.LayoutParams(
        RelativeLayout.LayoutParams.WRAP_CONTENT,
        RelativeLayout.LayoutParams.WRAP_CONTENT
    )
    ratingtext.layoutParams = ratinglp
    ratingtext.text = "Rating : " + cursor.getString(3)
    ratingtext.setTextColor(Color.WHITE)
    ratingtext.textSize = 20f
    ratingtext.gravity = Gravity.CENTER_VERTICAL

    //difficulty text
    val difftext = TextView(context)
    val difflp : RelativeLayout.LayoutParams = RelativeLayout.LayoutParams(
        RelativeLayout.LayoutParams.WRAP_CONTENT,
        RelativeLayout.LayoutParams.WRAP_CONTENT
    )
    difftext.layoutParams = ratinglp
    difftext.text = "Difficulty : " + cursor.getString(4)
    difftext.setTextColor(Color.WHITE)
    difftext.textSize = 20f
    difftext.gravity = Gravity.CENTER_VERTICAL

    horilayout.addView(ratingtext)
    horilayout.addView(difftext)

    vertlayout.addView(proftext)
    vertlayout.addView(horilayout)

    card?.addView(vertlayout)

    var LastName : String = cursor.getString(0)
    var FirstName : String = cursor.getString(1)
    card?.setOnClickListener { val toast = Toast.makeText(context, "It works at least", Toast.LENGTH_SHORT)
        toast.show()
        dataViewModel?.setLastName(LastName);
        dataViewModel?.setFirstName(FirstName)
        findNavController(view).navigate(R.id.action_CourseView_to_ProfessorView)
    }

    return card

}

fun makeReviewCard(cursor: Cursor, context: Context?, view : View, dataViewModel : DataViewModel?): CardView? {

    val card = context?.let { CardView(it) }

    val cardlp : RelativeLayout.LayoutParams = RelativeLayout.LayoutParams(
        RelativeLayout.LayoutParams.MATCH_PARENT,
        RelativeLayout.LayoutParams.WRAP_CONTENT
    )
    card?.layoutParams = cardlp
    card?.setCardBackgroundColor(Color.rgb(0, 51, 25))
    card?.setContentPadding(0,10,0,10)
    card?.useCompatPadding = true



    val vertlayout = LinearLayout(context)
    val vertlp : RelativeLayout.LayoutParams = RelativeLayout.LayoutParams(
        RelativeLayout.LayoutParams.MATCH_PARENT,
        RelativeLayout.LayoutParams.WRAP_CONTENT
    )
    vertlayout.layoutParams = vertlp
    vertlayout.orientation = LinearLayout.VERTICAL


    //prof text
    val proftext = TextView(context)
    val proflp : RelativeLayout.LayoutParams = RelativeLayout.LayoutParams(
        RelativeLayout.LayoutParams.MATCH_PARENT,
        RelativeLayout.LayoutParams.WRAP_CONTENT
    )
    proftext.layoutParams = proflp
    proftext.text = cursor.getString(2) + " " + cursor.getString(1)
    proftext.setTextColor(Color.WHITE)
    proftext.textSize = 30f

    val courseidtext = TextView(context)

    courseidtext.layoutParams = RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
        200)
    courseidtext.text = cursor.getString(3)
    courseidtext.setTextColor(Color.WHITE)
    courseidtext.textSize = 20f
    courseidtext.gravity = Gravity.CENTER

//rating text
    val ratingtext = TextView(context)
    val ratinglp : RelativeLayout.LayoutParams = RelativeLayout.LayoutParams(
        RelativeLayout.LayoutParams.WRAP_CONTENT,
        RelativeLayout.LayoutParams.WRAP_CONTENT
    )
    ratingtext.layoutParams = ratinglp
    ratingtext.text = "Rating : " + cursor.getString(5)
    ratingtext.setTextColor(Color.WHITE)
    ratingtext.textSize = 20f
    ratingtext.gravity = Gravity.CENTER_VERTICAL

    //difficulty text
    val difftext = TextView(context)
    val difflp : RelativeLayout.LayoutParams = RelativeLayout.LayoutParams(
        RelativeLayout.LayoutParams.WRAP_CONTENT,
        RelativeLayout.LayoutParams.WRAP_CONTENT
    )
    difftext.layoutParams = ratinglp
    difftext.text = "Difficulty : " + cursor.getString(6)
    difftext.setTextColor(Color.WHITE)
    difftext.textSize = 20f
    difftext.gravity = Gravity.CENTER_VERTICAL


    val commenttext = TextView(context)
    commenttext.layoutParams = RelativeLayout.LayoutParams(
        RelativeLayout.LayoutParams.WRAP_CONTENT,
        RelativeLayout.LayoutParams.WRAP_CONTENT
    )
    commenttext.text = "Comment: " + cursor.getString(4)
    commenttext.textSize = 25f
    commenttext.setTextColor(Color.WHITE)


    val liketext = TextView(context)
    liketext.layoutParams = RelativeLayout.LayoutParams(
        RelativeLayout.LayoutParams.WRAP_CONTENT,
        RelativeLayout.LayoutParams.WRAP_CONTENT
    )
    liketext.textSize = 20f
    liketext.text= "Likes: " + cursor.getString(7)
    liketext.setTextColor(Color.WHITE)

    val disliketext = TextView(context)
    disliketext.layoutParams = RelativeLayout.LayoutParams(
        RelativeLayout.LayoutParams.WRAP_CONTENT,
        RelativeLayout.LayoutParams.WRAP_CONTENT
    )
    disliketext.textSize = 20f
    disliketext.text= "Likes: " + cursor.getString(7)
    disliketext.setTextColor(Color.WHITE)

    vertlayout.addView(proftext)
    vertlayout.addView(courseidtext)
    vertlayout.addView(ratingtext)
    vertlayout.addView(difftext)
    vertlayout.addView(commenttext)
//    vertlayout.addView(liketext)
//    vertlayout.addView(disliketext)

    card?.addView(vertlayout)

    return card
}

