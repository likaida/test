package com.example.likaida.myapplication

import android.util.Log
import java.net.URL

/**
 * Created by likaida on 2017/7/3.
 */
public class Request(val url: String) {
	public fun run() {
		val str = URL(url).readText()
		Log.d(javaClass.simpleName, str)
	}
}