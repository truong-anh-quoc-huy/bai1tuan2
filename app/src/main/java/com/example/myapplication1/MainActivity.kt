package com.example.ageclassifier

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication1.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edtName = findViewById<EditText>(R.id.edtName)
        val edtAge = findViewById<EditText>(R.id.edtAge)
        val btnCheck = findViewById<Button>(R.id.btnCheck)
        val tvResult = findViewById<TextView>(R.id.tvResult)

        btnCheck.setOnClickListener {
            val name = edtName.text.toString()
            val ageText = edtAge.text.toString()

            if (name.isEmpty() || ageText.isEmpty()) {
                tvResult.text = "Vui lòng nhập đầy đủ thông tin!"
                return@setOnClickListener
            }

            val age = ageText.toIntOrNull()
            if (age == null || age < 0) {
                tvResult.text = "Tuổi không hợp lệ!"
                return@setOnClickListener
            }

            val category = when {
                age > 65 -> "Người già"
                age in 6..65 -> "Người lớn"
                age in 2..6 -> "Trẻ em"
                else -> "Em bé"
            }

            tvResult.text = "$name thuộc nhóm: $category"
        }
    }
}
