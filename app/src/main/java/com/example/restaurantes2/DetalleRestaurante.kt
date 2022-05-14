package com.example.restaurantes2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.json.Adapter
import com.example.json.Resultado
import com.example.restaurantes2.databinding.ActivityDetalleRestauranteBinding
import com.squareup.picasso.Picasso

class DetalleRestaurante : AppCompatActivity() {
  //  private lateinit var binding: ActivityDetalleRestauranteBinding
    private lateinit var  nombre: String
    private lateinit var  anio: String
    private lateinit var  calificacion: String
    private lateinit var  costo: String
    private lateinit var  resenia: String
    private lateinit var  img1: String
    private lateinit var  img2: String
    private lateinit var  img3: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_restaurante)
        val bundle = intent.extras
        if(savedInstanceState == null)
        {
            val bundle = intent.extras

            nombre = if( bundle != null ){
                bundle.getString("nombre" , "nombre")
            } else {
                savedInstanceState?.getSerializable("nombre") as String
            }
            anio = if( bundle != null ){
                bundle.getString("anio" , "anio")
            } else {
                savedInstanceState?.getSerializable("anio") as String
            }
            calificacion = if( bundle != null ){
                bundle.getString("calificacion" , "calificacion")
            } else {
                savedInstanceState?.getSerializable("calificacion") as String
            }
            costo = if( bundle != null ){
                bundle.getString("costo" , "costo")
            } else {
                savedInstanceState?.getSerializable("costo") as String
            }
            resenia = if( bundle != null ){
                bundle.getString("resenia" , "resenia")
            } else {
                savedInstanceState?.getSerializable("resenia") as String
            }
            img1 = if( bundle != null ){
                bundle.getString("img1" , "img1")
            } else {
                savedInstanceState?.getSerializable("img1") as String
            }
            img2 = if( bundle != null ){
                bundle.getString("img2" , "img2")
            } else {
                savedInstanceState?.getSerializable("img2") as String
            }
            img3 = if( bundle != null ){
                bundle.getString("img3" , "img3")
            } else {
                savedInstanceState?.getSerializable("img3") as String
            }

        }
        //binding.tvDRNombre.text = nombre.toString()
        findViewById<TextView>(R.id.tvDRNombre).text=nombre.toString()
        findViewById<TextView>(R.id.tvDRAnio).text=anio.toString()
        findViewById<TextView>(R.id.tvDRCalificacion).text=calificacion.toString()
        findViewById<TextView>(R.id.tvDRCosto).text=costo.toString()
        findViewById<TextView>(R.id.tvDRResenia).text=resenia.toString()
        Picasso.get().load(img1.toString()).into(findViewById<ImageView>(R.id.imgv1))
        Picasso.get().load(img2.toString()).into(findViewById<ImageView>(R.id.imgv2))
        Picasso.get().load(img3.toString()).into(findViewById<ImageView>(R.id.imgv3))

        //Toast.makeText(this,"Esto es lo que trae imagen 1:  "+img1.get(0).toString(),Toast.LENGTH_SHORT).show()
    }


}