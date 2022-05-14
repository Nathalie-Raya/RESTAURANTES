package com.example.json

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.restaurantes2.R
import com.squareup.picasso.Picasso

class Adapter(val articulos : List<Resultado>,val clickListener:(Resultado) -> Unit): RecyclerView.Adapter<MainViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {

        return MainViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false))

    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {


        val articulo:Resultado= articulos.get(position)
        holder.render(articulo)

        holder.itemView.setOnClickListener{
            clickListener(articulos[position])

        }



    }

    override fun getItemCount(): Int {
        return articulos.size
    }

}
class MainViewHolder(val view: View):RecyclerView.ViewHolder(view){
    fun render(articulo:Resultado)
    {
        view.findViewById<TextView>(R.id.tvNombre).text = " Restaurante:  "+articulo.nombre
        view.findViewById<TextView>(R.id.tvAnio).text=" Año Inauguración:  "+articulo.anio
        view.findViewById<TextView>(R.id.tvCalificacion).text=" Calificación:  "+articulo.calificacion
        view.findViewById<TextView>(R.id.tvCosto).text=" Costo Promedio:  "+articulo.costo
        //Picasso.get().load(articulo.img_variadas[0].img).into(view.findViewById<ImageView>(R.id.ivLogo))
        Picasso.get().load(articulo.imagen).into(view.findViewById<ImageView>(R.id.ivLogo))

    }
}

