package com.example.thirdapp

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.pay_aar.MainActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        gopay.setOnClickListener {


            val intent = Intent(this,MainActivity::class.java)

            intent.putExtra("pay",edit.text.toString())

            startActivityForResult(intent, 102)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (data != null) {
            gopay.text = "支付结果："+data.extras.getString("payresult")
            info.text = "支付结果："+data.extras.getString("payresult")
        }
    }
}
