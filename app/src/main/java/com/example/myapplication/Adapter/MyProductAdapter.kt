package com.example.myapplication.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.Model.Product
import com.example.myapplication.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.layout_product_item.view.*

class MyProductAdapter (private val context: Context, private val productList: MutableList<Product>):
    RecyclerView.Adapter<MyProductAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var itemView = LayoutInflater.from(context).inflate(R.layout.layout_product_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        Picasso.get().load(productList[position].imageurl).into(holder.image)
        holder.txt_name.text = productList[position].title
        holder.txt_price.text = productList[position].price
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var image : ImageView
        var txt_name : TextView
        var txt_price : TextView

        init {
            image = itemView.image_product
            txt_name = itemView.txt_title
            txt_price = itemView.txt_price
        }
    }
}