package com.example.candostlar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detay2.*

class DetayActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detay2)

        var gelenIntent= intent
        if(gelenIntent !=null){
            txtDetay.text=gelenIntent.getStringExtra("ad")
            imgDetay.setImageResource(gelenIntent.getIntExtra("resim",R.drawable.ani_cat_five))
        }

    }
}
