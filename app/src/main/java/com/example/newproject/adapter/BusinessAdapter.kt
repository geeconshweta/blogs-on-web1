package com.example.newproject.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newproject.HomeView
import com.example.newproject.R
import com.example.newproject.model.DataModel

class BusinessAdapter(val ctx: Context,private val dataList:ArrayList<DataModel>):RecyclerView.Adapter<BusinessAdapter.ViewHolder>()
{
inner  class ViewHolder(itemView : View):RecyclerView.ViewHolder(itemView){
    val photo: ImageView = itemView.findViewById(R.id.photo)
    val soft1: TextView = itemView.findViewById(R.id.soft1)
    val Tvbussin: TextView =itemView.findViewById(R.id.Tvbussin)
    val bussinesbutton1: TextView = itemView.findViewById(R.id.bussinesbutton1)
    val Tv_date: TextView =itemView.findViewById(R.id.Tv_date)
    val cardhome: CardView =itemView.findViewById(R.id.cardhome)
}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.singlehome, parent,
            false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(ctx).load(dataList[position].imageId).into(holder.photo)
        /*holder.img.setImageResource(dataList[position].imageId!!)*/
        holder.soft1.text = dataList[position].imageName
        holder.Tvbussin.text=dataList[position].textname
        holder.Tv_date.text=dataList[position].imagename
        holder.bussinesbutton1.text = dataList[position].valuename
        holder.cardhome.setOnClickListener { view ->
            val intent= Intent(ctx,HomeView::class.java)
            intent.putExtra("image",dataList[position].imageId.toString())
            intent.putExtra("author_full_name",dataList[position].imageName.toString())
            intent.putExtra("title",dataList[position].textname.toString())
            intent.putExtra("short_description",dataList[position].imagename.toString())
            intent.putExtra("description",dataList[position].valuename.toString())
            view.context.startActivity(intent)
        }


    }

    override fun getItemCount(): Int {
        return dataList.size
    }

}