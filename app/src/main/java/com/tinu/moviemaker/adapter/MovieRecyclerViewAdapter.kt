package com.tinu.moviemaker.adapter

import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.tinu.moviemaker.R
import com.tinu.moviemaker.data.response.Content
import com.tinu.moviemaker.databinding.ActivityMainBinding.inflate
import com.tinu.moviemaker.databinding.HeaderBinding.inflate
import com.tinu.moviemaker.databinding.ListItemBinding


class MovieRecyclerViewAdapter(var movieItemList: ArrayList<Content?>, val context: FragmentActivity?, private val clickListener: (Content) -> Unit) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val VIEW_TYPE_ITEM = 0
    private val VIEW_TYPE_LOADING = 1
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return if (viewType == VIEW_TYPE_ITEM) {

            val view =
                LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
            ItemViewHolder(view)
        } else {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_loading, parent, false)
            LoadingViewHolder(view)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ItemViewHolder) {
            populateItemRows(holder, position)
        } else if (holder is LoadingViewHolder) {
            showLoadingView(holder, position)
        }

    }

    override fun getItemCount() = movieItemList.size



    private inner class ItemViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var tvItem: TextView
        var imageView: ImageView

        init {
            tvItem = itemView.findViewById(R.id.tv_name)
            imageView = itemView.findViewById(R.id.iv_image)
        }
    }

    private inner class LoadingViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var progressBar: ProgressBar

        init {
            progressBar = itemView.findViewById(R.id.progressBar)
        }
    }
    private fun showLoadingView(viewHolder: LoadingViewHolder, position: Int) {

    }

    private fun populateItemRows(viewHolder: ItemViewHolder, position: Int) {
        val item = movieItemList!![position]
        viewHolder.tvItem.text = item?.name
        if (item?.poster_image!=null && item?.poster_image.contains("."))
        {
            val poster_image: String =item?.poster_image!!.dropLast(4)
            val resId: Int =
                context?.getResources()!!.getIdentifier(poster_image, "drawable", context.getPackageName())
            val image: Drawable = context?.getResources().getDrawable(resId)
            viewHolder.imageView.setImageDrawable(image)
        }

    }
}

