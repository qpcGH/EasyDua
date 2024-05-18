package com.example.dua

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
class ViewPagerAdapter(private var duaArabic:List<String>,private var translation:List<String>,private var duaEnglish:List<String>):RecyclerView.Adapter<ViewPagerAdapter.Pager2ViewHolder>() {

    inner class Pager2ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView)
    {
        val DuaArabic: TextView =itemView.findViewById(R.id.tvDuaArabic)
        val Translation: TextView =itemView.findViewById(R.id.tvTranslation)
        val DuaEnglis: TextView =itemView.findViewById(R.id.tvEnglish)

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewPagerAdapter.Pager2ViewHolder {
        return Pager2ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.items,parent,false))
    }

    override fun onBindViewHolder(holder: ViewPagerAdapter.Pager2ViewHolder, position: Int) {
        holder.DuaArabic.text=duaArabic[position]
        holder.Translation.text=translation[position]
        holder.DuaEnglis.text=duaEnglish[position]

    }

    override fun getItemCount(): Int {

        return duaArabic.size
    }
}