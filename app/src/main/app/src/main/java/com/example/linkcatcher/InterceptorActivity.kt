package com.example.linkcatcher

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import java.io.File
import java.io.FileOutputStream

class InterceptorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        val uri = intent.data
        val link = uri?.toString() ?: intent.getStringExtra("android.intent.extra.TEXT") ?: "Неизвестная ссылка"

        AlertDialog.Builder(this)
            .setTitle("Сохранить ссылку?")
            .setMessage(link)
            .setPositiveButton("Да") { _, _ ->
                saveLink(link)
                Toast.makeText(this, "Сохранено!", Toast.LENGTH_SHORT).show()
                finish()
            }
            .setNegativeButton("Нет") { _, _ ->
                finish()
            }
            .setCancelable(false)
            .show()
    }

    private fun saveLink(link: String) {
        try {
            val file = File(filesDir, "saved_links.txt")
            FileOutputStream(file, true).use { fos ->
                fos.write(("$link\n").toByteArray())
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}
