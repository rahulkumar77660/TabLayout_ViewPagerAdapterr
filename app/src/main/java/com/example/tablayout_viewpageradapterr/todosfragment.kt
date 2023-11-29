package com.example.tablayout_viewpageradapterr

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


class todosfragment : Fragment() {
    lateinit var myAdapter: todoAdapter
    lateinit var listItem : ArrayList<TodoModel>
    lateinit var recyclerView : RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_todosfragment, container, false)
        recyclerView  = view.findViewById(R.id.recyclyView5)
        listItem = arrayListOf()

        todointerface.createRetrofit()!!.getAllposts()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe({
                recyclerView.layoutManager = LinearLayoutManager(requireContext())
                listItem.addAll(it)
                myAdapter = todoAdapter(requireContext(),listItem)
                recyclerView.adapter = myAdapter


            },{it->
                Toast.makeText(requireContext(), it.toString(), Toast.LENGTH_SHORT).show()
            })

        return view
    }


}