package com.example.restaurantes2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

import android.webkit.WebView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.json.APIService
import com.example.json.Adapter
import com.example.json.Respuesta
import com.example.json.Resultado
import com.example.restaurantes2.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private lateinit var adapter: Adapter
    private var articulos2= mutableListOf<Resultado>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

         initRecycler()
         call()
    }
    private fun initRecycler(){
        adapter = Adapter(articulos2){
            //Toast.makeText(this,it.url,Toast.LENGTH_SHORT).show()
        //comente la siguiente linea, esta muestra el contenido del NY Times en un webview
        // ------->
        //findViewById<WebView>(R.id.wvUrl).loadUrl(it.url)
//Toast.makeText(this,"selecciono un elemento"+it.nombre,Toast.LENGTH_SHORT).show()
            val intent = Intent(this,DetalleRestaurante::class.java)
           // startActivity(intent)
           // valores(it.nombre,it.anio,it.calificacion,it.costo,it.)
            //val intent = Intent(this,DetalleRestaurante::class.java)
            intent.putExtra("nombre" , it.nombre.toString())
            intent.putExtra("anio" , it.anio.toString())
            intent.putExtra("calificacion" , it.calificacion.toString())
            intent.putExtra("costo" , it.costo.toString())
            intent.putExtra("resenia" , it.resenia.toString())
            intent.putExtra("img1" , it.img_variadas.get(0).img.toString())
            intent.putExtra("img2" , it.img_variadas.get(1).img.toString())
            intent.putExtra("img3" , it.img_variadas.get(2).img.toString())
           // intent.putExtra("photo_second" , it.img_variadas?.get(2)?.toString())
            //intent.putExtra("photo_third" , it.img_variadas?.get(3)?.toString())
            startActivity(intent)

        }

        findViewById<RecyclerView>(R.id.rv1).layoutManager= LinearLayoutManager(this,
            LinearLayoutManager.VERTICAL,false)
        findViewById<RecyclerView>(R.id.rv1).adapter = adapter


    }
    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://demo8226633.mockable.io/listado-restaurantes/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }

    public fun call(){
       // mensaje()
        Log.i("call2", "**********")
        CoroutineScope(Dispatchers.IO).launch {
            val call2: Response<Respuesta> = getRetrofit().create(APIService::class.java).getResponse("mostrar")


            val respuesta: Respuesta? = call2.body()
            Log.i("call2", "variable call2: ${call2.body()}")

            val articulos:List<Resultado> = respuesta?.restaurantes ?: emptyList()

            runOnUiThread {
                if(call2.isSuccessful){
                   // mensaje()
                    if (respuesta!=null)
                    {

                        //findViewById<TextView>(R.id.TitleTextView).text= respuesta.results.first().title
                        articulos2.clear()

                        articulos2.addAll(articulos)
                        adapter.notifyDataSetChanged()



                    }
                }else
                {
                    mensaje()


                }

            }


        }
    }
    fun mensaje(){
       Toast.makeText(this,"Ha ocurrido un error", Toast.LENGTH_LONG).show()

    }


}