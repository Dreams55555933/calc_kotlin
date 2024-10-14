package ru.ievetrov.calc

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        val result3Text = findViewById<TextView>(R.id.text3)


        val button_1 = findViewById<Button>(R.id.button1)
        val button_2 = findViewById<Button>(R.id.button2)
        val button_3 = findViewById<Button>(R.id.button3)
        val button_4 = findViewById<Button>(R.id.button4)
        val button_5 = findViewById<Button>(R.id.button5)
        val button_6 = findViewById<Button>(R.id.button6)
        val button_7 = findViewById<Button>(R.id.button7)
        val button_8 = findViewById<Button>(R.id.button8)
        val button_9 = findViewById<Button>(R.id.button9)
        val button_add = findViewById<Button>(R.id.button_add)
        val button_sub = findViewById<Button>(R.id.button_sub)
        val button_multi = findViewById<Button>(R.id.button_multi)
        val button_div = findViewById<Button>(R.id.button_div)
        val button_0 = findViewById<Button>(R.id.button0)
        val button_equals = findViewById<Button>(R.id.button_equals)
        val button_dot = findViewById<Button>(R.id.button_dot)
        val button_clear = findViewById<Button>(R.id.button_clear)

        findViewById<TextView>(R.id.text3).text = ""

        button_1.setOnClickListener {update("1")}
        button_2.setOnClickListener {update("2")}
        button_3.setOnClickListener {update("3")}
        button_4.setOnClickListener {update("4")}
        button_5.setOnClickListener {update("5")}
        button_6.setOnClickListener {update("6")}
        button_7.setOnClickListener {update("7")}
        button_8.setOnClickListener {update("8")}
        button_9.setOnClickListener {update("9")}
        button_0.setOnClickListener {update("0")}
        button_dot.setOnClickListener {update(".")}

        button_add.setOnClickListener {mark("+")}
        button_sub.setOnClickListener {mark("-")}
        button_multi.setOnClickListener {mark("x")}
        button_div.setOnClickListener {mark("/")}

        button_equals.setOnClickListener {result()}
        button_clear.setOnClickListener {clear()}
    }
    fun clear(){
        findViewById<TextView>(R.id.text1).text=""
        findViewById<TextView>(R.id.text3).text=""
    }
    fun update(num: String) {
        if (findViewById<TextView>(R.id.text3).text=="0"){
            findViewById<TextView>(R.id.text3).text = ""
            val res: String = findViewById<TextView>(R.id.text3).text.toString() + num
            findViewById<TextView>(R.id.text3).text = res
        }else{
            val res: String = findViewById<TextView>(R.id.text3).text.toString() + num
            findViewById<TextView>(R.id.text3).text = res
        }
    }
    fun mark(mark: String) {
        val resultText1 = findViewById<TextView>(R.id.text1)
        val resultText2 = findViewById<TextView>(R.id.text2)
        val resultText3 = findViewById<TextView>(R.id.text3)

        resultText1.text = resultText3.text
        resultText2.text = mark
        resultText3.text = "0"
    }
    fun result() {
        val num1Text = findViewById<TextView>(R.id.text1).text.toString()
        val num2Text = findViewById<TextView>(R.id.text3).text.toString()
        try {
            val num1 = num1Text.toDouble()
            val num2 = num2Text.toDouble()
            when(findViewById<TextView>(R.id.text2).text)
            {
                "+"->findViewById<TextView>(R.id.text3).text = if(hasDecimalPart(num1+num2)){(num1+num2).toString()}else{(num1+num2).toInt().toString()}
                "-"->findViewById<TextView>(R.id.text3).text = if(hasDecimalPart(num1+num2)){(num1-num2).toString()}else{(num1-num2).toInt().toString()}
                "x"->findViewById<TextView>(R.id.text3).text = if(hasDecimalPart(num1+num2)){(num1*num2).toString()}else{(num1*num2).toInt().toString()}
                "/"->if (num2==0.0){findViewById<TextView>(R.id.text3).text="На 0 делить нельзя"}else if (hasDecimalPart(num1/num2)){findViewById<TextView>(R.id.text3).text = (num1/num2).toString()}else{findViewById<TextView>(R.id.text3).text = (num1/num2).toInt().toString()}
            }
        }catch (e: NumberFormatException) {
            findViewById<TextView>(R.id.text3).text = "Ошибка"
        }

    }
    fun hasDecimalPart(number: Double): Boolean {
        return number % 1 != 0.0
    }
}

