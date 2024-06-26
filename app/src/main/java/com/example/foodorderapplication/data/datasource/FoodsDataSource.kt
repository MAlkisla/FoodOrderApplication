package com.example.foodorderapplication.data.datasource

import com.example.foodorderapplication.data.entity.Foods
import com.example.foodorderapplication.retrofit.FoodsDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class FoodsDataSource(var fdao: FoodsDao) {
    suspend fun foodsLoad() : List<Foods> = withContext(Dispatchers.IO){
        return@withContext fdao.foodsLoad().foodsList
    }

}