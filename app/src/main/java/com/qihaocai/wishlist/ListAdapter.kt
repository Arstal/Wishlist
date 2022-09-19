package com.qihaocai.wishlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListAdapter (private val wishlist: List<ItemTemp>) : RecyclerView.Adapter<ListAdapter.ViewHolder>(){
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val itemNameTextView: TextView
        val UrlTextView: TextView
        val priceTextView: TextView

        init{
            itemNameTextView = itemView.findViewById(R.id.itemname)
            UrlTextView = itemView.findViewById(R.id.link)
            priceTextView = itemView.findViewById(R.id.price)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)

        val contactView = inflater.inflate(R.layout.item_temp, parent, false)

        return ViewHolder((contactView))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val ItemTemp = wishlist.get(position)
        holder.itemNameTextView.text = ItemTemp.name
        holder.UrlTextView.text = ItemTemp.Url
        holder.priceTextView.text = ItemTemp.price

    }

    override fun getItemCount(): Int {
        return wishlist.size
    }
}