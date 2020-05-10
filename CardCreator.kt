package com.example.rmpnyit

import android.content.Context
import android.database.Cursor
import android.graphics.Color
import android.view.Gravity
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.fragment.app.FragmentActivity


fun makeCourseCard(cursor: Cursor, context: Context?): CardView? {

    //cursor.moveToNext()

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

    card?.setOnClickListener()
    return card
}


fun makeProfessorCard(cursor: Cursor,  context: Context): CardView {

    //cursor.moveToNext()

    //card
    val card = CardView(context)
    val cardlp : RelativeLayout.LayoutParams = RelativeLayout.LayoutParams(
        RelativeLayout.LayoutParams.MATCH_PARENT,
        RelativeLayout.LayoutParams.WRAP_CONTENT
    )
    card.layoutParams = cardlp
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

    card.addView(vertlayout)
    return card

}
/*

fun makeProfessorCourseCard(cursor: Cursor, layout : LinearLayout, context : Context): CardView{


}

fun makeReviewCard(cursor: Cursor, layout : LinearLayout, context : Context): CardView{


}
*/
