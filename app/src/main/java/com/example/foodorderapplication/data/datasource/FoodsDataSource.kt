package com.example.foodorderapplication.data.datasource

import android.util.Log
import com.example.foodorderapplication.data.entity.Foods
import com.example.foodorderapplication.retrofit.FoodsDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class FoodsDataSource(var fdao: FoodsDao) {
    suspend fun foodsLoad() : List<Foods> = withContext(Dispatchers.IO){
        return@withContext fdao.foodsLoad().foodsList
    }

    suspend fun search(searchWord: String) : List<Foods> = withContext(Dispatchers.IO) {
        return@withContext fdao.search(searchWord).foodsList
    }

}