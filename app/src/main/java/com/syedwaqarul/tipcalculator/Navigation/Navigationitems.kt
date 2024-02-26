package com.syedwaqarul.tipcalculator.Navigation

sealed class Navigationitems(var route:String) {

    object splashScreen: Navigationitems("SplashScreen")
    object acountCreate: Navigationitems("AccountCreate")
    object myComponents: Navigationitems("my_components")
    object tipCalculator: Navigationitems("tipcalculator")
}