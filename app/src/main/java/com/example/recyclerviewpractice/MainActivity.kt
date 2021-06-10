package com.example.recyclerviewpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerviewpractice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // Datas 타입의 리스트
    var datas = mutableListOf<Datas>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val mainbinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainbinding.root)

        // MyAdapter를 생성 후 recyclerview의 adapter로 선언해줍니다.
        val myAdapter = MyAdapter(this)
        mainbinding.recyclerView.adapter = myAdapter

        // layout을 생성 후 recyclerview의 adapter로 선언해줍니다.
        val layout = LinearLayoutManager(this)
        mainbinding.recyclerView.layoutManager = layout

        datas.apply {
            add(Datas(name = "AAA",num = 111))
            add(Datas(name = "BBB",num = 222))
            add(Datas(name = "CCC",num = 333))
            add(Datas(name = "DDD",num = 444))
            add(Datas(name = "EEE",num = 555))
            add(Datas(name = "FFF",num = 666))
            add(Datas(name = "GGG",num = 777))
            add(Datas(name = "HHH",num = 888))
            add(Datas(name = "III",num = 999))
            add(Datas(name = "JJJ",num = 123))
            add(Datas(name = "KKK",num = 456))
            myAdapter.datas = datas
            myAdapter.notifyDataSetChanged()
        }

    }

}