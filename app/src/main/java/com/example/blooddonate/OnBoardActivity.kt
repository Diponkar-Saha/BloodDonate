package com.example.blooddonate

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.button.MaterialButton

class OnBoardActivity : AppCompatActivity() {
    private lateinit var onBoardingItemAdapter: OnboardingItemAdapter
    private lateinit var indicatorsContainer: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_on_board)
        setOnboardingItem()
        setupIndicators()
        setCurrentIndicator(0)


    }
    private fun setOnboardingItem(){
        onBoardingItemAdapter= OnboardingItemAdapter(
            listOf(
                OnboardingItem(
                    onboardingImage = R.drawable.ppp,
                    title = "Be A Blood Donor",
                    description = "Emergency Mode Is There For You . Become A Blood Donor & Save Lives"
                ),
                OnboardingItem(
                    onboardingImage = R.drawable.pp1,
                    title = "Be A Blood Donor",
                    description = "Emergency Mode Is There For You . Become A Blood Donor & Save Lives"
                )
            )

        )
        val onBoardingViewPager=findViewById<ViewPager2>(R.id.viewPager1)
        onBoardingViewPager.adapter = onBoardingItemAdapter
        onBoardingViewPager.registerOnPageChangeCallback(object :
        ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                setCurrentIndicator(position)
            }
        })
        (onBoardingViewPager.getChildAt(0) as RecyclerView).overScrollMode=
            RecyclerView.OVER_SCROLL_NEVER

        val button1 = findViewById<Button>(R.id.startButton1)

        button1.setOnClickListener() {
            if(onBoardingViewPager.currentItem+1<onBoardingItemAdapter.itemCount){
                onBoardingViewPager.currentItem==1
            }else{
                navigateHome()
            }
        }




    }
    private fun navigateHome(){
        intent = Intent(this, ImageActivity::class.java)
        startActivity(intent)
    }
    private fun setupIndicators(){
        indicatorsContainer=findViewById(R.id.indicatorContainer11)
        val indicators= arrayOfNulls<ImageView>(onBoardingItemAdapter.itemCount)
        val layoutParams:LinearLayout.LayoutParams=
            LinearLayout.LayoutParams(WRAP_CONTENT,WRAP_CONTENT)
        layoutParams.setMargins(0,0,0,0)
        for(i in indicators.indices){
            indicators[i]= ImageView(applicationContext)
            indicators[i]?.let {
                it.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.indicator_inactive
                    )
                )
                it.layoutParams=layoutParams
                indicatorsContainer.addView(it)
            }
        }
    }

    private fun setCurrentIndicator(position:Int){
        val childCount=indicatorsContainer.childCount
        for(i in 0 until childCount){
            val imageView=indicatorsContainer.getChildAt(i) as ImageView
            if(i==position){
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.indicator_active
                    )
                )
            }
        }
    }

}