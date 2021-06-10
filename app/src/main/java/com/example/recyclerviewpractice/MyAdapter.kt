package com.example.recyclerviewpractice

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CalendarView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class MyAdapter(private val context:Context) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    var datas = mutableListOf<Datas>()

    val calendar : Calendar = Calendar.getInstance()

    var selected_year = calendar.get(Calendar.YEAR)
    var selected_month = calendar.get(Calendar.MONTH) + 1
    var selected_day = calendar.get(Calendar.DAY_OF_MONTH)



    // 뷰 홀더를 생성 만들어둔 아이템 뷰를 연결
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val view = LayoutInflater.from(context).inflate(R.layout.recyclerview_item,parent,false)
        return MyViewHolder(view)
    }

    // 뷰 홀더에 데이터를 연결시키는 메소드
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(datas[position])
        
        holder.cal.setOnDateChangeListener { view, year, month, dayOfMonth ->
            selected_day = dayOfMonth
            selected_month = month+1
            selected_year = year
        }

        holder.btn.setOnClickListener {
            var intent = Intent(context,MainActivity2::class.java).apply {
                putExtra("NUM", holder.btn.text)
                putExtra("DATE", selected_year + selected_month + selected_day)
            }
            startActivity(context,intent,null)

        }

    }

    // 데이터의 사이즈를 카운트할 때 사용
    override fun getItemCount(): Int {
            return datas.size
    }

    // 뷰 홀더 클래스
    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private var TextTitle:TextView = view.findViewById(R.id.textView)
        var cal:CalendarView = view.findViewById(R.id.calendarView)

        // 버튼 사용을 위한 선언
        var btn:Button = view.findViewById(R.id.button)

        // 데이터를 뷰에 연결 시키는 함수
        fun bind(item : Datas) {
            TextTitle.text = item.name
            btn.text = item.num.toString()

        }

    }
}