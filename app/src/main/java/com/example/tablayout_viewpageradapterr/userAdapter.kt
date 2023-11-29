package com.example.tablayout_viewpageradapterr

//class userAdapter {
//}



import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class userAdapter(val context: Context, val listitem:List<UsersModel>):RecyclerView.Adapter<userAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.users_list,parent,false)
        return  ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listitem.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {


        holder.uid.text="id ="+listitem[position].id.toString()
        holder.uname.text="name ="+listitem[position].name
        holder.username.text="username ="+listitem[position].username
        holder.utitle.text="title ="+listitem[position].email
       holder.uaddress.text="address ="+listitem[position].address
        holder.uphone.text="phne ="+listitem[position].phone
        holder.uwebsite.text="Website ="+listitem[position].website
        holder.ucompany.text="company =" +listitem[position].company
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){


        val uid: TextView = itemView.findViewById(R.id.user_userid)
        val uname:TextView=itemView.findViewById(R.id.u_name)
        val username:TextView=itemView.findViewById(R.id.u_username)
        val utitle:TextView=itemView.findViewById(R.id.u_email)
        val uaddress:TextView=itemView.findViewById(R.id.u_address)
        val uphone:TextView=itemView.findViewById(R.id.u_phone)
        val uwebsite:TextView=itemView.findViewById(R.id.u_website)
        val ucompany:TextView=itemView.findViewById(R.id.u_company)

    }
}