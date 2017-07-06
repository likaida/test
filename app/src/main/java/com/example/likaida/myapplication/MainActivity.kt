package com.example.likaida.myapplication

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import org.jetbrains.anko.coroutines.experimental.bg
import org.jetbrains.anko.ctx
import org.jetbrains.anko.find
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {
	private var items: List<String>? = null
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)
		initDate()
		initView()
		initListener()
	}

	private fun initListener() {
		click.setOnClickListener {
			async(UI) {
				bg {
					Request("https://www.baidu.com/").run()
				}
			}
			toast("click")
		}
	}

	private fun initView() {
//		val forecastList = findViewById(R.id.forecast_list) as RecyclerView
		val forecastList: RecyclerView = find(R.id.forecast_list)
		forecastList.layoutManager = LinearLayoutManager(this)
		forecastList.adapter = ForecastListAdapter(items as List<String>)
	}

	private fun initDate() {
		items = listOf(
				"Mon 6/23 - Sunny - 31/17",
				"Tue 6/24 - Foggy - 21/8",
				"Wed 6/25 - Cloudy - 22/17",
				"Thurs 6/26 - Rainy - 18/11",
				"Fri 6/27 - Foggy - 21/10",
				"Sat 6/28 - TRAPPED IN WEATHERSTATION - 23/18",
				"Sun 6/29 - Sunny - 20/7",
				"Mon 6/23 - Sunny - 31/17",
				"Tue 6/24 - Foggy - 21/8",
				"Wed 6/25 - Cloudy - 22/17",
				"Thurs 6/26 - Rainy - 18/11",
				"Fri 6/27 - Foggy - 21/10",
				"Sat 6/28 - TRAPPED IN WEATHERSTATION - 23/18",
				"Sun 6/29 - Sunny - 20/7",
				"Mon 6/23 - Sunny - 31/17",
				"Tue 6/24 - Foggy - 21/8",
				"Wed 6/25 - Cloudy - 22/17",
				"Thurs 6/26 - Rainy - 18/11",
				"Fri 6/27 - Foggy - 21/10",
				"Sat 6/28 - TRAPPED IN WEATHERSTATION - 23/18",
				"Sun 6/29 - Sunny - 20/7",
				"Mon 6/23 - Sunny - 31/17",
				"Tue 6/24 - Foggy - 21/8",
				"Wed 6/25 - Cloudy - 22/17",
				"Thurs 6/26 - Rainy - 18/11",
				"Fri 6/27 - Foggy - 21/10",
				"Sat 6/28 - TRAPPED IN WEATHERSTATION - 23/18",
				"Sun 6/29 - Sunny - 20/7",
				"Mon 6/23 - Sunny - 31/17",
				"Tue 6/24 - Foggy - 21/8",
				"Wed 6/25 - Cloudy - 22/17",
				"Thurs 6/26 - Rainy - 18/11",
				"Fri 6/27 - Foggy - 21/10",
				"Sat 6/28 - TRAPPED IN WEATHERSTATION - 23/18",
				"Sun 6/29 - Sunny - 20/7"
		)
	}

	fun Context.showToast(message: CharSequence, time: Int = Toast.LENGTH_SHORT) {
		Toast.makeText(this.ctx, message, time).show()
	}
}
