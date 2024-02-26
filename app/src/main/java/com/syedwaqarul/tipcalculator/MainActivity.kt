package com.syedwaqarul.tipcalculator

import android.content.Intent
import android.graphics.drawable.Icon
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.syedwaqarul.tipcalculator.Navigation.Navigation
import com.syedwaqarul.tipcalculator.ui.components.UserInputFieldui
import com.syedwaqarul.tipcalculator.ui.splashScreen.Bussiness_Card
import com.syedwaqarul.tipcalculator.ui.theme.TipCalculatorTheme
import com.syedwaqarul.tipcalculator.ui.theme.TipTimeLayout
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TipCalculatorTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyApp()
//                    Bussiness_Card()

//                   TipTimeLayout()

//                UserInputFieldui()

                }
            }
        }
    }
}

@Composable
fun MyApp(modifier: Modifier = Modifier) {
    Scaffold(modifier = Modifier.fillMaxSize()) {
        it
        var navHostController = rememberNavController()
        Navigation(navHostController = navHostController)
    }


}

@Preview(showBackground = true)
@Composable
fun LoginScreen() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        MaterialTheme.colorScheme.primary.copy(alpha = .9f),
                        MaterialTheme.colorScheme.primary.copy(alpha = .1f)
//                        Color.Blue.copy(alpha = .3f),

//                        Color.White,

                    )
                )
            )
            .padding(24.dp)

    ) {
        Spacer(modifier = Modifier.height(80.dp))
        //Spacer is the fastest method to provide space
        Image(
            painter = painterResource(id = R.drawable.undraw_mobile_content_xvgr),
            contentDescription = "",
            modifier = Modifier
                .size(250.dp)
                .border(
                    4.dp,
                    MaterialTheme.colorScheme.primary,
                    MaterialTheme.shapes.extraLarge
                )
        )
        Text(
            text = "Welcome back",
            style = MaterialTheme.typography.headlineLarge,
            fontWeight = FontWeight.ExtraBold
        )
        Text(text = "Log in to your existing account of Q allure",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f))//alpha ka matlab hai kitna dull karna text
        //alpha means how much you want color to be dull in a text.
        Spacer(modifier =Modifier.height(24.dp) )
        var email by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }

UserInputField(
    modifier = Modifier.fillMaxWidth(),
    onValueChange = {email=it},
    value = email
)
        Spacer(modifier =Modifier.height(16.dp) )

        UserInputField(
            modifier = Modifier.fillMaxWidth(),
            label = "Password", icon = Icons.Default.Lock,
            onValueChange = {password=it},
            value = password
        )
        Row(
            horizontalArrangement = Arrangement.End,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Forget Password",
                modifier= Modifier.padding(vertical = 12.dp),
                color = Color.Black.copy(alpha = .8f),
                fontWeight = FontWeight.Bold
            )
        }
//        RoundedButton(modifier=Modifier
    //        .height(50.dp)
//        .width(180.dp)
//        )
//        {
//     //handle action
//        }

        Spacer(modifier =Modifier.height(24.dp) )
        Text(text = "Or connect using",
            color=MaterialTheme.colorScheme.onSurface.copy(alpha = 0.8f))
Row(
    horizontalArrangement = Arrangement.spacedBy(8.dp)

) {
    RectangularButton(onClick = {}, color = Color.Blue)
    RectangularButton(
        color = Color.Red,
        icon = Icons.Default.Lock,
        text = "Google",
    ) {}
}
        Spacer(modifier =Modifier.weight(1f) )

        Text(text = "Don't have an account? Sign up",
            color=MaterialTheme.colorScheme.onSurface.copy(alpha=.8f))



    }

}

@Composable
fun RectangularButton(
modifier: Modifier=Modifier,
icon: ImageVector=Icons.Default.Refresh,
text:String="facebook",
color: Color= Color.Blue,
    onClick:()->Unit,//last parameter must be on click
                      ) {
    Button(onClick = onClick,
        shape = MaterialTheme.shapes.small,
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(
            containerColor = color,
            contentColor = Color.White
        )
    )
        {
       Icon(imageVector = icon ,
           contentDescription = null,
           )
            Spacer(modifier = Modifier.width(10.dp))
            Text(text = text)
        }


}