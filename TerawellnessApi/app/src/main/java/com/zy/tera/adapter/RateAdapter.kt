package com.zy.tera.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.zy.tera.R
import com.zy.tera.adapter.RateAdapter.ViewHolder
import com.zy.tera.db.CoachRateInfo
import kotlinx.android.synthetic.main.layout_rateitem.view.*

class RateAdapter(var list: List<CoachRateInfo>) : RecyclerView.Adapter<ViewHolder>() {


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var text:TextView = itemView.coachname;
        var rate: RatingBar = itemView.ratingBar;
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflate = LayoutInflater.from(parent.context).inflate(R.layout.layout_rateitem, null, false)
        var holder: ViewHolder = ViewHolder(inflate)
        return holder;
    }

    override fun getItemCount(): Int {
        return list.size;
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var c = list.get(position);
        holder.text.setText(c.name+"("+c.id+")");
        holder.rate.rating = c.rate!!;
    }

}
