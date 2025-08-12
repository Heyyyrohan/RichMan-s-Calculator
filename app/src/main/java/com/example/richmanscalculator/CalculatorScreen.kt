package com.example.richmanscalculator

import android.R.attr.button
import android.graphics.Paint
import android.text.Layout
import androidx.compose.foundation.gestures.snapping.SnapPosition
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.InspectableModifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.collections.listOf

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Screen(){
    var input by remember  { mutableStateOf("0") }
    var result by remember { mutableStateOf("") }

    val buttons = listOf(
        listOf("(",")","DEL","/"),
        listOf("7","8","9","*"),
        listOf("4","5","6","-"),
        listOf("1","2","3","+"),
        listOf("AC","0",".","=")

    )

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xffF3F4F6) // Yellow background
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 8.dp, end = 8.dp, top = 15.dp, bottom = 25.dp),

        ) {
            Text(
                text = input,
                fontSize = 55.sp,
                color = Color(0xff191919),
                textAlign = TextAlign.End,
                modifier = Modifier.fillMaxWidth().padding(10.dp)
            )
            Text(
                text = result,
                fontSize = 35.sp,
                color = Color(0xff191919),
                textAlign = TextAlign.End,
                modifier = Modifier.fillMaxWidth().padding(10.dp)
            )

            Spacer( modifier = Modifier.weight(.8f))

            for(row in buttons){
                Row(
                    modifier = Modifier.fillMaxWidth()
                    .weight(1f), // Each row gets equal height
                    horizontalArrangement = Arrangement.SpaceEvenly
                    ){
                    for(symbol in row){
                        val bgcolor = when(symbol){

                            "=" -> Color(0xff37D6D2)
                            "(",")","AC","^","DEL","/","*","-","+" ,"."-> Color(0xffE6E7EB)
                            else -> Color(0xffFFFFFF)


                        }
                        val contentCol = when(bgcolor){
                            Color(0xff37D6D2) -> Color(0xffFFFFFF)
                            else -> Color(0xff191919)
                        }

                        if(symbol == ""){
                            Spacer(modifier = Modifier
                                .weight(1f)
                                .aspectRatio(1f)
                                .padding(5.dp))
                        }
                        else{
                            Button(
                                onClick = {

                                    when(symbol){
                                        "AC" -> {
                                            result =""
                                            input ="0"
                                            val resultFontSize = 35.sp
                                            val inputtFontSize = 55.sp
                                        }
                                        "=" -> {
                                            result = calculation(input)
                                            val resultFontSize = 55.sp
                                            val inputtFontSize = 35.sp
                                        }
                                        "DEL" -> {
                                            when{
                                                input.length == 1 -> input = "0"
                                                else -> input = input.dropLast(1)

                                            }

                                        }
                                        else -> {
                                            if(input == "0"){input = ""}
                                            input += symbol
                                        }
                                    }

                                },
                                modifier = Modifier
                                    .padding(5.dp)
                                    .weight(1f)
                                    .aspectRatio(1f),
                                contentPadding = PaddingValues(0.dp) ,
                                shape = CircleShape,
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = bgcolor,
                                    contentColor = contentCol

                                )


                            ) {
                                Text(
                                    text = symbol,
                                    fontSize = 25.sp
                                )
                        }


                        }
                    }
                }
            }

        }

    }
    }
