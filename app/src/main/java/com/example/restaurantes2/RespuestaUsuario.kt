package com.example.json

import com.google.gson.annotations.SerializedName

data class RespuestaUsuario(
    @SerializedName("usuarios") var usuarios : ArrayList<ResultadoUsuario> = arrayListOf()
)


