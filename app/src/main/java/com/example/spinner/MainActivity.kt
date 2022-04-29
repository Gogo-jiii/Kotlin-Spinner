package com.example.spinner

import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.view.View.OnTouchListener
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), OnTouchListener, AdapterView.OnItemSelectedListener {

    var data = arrayOf<String?>("a", "b", "c", "d", "e")
    var isSpinnerTouched = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter: ArrayAdapter<*> =
            ArrayAdapter<Any?>(this, com.google.android.material.R.layout.support_simple_spinner_dropdown_item, data)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.setAdapter(adapter)
        spinner.setOnTouchListener(this)
        spinner.setOnItemSelectedListener(this)
    }

    override fun onTouch(view: View, motionEvent: MotionEvent): Boolean {
        isSpinnerTouched = true
        return false
    }

    override fun onItemSelected(adapterView: AdapterView<*>?, view: View, i: Int, l: Long) {
        if (isSpinnerTouched) {
            isSpinnerTouched = false
            Toast.makeText(this@MainActivity, "Selected: " + data[i], Toast.LENGTH_SHORT).show()
        }
    }

    override fun onNothingSelected(adapterView: AdapterView<*>?) {}
}