package com.example.foodorderapplication.retrofit

import com.example.foodorderapplication.data.entity.CRUDResponse
import com.example.foodorderapplication.data.entity.CartFoodsResponse
import com.example.foodorderapplication.data.entity.FoodsResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface FoodsDao {
    //http://kasimadalan.pe.hu/yemekler/tumYemekleriGetir.php
    //http://kasimadalan.pe.hu/ --> base url
    //yemekler/tumYemekleriGetir.php --> api url
    @GET("yemekler/tumYemekleriGetir.php")
    suspend fun foodsLoad(): FoodsResponse

    @POST("yemekler/tumYemekleriGetir.php")
    @FormUrlEncoded
    suspend fun search(@Field("yemek_adi") aramaKelimesi: String): FoodsResponse
    @POST("yemekler/sepettenYemekSil.php")
    @FormUrlEncoded
    suspend fun remove(@Field("sepet_yemek_id") cart_food_id: Int,
                       @Field("kullanici_adi") nickname: String): CRUDResponse

    @POST("yemekler/sepeteYemekEkle.php")
    @FormUrlEncoded
    suspend fun addCart(@Field("yemek_adi") food_name: String,
                        @Field("yemek_resim_adi") food_image_name: String,
                        @Field("yemek_fiyat") food_price: Int,
                        @Field("yemek_siparis_adet") food_order_amount: Int,
                        @Field("kullanici_adi") nickname: String): CRUDResponse
    @POST("yemekler/sepettekiYemekleriGetir.php")
    @FormUrlEncoded
    suspend fun cartFoodsLoad(@Field("kullanici_adi") nickname: String): CartFoodsResponse
}