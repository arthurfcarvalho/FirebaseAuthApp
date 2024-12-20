package com.example.firebaseauthapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class HomeActivity : ComponentActivity() {
    private lateinit var welcomeText: TextView
    private lateinit var logoutButton: Button
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        auth = FirebaseAuth.getInstance()

        welcomeText = findViewById(R.id.welcomeMessage)
        logoutButton = findViewById(R.id.logoutButton)

        val user = auth.currentUser
        welcomeText.text = "Bem-vindo, ${user?.email}"

        logoutButton.setOnClickListener{
            auth.signOut()
            redirectToLogin()
        }
    }

    private fun redirectToLogin() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}