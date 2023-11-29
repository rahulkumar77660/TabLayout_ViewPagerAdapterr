package com.example.tablayout_viewpageradapterr

//class albumAdapter {
//}




import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class albumAdapter(val context: Context, val albumitem:List<albumsModel>):RecyclerView.Adapter<albumAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.albums_list,parent,false)
        return  ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return albumitem.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.uid.text="User Id ="+albumitem[position].userId.toString()
        holder.pid.text="Id ="+albumitem[position].id.toString()
        holder.hellow.text="Title ="+albumitem[position].title

    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val uid: TextView = itemView.findViewById(R.id.album_id)
        val pid : TextView = itemView.findViewById(R.id.a_id)
        val hellow : TextView = itemView.findViewById(R.id.a_title)

    }
}