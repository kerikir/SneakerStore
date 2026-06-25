package com.kerikir.sneakerstore.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.kerikir.sneakerstore.model.CategoryModel
import com.kerikir.sneakerstore.repository.MainRepository

class MainViewModel : ViewModel() {

    private val repository = MainRepository()

    val category: LiveData<MutableList<CategoryModel>> = repository.loadCategories()
}