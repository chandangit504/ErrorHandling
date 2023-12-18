package com.example.errorhandling

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.errorhandling.presentation.viewModel
import com.example.errorhandling.ui.theme.ErrorHandlingTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ErrorHandlingTheme {
                // A surface container using the 'background' color from the theme
                Column(
                    modifier = Modifier
                        .background(Color.LightGray)
                        .padding(16.dp)
                        .fillMaxSize(), verticalArrangement = Arrangement.Center
                ) {
                    val viewmodel = viewModel<viewModel>()
                    OutlinedTextField(
                        value = viewmodel.email,
                        onValueChange = viewmodel::onEmailChanged,
                        modifier = Modifier.fillMaxWidth(),
                        label = {
                            Text(
                                text = "Email"
                            )
                        })
                    Spacer(modifier = Modifier.height(12.dp))
                    Button(
                        onClick =  viewmodel::submitEmail,
                        modifier = Modifier.align(Alignment.End)
                    ) {
                        Text(text = "Submit")
                    }
                    Spacer(modifier = Modifier.height(12.dp))
                    if (viewmodel.error != null) {
                        Text(text = viewmodel.error ?: "")
                    }
                }
            }
        }
    }
}