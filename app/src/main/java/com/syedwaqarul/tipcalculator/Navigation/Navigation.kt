package com.syedwaqarul.tipcalculator.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.syedwaqarul.tipcalculator.ui.components.AccountCreate
import com.syedwaqarul.tipcalculator.ui.components.UserInputFieldui
import com.syedwaqarul.tipcalculator.ui.splashScreen.Bussiness_Card
import com.syedwaqarul.tipcalculator.ui.theme.TipTimeLayout


@Composable
fun Navigation(navHostController: NavHostController) {//navHostController is a jetpack compose type controller

    NavHost(
        navController = navHostController,
        startDestination = Navigationitems.splashScreen.route
    )
    {

        composable(Navigationitems.splashScreen.route)
        {
            Bussiness_Card(navHostController)
        }

        composable(Navigationitems.acountCreate.route) {
            AccountCreate(navHostController)
        }
        composable(Navigationitems.myComponents.route) {

            UserInputFieldui(navHostController)
        }
        composable(Navigationitems.tipCalculator.route)
        {
            TipTimeLayout()
        }
    }


}

