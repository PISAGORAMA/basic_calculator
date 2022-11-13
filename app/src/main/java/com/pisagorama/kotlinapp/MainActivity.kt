package com.pisagorama.kotlinapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.pisagorama.kotlinapp.databinding.ActivityMainBinding
import kotlin.math.pow

@SuppressLint("SetTextI18n")
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var myCombinedFirstNumber : Double = 0.0
    private var myCombinedFirstNumber1 : Double = 0.0
    private var myCombinedFirstNumber2 : Double = 0.0
    private var myCombinedFirstNumber3 : Double = 0.0
    private var myCombinedFirstNumber4 : Double = 0.0
    private var myCombinedFirstNumber5 : Double = 0.0
    private var myCombinedSecondNumber : Double = 0.0
    private var myCombinedSecondNumber1 : Double = 0.0
    private var myCombinedSecondNumber2 : Double = 0.0
    private var myCombinedSecondNumber3 : Double = 0.0
    private var myCombinedSecondNumber4 : Double = 0.0
    private var myCombinedSecondNumber5 : Double = 0.0
    private var promoterBoolean : Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

    }
    /*

    fun zeroAC(secondPromoterBoolean: Boolean) : Boolean{
        if (zeroAC(true).)
        if (binding.resultView.isEnabled){
            if (binding.button0.isPressed){
                binding.resultView.text = "0"
                zeroAC(false)
            }
        }
        return false
    // when a calculation is done(binding.resultView.text is changed.), clean the calculator monitor when 0 is pressed; it must be called just once.
    }
     */

    fun buttonEqual(view: View) {
        val myResult = binding.calculatorMonitor.text.toString()
        if (myResult.isNotEmpty()){
            if (myResult.all { char -> char.isDigit() }){
                binding.resultView.text = "Error"
            }
            if (myResult.any{char -> char.isDigit()} && myResult.contains(',')){
                binding.resultView.text = "Error"
            }
        try {
            var i = 0
            for (nums in myResult.indices){
                when(myResult[nums]){
                    '+' -> i++
                    '-' -> i++
                    '*' -> i++
                    '/' -> i++
                    '%' -> i++
                }
                if (i >= 2){
                    promoterBoolean = false
                    //binding.resultView.text = "Error"
                    binding.resultView.text = "Error"
                }
            }

        }catch (e : Exception){
            e.printStackTrace()
        }
        if (promoterBoolean){
            for (indexs in myResult.indices){
                if (myResult[indexs] == '*' || myResult[indexs] == '/'){
                    val myOperation = myResult[indexs]
                    val firstVariable = myResult.subSequence(0,indexs).toString()
                    val secondVariable = myResult.subSequence(indexs+1,myResult.length).toString()
                    if (firstVariable.contains(',') && !secondVariable.contains(',')){
                        val ten = 10.0
                        //firstVariable.indexOf(',')
                        val myFirstNewHalf = firstVariable.subSequence(0,firstVariable.indexOf(',')).toString()
                        val mySecondNewHalf = firstVariable.subSequence(firstVariable.indexOf(',')+1, firstVariable.length).toString()
                        val randomVariable = (myFirstNewHalf + mySecondNewHalf).toFloat()/(ten.pow(
                            mySecondNewHalf.length.toDouble()
                        ))
                        myCombinedFirstNumber = randomVariable
                        if (myOperation == '*'){
                            binding.resultView.text = "${myCombinedFirstNumber * secondVariable.toFloat()}"
                        } else if (myOperation == '/'){
                            binding.resultView.text = "${myCombinedFirstNumber / secondVariable.toFloat()}"
                        }
                    }
                    if (firstVariable.contains(',') && secondVariable.contains(',')){
                        val ten = 10.0
                        //firstVariable.indexOf(',')
                        val myFirstNewHalf = firstVariable.subSequence(0,firstVariable.indexOf(',')).toString()
                        val mySecondNewHalf = firstVariable.subSequence(firstVariable.indexOf(',')+1, firstVariable.length).toString()
                        val randomVariable = (myFirstNewHalf + mySecondNewHalf).toFloat()/(ten.pow(
                            mySecondNewHalf.length.toDouble()
                        ))
                        val myFirstNewHalf1 = secondVariable.subSequence(0,secondVariable.indexOf(',')).toString()
                        val mySecondNewHalf1 = secondVariable.subSequence(secondVariable.indexOf(',')+1, secondVariable.length).toString()
                        val randomVariable1 = (myFirstNewHalf1 + mySecondNewHalf1).toFloat()/(ten.pow(
                            mySecondNewHalf.length.toDouble()
                        ))
                        myCombinedFirstNumber1 = randomVariable
                        myCombinedSecondNumber = randomVariable1
                        if (myOperation == '*'){
                            binding.resultView.text = "${myCombinedFirstNumber1 * myCombinedSecondNumber}"
                        } else if (myOperation == '/'){
                            binding.resultView.text = "${myCombinedFirstNumber1 / myCombinedSecondNumber}"
                        }
                    }
                    if (!firstVariable.contains(',') && secondVariable.contains(',')){
                        val ten = 10.0
                        //firstVariable.indexOf(',')
                        val myFirstNewHalf = secondVariable.subSequence(0,secondVariable.indexOf(',')).toString()
                        val mySecondNewHalf = secondVariable.subSequence(secondVariable.indexOf(',')+1, secondVariable.length).toString()
                        val randomVariable = (myFirstNewHalf + mySecondNewHalf).toFloat()/(ten.pow(
                            mySecondNewHalf.length.toDouble()
                        ))
                        myCombinedSecondNumber1 = randomVariable
                        if (myOperation == '*'){
                            binding.resultView.text = "${firstVariable.toFloat() * myCombinedSecondNumber1}"
                        } else if (myOperation == '/'){
                            binding.resultView.text = "${firstVariable.toFloat() / myCombinedSecondNumber1}"
                        }
                    }
                    if (!firstVariable.contains(',') && !secondVariable.contains(',')){
                        if (myOperation == '*'){
                            binding.resultView.text = "${firstVariable.toInt() * secondVariable.toInt()}"
                        } else if (myOperation == '/' && ((firstVariable.toInt() % secondVariable.toInt()) == 0 )){
                            binding.resultView.text = "${firstVariable.toInt() / secondVariable.toInt()}"
                        } else if (myOperation == '/' && ((firstVariable.toInt() % secondVariable.toInt()) != 0)){
                            binding.resultView.text = "${firstVariable.toFloat() / secondVariable.toFloat()}"
                        }
                        //firstVariable.indexOf(',')
                    }
                }

                if (myResult[indexs] == '+' || myResult[indexs] == '-'){
                    val myOperation = myResult[indexs]
                    val firstVariable = myResult.subSequence(0,indexs).toString()
                    val secondVariable = myResult.subSequence(indexs+1,myResult.length).toString()
                    if (firstVariable.contains(',') && !secondVariable.contains(',')){
                        val ten = 10.0
                        //firstVariable.indexOf(',')
                        val myFirstNewHalf = firstVariable.subSequence(0,firstVariable.indexOf(',')).toString()
                        val mySecondNewHalf = firstVariable.subSequence(firstVariable.indexOf(',')+1, firstVariable.length).toString()
                        val randomVariable = (myFirstNewHalf + mySecondNewHalf).toFloat()/(ten.pow(
                            mySecondNewHalf.length.toDouble()
                        ))
                        myCombinedFirstNumber2 = randomVariable
                        if (myOperation == '+'){
                            binding.resultView.text = "${myCombinedFirstNumber2 + secondVariable.toFloat()}"
                        } else if (myOperation == '-'){
                            binding.resultView.text = "${myCombinedFirstNumber2 - secondVariable.toFloat()}"
                        }
                    }
                    if (firstVariable.contains(',') && secondVariable.contains(',')){
                        val ten = 10.0
                        //firstVariable.indexOf(',')
                        val myFirstNewHalf = firstVariable.subSequence(0,firstVariable.indexOf(',')).toString()
                        val mySecondNewHalf = firstVariable.subSequence(firstVariable.indexOf(',')+1, firstVariable.length).toString()
                        val randomVariable = (myFirstNewHalf + mySecondNewHalf).toFloat()/(ten.pow(
                            mySecondNewHalf.length.toDouble()
                        ))
                        val myFirstNewHalf1 = secondVariable.subSequence(0,secondVariable.indexOf(',')).toString()
                        val mySecondNewHalf1 = secondVariable.subSequence(secondVariable.indexOf(',')+1, secondVariable.length).toString()
                        val randomVariable1 = (myFirstNewHalf1 + mySecondNewHalf1).toFloat()/(ten.pow(
                            mySecondNewHalf.length.toDouble()
                        ))
                        myCombinedFirstNumber3 = randomVariable
                        myCombinedSecondNumber2 = randomVariable1
                        if (myOperation == '+'){
                            binding.resultView.text = "${myCombinedFirstNumber3 + myCombinedSecondNumber2}"
                        } else if (myOperation == '-'){
                            binding.resultView.text = "${myCombinedFirstNumber3 - myCombinedSecondNumber2}"
                        }
                    }
                    if (!firstVariable.contains(',') && secondVariable.contains(',')){
                        val ten = 10.0
                        //firstVariable.indexOf(',')
                        val myFirstNewHalf = secondVariable.subSequence(0,secondVariable.indexOf(',')).toString()
                        val mySecondNewHalf = secondVariable.subSequence(secondVariable.indexOf(',')+1, secondVariable.length).toString()
                        val randomVariable = (myFirstNewHalf + mySecondNewHalf).toFloat()/(ten.pow(
                            mySecondNewHalf.length.toDouble()
                        ))
                        myCombinedSecondNumber3 = randomVariable
                        if (myOperation == '+'){
                            binding.resultView.text = "${firstVariable.toFloat() + myCombinedSecondNumber3}"
                        } else if (myOperation == '-'){
                            binding.resultView.text = "${firstVariable.toFloat() - myCombinedSecondNumber3}"
                        }
                    }
                    if (!firstVariable.contains(',') && !secondVariable.contains(',')){
                        if (myOperation == '+'){
                            binding.resultView.text = "${firstVariable.toInt() + secondVariable.toInt()}"
                        } else if (myOperation == '-'){
                            binding.resultView.text = "${firstVariable.toInt() - secondVariable.toInt()}"
                        }
                        //firstVariable.indexOf(',')
                    }
                }
                if (myResult[indexs] == '%'){
                    val firstVariable = myResult.subSequence(0,indexs).toString()
                    val secondVariable = myResult.subSequence(indexs+1,myResult.length).toString()
                    if (firstVariable.contains(',') && !secondVariable.contains(',')){
                        val ten = 10.0
                        //firstVariable.indexOf(',')
                        val myFirstNewHalf = firstVariable.subSequence(0,firstVariable.indexOf(',')).toString()
                        val mySecondNewHalf = firstVariable.subSequence(firstVariable.indexOf(',')+1, firstVariable.length).toString()
                        val randomVariable = (myFirstNewHalf + mySecondNewHalf).toFloat()/(ten.pow(
                            mySecondNewHalf.length.toDouble()
                        ))
                        myCombinedFirstNumber4 = randomVariable
                        binding.resultView.text = "${randomVariable % secondVariable.toInt()}"
                    }
                    if (firstVariable.contains(',') && secondVariable.contains(',')){
                        val ten = 10.0
                        //firstVariable.indexOf(',')
                        val myFirstNewHalf = firstVariable.subSequence(0,firstVariable.indexOf(',')).toString()
                        val mySecondNewHalf = firstVariable.subSequence(firstVariable.indexOf(',')+1, firstVariable.length).toString()
                        val randomVariable = (myFirstNewHalf + mySecondNewHalf).toFloat()/(ten.pow(
                            mySecondNewHalf.length.toDouble()
                        ))
                        val myFirstNewHalf1 = secondVariable.subSequence(0,secondVariable.indexOf(',')).toString()
                        val mySecondNewHalf1 = secondVariable.subSequence(secondVariable.indexOf(',')+1, secondVariable.length).toString()
                        val randomVariable1 = (myFirstNewHalf1 + mySecondNewHalf1).toFloat()/(ten.pow(
                            mySecondNewHalf.length.toDouble()
                        ))
                        myCombinedFirstNumber5 = randomVariable
                        myCombinedSecondNumber4 = randomVariable1
                        binding.resultView.text = "${randomVariable % randomVariable1}"
                    }
                    if (!firstVariable.contains(',') && secondVariable.contains(',')){
                        val ten = 10.0
                        //firstVariable.indexOf(',')
                        val myFirstNewHalf = secondVariable.subSequence(0,secondVariable.indexOf(',')).toString()
                        val mySecondNewHalf = secondVariable.subSequence(secondVariable.indexOf(',')+1, secondVariable.length).toString()
                        val randomVariable = (myFirstNewHalf + mySecondNewHalf).toFloat()/(ten.pow(
                            mySecondNewHalf.length.toDouble()
                        ))
                        myCombinedSecondNumber5 = randomVariable
                        binding.resultView.text ="${firstVariable.toInt() % randomVariable}"
                    }
                    if (!firstVariable.contains(',') && !secondVariable.contains(',')){
                        binding.resultView.text = "${firstVariable.toInt() % secondVariable.toInt()}"
                        //firstVariable.indexOf(',')
                    }
                }
            }

            if (myResult[0] == '+') {
                binding.resultView.text = "Error"
            }
            if (myResult[0] == '-') {
                binding.resultView.text = "Error"
            }
            if (myResult[0] == '*') {
                binding.resultView.text = "Error"
            }
            if (myResult[0] == '/') {
                binding.resultView.text = "Error"
            }
            if (myResult[0] == '%') {
                binding.resultView.text = "Error"
            }
            if (myResult[0] == ',') {
                binding.resultView.text = "Error"
            }

        }
        println(myResult)
        } else if (myResult.isEmpty()) {
        binding.resultView.text = "Error"
        }
    }

    fun buttonMultiply(view: View) {
        if (binding.buttonMultiply.isPressed){
            binding.buttonMultiply.isClickable = false
        }
        binding.calculatorMonitor.text = binding.calculatorMonitor.text.toString() + "*"

    }

    fun buttonComma(view: View) {
        if (binding.buttonComma.isPressed){
            binding.calculatorMonitor.text = binding.calculatorMonitor.text.toString() + ","
        }

    }

    fun buttonExtract(view: View) {
        if (binding.buttonExtract.isPressed){
            binding.buttonExtract.isClickable = false
        }
        binding.calculatorMonitor.text = binding.calculatorMonitor.text.toString() + "-"

    }

    fun buttonSum(view: View) {
        if (binding.buttonSum.isPressed){
            binding.buttonSum.isClickable = false
        }
        binding.calculatorMonitor.text = binding.calculatorMonitor.text.toString() + "+"
    }

    fun buttonPercentager(view: View) {
        if (binding.buttonPercentager.isPressed){
            binding.buttonPercentager.isClickable = false
        }
        binding.calculatorMonitor.text = binding.calculatorMonitor.text.toString() + "%"

    }

    fun buttonReset(view: View) {
        binding.buttonReset.text = "AC"
        binding.resultView.text = ""
        binding.calculatorMonitor.text = ""
        binding.buttonMultiply.isClickable = true
        binding.buttonComma.isClickable = true
        binding.buttonSum.isClickable = true
        binding.buttonExtract.isClickable = true
        binding.buttonPercentager.isClickable = true
        binding.buttonDivide.isClickable = true
        promoterBoolean = true
        myCombinedFirstNumber = 0.0
        myCombinedFirstNumber1 = 0.0
        myCombinedFirstNumber2 = 0.0
        myCombinedFirstNumber3 = 0.0
        myCombinedFirstNumber4 = 0.0
        myCombinedFirstNumber5 = 0.0
        myCombinedSecondNumber = 0.0
        myCombinedSecondNumber1 = 0.0
        myCombinedSecondNumber2 = 0.0
        myCombinedSecondNumber3 = 0.0
        myCombinedSecondNumber4 = 0.0
        myCombinedSecondNumber5 = 0.0

    }

    fun buttonDivide(view: View) {
        if (binding.buttonDivide.isPressed){
            binding.buttonDivide.isClickable = false
        }
        binding.buttonReset.text = "C"
        binding.calculatorMonitor.text = binding.calculatorMonitor.text.toString() + "/"

    }

    fun button0(view: View) {
        binding.buttonReset.text = "C"
        binding.calculatorMonitor.text = binding.calculatorMonitor.text.toString() + "0"

    }

    fun button1(view: View) {
        binding.buttonReset.text = "C"
        binding.calculatorMonitor.text = binding.calculatorMonitor.text.toString() + "1"

    }

    fun button2(view: View) {
        binding.buttonReset.text = "C"
        binding.calculatorMonitor.text = binding.calculatorMonitor.text.toString() + "2"

    }

    fun button3(view: View) {
        binding.buttonReset.text = "C"
        binding.calculatorMonitor.text = binding.calculatorMonitor.text.toString() + "3"

    }

    fun button4(view: View) {
        binding.buttonReset.text = "C"
        binding.calculatorMonitor.text = binding.calculatorMonitor.text.toString() + "4"
    }

    fun button5(view: View) {
        binding.buttonReset.text = "C"
        binding.calculatorMonitor.text = binding.calculatorMonitor.text.toString() + "5"

    }

    fun button6(view: View) {
        binding.buttonReset.text = "C"
        binding.calculatorMonitor.text = binding.calculatorMonitor.text.toString() + "6"
    }


    fun button7(view: View) {
        binding.buttonReset.text = "C"
        binding.calculatorMonitor.text = binding.calculatorMonitor.text.toString() + "7"

    }

    fun button8(view: View) {

        binding.buttonReset.text = "C"
        binding.calculatorMonitor.text = binding.calculatorMonitor.text.toString() + "8"
    }

    fun button9(view: View) {
        binding.buttonReset.text = "C"
        binding.calculatorMonitor.text = binding.calculatorMonitor.text.toString() + "9"
    }
}




