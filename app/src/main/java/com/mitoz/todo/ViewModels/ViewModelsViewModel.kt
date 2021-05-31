package com.mitoz.todo.viewmodels

import android.app.Application
import android.provider.ContactsContract.CommonDataKinds.Note
import androidx.annotation.NonNull
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mitoz.todo.models.ModelsEntity
import com.mitoz.todo.repository.RepositoryTodoRepository


class ViewModelsViewModel  : ViewModel(){

    private lateinit var repository: RepositoryTodoRepository
    private var todosList = ArrayList<ModelsEntity>()

    val taskList: MutableLiveData<ArrayList<ModelsEntity>> by lazy {
        MutableLiveData<ArrayList<ModelsEntity>>()
    }
    public fun ViewModelsViewModel (@NonNull application : Application) {
        super.onCleared()
        repository = RepositoryTodoRepository()
        val data =   repository.getAll()
        data?.forEach {
            if(it.doneornot == "not")
                todosList.add(it)
            //  viewModel.taskList.value.add();
        }
        taskList.value = todosList


    }


    fun insert(modelsentity: ModelsEntity) {
        repository.insertAll(modelsentity)
    }

    fun update(modelsentity: ModelsEntity) {
        repository.update(modelsentity)
    }

    fun delete(modelsentity: ModelsEntity) {
        repository.delete(modelsentity)
    }



    fun getAllTodos(): ArrayList<ModelsEntity> {
        return todosList
    }






    var number = 0
    
        val currentNumber: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }

}