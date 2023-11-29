package com.example.tablayout_viewpageradapterr

//class CommentAdapter {
//
//
//}


import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CommentAdapter(val context: Context, val commentitem:List<commentModel>):RecyclerView.Adapter<CommentAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.comment_list,parent,false)
        return  ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return commentitem.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.uid.text="PostId ="+commentitem[position].postId.toString()
        holder.pid.text="Id ="+commentitem[position].id.toString()
        holder.hellow.text="Name ="+commentitem[position].name
        holder.body.text="Body ="+commentitem[position].body
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val uid: TextView = itemView.findViewById(R.id.post_id)
        val pid : TextView = itemView.findViewById(R.id.p_id)
        val hellow : TextView = itemView.findViewById(R.id.p_name)
        val body: TextView = itemView.findViewById(R.id.p_body)
    }
}