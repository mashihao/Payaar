package com.example.pay_aar

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.helloword.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.helloword)
        var pay = "123";

        if (intent!=null&&intent.extras!=null)
        {
            pay = intent.getStringExtra("pay")
        }

        info.text = info.text.toString()+" : "+pay
        gopay.setOnClickListener {
            val url = "scheme://mtime/goodsDetail?goodsId=" + pay

            val intent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse(url)
            )
            startActivityForResult(intent, 102)
        }

        out.setOnClickListener { this.finish() }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (data != null) {
            gopay.text = data.extras.getString("payresult")

            val intent = Intent()
            intent.putExtra("payresult",data.extras.getString("payresult"))
            setResult(102,intent)
            this.finish()
        }
    }
}
