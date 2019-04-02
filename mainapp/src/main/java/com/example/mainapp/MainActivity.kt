package com.example.mainapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.net.Proxy.getHost
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val data = intent.data
        if (data!=null)
        {
            val param = data.getQueryParameter("goodsId")
            Toast.makeText(this,param,Toast.LENGTH_SHORT).show()
            info.text = "获取的参数为：$param"
        }

        back.setOnClickListener {

            val intent = Intent()
            intent.putExtra("payresult","paysuccess")
            setResult(102,intent)
            finish()
        }

    }
}
