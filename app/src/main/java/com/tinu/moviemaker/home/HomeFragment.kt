package com.tinu.moviemaker.home

import android.content.res.Configuration
import android.os.Bundle
import android.os.Handler
import android.view.*
import android.widget.SearchView
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tinu.moviemaker.adapter.MovieRecyclerViewAdapter
import com.tinu.moviemaker.base.BaseFragment
import com.tinu.moviemaker.dao.MovieDAO
import com.tinu.moviemaker.data.repository.HomeRepository
import com.tinu.moviemaker.data.response.Content
import com.tinu.moviemaker.databinding.FragmentHomeBinding


class HomeFragment : BaseFragment<HomeViewModel, FragmentHomeBinding, HomeRepository>() {

    private lateinit var navController: NavController
    private lateinit var searchView: SearchView
    private lateinit var movieDAO: MovieDAO;
    private lateinit var listItem: ArrayList<Content?>
    var isLoading = false

    private lateinit var movieRecyclerViewAdapter: MovieRecyclerViewAdapter

    override fun getViewModel() = HomeViewModel::class.java
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        listItem = ArrayList<Content?>()

        movieDAO = object : MovieDAO {

        }

    }

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentHomeBinding.inflate(inflater, container, false)

    override fun getFragmentRepository() = HomeRepository(movieDAO)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        if (resources
                .configuration.orientation == Configuration.ORIENTATION_PORTRAIT
        ) {
            binding.rvMovieList?.setLayoutManager(GridLayoutManager(context, 3))
        } else {
            binding.rvMovieList?.setLayoutManager(GridLayoutManager(context, 7))
        }

        movieRecyclerViewAdapter =
            MovieRecyclerViewAdapter(mutableListOf<Content>() as ArrayList<Content?>,activity) { content: Content -> movieItemClicked(content) }
        binding.rvMovieList.adapter = movieRecyclerViewAdapter
        getItems()
        initScrollListener()



    }

    private fun movieItemClicked(content: Content) {

        Toast.makeText(context, content.name, Toast.LENGTH_LONG)


    }

    private fun getItems() {
        listItem.addAll(viewModel.movieDataList as ArrayList<Content?>)
        movieRecyclerViewAdapter.movieItemList = listItem
        movieRecyclerViewAdapter.notifyDataSetChanged()


    }

    private fun getUpdateItems(listItem: ArrayList<Content?>) {

        movieRecyclerViewAdapter.movieItemList = listItem
        movieRecyclerViewAdapter.notifyDataSetChanged()


    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(com.tinu.moviemaker.R.menu.main_menu, menu)

        val searchItem: MenuItem? = menu.findItem(com.tinu.moviemaker.R.id.app_bar_search)
        /*   val searchManager =
              context?.getSystemService<Any>(Context.SEARCH_SERVICE) as SearchManager*/
        if (searchItem != null) {
            searchView = searchItem.getActionView() as SearchView
        }
        if (searchView != null) {
            //searchView?.setSearchableInfo(searchManager.getSearchableInfo(context?.name))
            queryTextListener = object : SearchView.OnQueryTextListener {
                override fun onQueryTextChange(newText: String): Boolean {

                    if (newText != null)
                        if (newText.length > 3) {
                            listItem = viewModel.filterData(newText)
                            getUpdateItems(listItem);


                        } else if (newText.equals("")) {
                            getItems()
                        }
                    return true
                }

                override fun onQueryTextSubmit(query: String): Boolean {
                    return true
                }
            }
            searchView?.setOnQueryTextListener(queryTextListener)
            searchView.setOnClickListener {
                getItems()
            }
        }
        super.onCreateOptionsMenu(menu, inflater)
    }

    // Lazy loading
    private fun initScrollListener() {
        binding.rvMovieList!!.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(
                recyclerView: RecyclerView,
                newState: Int
            ) {
                super.onScrollStateChanged(recyclerView, newState)
            }

            override fun onScrolled(
                recyclerView: RecyclerView,
                dx: Int,
                dy: Int
            ) {
                super.onScrolled(recyclerView, dx, dy)
                val linearLayoutManager =
                    recyclerView.layoutManager as LinearLayoutManager?
                if (!isLoading) {
                    if (linearLayoutManager != null && linearLayoutManager.findLastCompletelyVisibleItemPosition() == viewModel.movieDataList.size - 1) {
                        //bottom of list!
                        loadMore()
                        isLoading = true
                    }
                }
            }
        })
    }

    private fun loadMore() {
        listItem.add(null)
        movieRecyclerViewAdapter!!.notifyItemInserted(viewModel.movieDataList.size - 1)
        val handler = Handler()
        handler.postDelayed({
          //  viewModel.movieDataList.removeAt(viewModel.movieDataList.size - 1)
            listItem.removeAt(viewModel.movieDataList.size - 1)
            val scrollPosition = viewModel.movieDataList.size
            movieRecyclerViewAdapter!!.notifyItemRemoved(scrollPosition)
            var currentSize = scrollPosition

            listItem.addAll(viewModel.movieDataListSecond as ArrayList<Content?>)

            movieRecyclerViewAdapter!!.notifyDataSetChanged()
            isLoading = false
        }, 20)
    }
}