package com.example.myapplication

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.Toolbar
import android.util.Log
import com.example.myapplication.Adapter.ProductAdapter
import com.example.myapplication.Interface.CommonResponseListener
import com.example.myapplication.Model.ProductModel
import com.example.myapplication.Network.NetworkAccessor
import com.example.myapplication.Network.WebUrls
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject

class MainActivity : AppCompatActivity(), CommonResponseListener
{
    private lateinit var arrList:Array<ProductModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        getProductData()
    }

    private fun getProductData() {
        var networkAccessor= NetworkAccessor()
        var jsoPayload = JSONObject()
        networkAccessor.commonNetworkCall(this@MainActivity,jsoPayload,this@MainActivity,
            WebUrls.BASE_URL,WebUrls.GET_PRODUCTS)
    }

    override fun onSuccessResponse(result: String, from: String, code: Int)
    {

        var gson = Gson()
        val productModel = gson.fromJson(result, Array<ProductModel>::class.java)
        arrList = productModel

        Log.d("DATA JSON", productModel.toString())

        if (arrList.isNotEmpty()) {
            setDataToAdapter()
        }
    }

    override fun onError(msg: String, fromUrl: String) {
        println("Error Message:-$msg")
    }

    private fun setDataToAdapter()
    {
        var linearLayoutManager = LinearLayoutManager(this)
        var adapter = ProductAdapter(arrList)
        recyclerView.layoutManager = linearLayoutManager
        recyclerView.adapter = adapter
    }
}
