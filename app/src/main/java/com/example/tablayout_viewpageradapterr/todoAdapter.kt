package com.example.tablayout_viewpageradapterr

//class todoAdapter {
//}



import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class todoAdapter(val context: Context, val listitem1:List<TodoModel>):RecyclerView.Adapter<todoAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.todos_list,parent,false)
        return  ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listitem1.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.uid.text="UserId ="+listitem1[position].userId.toString()
        holder.pid.text="Id ="+listitem1[position].id.toString()
        holder.hellow.text="Title ="+listitem1[position].title
        holder.body.text="completed ="+listitem1[position].completed
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val uid: TextView = itemView.findViewById(R.id.todo_userid)
        val pid : TextView = itemView.findViewById(R.id.t_id)
        val hellow : TextView = itemView.findViewById(R.id.t_title)
        val body: TextView = itemView.findViewById(R.id.t_completed)
    }
}