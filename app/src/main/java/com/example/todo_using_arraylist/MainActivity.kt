package com.example.todo_using_arraylist

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

  private  val todos = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnAddTodo : Button = findViewById(R.id.btnAddTodo)
        val etNewTodo : EditText = findViewById(R.id.etNewTodo)

        val lvTodo : ListView = findViewById(R.id.lvTodo)


        val todoAdapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            android.R.id.text1,
            todos
        )

        lvTodo.adapter = todoAdapter

        btnAddTodo.setOnClickListener{
            val newTodo = etNewTodo.text.toString()
            todos.add(newTodo)
            todoAdapter.notifyDataSetChanged()
            etNewTodo.setText("")
        }



    }
}