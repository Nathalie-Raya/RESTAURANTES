package com.example.json

import com.google.gson.annotations.SerializedName

data class Resultado(
    @SerializedName("nombre") var nombre: String,
    @SerializedName("calificacion") var calificacion: String,
    @SerializedName("anio") var anio: String,
    @SerializedName("direccion") var direccion: String,
    @SerializedName("imagen") var imagen: String,
    @SerializedName("resenia") var resenia: String,
    @SerializedName("imagenes_variadas") var img_variadas: ArrayList<ListadoFotos>,
    @SerializedName("costo") var costo: String
)


data class ListadoFotos(
    @SerializedName("img") var img: String
)

