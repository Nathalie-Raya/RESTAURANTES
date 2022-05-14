package com.example.json

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url


interface APIServiceUsuario {
    @GET
    suspend fun  getResponseUsuario(@Url url:String): Response<RespuestaUsuario>
}

