package com.example.errorhandling.domain

import com.example.errorhandling.Util.Resource

interface Repository {
    fun submitRepository(email: String): Resource<Unit>
}