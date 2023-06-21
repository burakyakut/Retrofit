package com.example.kotlinretrofitapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kotlinretrofitapp.databinding.CountryRowBinding
import com.example.kotlinretrofitapp.model.CountryModel

class CountryAdapter(private val countryList:ArrayList<CountryModel>):RecyclerView.Adapter<CountryAdapter.CountryHolder>() {

    class CountryHolder(private val countryRowBinding: CountryRowBinding):RecyclerView.ViewHolder(countryRowBinding.root){
        fun bind(countryModel: CountryModel){
            countryRowBinding.countryRowName.text=countryModel.name
            countryRowBinding.countryRowCapital.text=countryModel.capital
            countryRowBinding.countryRowRegion.text=countryModel.region
            countryRowBinding.countryRowCurrency.text=countryModel.currency
            countryRowBinding.countryRowLanguage.text=countryModel.language


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryHolder {
        return CountryHolder(CountryRowBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
        return countryList.size
    }

    override fun onBindViewHolder(holder: CountryHolder, position: Int) {
        holder.bind(countryList[position])

    }
}