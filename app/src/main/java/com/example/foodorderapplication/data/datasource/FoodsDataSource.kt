package com.example.foodorderapplication.data.datasource

import android.util.Log
import com.example.foodorderapplication.data.entity.Foods
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class FoodsDataSource {
    suspend fun foodsLoad() : List<Foods> = withContext(Dispatchers.IO){
        val list = ArrayList<Foods>()
        val f1 = Foods(1,"Küçük Ayran","ayran",111)
        val f2 = Foods(2,"büyük Ayran","ayran",222)
        list.add(f1)
        list.add(f2)
        return@withContext list
    }

    suspend fun search(searchWord: String) : List<Foods> = withContext(Dispatchers.IO) {
        val list = ArrayList<Foods>()
        val f1 = Foods(1, "Küçük Ayran", "ayran", 111)
        list.add(f1)
        return@withContext list
    }

}