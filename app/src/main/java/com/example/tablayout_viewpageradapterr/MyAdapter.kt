package com.example.tablayout_viewpageradapterr

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(val context: Context, val listitem:List<PostModelApi>):RecyclerView.Adapter<MyAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent,false)
        return  ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listitem.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.uid.text="UserId ="+listitem[position].userId.toString()
        holder.pid.text="Id ="+listitem[position].id.toString()
        holder.hellow.text="Title ="+listitem[position].title
        holder.body.text="Body ="+listitem[position].body
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val uid: TextView = itemView.findViewById(R.id.textuserid)
        val pid : TextView = itemView.findViewById(R.id.textid)
        val hellow : TextView = itemView.findViewById(R.id.text)
        val body: TextView = itemView.findViewById(R.id.body)
    }
}