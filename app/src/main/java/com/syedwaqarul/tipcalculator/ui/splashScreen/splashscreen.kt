package com.syedwaqarul.tipcalculator.ui.splashScreen

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.AnimationVector1D
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons

import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Mail
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.syedwaqarul.tipcalculator.Navigation.Navigationitems
import com.syedwaqarul.tipcalculator.R
import com.syedwaqarul.tipcalculator.ui.theme.TipCalculatorTheme
import kotlinx.coroutines.delay


@Composable
    fun Bussiness_Card(navHostController: NavHostController) {
//        val navigationColor = LocalContentColor.current
        Box(
            modifier = Modifier
                .background(Color.Yellow)
                .fillMaxSize()

        ) {
            var scale: Animatable<Float, AnimationVector1D> = remember {
                Animatable(0.0f)
            }

            LaunchedEffect(key1 = true)
            {
                scale.animateTo(
                    targetValue = 0.0f,
                    animationSpec = tween(800,
                        easing = {
                            OvershootInterpolator(4f).getInterpolation(it)
                        })
                )
                delay(1000)
                navHostController.navigate(Navigationitems.myComponents.route)
                {
                    popUpTo(Navigationitems.splashScreen.route)
                    {
                        inclusive=true
                    }
                }
            }
            Column(

            ) {

                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                ) {

                    Box {
                        Image(
                            painter = painterResource(id = R.drawable.ic_launcher_background),
                            contentDescription = "",
                            modifier = Modifier
                                .border(
                                    width = 6.dp,
                                    color = Color.Black
                                )


                        )

                        Image(
                            painter = painterResource(id = R.drawable.ic_launcher_foreground),
                            contentDescription = ""
                        )
                    }

                    Text(
                        text = "Jennifer Doe",
                        fontSize = 38.sp
                    )
                    Text(
                        text = "Android Developer Extraordinaire",
//                    style = MaterialTheme.typography.bodyMedium,
                        color = Color.Magenta
                    )
                }

                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column {

                        Row() {
                            Image(
                                imageVector = Icons.Default.Call,
                                contentDescription = ""
                            )
                            Spacer(modifier = Modifier.size(24.dp))
                            Text(text = "+9232233332323")
                        }
                        Spacer(modifier = Modifier.size(24.dp))

                        Row {
                            Image(imageVector = Icons.Default.Share, contentDescription = "")
                            Spacer(modifier = Modifier.size(24.dp))
                            Text(
                                text = "syedwaqarul@gmail.com",
//                        color = MaterialTheme.colorScheme.onSurface
                            )
                        }
                        Spacer(modifier = Modifier.size(24.dp))

                        Row(

                        ) {
                            Image(imageVector = Icons.Default.Mail, contentDescription = "")
                            Spacer(modifier = Modifier.size(24.dp))
                            Text(
                                text = "Send me Message",
//                        color = MaterialTheme.colorScheme.onSurface
                            )
                        }
                        Spacer(modifier = Modifier.size(24.dp))
                    }


                }

            }

        }


    }

//    @Preview(showBackground = true, showSystemUi = true)
//    @Composable
//    fun GreetingPreview() {
//        TipCalculatorTheme {
//            Bussiness_Card()
//
//        }
//
//    }

