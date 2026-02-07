package com.zeninlab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.zeninlab.ui.theme.ForLab1Theme
import com.zeninlab.BusinessCardScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ForLab1Theme {
                BusinessCardScreen()
            }
        }
    }
}
