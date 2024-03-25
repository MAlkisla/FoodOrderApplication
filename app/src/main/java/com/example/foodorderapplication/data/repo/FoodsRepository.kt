package com.example.foodorderapplication.data.repo

import com.example.foodorderapplication.data.datasource.FoodsDataSource


class FoodsRepository(var fds: FoodsDataSource) {
    suspend fun foodsLoad() = fds.foodsLoad()

    suspend fun search(searchWord: String) = fds.search(searchWord)
}