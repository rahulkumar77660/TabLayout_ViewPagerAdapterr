package com.example.tablayout_viewpageradapterr

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


class albumsfragment : Fragment() {

    lateinit var myAdapter: albumAdapter
    lateinit var albumlist : ArrayList<albumsModel>
    lateinit var recyclerView : RecyclerView
    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view=inflater.inflate(R.layout.fragment_albumsfragment, container, false)

        recyclerView  = view.findViewById(R.id.recyclyView3)
        albumlist = arrayListOf()


        albuminterface.createRetrofit().getAllposts()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe({

                recyclerView.layoutManager = LinearLayoutManager(requireContext())
                albumlist.addAll(it)
                myAdapter = albumAdapter(requireContext(), albumlist)
                recyclerView.adapter = myAdapter


            },{it->
                Toast.makeText(requireContext(), it.toString(), Toast.LENGTH_SHORT).show()
            })

        return view
    }


}