package com.example.privatemessangerjkt48

import android.annotation.SuppressLint
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.example.privatemessangerjkt48.databinding.ActivitySplashScreenBinding

@SuppressLint("CustomSplashScreen")
class SplashScreenActivity : AppCompatActivity() {

    private val splashTimeOut: Long = 3000
    private lateinit var binding: ActivitySplashScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Glide.with(this)
            .load("https://jkt48.primesse.me/_next/image?url=%2Fimages%2FLogo%402x.png&w=384&q=75") // Ganti dengan URL gambar Anda
            .apply(RequestOptions().diskCacheStrategy(DiskCacheStrategy.NONE)) // Menghindari caching
            .into(binding.logoImageView)

        Handler(Looper.getMainLooper()).postDelayed({
            if (isNetworkAvailable()){
                startActivity(Intent(this, LoginActivity::class.java))
            }
            finish()
        }, splashTimeOut)
    }

    private fun isNetworkAvailable(): Boolean{
        val connectivityManager = getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager
        val network = connectivityManager.activeNetwork
        val networkCapabilities = connectivityManager.getNetworkCapabilities(network)

        return networkCapabilities != null &&
                (networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) ||
                        networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR))
    }

//    private fun showNoInternetDialog(){
//        if (!isFinishing) {
//            MaterialAlertDialogBuilder(applicationContext)
//                .setTitle(resources.getString(R.string.title))
//                .setMessage(resources.getString(R.string.supporting_text))
//                .setPositiveButton(resources.getString(R.string.close)) { dialog, which ->
//                    // Respond to positive button press
//                }
//                .show()
//        }
//    }
//        AlertDialog.Builder(this)
//            .setTitle("Tidak Ada Koneksi Internet")
//            .setMessage("Mohon periksa kembali koneksi internet Anda.")
//            .setPositiveButton("Tutup Aplikasi") { dialogInterface, _ ->
//                dialogInterface.dismiss()
//                finish()
//            }
//            .setCancelable(false)
//            .show()
//    }
}