package com.example.errorhandling.data

import com.example.errorhandling.Util.Resource
import com.example.errorhandling.domain.Repository
import kotlin.random.Random

class RepositoryIml : Repository {


    override fun submitRepository(email: String): Resource<Unit> {
        if(Random.nextBoolean()){
            return Resource.Success(Unit)
        }
        else{

            if (Random.nextBoolean()){
                return Resource.Error(message = "Server Error")
            }
                else{
                return Resource.Error(message = "Unknown Error")
                }
        }
    }
}