package com.example.blooddonate

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class OnboardingItemAdapter(private val onboardingItem: List<OnboardingItem>):
RecyclerView.Adapter<OnboardingItemAdapter.OnboardingViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnboardingViewHolder {
        return OnboardingViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item,
                parent,
                false
            )
        )
    }
    override fun onBindViewHolder(holder: OnboardingViewHolder, position: Int) {
         holder.bind(onboardingItem[position])

    }

    override fun getItemCount(): Int {
        return onboardingItem.size
    }




    inner class OnboardingViewHolder(view:View):RecyclerView.ViewHolder(view){
        private val imageOnboarding=view.findViewById<ImageView>(R.id.onboardingImage)
        private val textTitle=view.findViewById<TextView>(R.id.textTitle)
        private val textDescription=view.findViewById<TextView>(R.id.textDesc)

        fun bind(onboardingItem:OnboardingItem){
            imageOnboarding.setImageResource(onboardingItem.onboardingImage)
            textTitle.text=onboardingItem.title
            textDescription.text=onboardingItem.description
        }
    }


}