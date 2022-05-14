package com.example.restaurantes2

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.json.*
import com.example.restaurantes2.databinding.ActivityMainBinding
import com.example.restaurantes2.databinding.ActivityUsuarioBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Usuario : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var nombreusuario: String
    private lateinit var contraseniausuario: String
    private lateinit var context:Context
    private  var i=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_usuario)

    }
    private fun getRetrofitUsuario(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://demo8226633.mockable.io/listado-usuario/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }

     fun login(view: View){
        // mensaje()
        Log.i("call2", "**********")
        CoroutineScope(Dispatchers.IO).launch {
            val callUser: Response<RespuestaUsuario> = getRetrofitUsuario().create(APIServiceUsuario::class.java).getResponseUsuario("mostrar")


            val respuestaUser: RespuestaUsuario? = callUser.body()
            Log.i("call2", "variable call2: ${callUser.body()}")

            val usuarios:List<ResultadoUsuario> = respuestaUser?.usuarios ?: emptyList()
            Log.i("usuarios", "variable usuarios----: ${usuarios[0].nombre}")
            Log.i("contraseña", "variable contraseña----: ${usuarios[0].contrasenia}")

            //findViewById<TextView>(R.id.TitleTextView).text

            nombreusuario= findViewById<TextView>(R.id.txtUsuario).text.toString()
            contraseniausuario= findViewById<TextView>(R.id.txtContrasena).text.toString()
            val varnombre=usuarios[0].nombre
var tamañoarray=(usuarios.size)-1
            for ( i in 0..tamañoarray)
            {
               if ((nombreusuario.equals(usuarios[i].nombre))&&
                   (contraseniausuario.equals(usuarios[i].contrasenia)))
               {
                   Log.i("********", "******")
                   Log.i("Usuario Logueado", "usuario: ${usuarios[i].nombre}")
                   Log.i("Usuario Logueado", "contraseña----: ${usuarios[i].contrasenia}")
                   Log.i("********", "******")
                   //val intent = Intent(this,MainActivity::class.java)
                   val intent2 = Intent(this@Usuario,MainActivity::class.java)
                   startActivity(intent2)

               }
                else{
                   // mensaje()
                   //Toast.makeText(this,"Usuario incorrecto o no existe!, Intenta otra vez", Toast.LENGTH_LONG).show()

               }

            }
            /*if(nombreusuario.equals(varnombre))
            {
                Log.i("***IF***", "ENTRO A IF")
               // mensaje()


            }*/
           runOnUiThread {
                if(callUser.isSuccessful){
                   // mensaje()
                    if (respuestaUser!=null)
                    {


                        //findViewById<TextView>(R.id.TitleTextView).text= respuesta.results.first().title
                        /*callUser.clear()

                        callUser.addAll(articulos)
                        adapter.notifyDataSetChanged()*/



                    }
                }else
                {
                    //mensaje()


                }

            }


        }
    }


    fun mensaje(){
        Toast.makeText(this,"USUARIO INCORRECTO!", Toast.LENGTH_LONG).show()

    }

    /*fun login2(view: View) {
       nombreusuario= findViewById<RecyclerView>(R.id.txtUsuario)
        contraseniausuario= findViewById<RecyclerView>(R.id.txtContrasena)

        if(nombreusuario==usuarios[0].nombre)
        {

        }

    }*/

}