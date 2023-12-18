package com.example.errorhandling.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.errorhandling.Util.Resource
import com.example.errorhandling.domain.Usecase
import kotlinx.coroutines.launch

class viewModel (
    private val usecase: Usecase = Usecase()
) : ViewModel(){

    var email by mutableStateOf("")
        private set
    var error by mutableStateOf<String?>(null)

    fun onEmailChanged(email: String){
         this.email= email
    }
    fun submitEmail(){
       viewModelScope.launch {
       val result = usecase.execute(email)
           when(result){
               is Resource.Error -> {
                   error = result.message
               }
               is Resource.Success -> {}
           }

       }
    }
}