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


class postsfragment : Fragment() {

    lateinit var myAdapter: MyAdapter
    lateinit var listItem : ArrayList<PostModelApi>
    lateinit var recyclerView : RecyclerView
    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        val view=inflater.inflate(R.layout.fragment_postsfragment, container, false)
        recyclerView  = view.findViewById(R.id.recyclyView)
        listItem = arrayListOf()
        ApiInterface.createRetrofit().getAllposts()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe({
                recyclerView.layoutManager = LinearLayoutManager(requireContext())
                listItem.addAll(it)
                myAdapter = MyAdapter(requireContext(),listItem)
                recyclerView.adapter = myAdapter


            },{it->
                Toast.makeText(requireContext(), it.toString(), Toast.LENGTH_SHORT).show()
            })


        return view
    }


}