package com.syedwaqarul.tipcalculator.ui.theme

import android.inputmethodservice.Keyboard
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.syedwaqarul.tipcalculator.R
import java.text.NumberFormat


@Composable
fun EditNumberField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        singleLine = true,
        label = {
            Text(stringResource(R.string.bill_amount))
                },
        shape = MaterialTheme.shapes.extraLarge,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        modifier = modifier
    )
}


@Preview(showSystemUi = true)
@Composable
fun TipTimeLayout() {
    var amountInput by remember { mutableStateOf("") }
    val amount = amountInput.toDoubleOrNull() ?: 0.0
    val tip = calculateTip(amount)
    Column(
        modifier = Modifier
            .statusBarsPadding()
            .fillMaxSize()
            .padding(horizontal = 40.dp)
            .verticalScroll(rememberScrollState())
            .safeDrawingPadding()
//            .background(Color.LightGray)
            ,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    )

    {
        Image(
            painter = painterResource(id = R.drawable.undraw_mobile_content_xvgr),
            contentDescription = "",
            modifier=Modifier.size(180.dp)
        )
        Text(text = "Tip Calculator",
            style = MaterialTheme.typography.headlineLarge,
            fontWeight = FontWeight.ExtraBold,
            fontFamily = FontFamily.SansSerif
            , color = Color.Red
        )
//        Text(
//            text = stringResource(R.string.calculate_tip),
//            modifier = Modifier
//                .padding(bottom = 10.dp, top = 40.dp)
//                .align(alignment = Alignment.Start)
//
//        )
        Text(text = "Log in to your exitant account of Q Allure"
            , fontWeight = FontWeight.Medium,
            color = Color.Blue,
            modifier= Modifier
                .padding(top = 2.dp)
                .padding(bottom = 25.dp)
        )
                EditNumberField(
            value = amountInput,
            onValueChange = { amountInput = it },
            modifier = Modifier
                .padding(bottom = 32.dp)
                .fillMaxWidth()
        )


        Text(
            text = stringResource(R.string.tip_amount, tip),
            style = MaterialTheme.typography.displaySmall,
            color = Color.Green
        )
        Spacer(modifier = Modifier.height(150.dp))
    }
}


private fun calculateTip(amount: Double, tipPercent: Double = 15.0): String {
// Log.d("Data")
    val tip = tipPercent / 100 * amount
    return NumberFormat.getCurrencyInstance().format(tip)
}
