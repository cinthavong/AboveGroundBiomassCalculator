package com.example.carbonsequestrationcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import com.example.carbonsequestrationcalculator.R.id.calculateButton
import kotlin.math.pow
import kotlin.math.sqrt

class MainActivity() : AppCompatActivity(), Parcelable {
    constructor(parcel: Parcel) : this() {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MainActivity> {
        override fun createFromParcel(parcel: Parcel): MainActivity {
            return MainActivity(parcel)
        }

        override fun newArray(size: Int): Array<MainActivity?> {
            return arrayOfNulls(size)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val calculateButton = findViewById<TextView>(R.id.calculateButton)
        calculateButton.setOnClickListener {
            showResult()
        }
    }

    private fun calculateResult(): Double {
        val heightText = findViewById<EditText>(R.id.canopyHeight)
        val widthText = findViewById<EditText>(R.id.canopyWidth)

        val canopyHeight = heightText.text.toString().toDouble()
        val canopyWidth = widthText.text.toString().toDouble()

        val agbResult: Double = canopyHeight.pow(canopyHeight) + canopyWidth.pow(canopyWidth)
        return sqrt(agbResult)
    }

    private fun showResult() {
        val agbResult = calculateResult()

        val agbText: TextView = findViewById(R.id.agbResult)
        val resultText: String = ("%.2f".format(agbResult))

        agbText.text = resultText
    }

}

