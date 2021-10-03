package com.example.calculaterapp

import android.R.attr
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.R.attr.y

import android.R.attr.x
import android.widget.Toast


class MainActivity : AppCompatActivity() {


    lateinit var EquatinView: TextView
    var Equatin: String = ""
    var result: Float = 0F
    var indexOfOp = 0

    lateinit var button1: Button
    lateinit var button2: Button
    lateinit var button3: Button
    lateinit var button4: Button
    lateinit var button5: Button
    lateinit var button6: Button
    lateinit var button7: Button
    lateinit var button8: Button
    lateinit var button9: Button
    lateinit var button0: Button
    lateinit var buttonSub: Button
    lateinit var buttonAdd: Button
    lateinit var buttonMul: Button
    lateinit var buttonDiv: Button
    lateinit var buttonNeg: Button
    lateinit var buttonEqu: Button
    lateinit var buttonDEL: Button
    lateinit var buttonDot: Button
    lateinit var buttonC: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        EquatinView = findViewById(R.id.equation)
        button0 = findViewById(R.id.button0)
        button1 = findViewById(R.id.button1)
        button2 = findViewById(R.id.button2)
        button3 = findViewById(R.id.button3)
        button4 = findViewById(R.id.button4)
        button5 = findViewById(R.id.button5)
        button6 = findViewById(R.id.button6)
        button7 = findViewById(R.id.button7)
        button8 = findViewById(R.id.button8)
        button9 = findViewById(R.id.button9)
        buttonAdd = findViewById(R.id.buttonAdd)
        buttonMul = findViewById(R.id.buttonMul)
        buttonSub = findViewById(R.id.buttonSub)
        buttonDiv = findViewById(R.id.buttonDiv)
        buttonNeg = findViewById(R.id.buttonNeg)
        buttonDEL = findViewById(R.id.buttonDEL)
        buttonEqu = findViewById(R.id.buttonEqula)
        buttonDot = findViewById(R.id.buttonDot)
        buttonC = findViewById(R.id.buttonC)




        button0.setOnClickListener {
            Equatin += "0"
            EquatinView.text = Equatin

        }

        button1.setOnClickListener {
            Equatin += "1"
            EquatinView.text = Equatin

        }
        button2.setOnClickListener {
            Equatin += "2"
            EquatinView.text = Equatin

        }
        button3.setOnClickListener {
            Equatin += "3"
            EquatinView.text = Equatin

        }
        button4.setOnClickListener {
            Equatin += "4"
            EquatinView.text = Equatin

        }
        button5.setOnClickListener {
            Equatin += "5"
            EquatinView.text = Equatin

        }
        button6.setOnClickListener {
            Equatin += "6"
            EquatinView.text = Equatin

        }
        button7.setOnClickListener {
            Equatin += "7"
            EquatinView.text = Equatin

        }

        button8.setOnClickListener {
            Equatin += "8"
            EquatinView.text = Equatin

        }
        button9.setOnClickListener {
            Equatin += "9"
            EquatinView.text = Equatin

        }
        buttonDiv.setOnClickListener {

            if (Equatin.isNotEmpty() && Equatin[Equatin.length - 1].isDigit()) {


                if ((Equatin.contains('/') || Equatin.contains('+') || Equatin.contains('-')
                            || Equatin.contains('*'))
                ) { //if there is equation
                    calculater()
                    Equatin += "/"
                    EquatinView.text = Equatin

                } else {
                    Equatin += "/"
                    EquatinView.text = Equatin
                }
            }


        }
        buttonAdd.setOnClickListener {
            if (Equatin.isNotEmpty() && Equatin[Equatin.length - 1].isDigit()) {


                if ((Equatin.contains('/') || Equatin.contains('+') || Equatin.contains('-')
                            || Equatin.contains('*'))
                ) { //if there is equation
                    calculater()
                    Equatin += "+"
                    EquatinView.text = Equatin

                } else {
                    Equatin += "+"
                    EquatinView.text = Equatin
                }
            }


        }



        buttonSub.setOnClickListener {
            if (Equatin.isNotEmpty() && Equatin[Equatin.length - 1].isDigit()) {


                if ((Equatin.contains('/') || Equatin.contains('+') || Equatin.contains('-')
                            || Equatin.contains('*'))
                ) { //if there is equation
                    calculater()
                    Equatin += "-"
                    EquatinView.text = Equatin

                } else {
                    Equatin += "-"
                    EquatinView.text = Equatin
                }
            }

        }
        buttonMul.setOnClickListener {
            if (Equatin.isNotEmpty() && Equatin[Equatin.length - 1].isDigit()) {


                if ((Equatin.contains('/') || Equatin.contains('+') || Equatin.contains('-')
                            || Equatin.contains('*'))
                ) { //if there is equation
                    calculater()
                    Equatin += "*"
                    EquatinView.text = Equatin

                } else {
                    Equatin += "*"
                    EquatinView.text = Equatin
                }
            }

        }


        buttonDot.setOnClickListener {
            if (Equatin == "") {
            } else {
                Equatin += "."
                EquatinView.text = Equatin
            }

        }
        buttonDEL.setOnClickListener {

             Equatin = Equatin.substring(0,Equatin.length-1)
            EquatinView.text = Equatin

        }
        buttonNeg.setOnClickListener {
            Equatin += "-"
            EquatinView.text = Equatin

        }
        buttonC.setOnClickListener {
            Equatin = ""
            EquatinView.text = Equatin

        }









        buttonEqu.setOnClickListener {

            calculater()


        }


    }

    private fun calculater() {
        indexOfOp = 0
        for (i in Equatin) {
            if (i == '/' || i == '-' || i == '+' || i == '*') {
                break
            }
            indexOfOp++
        }
        var eq1 = Equatin.subSequence(0, indexOfOp).toString().toFloat()
        var operatin = Equatin[indexOfOp]
        var eq2 = Equatin.subSequence(indexOfOp + 1, Equatin.length).toString().toFloat()

        if (operatin == '+') {

            result = eq1 + eq2
        } else if (operatin == '-') {
            result = eq1 - eq2
        } else if (operatin == '/') {

            if (eq2.toFloat().toString() == "0.0") {
                Toast.makeText(this, "Error : divide by 0 !", Toast.LENGTH_LONG).show()

            } else {
                result = eq1 / eq2

            }

        } else {
            result = eq1 * eq2
        }
        Equatin = String.format("%.2f", result).toString()
        EquatinView.text = Equatin


    }
}