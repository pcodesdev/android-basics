package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Card()
                }
            }
        }
    }
}

@Composable
fun Card() {
   Column (
       verticalArrangement = Arrangement.Center,
       horizontalAlignment = Alignment.CenterHorizontally,
       modifier = Modifier
           .fillMaxSize()
           .background(Color(0xFFCCFFCC))
       ){

    PersonImage(
        name = stringResource(R.string.name),
        profession = stringResource(R.string.profession)
    )

       Column(modifier = Modifier.padding(
           top = 160.dp
       )) {
           Contacts(icon = Icons.Default.Phone, contactType = stringResource(R.string.phone_number))
           Contacts(icon = Icons.Default.Share, contactType = stringResource(R.string.share_handle))
           Contacts(icon = Icons.Default.Email, contactType = stringResource(R.string.email_address))
       }

   }
}

@Composable

fun Person(name: String, profession:String, modifier: Modifier=Modifier){
    Text(
        text = name,
        fontSize = 32.sp,
        fontWeight = FontWeight.Light,
        lineHeight = 2.sp

    )
    Text(
        text =profession,
        fontSize = 16.sp,
        color = Color(0xFF006600),
        fontWeight = FontWeight.Bold,
        lineHeight = 1.sp,
        modifier = modifier.padding(
            top = 4.dp
        )
    )
}

@Composable
fun PersonImage(name: String, profession:String, modifier: Modifier=Modifier){
 val image= painterResource(R.drawable.android_logo)

    Column (verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {


    Image(
        painter = image,
        contentDescription = null,
//        alpha=1f,
        modifier= Modifier
            .width(200.dp)
            .height(200.dp)
    )
    Person(
        name = name,
        profession = profession
    )
    }
}

@Composable
fun Contacts(icon:ImageVector, contactType:String, modifier: Modifier=Modifier){

    Row {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint= Color(0xFF006600),
            modifier = modifier.padding(8.dp))


        Text(
            text = contactType,
            modifier = modifier.padding(8.dp)

        )
    }
}

@Preview(showBackground = true)
@Composable
fun CardPreview() {
    BusinessCardTheme {
        Card()
    }
}