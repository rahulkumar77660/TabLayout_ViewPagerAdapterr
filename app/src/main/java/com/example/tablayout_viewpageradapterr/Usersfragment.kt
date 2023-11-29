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


class Usersfragment : Fragment() {

    private lateinit var myAdapter: userAdapter
    private lateinit var listItemu: ArrayList<UsersModel>
   private lateinit var recyclerView : RecyclerView
    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_usersfragment, container, false)

        recyclerView = view.findViewById(R.id.recyclyView6)
        listItemu = arrayListOf()

        userinterface.createRetrofit()?.getAllposts()
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.subscribeOn(Schedulers.io())
            ?.subscribe({ response ->
                recyclerView.layoutManager = LinearLayoutManager(context)
                listItemu.addAll(response)
                myAdapter = userAdapter(requireContext(), listItemu)
                recyclerView.adapter = myAdapter
            }, { error ->
                Toast.makeText(requireContext(), "Failed: $error", Toast.LENGTH_SHORT).show()
            })


        return view
    }


}