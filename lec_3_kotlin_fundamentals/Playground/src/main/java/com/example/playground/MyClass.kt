package com.example.playground


fun main(){
    varVal() //lec 1
    explicitlyType() //lec 2
    kotlinOperators() //lec 3
}
fun varVal(){
    print("LECTURE -> 1 \n")
    var name = "Mimo"
    name = " Mimo Patra" //mutable: value updation can be done
    print(" My name is: $name \n ")

    val nameVal = "mimo" //immutable: value can't be updated
    print(nameVal+"\n")
}
fun explicitlyType(){
    print("LECTURE -> 2 \n")
    val name:String =  "Mimo"
    val age:Byte = 21
    val marks:Float =  92.2f // float Explicitly
    val preciseAge:Double = 21.223454555
    val phoneNo:Long = 912121212121L // Long Explicitly
    print(" my name is $name \n my age is $age \n my marks is $marks" +
            " \n my precise age is $preciseAge \n my phone no is $phoneNo \n ")
}

fun kotlinOperators(){
    print("LECTURE -> 3 \n")
    var numberOne = 22.0
    var numberTwo = 1.0
    var result = 0.00
    result = numberOne + numberTwo //addition operator
    print(" $numberOne + $numberTwo = $result \n")
    result = numberOne - numberTwo //subtraction operator
    print(" $numberOne - $numberTwo = $result \n")
    result = numberOne * numberTwo //multiply operator
    print(" $numberOne * $numberTwo = $result \n")
    result = numberOne / numberTwo //division operator
    print(" $numberOne / $numberTwo = $result \n")
    result = numberOne % numberTwo //modulus operator
    print(" $numberOne % $numberTwo = $result \n")

}