package com.paneschidos.divisas

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import com.paneschidos.divisas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

//rivate lateinit var binding: ResultProfileBinding
    override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    val binding = ActivityMainBinding.inflate(layoutInflater)
    setContentView(binding.root)
    val spinner = binding.spinner
    val spinner2 = binding.spinner2
    val btnConvert = binding.btnConvertir
    val cantidadx = binding.num
    val conv = binding.conv



    ArrayAdapter.createFromResource(
        this,
        R.array.array_divisas,
        android.R.layout.simple_spinner_item
    ).also { adapter ->
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        // Apply the adapter to the spinner
        spinner.adapter = adapter
        spinner2.adapter = adapter
    }

    binding.btnConvertir.setOnClickListener {
        val select1 = binding.spinner.selectedItem.toString()
        val select2 = binding.spinner2.selectedItem.toString()
        R.array.array_divisas
        if (select1=="MXN"&&select2=="DLS") {
            conv.text= (cantidadx.text.toString().toDouble()*0.050).toString()
            }
        else if (select1=="MXN"&&select2=="EU") {
            conv.text = ((cantidadx.text.toString().toDouble()*0.051).toString().format("%.2f"))
        }
        else if (select1=="DLS"&&select2=="MXN") {
            conv.text= ((cantidadx.text.toString().toDouble()*20).toString().format("%.2f"))
        }
        else if (select1=="DLS"&&select2=="EU") {
            conv.text= ((cantidadx.text.toString().toDouble()*1.01).toString().format("%.2f"))
        }
        else if (select1=="EU"&&select2=="MXN") {
            conv.text= ((cantidadx.text.toString().toDouble()*19.74).toString().format("%.2f"))
        }
        else if (select1=="EU"&&select2=="DLS") {
            conv.text= ((cantidadx.text.toString().toDouble()*0.99).toString().format("%.2f"))
        }
        }

    }

}
    /*fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        TODO("Not yet implemented")

        val selected = R.array.array_divisas
        if (p0?.id == Spinner.NO_ID) {
            selected = R.array.array_divisas
        }
        if (p0?.id == Spinner.NO_ID) {
            selected = R.array.array_divisas
        }

    }

    fun onNothingSelected(p0: AdapterView<*>?) {
        TODO("Not yet implemented")
    }*/
