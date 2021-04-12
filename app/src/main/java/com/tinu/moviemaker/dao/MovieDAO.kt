package com.tinu.moviemaker.dao

import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import com.tinu.moviemaker.data.response.Content
import com.tinu.moviemaker.data.response.MovieResponse

interface MovieDAO {
    fun getAllMovieList(): List<Content?> {

        val json = """{
  "page": {
    "title": "Romantic Comedy",
    "total_content-items" : "54",
    "page_num" : "1",
    "page_size" : "20",
    "content_items": {
      "content": [
        {
          "name": "The Birds",
          "poster_image": "poster1.jpg"
        },
        {
          "name": "Rear Window",
          "poster_image": "poster2.jpg"
        },
        {
          "name": "Family Pot",
          "poster_image": "poster3.jpg"
        },
        {
          "name": "Family Pot",
          "poster_image": "poster2.jpg"
        },
        {
          "name": "Rear Window",
          "poster_image": "poster1.jpg"
        },
        {
          "name": "The Birds",
          "poster_image": "poster3.jpg"
        },
        {
          "name": "Rear Window",
          "poster_image": "poster3.jpg"
        },
        {
          "name": "The Birds",
          "poster_image": "poster2.jpg"
        },
        {
          "name": "Family Pot",
          "poster_image": "poster1.jpg"
        },
        {
          "name": "The Birds",
          "poster_image": "poster1.jpg"
        },
                {
          "name": "The Birds",
          "poster_image": "poster1.jpg"
        },
        {
          "name": "Rear Window",
          "poster_image": "poster2.jpg"
        },
        {
          "name": "Family Pot",
          "poster_image": "poster3.jpg"
        },
        {
          "name": "Family Pot",
          "poster_image": "poster2.jpg"
        },
        {
          "name": "Rear Window",
          "poster_image": "poster1.jpg"
        },
        {
          "name": "The Birds",
          "poster_image": "poster3.jpg"
        },
        {
          "name": "Rear Window",
          "poster_image": "poster3.jpg"
        },
        {
          "name": "The Birds",
          "poster_image": "poster2.jpg"
        },
        {
          "name": "Family Pot",
          "poster_image": "poster1.jpg"
        },
        {
          "name": "The Birds",
          "poster_image": "poster1.jpg"
        }
      ]
    }
  }
}"""
        val gson = Gson()

        val movieList: MovieResponse = gson.fromJson(json, MovieResponse::class.java)

        return movieList.page.content_items.content

    }

    fun getAllSecondMovieList(): List<Content?> {

        val json = """{
  "page": {
    "title": "Romantic Comedy",
    "total_content-items" : "54",
    "page_num" : "2",
    "page_size" : "20",
    "content_items": {
      "content": [
        {
          "name": "Rear Window",
          "poster_image": "poster5.jpg"
        },
        {
          "name": "Family Pot",
          "poster_image": "poster6.jpg"
        },
        {
          "name": "Family Pot",
          "poster_image": "poster5.jpg"
        },
        {
          "name": "Rear Window",
          "poster_image": "poster4.jpg"
        },
        {
          "name": "The Birds",
          "poster_image": "poster6.jpg"
        },
        {
          "name": "Rear Window",
          "poster_image": "poster6.jpg"
        },
        {
          "name": "The Birds",
          "poster_image": "poster5.jpg"
        },
        {
          "name": "Family Pot",
          "poster_image": "poster4.jpg"
        },
        {
          "name": "The Birds",
          "poster_image": "poster4.jpg"
        },
        {
          "name": "Rear Window",
          "poster_image": "poster5.jpg"
        },
                {
          "name": "Rear Window",
          "poster_image": "poster5.jpg"
        },
        {
          "name": "Family Pot",
          "poster_image": "poster6.jpg"
        },
        {
          "name": "Family Pot",
          "poster_image": "poster5.jpg"
        },
        {
          "name": "Rear Window",
          "poster_image": "poster4.jpg"
        },
        {
          "name": "The Birds",
          "poster_image": "poster6.jpg"
        },
        {
          "name": "Rear Window",
          "poster_image": "poster6.jpg"
        },
        {
          "name": "The Birds",
          "poster_image": "poster5.jpg"
        },
        {
          "name": "Family Pot",
          "poster_image": "poster4.jpg"
        },
        {
          "name": "The Birds",
          "poster_image": "poster4.jpg"
        },
        {
          "name": "Rear Window",
          "poster_image": "poster5.jpg"
        }
      ]
    }
  }
}"""
        val gson = Gson()

        val movieList: MovieResponse = gson.fromJson(json, MovieResponse::class.java)

        return movieList.page.content_items.content

    }
}

