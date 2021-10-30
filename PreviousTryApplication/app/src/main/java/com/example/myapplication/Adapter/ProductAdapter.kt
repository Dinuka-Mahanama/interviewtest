package com.example.myapplication.Adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.myapplication.Model.ProductModel
import com.example.myapplication.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.single_product_details.view.*

class ProductAdapter(private val arrList: Array<ProductModel>) : RecyclerView.Adapter<CustomViewHolder>()
{

    override fun getItemCount()=arrList.size
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val layoutInflater= LayoutInflater.from(parent?.context)
        val cellRow=layoutInflater.inflate(R.layout.single_product_details,parent,false)
        return CustomViewHolder(cellRow)
    }
    override fun onBindViewHolder(holder: CustomViewHolder, position: Int)
    {
        holder.bindItems(arrList[position])
    }
}

class CustomViewHolder(view: View): RecyclerView.ViewHolder(view)
{
    fun bindItems(productModel: ProductModel)
    {
        try {

            itemView.textView_title.text = "Name: "+productModel.title
            itemView.textView_price.text= productModel.price

            Picasso.get().load(productModel.image).into(itemView.imageView_product)

            itemView.setOnClickListener({
                Toast.makeText(itemView.context, "Clicked Position $position", Toast.LENGTH_SHORT).show()
            })


        }catch (e:Exception){
            println(e.message)
        }
    }

}