package com.example.json

import com.google.gson.annotations.SerializedName

data class Respuesta(
    @SerializedName("restaurantes") var restaurantes : ArrayList<Resultado> = arrayListOf()
    )


