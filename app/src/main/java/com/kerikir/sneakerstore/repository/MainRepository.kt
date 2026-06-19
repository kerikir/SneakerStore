package com.kerikir.sneakerstore.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.kerikir.sneakerstore.model.CategoryModel

class MainRepository {

    private val firebaseDatabase = FirebaseDatabase.getInstance()


    fun loadCategories(): LiveData<MutableList<CategoryModel>> {
        val categoriesLiveData = MutableLiveData<MutableList<CategoryModel>>()

        val ref = firebaseDatabase.getReference("Category")
        ref.addValueEventListener(object : ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {
                val list = mutableListOf<CategoryModel>()
                for (childSnapshot in snapshot.children) {
                    val category = childSnapshot.getValue(CategoryModel::class.java)
                    if (category != null) {
                        list.add(category)
                    }
                }
                categoriesLiveData.value = list
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
    }
}