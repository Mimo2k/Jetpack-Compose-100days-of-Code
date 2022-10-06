package com.example.bizcard

import android.graphics.drawable.shapes.Shape
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.ColorRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bizcard.ui.theme.BizCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BizCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                   CreateBizCard()
                }
            }
        }
    }
}
@Composable
fun CreateBizCard(){
    val buttonState = remember {
        mutableStateOf(false)
    }
 Surface(modifier = Modifier
     .fillMaxWidth()
     .fillMaxHeight()) {
     Card(modifier = Modifier
         .width(200.dp)
         .height(390.dp)
         .padding(12.dp),
         shape = RoundedCornerShape(corner = CornerSize(15.dp)),
         backgroundColor = Color.White,
         elevation = 4.dp) {
         Column(modifier = Modifier.height(300.dp),
             verticalArrangement = Arrangement.Top,
             horizontalAlignment = Alignment.CenterHorizontally) {

             MyImage()
             Divider()
             Info()
             Button(onClick = {
                buttonState.value = !buttonState.value
             }) {
                 Text(text = "Portfolio",
                 style = MaterialTheme.typography.button)
             }
             if(buttonState.value){
                 Content()
             }else{
                 Box() {
                     
                 }
             }

         }


     }
 }
}

@Composable
private fun Info() {
    Column(modifier = Modifier.padding(10.dp)) {
        Text(
            text = "Sompa Patra",
            style = MaterialTheme.typography.h4,
            color = colorResource(id = R.color.maroon)
        )

        Text(
            text = "Geographers",
            modifier = Modifier.padding(3.dp),
            color = colorResource(id = R.color.maroon_medium),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.subtitle1

        )
        Text(
            text = "@Sompa",
            modifier = Modifier.padding(3.dp),
            color = colorResource(id = R.color.maroon_light),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.subtitle2

        )

    }
}

@Composable
fun MyImage(modifier: Modifier = Modifier ){
    Surface(modifier = modifier
        .size(150.dp)
        .padding(5.dp),
        shape = CircleShape,
        border = BorderStroke(0.5.dp,Color.LightGray),
        elevation = 4.dp,
        color = MaterialTheme.colors.onSurface.copy(0.5f)
    ) {
        Image(painter = painterResource(id = R.drawable.profile),
            contentDescription = "profile_image",
            modifier = Modifier.size(135.dp),
            contentScale = ContentScale.Crop
        )
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BizCardTheme {
        CreateBizCard()
    }
}
@Composable
fun Content(){
    Box(modifier = Modifier
        .fillMaxHeight()
        .fillMaxWidth()
        .padding(5.dp)) {
        Surface(modifier = Modifier
            .fillMaxWidth()
            .fillMaxWidth()
            .padding(3.dp),
             shape = RoundedCornerShape(corner = CornerSize(6.dp)),
             border = BorderStroke(width = 1.dp,
                 color = Color.LightGray)) {
              Portfolio(data = listOf("project 1","project 2","project 3"))
        }
    }
}

@Composable
fun Portfolio(data: List<String>) {
    LazyColumn{
        items(data){
            item ->
            Card(modifier = Modifier
                .padding(15.dp)
                .fillMaxWidth(),
                shape = RoundedCornerShape(10.dp),
                elevation = 4.dp) {
                Row(modifier = Modifier
                    .padding(16.dp)
                    .background(MaterialTheme.colors.surface),
                ) {
                   MyImage(modifier = Modifier.size(100.dp))
                    Column(modifier = Modifier.padding(7.dp).align(alignment = Alignment.CenterVertically)) {
                        Text(text = item, fontWeight = FontWeight.Bold,
                            color = colorResource(id = R.color.maroon_medium))
                        Text(text = "A Great Project",
                            style = MaterialTheme.typography.body2,
                            color = colorResource(id = R.color.maroon_light))
                    }

                }

            }
        }
    }
}
