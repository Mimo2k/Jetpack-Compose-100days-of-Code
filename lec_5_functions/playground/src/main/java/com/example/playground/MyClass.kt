package com.example.playground

fun main(){
    //LECTURE 1:
    even()
    //LECTURE 2:
    multiple(1,10,3) // here 1, 30 and 3 are arguments
    //Lecture 3:
    defaultArguments(name="mimo") // name is Named Argument
    //Lecture 4:
    val age:Int = fishAge(6) //accept return type int from fishAge function in age val
    print("my fish is : $age year's old \n")
    //Lecture 5:
    if(fishType(age)){
        print("my fish is old \n")
    }else{
        print("my fish is young \n")
    }

    //Lecture 6: Lambda Function
   print("fish real age is ${realAge(age,6)} \n")

    //Lecture 7: Lambda no return using Unit
    name("Mimo")

    // Lecture 8: Trailing Lambda
    enhancedMessage(message = "Name is: "){
        print(it)
        fishAge(6)

    }



}
//LECTURE 1:
fun even(){
    print(" Even in range 1..30: ")
    for(i in 1..30){
        print("$i, ")
    }
    print("\n")
}
//LECTURE 2:
fun multiple(start: Int, end: Int, multipleOf: Int){ //here start, end and multipleOf are parameters
    for(i in start..end){
        if(i%multipleOf == 0){
            print("$i is multiple of $multipleOf \n")
        }
    }
}

//LECTURE 3:
fun defaultArguments(age: Int = 22, name: String){ //age is default argument
    print("My name is : $name and my age is: $age \n")
}

//LECTURE 4:
fun fishAge(age: Int): Int {  // : Int indicate return type of function
    return age*6  // return age of fish
}

//LECTURE 5:
fun fishType(age: Int): Boolean{ //: Boolean indicate return type of function
    return age>=30
}

//LECTURE 6:
val realAge: (Int, Int) -> Int = {age, multipleOf -> age/multipleOf}

//LECTURE 7: lambda return void and it keyword
val name: (String) -> Unit = { print("name is $it \n")}

//LECTURE 8: Trailing Lambda

fun enhancedMessage(message: String, funAsParameter: (String) -> Int){
    println("$message ${funAsParameter("Hey")}")
}
