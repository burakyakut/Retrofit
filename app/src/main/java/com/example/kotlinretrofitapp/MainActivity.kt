package com.example.kotlinretrofitapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlinretrofitapp.adapter.CountryAdapter
import com.example.kotlinretrofitapp.databinding.ActivityMainBinding
import com.example.kotlinretrofitapp.model.CountryModel
import com.example.kotlinretrofitapp.service.CountryAPI
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private  val BASE_URL="https://raw.githubusercontent.com/"
    private var countryList:ArrayList<CountryModel>?=null
    private lateinit var countryAdapter: CountryAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.recyclerView.layoutManager=LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        loadCountryData()

        //https://raw.githubusercontent.com/
        //atilsamancioglu/IA19-DataSetCountries/master/countrydataset.json
    }

    private fun loadCountryData(){
        val retrofit=Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service=retrofit.create(CountryAPI::class.java)
        val call=service.getCountryData()
        
        call.enqueue(object : Callback<List<CountryModel>> {
            override fun onResponse(
                call: Call<List<CountryModel>>,
                response: Response<List<CountryModel>>
            ) {
                if (response.isSuccessful){
                    response.body()?.let {
                        countryList= ArrayList(it)

                        countryList?.let {
                            countryAdapter=CountryAdapter(countryList!!)
                            binding.recyclerView.adapter=countryAdapter
                        }
                    }

                }
            }

            override fun onFailure(call: Call<List<CountryModel>>, t: Throwable) {
                t.printStackTrace()
            }
        })


    }
}