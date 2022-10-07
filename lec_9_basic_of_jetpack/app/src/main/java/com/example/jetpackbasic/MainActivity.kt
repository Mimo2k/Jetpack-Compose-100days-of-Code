package com.example.jetpackbasic

import android.graphics.Paint.Style
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackbasic.ui.theme.JetpackBasicTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackBasicTheme {
                MyApp()
            }
        }
    }
}
@Composable
fun MyApp(){
    var moneyCounter by remember {
        mutableStateOf(0)
    }
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFF546E7A)
    ) {
        Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "\$ ${moneyCounter*10} ", style = TextStyle(
                color = Color.White,
                fontSize = 20.sp, fontWeight = FontWeight.ExtraBold
            ))
            Spacer(modifier = Modifier.height(30.dp))
            CreateCircle(moneyCounter = moneyCounter){
                moneyCounter += 1
            }
        }
    }
}
//@Preview
@Composable
fun CreateCircle(moneyCounter: Int = 0,updateMoneyCounter: (Int) -> Unit){
    Log.d("val",moneyCounter.toString())
  Card(modifier = Modifier
      .padding(3.dp)
      .size(150.dp)
      .clickable {
       updateMoneyCounter(moneyCounter)

      }, shape = CircleShape, elevation = 4.dp) {
      Box(contentAlignment = Alignment.Center) {
          Text(text = "Tap $moneyCounter", fontSize = 18.sp,)
      }
  }
}


@Composable
fun DefaultPreview() {
    JetpackBasicTheme {
       MyApp()

    }
}