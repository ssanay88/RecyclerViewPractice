package com.example.recyclerviewpractice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerviewpractice.databinding.ActivityMainBinding
import com.example.recyclerviewpractice.databinding.RecyclerviewItemBinding
import java.util.*

class MainActivity : AppCompatActivity() {

    // Datas 타입의 리스트
    var datas = mutableListOf<Datas>()

    // 오늘 날짜로 캘린더 객체 생성
    val calendar: Calendar = Calendar.getInstance()
    var TAG : String = "로그"


    // 년도, 월, 일 변수를 선언
    var selected_year = calendar.get(Calendar.YEAR)
    var selected_month = calendar.get(Calendar.MONTH) + 1
    var selected_day = calendar.get(Calendar.DAY_OF_MONTH)
    var selected_date : String = selected_year.toString() + selected_month.toString() + selected_day.toString()

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

        mainbinding.CalendarView.setOnDateChangeListener { view, year, month, dayOfMonth ->

            selected_day = dayOfMonth
            selected_month = month+1
            selected_year = year
            selected_date = selected_year.toString() + selected_month.toString() + selected_day.toString()
            Log.d(TAG,"오늘 날짜는 $year - ${month+1} - $dayOfMonth 입니다.")
        }


        myAdapter.setonBtnClickListener(object : MyAdapter.onBtnClickListener{
            override fun onBtnClick(v : RecyclerviewItemBinding,datas: Datas) {

            var intent = Intent(this@MainActivity,MainActivity2::class.java).apply {
                putExtra("NUM", datas.num.toString())
                putExtra("DATE", selected_date)
            }
            startActivity(intent)
            }
        })



    }

}