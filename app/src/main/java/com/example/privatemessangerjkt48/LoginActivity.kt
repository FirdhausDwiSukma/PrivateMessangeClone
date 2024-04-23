package com.example.privatemessangerjkt48

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.example.privatemessangerjkt48.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding : ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Glide.with(this)
            .load("https://jkt48.primesse.me/_next/image?url=%2Fimages%2FLogo%402x.png&w=384&q=75") // Ganti dengan URL gambar Anda
            .apply(RequestOptions().diskCacheStrategy(DiskCacheStrategy.NONE)) // Menghindari caching
            .into(binding.imageViewLogin)
    }
}