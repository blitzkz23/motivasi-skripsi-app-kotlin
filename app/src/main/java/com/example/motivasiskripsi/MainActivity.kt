package com.example.motivasiskripsi

import android.content.Context
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
//  Declare our references to views before layout inflation
    private lateinit var name: EditText
    private lateinit var message: TextView

//  Override lifecycle method onCreate.  This should initialize all important items for the code.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//      Inflate the given layout to turn xml views into kotlin objects
        setContentView(R.layout.activity_main)

//      Reference to the button view from out layour and set a clickListener
        val updateButton: Button = findViewById(R.id.activity_main_bt_update)
        updateButton.setOnClickListener { updateMessage() }

//      Set the value to out declared views
        name = findViewById(R.id.activity_main_et_name)
        message = findViewById(R.id.main_activity_tv_message)

    }

    private fun updateMessage() {
//      Get the name value from the edit text
        val username = name.text

//      Pick a motivational message
        val motivationalMessages = listOf("skripsine garapo ndes", "malah bukai sosmed tok", "1 langkah perhari ndang", "nek ra mlaku saiki sesok mlayu")
        val index = (0..4).random()
        val randomMessage = motivationalMessages[index]


//      Validate name and update the message
        if(username.toString() == "") {
            message.text = "Mohon masukkan nama anda!"
        } else {
            message.text = "Weh, $username $randomMessage!"
        }
//      Clear the edit text because its not string but an editable so we clear it this way
        name.setText("")

//      Hide the keyboard
        hideKeyboard()
    }

    private fun hideKeyboard() {
//      we are calling context(to access android native feature) automatically because it is available from extending app compat act.  And then call the
//      Input method service so we can adjust the keyboard
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(name.windowToken, 0)
    }
}