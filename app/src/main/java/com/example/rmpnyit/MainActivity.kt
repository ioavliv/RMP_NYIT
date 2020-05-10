package com.example.rmpnyit

import android.os.Bundle
import android.provider.ContactsContract
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        //create database
        val myDb = DatabaseHelper (this);

        //add initial courses
        myDb.destroy()
        getInitialData(myDb)
    }

    override fun onResume() {
        super.onResume()
        val myDb = DatabaseHelper (this);
        myDb.destroy()
        getInitialData(myDb)
    }

    override fun onDestroy() {
        super.onDestroy()
        val myDb = DatabaseHelper (this);
        myDb.destroy()
        getInitialData(myDb)
    }

    private fun getInitialData(myDb : DatabaseHelper){
        myDb.addCourse("CSCI 125", "Programming I");
        myDb.addCourse("CSCI 130", "Computer Organization");
        myDb.addCourse("CSCI 185", "Programming II");
        myDb.addCourse("CSCI 260", "Data Structures");
        myDb.addCourse("CSCI 318", "Programming Language Concepts");
        myDb.addCourse("CSCI 330", "Operating Systems");
        myDb.addCourse("CSCI 335", "Design and Analysis of Algorithms");
        myDb.addCourse("CSCI 345", "Computer Networks");

        //add initial professors
        myDb.addProfessor("Li", "Wenjia");
        myDb.addProfessor("Ben-Avi", "Simon");
        myDb.addProfessor("Gass", "Susan");
        myDb.addProfessor("Billis", "Steven");
        myDb.addProfessor("Taylor", "Herbert");
        myDb.addProfessor("Kadri", "Michael");
        myDb.addProfessor("Meyers", "Richard");
        myDb.addProfessor("Gennady", "Lomako");

        //add initial reviews
        myDb.addReview("Li", "Wenjia", "CSCI 125", "Really cares about his students. Makes an effort to learn your name and know more about you. Really does his best to make class fun and interesting. He doesn't do a great job at that, but his efforts are endearing. Very helpful as well", 5F, 2F);
        myDb.addReview("Li", "Wenjia", "CSCI 125", "So far I really enjoyed Dr. Li's CSCI 125 class. He made a good blend of lecture and lab in each class, which makes it very easy to grab hands-on experience on Java programming concepts. Very friendly professor, and you can tell that he truly wants you to be successful in this subject. Strongly recommend him!", 5F, 3F);
        myDb.addReview("Li", "Wenjia", "CSCI 185", "Dr. Li is honestly an amazing professor! He goes into detail during his lectures which he posts on Blackboard and he always asks if there's any questions in the class no matter how small the question. His labs are fairly fun to do and if you're ever confused, you can always ask him or one of his GA's for one-on-one help. I highly recommend him!", 5F, 2F);
        myDb.addReview("Li", "Wenjia", "CSCI 185", "A really good professor who wants you to learn Java prog rather than just passing you. He uses PollEverywhere a lot in class to collect student feedback and interactive opinions. Also there were several group prog hws that made us work in a team. Overall I would highly recommend him for Java prog classes. You won't be disappointed.", 5F, 3F);
        myDb.addReview("Li", "Wenjia", "CSCI 260", "Great for Data Structures, he knows what he's doing and is very kind in terms of grading. Just show some effort and study the slides, test are not that hard because he gives a good review the class before.", 5F, 2F)
        myDb.addReview("Li", "Wenjia", "CSCI 318", "Dr. Li did an amazing job of making this pretty theoretic course to be as much fun as possible. He gave real world examples to show you how the program language concepts work in practice, and the group project was really fun and I love the presentations. Overall you wont go wrong to take him. Will try to take his other course(s) again!", 5F, 4F);
        myDb.addReview("Kadri", "Michael", "CSCI 125", "All i can say is you need to be a professional programmer to take this class and have 19 years of experience. If you don't have that many years of experience, please don't take this class and don't be comp sci major, it's not worth it!",1F,5F)
        myDb.addReview("Kadri", "Michael", "CSCI 125", "You will learn programming very will, but your GPA will be destroyed. Do not miss a class, because he goes through a whole chapter in one class. Really makes you work for your grade.",4F,4F)
        myDb.addReview("Kadri", "Michael", "CSCI 260", "I hate this guy so much because he failed me for the final only because my computer crashed. He doesn't understand anything or any of his students needs. Don't take him because he does not give good advice to you and takes off points on little to little mistakes.",1F,5F)
        myDb.addReview("Kadri", "Michael", "CSCI 260", "He gives a lot of work but you learn from them. Everything on the midterm and the final are from his assigned homeworks. Make sure you do your best to pay attention in class because he is very soft spoken and you might get bored and not be able to understand the topics. Also, never cheat in his class!!",5F,4F)
        myDb.addReview("Ben-Avi", "Simon", "CSCI 155", "Dr. Simon is a great professor. He is super intelligent. I loved his lectures. His grading is very clear. If you will do his assignments/projects on time, you will get a good grades. I would definitely recommend him.", 5F, 4F);
        myDb.addReview("Ben-Avi", "Simon", "CSCI 155", "Professor Ben-Avi is a brilliant teacher and professor, and his lectures are interesting and straightforward. However, his grading criteria is unclear and his tests nearly impossible and have nothing to do with what was taught. Would still take again just for the amazing lectures.", 3F, 5F);
        myDb.addReview("Ben-Avi", "Simon", "CSCI 155", "Well, he is an okay professor. His exams can be difficult. Many people cheat of course but some get caught. Up to you if you want to get expelled from the school or not. He is very strict when it comes to that.", 3F, 4F);
        myDb.addReview("Ben-Avi", "Simon", "CSCI 155", "Make sure you go to every class, then you will get a very good grade.", 5F, 1F);
        myDb.addReview("Billis", "Steven", "CSCI 130", "The best professor at NYIT that I've ever had for EENG and Computer Science(besides Akhtar). He's extremely clear, goes at a good pace, takes sanity breaks, and breaks down the material so that everyone paying attention can understand. I would highly recommend attending every class since his tests do involve knowledge of the subject though!", 5F, 2F);
        myDb.addReview("Gass", "Susan", "CSCI 330", "She is a wonderful teacher who truly cares about her students. You need to pay attention in class, which is mostly a powerpoint but her commentary is important. Don't expect to download the powerpoint and get an A. She loves students who participate, and make sure you get off on the right foot. She teaches most of the high level csci classes.", 5F, 3F);
        myDb.addReview("Taylor", "Herbert", "CSCI 270", "Attending lecture and copying down the solutions to the sample exercises is KEY to getting an A. The mid-term and final are both take-home and are exact replicas of the exercises done in lecture. Professor Taylor's approach involves a lot of student participation.", 5F, 2F);
        myDb.addReview("Meyers", "Richard", "CSCI 125", "Yes like many ppl already said. He does have a nice personality. But when it comes to the MAIN purpose why ur in college...HE SUCKS AT TEACHING..Guarantee urself a to FAIL if u do not know JAVA when u enter the class.. Im a freshman and im totally clueless i try to listen but he teaches us like were experts already..stay away ima transfer maybe", 1F, 5F);
        myDb.addReview("Meyers", "Richard", "CSCI 125", "He is a great teacher when you understand the material.", 4F, 3F);
        myDb.addReview("Gennady", "Lomako", "CSCI 125", "This class was simply a terrible experience. He always expected a specific answer to unclear questions, and no one ever knew or had the answer he was looking for. The one good thing about that class was that it made me realize that Computer Science was not my desired major.", 2F, 3F);
        myDb.addReview("Gennady", "Lomako", "CSCI 125", "Very nice professor, tries hard to help but isnt really clear. Sometimes hard to understand. Usually wanders off the subject trying to explain something with irrelevant ex's . I got a B and I had a hard time understanding everything. Do the projects and you should be fine. Russian students will have an easier time with him if you know the language.", 3F, 2F);

    }

}
