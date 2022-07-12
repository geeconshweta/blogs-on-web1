package com.example.newproject.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

import java.util.ArrayList
import com.example.newproject.HomeScreen
import com.example.newproject.R
import com.example.newproject.model.DataModel


class TagBlogAdapter(val ctx: Context, private val dataList: ArrayList<DataModel>): RecyclerView.Adapter<TagBlogAdapter.ViewHolder>() {
    var flag = 0
    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val Buss_button: TextView = itemView.findViewById(R.id.Buss_button)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.single_bussinessbutton, parent,
            false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.Buss_button.text = dataList[position].valuename

        holder.Buss_button.setOnClickListener{
            if (ctx is HomeScreen) {
                (ctx as HomeScreen).getBlogsBasedOnTagsFilter(dataList[position].valuename)

            }
            flag = position
            notifyDataSetChanged()
        }



        if (flag == position) {
            holder.Buss_button.setBackgroundResource(R.color.black)
            holder.Buss_button.setTextColor(ContextCompat.getColor(ctx, R.color.white))
        } else {
            holder.Buss_button.setBackgroundResource(R.color.gray)
            holder.Buss_button.setTextColor(ContextCompat.getColor(ctx, R.color.black))
        }




    }
    override fun getItemCount(): Int {
        return dataList.size
    }

}