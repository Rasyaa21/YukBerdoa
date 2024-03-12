package com.example.kumpulandoadoa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kumpulandoadoa.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private val list = ArrayList<DoaAPIItem>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvPost.setHasFixedSize(true)
        binding.rvPost.layoutManager = LinearLayoutManager(this)

        ApiClient.instance.GetPosts().enqueue(object : Callback<ArrayList<DoaAPIItem>> {
            override fun onResponse(
                call: Call<ArrayList<DoaAPIItem>>,
                response: Response<ArrayList<DoaAPIItem>>
            ) {
                val responseCode = response.code().toString()
                binding.tvApiStatus.text = responseCode

                response.body()?.let { list.addAll(it) }

                val adapter = PostAdapter(list)
                binding.rvPost.adapter = adapter
            }

            override fun onFailure(call: Call<ArrayList<DoaAPIItem>>, t: Throwable) {

            }

        })
    }
}