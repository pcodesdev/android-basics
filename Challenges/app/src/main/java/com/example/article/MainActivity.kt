package com.example.article

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.article.ui.theme.ArticleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArticleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BlogContentImage(stringResource(R.string.heading),
                        stringResource(R.string.description), stringResource(R.string.main_content)
                    )
                }
            }
        }
    }
}

@Composable
fun BlogContent(heading: String, paragraph1:String, paragraph2: String, modifier: Modifier = Modifier) {
    Column (verticalArrangement = Arrangement.Center){


    Text(
        text = heading,
        fontSize=24.sp,
        color= Color.Gray,
        modifier = Modifier.padding(16.dp)
    )
    Text(
        text = paragraph1,
        textAlign = TextAlign.Justify,
        modifier = Modifier.padding(
            start = 16.dp,
            end = 16.dp
        )

    )
    Text(
        text = paragraph2,
        textAlign = TextAlign.Justify,
        modifier = Modifier.padding(16.dp)
    )
}
}

@Composable
fun BlogContentImage(heading:String, paragraph1:String, paragraph2:String, modifier:Modifier=Modifier) {
    val image = painterResource(R.drawable.bg_compose_background)

    Column(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = image,
            contentDescription = null,
//            contentScale = ContentScale.Crop,
//            modifier = Modifier.fillMaxWidth()
        )
        BlogContent(
            heading = heading,
            paragraph1 =paragraph1 ,
            paragraph2 = paragraph2,
//        modifier = Modifier.fillMaxSize()
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ArticleTheme {

        BlogContentImage(stringResource(R.string.heading),
            stringResource(R.string.description), stringResource(R.string.main_content)
        )
    }
}