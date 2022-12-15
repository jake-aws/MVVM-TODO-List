package com.example.todolist

import android.os.Binder
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.todolist.databinding.FragmentNewTaskSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class NewTaskSheet : BottomSheetDialogFragment() {

    private lateinit var binding: FragmentNewTaskSheetBinding
    private lateinit var taskViewModel: TaskViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val activity = requireActivity()
        taskViewModel =  ViewModelProvider(activity).get(TaskViewModel::class.java)
        binding.addTaskBtn.setOnClickListener{
            addTask()
        }
    }

    private fun addTask() {
        taskViewModel.title.value = binding.taskTextTitle.text.toString()
        taskViewModel.desc.value = binding.taskTextDesc.text.toString()
        binding.taskTextTitle.setText("")
        binding.taskTextDesc.setText("")
        dismiss()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentNewTaskSheetBinding.inflate(inflater, container, false)
        return binding.root
    }

}