package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val list = mutableListOf<String>()
        for (i in 0..100) {
            list.add(Math.random().toString())
        }
        val buttonAdd = findViewById<Button>(R.id.button)
// реакция на нажатие
        buttonAdd.setOnClickListener {
            // добавляем элемент в список
            list.add(Math.random().toString())
            // создаём инстанс адаптера, отдаём ему список
            val adapter = RecyclerAdapter(list)
            // извещаем адаптер об изменениях
            adapter.notifyItemInserted(list.lastIndex)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
// у нас будет линейный список
        recyclerView.layoutManager = LinearLayoutManager(this)
// прикручиваем адаптер к RecyclerView
        recyclerView.adapter = adapter

    }

}

class RecyclerAdapter(private val list: List<String>) :
    RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView.text = list[position]
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView = itemView.findViewById<TextView>(R.id.textView)
    }
}}


