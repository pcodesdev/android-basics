package com.example.greetingcard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.greetingcard.ui.theme.GreetingCardTheme

// Define the main activity class that inherits from ComponentActivity
class MainActivity : ComponentActivity() {
    // Override the onCreate method
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Set the content of the activity using Jetpack Compose
        setContent {
            // Apply the GreetingCardTheme to the content of the activity
            GreetingCardTheme {
                // Create a Surface container that occupies the entire available space,
                // using the background color from the MaterialTheme color scheme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // Call the Greeting Composable function and provide the name "Peter Njuguna"
                    Greeting("Peter Njuguna")
                }
            }
        }
    }
}

// Define a Composable function named Greeting that takes a name and modifier as parameters
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    // Create a Surface with a Cyan color
    Surface(color = Color.Cyan) {
        // Display a Text component with a message containing the provided name,
        // using the specified modifier to add padding
        Text(
            text = "Hi, my name is $name!",
            modifier = modifier.padding(24.dp)
        )
    }
}

// Define a Composable function named GreetingPreview for previewing the Greeting Composable
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    // Apply the GreetingCardTheme to the preview
    GreetingCardTheme {
        // Call the Greeting Composable function in the preview and provide the name "Peter Njuguna"
        Greeting("Peter Njuguna")
    }
}
