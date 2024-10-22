package com.example.tugasintentactivity_pertemuan5

import android.content.Context
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tugasintentactivity_pertemuan5.databinding.ActivityProfileBinding
import org.w3c.dom.Text

class ProfileActivity : AppCompatActivity() {

    private lateinit var nameTextView: TextView
    private lateinit var emailTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        nameTextView = findViewById(R.id.txt_name)
        emailTextView = findViewById(R.id.txt_email)

        // Ambil nama dari shared preferences
        val sharedPrefs = getSharedPreferences("UserData", Context.MODE_PRIVATE)
        val name = sharedPrefs.getString("name", "User")
        val email = sharedPrefs.getString("email", "User")

        // Tampilkan nama
        nameTextView.text = name
        emailTextView.text = email
    }
}
