package com.example.diceroller

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.diceroller.ui.theme.DiceRollerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DiceRollerTheme {
               DiceRollerApp()
            }
        }
    }
}



@Composable
fun DiceWithButtonAndImage(modifier: Modifier = Modifier
    ){
//Creating a UI State
var result by remember {
   mutableStateOf(1)
}

//    get random images
    var imageResource=when(result){
        1->R.drawable.dice_1
        2->R.drawable.dice_2
        3->R.drawable.dice_3
        4->R.drawable.dice_4
        5->R.drawable.dice_5
        else->R.drawable.dice_6
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()) {
Image(
    painter = painterResource(id = imageResource),
//    convert integer to string
    contentDescription =result.toString()
)
//       creates an empty space between the the image and the button
        Spacer(modifier = Modifier.height(48.dp))

        Button(onClick = {
        /*TODO*/
            result=(1..6).random()
        },
            ) {
            Text(
                text = stringResource(R.string.roll),
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DiceRollerApp(){
Surface(modifier = Modifier.fillMaxSize(),
    color = MaterialTheme.colorScheme.background) {

Image(painter = painterResource(R.drawable.bg), contentDescription ="bg-image",
modifier = Modifier.fillMaxSize(),
    contentScale = ContentScale.FillBounds
)
    DiceWithButtonAndImage()
}

}