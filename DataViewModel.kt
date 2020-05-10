package com.example.rmpnyit

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class DataViewModel : ViewModel() {
    private val LastName = MutableLiveData<String>()
    private val FirstName = MutableLiveData<String>()
    private val CourseID = MutableLiveData<String>()

    fun getLastName() : MutableLiveData<String>{
        return LastName
    }

    fun setLastName(LastName : String){
        this.LastName.value = LastName
    }

    fun getFirstName() : MutableLiveData<String>{
        return FirstName
    }

    fun setFirstName(FirstName : String){
        this.FirstName.value = FirstName
    }
    fun getCourseID() : MutableLiveData<String>{
        return CourseID
    }

    fun setCourseID(CourseID : String){
        this.CourseID.value = CourseID
    }

}