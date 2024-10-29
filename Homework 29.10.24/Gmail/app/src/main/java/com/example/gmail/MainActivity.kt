package com.example.gmail

import EmailAdapter
import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gmail.Email
import com.example.gmail.R


class MainActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val emailList = listOf(
            Email("Alice Johnson", "Meeting Reminder", "Don't forget about the meeting tomorrow.", "9:00 AM"),
            Email("Bob Smith", "Project Update", "Here is the latest update on the project.", "Yesterday"),
            Email("Carol White", "Welcome!", "We are excited to have you on board.", "2:00 PM"),
            Email("David Brown", "Lunch Plans", "How about lunch at 12?", "10:30 AM"),
            Email("Eve Taylor", "Weekend Plans", "Are we still on for the weekend?", "4:00 PM")
        )

        val adapter = EmailAdapter(emailList)
        recyclerView.adapter = adapter
    }
}
