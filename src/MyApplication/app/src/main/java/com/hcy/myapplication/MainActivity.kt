package com.hcy.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*
import okhttp3.ResponseBody
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.Exception
import kotlin.coroutines.CoroutineContext

class MainActivity : AppCompatActivity() {
    val coroutineScope by lazy { CoroutineScope(Dispatchers.Main) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // main2()
        // main()
        //List()
        // List2()
        // whileItem()
        // WhemMmain()
        //furit()

        // initView()

        initData()
    }

    private fun initData() {
        coroutineScope.launch {
            btn_click.text = getClick()
            Log.e("hcy", "initData: " + getClick())
        }
    }

    suspend fun getClick(): String?{
        val retor = Retrofit.Builder()
            .baseUrl("http://api.ergedd.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val create = retor.create(Api::class.java)
        var aaa: ResponseBody? =null
        try {
            delay(2000L)
            aaa = withContext(Dispatchers.IO) {
                create.get()
            }
        } catch (e:Exception){

        }

        return aaa?.string()
    }

    override fun onDestroy() {
        super.onDestroy()
        coroutineScope.cancel()
    }

    private fun initView() {

        val coroutineScope = CoroutineScope(Dispatchers.Main)
        var text: String = "长度是否徐"
        coroutineScope.launch {
            getImage(1)
        }
        textView.text = text
        textView.setOnClickListener {
            Toast.makeText(this@MainActivity, "dianji l ", Toast.LENGTH_LONG).show()
        }
    }

    suspend fun getImage(i: Int) {
        var aaa = withContext(Dispatchers.IO) {
            println(i)

        }

    }

    fun maxOf(a: Int, b: Int): Int {
        if (a > b) {
            return a
        } else {
            return b
        }
    }

    fun main2() {
        println("max of 0 and 42 is ${maxOf(55, 42)}")
    }

    fun main() {
        // replace替换
        var a = 1
        val s1 = "a is $a"

        a = 2
        val s2 = "${s1.replace("is", "was")},but now is $a"
        println(s2)

    }

    fun List() {
        val listOf = listOf("123", "543", "543")
        for (s in listOf) {
            println(s)
        }
    }

    // 获取集合的下标以及值
    fun List2() {
        val items = listOf("apple", "banana", "kiwifruit")
        for (index in items.indices) {
            println("item at $index is ${items[index]}")
        }
    }


    // While循环
    fun whileItem() {
        val listOf = listOf("张三", "李四", "王麻子")
        var index = 1
        while (index < listOf.size) {
            println("item at $index is ${listOf[index]}")
            index++
        }
    }

    //  when 表达式
    fun WhenItem(obj: Any): String =
        when (obj) {
            1 -> "ONE"
            "Hellow" -> "Greetingf"
            is Long -> "Long"
            !is String -> "Not a String"
            else -> "UnKonw"
        }

    fun WhemMmain() {
        println(WhenItem(1))
        println(WhenItem("Hellow"))
        println(WhenItem(12L))
        println(WhenItem(88))
        println(WhenItem("other"))
    }


/*    * 在（）中加入标识符var 代表主动函数可不写存在*/

    open class Anmaial(age: Int, name: String) {
        //  主构造函数
        var age: Int = 0;
        var name: String

        init {
            this.age = age
            this.name = name
        }

        //次构函数
        constructor(sex: String, age: Int, name: String) : this(age, name)
        constructor(sex: String, age: Int, name: String, hot: String) : this(sex, age, name)
    }


    open class Anmali {
        constructor(age: Int, name: String, sex: String)

    }

    fun furit() {
        var furl = Anmaial("nan", 2, "zhangsan", "chi")
        var furl2 = Anmali(1, "234", "432")
        System.out.println("asd$furl and $furl2")
    }

    override fun toString(): String {
        return super.toString()
    }

    var aa = { a: Int, b: Int -> a + b }
}