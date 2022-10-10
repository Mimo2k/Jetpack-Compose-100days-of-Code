package com.mimo.jettip.util

fun calculateTotalTip(totalBill: Double,
                      tipPercentage: Int): Double {
    return if (totalBill > 1 && totalBill.toString().isNotEmpty()){
        (totalBill * tipPercentage )/ 100
    } else {
        0.00
    }
}

fun calculateTotalPerPerson(totalBill: Double,
                            totalSplit: Int,
                            tipPercentage: Int): Double{
    val bill = calculateTotalTip(totalBill = totalBill, tipPercentage = tipPercentage) + totalBill
    return (bill/totalSplit)
}