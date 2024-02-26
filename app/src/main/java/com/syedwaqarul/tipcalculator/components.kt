package com.syedwaqarul.tipcalculator

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.Scaffold

import android.telecom.StatusHints
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Facebook
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.syedwaqarul.tipcalculator.Navigation.Navigationitems
import com.syedwaqarul.tipcalculator.R


@Composable
fun UserInputField(
    label: String = "Email",
    icon: ImageVector = Icons.Default.Email,
    value: String = "",
    onValueChange: (String) -> Unit = {},
    isfocused: Boolean = false,
    modifier: Modifier = Modifier,
) {
    val customShape = MaterialTheme.shapes.extraLarge


    var amountInput by remember { mutableStateOf("") }


    OutlinedTextField(
        value = amountInput,
        onValueChange = { amountInput = it },
        singleLine = true,

//        value = value,
//        onValueChange = onValueChange,
//        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        label = {
            Text(
                text = label,
                color = if (isfocused) Color.Blue else Color.Gray
            )
        },
        leadingIcon = {
            Icon(
                icon,
                contentDescription = null,
                modifier = Modifier
                    .padding(start = 24.dp)
                    .padding(end = 8.dp),
                tint = if (isfocused) Color.Blue else Color.Gray
            )
        },
        shape = customShape,
//        shape = MaterialTheme.shapes.extraLarge,
        modifier = modifier
            .fillMaxWidth()
            .padding(14.dp, 10.dp)
    )
}

@Preview(showSystemUi = true)
@Composable
fun UserInputFieldui() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.undraw_mobile_content_xvgr),
            contentDescription = "",
            modifier=Modifier.size(180.dp)
        )
        Text(text = "Welcome back!",
            style = MaterialTheme.typography.headlineLarge,
            fontWeight = FontWeight.ExtraBold,
            fontFamily = FontFamily.SansSerif
        )
        Text(text = "Log in to your exitant account of Q Allure"
            , fontWeight = FontWeight.Medium,
            color = Color.Gray,
            modifier= Modifier
                .padding(top = 2.dp)
                .padding(bottom = 20.dp)
        )
        UserInputField(
            label = "Name",
            icon = Icons.Default.AccountCircle, isfocused = true
        )
        UserInputField(
            label = "Password",
            icon = Icons.Default.Lock
        )
        Text(text = "Forgot Password?"
            , fontWeight = FontWeight.Medium,
            color = Color.Black,
            modifier = Modifier
                .width(180.dp)
                .align(Alignment.End)
//                .padding(end = 10.dp)
        )

//        RoundedButton(navHostController
//        )
        Text(text = "Or connect using"
            , fontWeight = FontWeight.Medium,
            color = Color.Gray,
        )
        Row (
        ){

            Button(
                onClick = {},
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier
                    .width(200.dp)
                    .padding(20.dp)
                ,
                colors = ButtonDefaults
                    .buttonColors(
                        containerColor =
                        if (isSystemInDarkTheme()) Color.Yellow else Color.Blue,
                        contentColor =
                        if (isSystemInDarkTheme()) Color.Blue else Color.White


                    )

            ) {
                Icon(
                    imageVector = Icons.Default.Facebook,
                    contentDescription = null,
                    modifier = Modifier
                        .padding(end = 8.dp),
//                .weight(1f)

                    tint =  Color.White// Icon tint color
                )
                Text(text = "Facebook")

            }
            Button(
                onClick = {},
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier
                    .width(200.dp)
                    .padding(20.dp)
                ,
                colors = ButtonDefaults
                    .buttonColors(
                        containerColor =
                        if (isSystemInDarkTheme()) Color.Yellow else Color.Red,
                        contentColor =
                        if (isSystemInDarkTheme()) Color.Red else Color.White


                    )
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.google),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(end = 8.dp)
                        .size(16.dp),
                    tint =  Color.White// Icon tint color
                )
                Text(text = "Google")

            }


        }
        Row (
            modifier=Modifier.padding(top = 25.dp)
        ){
            Text(text = "Don't have an account?"
                , fontWeight = FontWeight.Medium,
            )
            Text(
                text = "Sign Up",
                modifier = Modifier.padding(start = 3.dp)
                    .clickable {
//                        navHostController.navigate(Navigationitems.acountCreate.route)

                    },
                fontWeight = FontWeight.Bold,
                color = Color.Blue,
//                onClick = { /*TODO*/ }

            )

        }
    }

}

@Composable
fun MyComposableFunction() {
    // Your composable function implementation
    Text("Hello from MyComposableFunction!")
}

@Composable
fun RoundedButton(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    text: String = "Log in",

    onclick: () -> Unit = { }
) {

    var buttonClicked by remember { mutableStateOf(false) }
    Button(
        onClick = {
//            buttonClicked = true

            navController.navigate(Navigationitems.tipCalculator.route)


        },
        modifier = modifier
            .width(200.dp)
            .padding(20.dp)
        ,
        colors = ButtonDefaults
            .buttonColors(
                containerColor =
                if (isSystemInDarkTheme()) Color.Yellow else Color.Blue,
                contentColor =
                if (isSystemInDarkTheme()) Color.Blue else Color.White


            )

    ) {

        Text(text = text.uppercase())

    }


}
