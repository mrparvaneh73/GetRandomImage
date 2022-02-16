package com.example.getrandomimage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.databinding.DataBindingUtil
import com.example.getrandomimage.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var activityResultLauncher: ActivityResultLauncher<Intent>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding=DataBindingUtil.setContentView<ActivityMainBinding>(this,R.layout.activity_main)
        var listcomingsoon= mutableListOf<ImageButton>(
            comingsoon_a,comingsoon_b,comingsoon_c,comingsoon_d)
        for(i in listcomingsoon){
            i.setOnClickListener(this)
        }
        activityResultLauncher=registerForActivityResult(
            ActivityResultContracts.StartActivityForResult(),
            ActivityResultCallback {  })

    }

    override fun onClick(v: View?) {
        val comingsoon=findViewById<ImageButton>(v!!.id)
        val intent=Intent()
        intent.setAction(Intent.ACTION_SEND)
        intent.putExtra(Intent.EXTRA_STREAM,comingsoon.toString())
        intent.setType("text/plain")
        activityResultLauncher.launch(intent)
    }
}