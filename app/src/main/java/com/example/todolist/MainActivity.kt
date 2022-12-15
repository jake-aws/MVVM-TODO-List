package com.example.todolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.todolist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var taskViewModel: TaskViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        taskViewModel = ViewModelProvider(this).get(taskViewModel::class.java)
        binding.newTaskBtn.setOnClickListener {
            NewTaskSheet().show(supportFragmentManager, "newTaskTag")
        }
        taskViewModel.title.observe(this) {
            binding.taskTitle.text = String.format("Task Title: %s", it)
        }
        taskViewModel.desc.observe(this) {
            binding.taskDesc.text = String.format("Task Description: %s", it)
        }
    }
}