package com.example.json

import com.google.gson.annotations.SerializedName

data class ResultadoUsuario(
    @SerializedName("nombre") var nombre: String,
    @SerializedName("contrasenia") var contrasenia: String
)


