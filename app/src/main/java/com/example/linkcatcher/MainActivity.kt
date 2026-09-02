package com.example.linkcatcher

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.io.File

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val textView = TextView(this)
        textView.setPadding(32, 32, 32, 32)
        textView.textSize = 16f
        setContentView(textView)

        val file = File(filesDir, "saved_links.txt")
        if (file.exists()) {
            textView.text = file.readText()
        } else {
            textView.text = "Пока нет сохраненных ссылок."
        }
    }
}
