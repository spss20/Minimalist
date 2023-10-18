package com.example.myapplication.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.models.App

class AppsAdapter(private val context: Context, private val appsList: List<App>)
    : RecyclerView.Adapter<AppsAdapter.AppViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AppViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.app_item , parent , false)
        return AppViewHolder(view)
    }

    override fun getItemCount(): Int {
        return appsList.size;
    }

    override fun onBindViewHolder(holder: AppViewHolder, position: Int) {
        val app = appsList[position];
        holder.appName.text = app.name;
    }

    class AppViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
       val appName: TextView = itemView.findViewById(R.id.app_name);
    }
}