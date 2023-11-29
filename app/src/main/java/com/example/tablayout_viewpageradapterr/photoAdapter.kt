package com.example.tablayout_viewpageradapterr

//class photoAdapter {
//}



import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class photoAdapter(val context: Context, val photositem:List<photoModel>):RecyclerView.Adapter<photoAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.photo_list,parent,false)
        return  ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return photositem.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.uid.text="User Id ="+photositem[position].albumId.toString()
        holder.pid.text="Id ="+photositem[position].id.toString()
        holder.hellow.text="Title ="+photositem[position].title

        Glide.with(context)
            .load(photositem[position].url) // Assuming there's a field `imageUrl` in photoModel
            .into(holder.image)

        Glide.with(context)
            .load(photositem[position].thumbnailUrl)
            .into(holder.imageView)

    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val uid: TextView = itemView.findViewById(R.id.newphoto_id)
        val pid : TextView = itemView.findViewById(R.id.newp_id)
        val hellow : TextView = itemView.findViewById(R.id.newp_title)
       val imageView: ImageView = itemView.findViewById(R.id.newp_thubnel)
        val image:ImageView=itemView.findViewById(R.id.newp_url)

    }
}