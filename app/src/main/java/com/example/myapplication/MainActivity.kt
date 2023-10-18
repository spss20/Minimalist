package com.example.myapplication

import android.content.pm.ApplicationInfo
import android.content.pm.PackageManager
import android.content.pm.PackageManager.ApplicationInfoFlags
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.adapters.AppsAdapter
import com.example.myapplication.models.App

class MainActivity : AppCompatActivity() {

    private lateinit var appsRecycler: RecyclerView;
    private lateinit var adapter: AppsAdapter;
    private val appsList: MutableList<App> = ArrayList();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        appsRecycler = findViewById(R.id.apps_recycler);
        adapter = AppsAdapter(this , appsList)

        //Setting up recyclerView
        appsRecycler.layoutManager = LinearLayoutManager(this);
        appsRecycler.adapter = adapter;

        //Setting Fake Data
        appsList.add(App("Surya"))
        appsList.add(App("Krishna"))
        appsList.add(App("Hello Hello"))
        appsList.add(App("Challenge Tracker"))
        adapter.notifyDataSetChanged();

        findPackageNames()

    }

    fun findPackageNames(){
        val appsList = packageManager.getInstalledApplications(PackageManager.GET_META_DATA);
        for(app in appsList){
            if(app.flags and ApplicationInfo.FLAG_SYSTEM != 1){
                //User App
                println("App Name: ${app.loadLabel(packageManager)}");
            }
        }
    }
}