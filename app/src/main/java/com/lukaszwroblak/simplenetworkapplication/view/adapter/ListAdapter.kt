package com.lukaszwroblak.simplenetworkapplication.view.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import com.lukaszwroblak.simplenetworkapplication.datamodel.ElementBase
import android.view.View
import android.view.ViewGroup
import com.lukaszwroblak.simplenetworkapplication.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.row_list_element.view.*

/**
 * Created by lukaszwroblak on 11.11.2018.
 */

class ListAdapter(private val click: (ElementBase) -> Unit) : RecyclerView.Adapter<ListAdapter.ViewHolder>()  {

    var items: MutableList<ElementBase> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.row_list_element, parent, false)
        val viewHolder = ViewHolder(view)

        view.setOnClickListener {
            val elementBase = this.items[viewHolder.adapterPosition]
            click.invoke(elementBase)
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val elementBase = items[position]
        holder.bind(elementBase)
    }

    override fun getItemCount() = items.size

    class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: ElementBase) = with(itemView) {

            Picasso.with(context)
                    .load(item.image)
                    .into(itemView.ivRowImage)
            itemView.tvRowName.text = item.name
        }
    }
}
