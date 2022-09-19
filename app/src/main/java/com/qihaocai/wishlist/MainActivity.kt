package com.qihaocai.wishlist

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


lateinit var wishlist: List<ItemTemp>
var WishList : MutableList<ItemTemp> = ArrayList()
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var itemList = findViewById<RecyclerView>(R.id.itemList)

        val button = findViewById<Button>(R.id.button)

        var name = findViewById<EditText>(R.id.itemName)
        var price = findViewById<EditText>(R.id.price)
        var url = findViewById<EditText>(R.id.url)

        //val newitem = ItemTemp(name.text.toString(),price.text.toString(), url.text.toString())


        button.setOnClickListener {

            val hidekeyboard = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager

            hidekeyboard.hideSoftInputFromWindow(button.getWindowToken(), 0)


            var newitem = ItemTemp(name.text.toString(), price.text.toString(), url.text.toString())

            name.setText("")
            price.setText("")
            url.setText("")

            WishList.add(newitem)

            var adapter = ListAdapter(WishList)

            itemList.adapter = adapter
            itemList.layoutManager = LinearLayoutManager(this)
        }

//        itemList.layoutManager = LinearLayoutManager(this)

//        WishList.add(newitem)
//
//        val adapter = ListAdapter(WishList)
//
//        itemList.adapter = adapter
//
//        itemList.layoutManager = LinearLayoutManager(this)



    }
}