package com.example.myapplication

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.Adapter.MyProductAdapter
import com.example.myapplication.Common.Common
import com.example.myapplication.Interface.RetrofitService
import com.example.myapplication.Model.Product
import dmax.dialog.SpotsDialog
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var mService : RetrofitService
    lateinit var layoutManager: LinearLayoutManager
    lateinit var adapter : MyProductAdapter
    lateinit var dialog: AlertDialog


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mService = Common.retrofitService

        recyclerProductList.setHasFixedSize(true)
        layoutManager = LinearLayoutManager(this)
        recyclerProductList.layoutManager = layoutManager

        dialog = SpotsDialog.Builder().setCancelable(false).setContext(this).build()

        getAllProductList()
    }

    private fun getAllProductList() {
        dialog.show()

        mService.getProductList().enqueue(object : Callback<MutableList<Product>> {
            override fun onFailure(call: Call<MutableList<Product>>, t: Throwable) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onResponse(call: Call<MutableList<Product>>, response: Response<MutableList<Product>>) {
                adapter = MyProductAdapter(baseContext, response.body() as MutableList<Product>)
                adapter.notifyDataSetChanged()
                recyclerProductList.adapter = adapter

                dialog.dismiss()
            }

        })
    }
}
