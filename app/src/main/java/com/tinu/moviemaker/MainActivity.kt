package com.tinu.moviemaker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.Navigation

class MainActivity : AppCompatActivity() {
    private lateinit var toolbar: Toolbar
    private lateinit var  navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
     toolbar = findViewById(R.id.toolbar)

     setSupportActionBar(toolbar)
  // title = "KotlinApp"
      navController = Navigation.findNavController(this,R.id.nav_host_fragment)

    }


}