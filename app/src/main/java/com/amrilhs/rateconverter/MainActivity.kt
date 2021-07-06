package com.amrilhs.rateconverter

import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.amrilhs.rateconverter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.rbDollar.isChecked = true
        binding.rbRupiah.isChecked = false

        binding.rbDollar.setOnClickListener {
            if (binding.rbDollar.isChecked) {
                binding.rbRupiah.isChecked = false
            }
        }
        binding.rbRupiah.setOnClickListener {
            if (binding.rbRupiah.isChecked) {
                binding.rbDollar.isChecked = false
            }
        }
        binding.btnConvert.setOnClickListener {
            //check Empty or not
            if (TextUtils.isEmpty(binding.editTextValue.text.toString().trim())) {
                Toast.makeText(this, "This field is required", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            } else { // converting...
                if (binding.rbDollar.isChecked) {
                    val editTextConvert =  binding.editTextValue.text.toString().trim()
                    val dollar = 14483.05
                    val convertToDollar = String.format("Rp.%.2f", dollar *  editTextConvert.toDouble())
                    binding.txtResult.text = convertToDollar
                }
                if (binding.rbRupiah.isChecked) {
                    val editTextConvert =  binding.editTextValue.text.toString().trim().toDouble()
                    val rupiah = 14483.05
                    val convertToRupiah = String.format("$%.5f", editTextConvert / rupiah)
                    binding.txtResult.text = convertToRupiah
                }

            }

        }//end binding btnConvert

        binding.btnClear.setOnClickListener {
            binding.editTextValue.text.clear()
            binding.txtResult.text = resources.getString(R.string.hasil2)
            binding.rbDollar.isChecked=true
            binding.rbRupiah.isChecked =false
        }

    }
}