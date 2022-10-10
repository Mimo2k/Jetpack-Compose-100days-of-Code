package com.mimo.jettip

import android.os.Bundle
import android.util.Log
import android.widget.EditText
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mimo.jettip.components.InputField
import com.mimo.jettip.ui.theme.TipCalculatorTheme
import com.mimo.jettip.util.calculateTotalPerPerson
import com.mimo.jettip.util.calculateTotalTip
import com.mimo.jettip.widgets.RoundIconButton

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp{
                Column() {
                    MainContent()
                }


            }
        }
    }
}

@Composable
fun MyApp(content: @Composable () -> Unit){
    Surface(
        modifier = Modifier.padding(5.dp),
        color = MaterialTheme.colors.background
    ) {
        content()
    }
}
//@Preview
@Composable
fun TopHeader(totalPerPerson: Double = 0.0){
    Surface(modifier = Modifier
        .padding(15.dp)
        .fillMaxWidth()
        .height(150.dp)
        .clip(shape = RoundedCornerShape(corner = CornerSize(12.dp))),
        color = Color(0xFFE95285),
        elevation = 4.dp
    ) {
        Column(modifier = Modifier.padding(12.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
            val total ="%.2f".format(totalPerPerson)
            Text(text = "Total Per Person",
                 color =  Color.White,
                 style = MaterialTheme.typography.h5
            )
            Text(text = "$ $total",
                color =  Color.White,
                style = MaterialTheme.typography.h4,
                fontWeight = FontWeight.ExtraBold
            )
        }
        
    }
}


//@Preview
@Composable
fun MainContent() {


    val totalSplitState = remember {
        mutableStateOf(1)
    }

    val tipAmountState = remember {
        mutableStateOf(0.0)
    }

    val  totalPerPersonState = remember {
        mutableStateOf(0.0)
    }
  BillForm(totalSplitState = totalSplitState,
      tipAmountState = tipAmountState,
      totalPerPersonState = totalPerPersonState)
}

@Composable
fun BillForm(modifier: Modifier = Modifier, range: IntRange = 1..100,
             totalSplitState:MutableState<Int>,
             tipAmountState: MutableState<Double>,
             totalPerPersonState: MutableState<Double>
             ,onValChange: (String) -> Unit = {  }){
    val totalBillState = remember{
        mutableStateOf("")
    }

    val validState = remember(totalBillState.value){
        totalBillState.value.trim().isNotEmpty()
    }


    val focusManager = LocalFocusManager.current

    val sliderPosition = remember {
        mutableStateOf(0f)
    }


    val tipPercentage:Int = (sliderPosition.value * 100).toInt()


    TopHeader(totalPerPerson = totalPerPersonState.value)
    Surface(modifier = modifier
        .padding(6.dp)
        .fillMaxWidth(),
        shape = RoundedCornerShape(corner = CornerSize(8.dp)),
        border = BorderStroke(width = 1.dp, color = Color.LightGray)
    ) {
        Column(modifier = modifier.padding(5.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start) {
            InputField(modifier = Modifier.fillMaxWidth(), valueState = totalBillState,
                labelId = "Enter Bill" ,
                enabled = true ,
                isSingleLine = true,
                onAction = KeyboardActions{
                    if(!validState) return@KeyboardActions
                    focusManager.clearFocus(force = true)
                    onValChange(totalBillState.value.trim())

                    totalPerPersonState.value = calculateTotalPerPerson(totalBill = totalBillState.value.toDouble(),
                        totalSplit = totalSplitState.value,
                        tipPercentage = tipPercentage)


                }
            )
          if(validState){
            Row(modifier = modifier.padding(bottom = 5.dp, start = 10.dp, end = 10.dp),
                horizontalArrangement =  Arrangement.Start,
              ) {
                Text(text = "Split",
                modifier = modifier.align(alignment = Alignment.CenterVertically))
                Spacer(modifier = modifier.width(120.dp))
                Row(modifier = modifier.padding(horizontal = 3.dp),
                horizontalArrangement = Arrangement.End) {

                    RoundIconButton(imageVector = Icons.Default.Remove,
                        onClick = {
                            if(totalSplitState.value>range.start)
                            totalSplitState.value -= 1
                            totalPerPersonState.value = calculateTotalPerPerson(totalBill = totalBillState.value.toDouble(),
                                totalSplit = totalSplitState.value,
                                tipPercentage = tipPercentage)

                        })

                    Text(text = totalSplitState.value.toString(), modifier = Modifier
                        .align(alignment = Alignment.CenterVertically)
                        .padding(start = 9.dp, end = 9.dp))

                    RoundIconButton(imageVector = Icons.Default.Add,
                        onClick = {
                            if(totalSplitState.value<range.last)
                            totalSplitState.value += 1
                            totalPerPersonState.value = calculateTotalPerPerson(totalBill = totalBillState.value.toDouble(),
                                totalSplit = totalSplitState.value,
                                tipPercentage = tipPercentage)
                        })
                }
            }

            //Tip Row
            Row(modifier = modifier.padding(horizontal = 10.dp, vertical = 12.dp)){
                Text(text = "Tip",
                    modifier = modifier.align(alignment = Alignment.CenterVertically))
                Spacer(modifier = modifier.width(200.dp))
                Text(text = "$${tipAmountState.value}",
                    modifier = modifier.align(alignment = Alignment.CenterVertically))
            }
            Column(modifier = modifier.padding(horizontal = 10.dp, vertical = 12.dp),
                verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,) {
                Text(text = "$tipPercentage %")
                Spacer(modifier = modifier.height(14.dp))

                //Slider

                Slider(value = sliderPosition.value,
                    onValueChange = { newVal ->
                            sliderPosition.value = newVal
                            tipAmountState.value = calculateTotalTip(totalBill = totalBillState.value.toDouble(),
                                tipPercentage =  tipPercentage)
                            totalPerPersonState.value = calculateTotalPerPerson(totalBill = totalBillState.value.toDouble(),
                            totalSplit = totalSplitState.value,
                                tipPercentage = tipPercentage)

                    }, modifier = modifier.padding(start = 16.dp, end = 16.dp),
                    steps = 5,
                    onValueChangeFinished = {

                    }

                )
            }
         }else{
           Box(modifier = modifier.fillMaxWidth().height(200.dp), contentAlignment = Alignment.Center) {
               Text(text = "Waiting for the Bill",
                   color = Color(0xFFE95285),
                   fontSize = 22.sp,
                   style = MaterialTheme.typography.body1
                   )
           }
         }
        }
    }
}




@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TipCalculatorTheme {
        MyApp {
            Column() {
                MainContent()
            }
        }
    }
}
