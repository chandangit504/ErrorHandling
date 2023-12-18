package com.example.errorhandling.domain

import com.example.errorhandling.Util.Resource
import com.example.errorhandling.data.RepositoryIml

class Usecase(
    private val repository : Repository = RepositoryIml()
) {

    fun execute(email: String?): Resource<Unit>{

            if (!email?.contains("@")!!){
               return  Resource.Error(message = "This is not a valid Email")
                }
           return  repository.submitRepository(email)
    }
}